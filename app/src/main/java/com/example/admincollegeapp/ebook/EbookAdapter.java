package com.example.admincollegeapp.ebook;


import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admincollegeapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.EbookViewAdapter> {

    private Context context;
    private ArrayList<EbookData> list;

    public EbookAdapter(Context context, ArrayList<EbookData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EbookViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false);

        return new EbookViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EbookViewAdapter holder, int position) {

        EbookData currentItem = list.get(position);

        holder.deleteEbookTitle.setText(currentItem.getPdfTitle());
        holder.deleteEbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Are you sure you want to delete?");
                builder.setCancelable(true);
                builder.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("pdf");
                                reference.child(currentItem.getKey()).removeValue()
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(context,"Ebook Deleted!",Toast.LENGTH_SHORT).show();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(context,"Something went wrong!",Toast.LENGTH_SHORT).show();
                                    }
                                });

                                notifyItemRemoved(position);
                            }
                        }
                );
                builder.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog dialog= null;
                try {
                    dialog = builder.create();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(dialog !=null)
                    dialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EbookViewAdapter extends RecyclerView.ViewHolder {

        private Button deleteEbook;
        private TextView deleteEbookTitle;

        public EbookViewAdapter(@NonNull View itemView) {
            super(itemView);

            deleteEbook = itemView.findViewById(R.id.deleteEbook);
            deleteEbookTitle = itemView.findViewById(R.id.deleteEbookTitle);
        }
    }


    }
