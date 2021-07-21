package com.example.admincollegeapp.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.admincollegeapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class updateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView aiDept,chDept,civDept,cseDept,eeeDept,eceDept,iseDept,mcaDept,mechDept,mathDept,phyDept;
    private LinearLayout aiNoData,chNoData,civNoData,cseNoData,eeeNoData,eceNoData,iseNoData,mcaNoData,mathNoData,phyNoData,mechNoData;
    private List<TeacherData> list1,list2,list3,list4,list5,list6,list7,list8,list9,list10,list11;
    private TeacherAdapter adapter;

    private DatabaseReference reference,dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        aiDept = findViewById(R.id.aiDept);
        chDept = findViewById(R.id.chDept);
        civDept = findViewById(R.id.civDept);
        cseDept = findViewById(R.id.cseDept);
        eeeDept = findViewById(R.id.eeeDept);
        eceDept = findViewById(R.id.eceDept);
        iseDept = findViewById(R.id.iseDept);
        mcaDept = findViewById(R.id.mcaDept);
        mechDept = findViewById(R.id.mechDept);
        mathDept = findViewById(R.id.mathDept);
        phyDept = findViewById(R.id.phyDept);

        aiNoData = findViewById(R.id.aiNoData);
        chNoData = findViewById(R.id.chNoData);
        civNoData = findViewById(R.id.civNoData);
        cseNoData = findViewById(R.id.cseNoData);
        eeeNoData = findViewById(R.id.eeeNoData);
        eceNoData = findViewById(R.id.eceNoData);
        iseNoData = findViewById(R.id.iseNoData);
        mcaNoData = findViewById(R.id.mcaNoData);
        mechNoData = findViewById(R.id.mechNoData);
        mathNoData = findViewById(R.id.mathNoData);
        phyNoData = findViewById(R.id.phyNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("Faculty");

        aiDept();
        chDept();
        civDept();
        cseDept();
        eceDept();
        eeeDept();
        iseDept();
        mcaDept();
        mathDept();
        mechDept();
        phyDept();

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(updateFaculty.this, addTeacher.class));
            }
        });
    }

    private void aiDept() {
        dbRef = reference.child("Artificial Intelligence and Machine Learning");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    aiNoData.setVisibility(View.VISIBLE);
                    aiDept.setVisibility(View.GONE);
                }else{
                    aiNoData.setVisibility(View.GONE);
                    aiDept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    aiDept.setHasFixedSize(true);
                    aiDept.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter = new TeacherAdapter(list1,updateFaculty.this,"Artificial Intelligence and Machine Learning");
                    aiDept.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(updateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void chDept() {
        dbRef = reference.child("Chemistry");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    chDept.setVisibility(View.VISIBLE);
                    chDept.setVisibility(View.GONE);
                }else{
                    chNoData.setVisibility(View.GONE);
                    chDept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    chDept.setHasFixedSize(true);
                    chDept.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter = new TeacherAdapter(list2,updateFaculty.this,"Chemistry");
                    chDept.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(updateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void civDept() {
        dbRef = reference.child("Civil Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    civNoData.setVisibility(View.VISIBLE);
                    civDept.setVisibility(View.GONE);
                }else{
                    civNoData.setVisibility(View.GONE);
                    civDept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    civDept.setHasFixedSize(true);
                    civDept.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter = new TeacherAdapter(list3,updateFaculty.this,"Civil Engineering");
                    civDept.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(updateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void cseDept() {
        dbRef = reference.child("Computer Science and Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    cseNoData.setVisibility(View.VISIBLE);
                    cseDept.setVisibility(View.GONE);
                }else{
                    cseNoData.setVisibility(View.GONE);
                    cseDept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    cseDept.setHasFixedSize(true);
                    cseDept.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter = new TeacherAdapter(list4,updateFaculty.this,"Computer Science and Engineering");
                    cseDept.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(updateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void eceDept() {
        dbRef = reference.child("Electronics and Communication Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    eceNoData.setVisibility(View.VISIBLE);
                    eceDept.setVisibility(View.GONE);
                }else{
                    eceNoData.setVisibility(View.GONE);
                    eceDept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    eceDept.setHasFixedSize(true);
                    eceDept.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter = new TeacherAdapter(list5,updateFaculty.this,"Electronics and Communication Engineering");
                    eceDept.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(updateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void eeeDept() {
        dbRef = reference.child("Electrical and Electronics Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    eeeNoData.setVisibility(View.VISIBLE);
                    eeeDept.setVisibility(View.GONE);
                }else{
                    eeeNoData.setVisibility(View.GONE);
                    eeeDept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    eeeDept.setHasFixedSize(true);
                    eeeDept.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter = new TeacherAdapter(list6,updateFaculty.this,"Electrical and Electronics Engineering");
                    eeeDept.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(updateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void iseDept() {
        dbRef = reference.child("Information Science Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    iseNoData.setVisibility(View.VISIBLE);
                    iseDept.setVisibility(View.GONE);
                }else{
                    iseNoData.setVisibility(View.GONE);
                    iseDept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list7.add(data);
                    }
                    iseDept.setHasFixedSize(true);
                    iseDept.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter = new TeacherAdapter(list7,updateFaculty.this,"Information Science Engineering");
                    iseDept.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(updateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void mcaDept() {
        dbRef = reference.child("Master of Computer Applications");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    mcaNoData.setVisibility(View.VISIBLE);
                    mcaDept.setVisibility(View.GONE);
                }else{
                    mcaNoData.setVisibility(View.GONE);
                    mcaDept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list8.add(data);
                    }
                    mcaDept.setHasFixedSize(true);
                    mcaDept.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter = new TeacherAdapter(list8,updateFaculty.this,"Master of Computer Applications");
                    mcaDept.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(updateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void mathDept() {
        dbRef = reference.child("Mathematics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    mathNoData.setVisibility(View.VISIBLE);
                    mathDept.setVisibility(View.GONE);
                }else{
                    mathNoData.setVisibility(View.GONE);
                    mathDept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list9.add(data);
                    }
                    mathDept.setHasFixedSize(true);
                    mathDept.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter = new TeacherAdapter(list9,updateFaculty.this,"Mathematics");
                    mathDept.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(updateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void mechDept() {
        dbRef = reference.child("Mechanical Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    mechNoData.setVisibility(View.VISIBLE);
                    mechDept.setVisibility(View.GONE);
                }else{
                    mechNoData.setVisibility(View.GONE);
                    mechDept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list10.add(data);
                    }
                    mechDept.setHasFixedSize(true);
                    mechDept.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter = new TeacherAdapter(list10,updateFaculty.this,"Mechanical Engineering");
                    mechDept.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(updateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void phyDept() {
        dbRef = reference.child("Physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    phyNoData.setVisibility(View.VISIBLE);
                    phyDept.setVisibility(View.GONE);
                }else{
                    phyNoData.setVisibility(View.GONE);
                    phyDept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list11.add(data);
                    }
                    phyDept.setHasFixedSize(true);
                    phyDept.setLayoutManager(new LinearLayoutManager(updateFaculty.this));
                    adapter = new TeacherAdapter(list11,updateFaculty.this,"Physics");
                    phyDept.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(updateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}