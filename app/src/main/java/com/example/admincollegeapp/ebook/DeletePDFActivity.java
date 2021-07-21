package com.example.admincollegeapp.ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.admincollegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DeletePDFActivity extends AppCompatActivity {

    private RecyclerView deletePDFRecycler;
    private ProgressBar progressBar;

    private ArrayList<EbookData> list;
    private EbookAdapter adapter;

    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_p_d_f);

        deletePDFRecycler = findViewById(R.id.deletePDFRecycler);
        progressBar = findViewById(R.id.pdfProgressBar);

        reference = FirebaseDatabase.getInstance().getReference().child("pdf");

        deletePDFRecycler.setLayoutManager(new LinearLayoutManager(this));
        deletePDFRecycler.setHasFixedSize(true);

        getPDF();

    }

    private void getPDF() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list = new ArrayList<>();
                for(DataSnapshot snapshot: datasnapshot.getChildren()){
                    EbookData data = snapshot.getValue(EbookData.class);
                    list.add(data);
                }
                adapter = new EbookAdapter(DeletePDFActivity.this,list);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);

                deletePDFRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressBar.setVisibility(View.GONE);

                Toast.makeText(DeletePDFActivity.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}