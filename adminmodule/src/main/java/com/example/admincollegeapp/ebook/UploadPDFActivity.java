package com.example.admincollegeapp.ebook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admincollegeapp.MainActivity;
import com.example.admincollegeapp.R;
import com.example.admincollegeapp.notice.DeleteNoticeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.HashMap;

public class UploadPDFActivity extends AppCompatActivity {
    

    private CardView addPDF;
    private final int REQ=1;
    private Uri pdfData;
    private EditText pdfTitle;
    private Button uploadPDFBtn;
    private TextView pdfTextView;
    private String pdfName,title;
    private ImageView deleteEbook;

    private DatabaseReference databaseReference,dbRef;
    private StorageReference storageReference;
    String downloadUrl = "";
    private ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_p_d_f);

        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        pd = new ProgressDialog(this);

        addPDF = findViewById(R.id.addPDF);
        pdfTitle = findViewById(R.id.pdfTitle);
        uploadPDFBtn = findViewById(R.id.uploadPDFBtn);
        pdfTextView = findViewById(R.id.pdfTextView);
        deleteEbook = findViewById(R.id.deleteEbookFab);

        deleteEbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UploadPDFActivity.this, DeletePDFActivity.class);
                startActivity(intent);
            }
        });


        addPDF.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        uploadPDFBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = pdfTitle.getText().toString();
                if(title.isEmpty()){
                    pdfTitle.setError("Empty");
                    pdfTitle.requestFocus();
                }else if(pdfData == null){
                    Toast.makeText(UploadPDFActivity.this,"Please upload PDF!",Toast.LENGTH_SHORT).show();
                }else{
                    uploadPDF();
                }
            }
        });
    }

    private void uploadPDF() {
        pd.setTitle("Please wait...");
        pd.setMessage("Uploading PDF");
        pd.show();

        StorageReference reference = storageReference.child("pdf/"+pdfName+"-"+System.currentTimeMillis()+".pdf");
        reference.putFile(pdfData).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while(!uriTask.isComplete());
                Uri uri = uriTask.getResult();
                uploadData(String.valueOf(uri));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(UploadPDFActivity.this,"Something went wrong!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void uploadData(String downloadUrl) {
        dbRef = databaseReference.child("pdf");
        final String key = dbRef.push().getKey();

        HashMap data = new HashMap();
        data.put("pdfTitle",title);
        data.put("pdfUrl",downloadUrl);
        data.put("key",key);
        dbRef.child(key).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                pd.dismiss();
                Toast.makeText(UploadPDFActivity.this,"PDF uploaded successfully!",Toast.LENGTH_SHORT).show();
                pdfTitle.setText("");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(UploadPDFActivity.this,"Failed to upload PDF!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openGallery() {
      Intent intent = new Intent();
      intent.setType("pdf/docs/ppt");
      intent.setAction(Intent.ACTION_GET_CONTENT);
      startActivityForResult(Intent.createChooser(intent,"Select PDF file"),REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ && resultCode == RESULT_OK) {
            pdfData = data.getData();

            if(pdfData.toString().startsWith("content://")){
                Cursor cursor = null;
                try {
                    cursor = UploadPDFActivity.this.getContentResolver().query(pdfData,null,null,null,null);
                    if(cursor != null && cursor.moveToFirst()){
                        pdfName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else if(pdfData.toString().startsWith("file://")){
                pdfName = new File(pdfData.toString()).getName();
            }
            pdfTextView.setText(pdfName);

        }
    }
}