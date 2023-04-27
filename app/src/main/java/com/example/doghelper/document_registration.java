package com.example.doghelper;

import static android.app.Activity.RESULT_OK;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class document_registration extends Fragment {
/*
    Button download;
    FirebaseDatabase mDataBase;
    FirebaseStorage storage;
    Uri PDFUri;

    private void selectPDF(){
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 77);
    }

    private void uploadFile(Uri PDFUri){
        String fileName = System.currentTimeMillis()+"";
        StorageReference storageReference = storage.getReference();
        storageReference.child("metrics_reg").child(fileName).putFile(PDFUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        String URL = taskSnapshot.getUploadSessionUri().toString();
                        DatabaseReference reference = mDataBase.getReference();
                        reference.child(fileName).setValue(URL).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {}
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {}
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode==77 && resultCode==RESULT_OK && data!=null){
            PDFUri = data.getData();
        }
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_document_registration, container, false);
    }/*

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        download = view.findViewById(R.id.upload_doc_reg);
        storage = FirebaseStorage.getInstance();
        mDataBase = FirebaseDatabase.getInstance();

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 selectPDF();
                 if (PDFUri != null){
                     uploadFile(PDFUri);
                 }
                 //else{
                 //    Toast.makeText(document_registration.this, "Выберите файл", Toast.LENGTH_SHORT).show();
                 //}

            }
        });
    }*/
}