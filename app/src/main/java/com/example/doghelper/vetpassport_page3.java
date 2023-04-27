package com.example.doghelper;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class vetpassport_page3 extends Fragment {
    private EditText chip_num1, chip_date1, chip_location1, tatoo_num1, tatoo_date1, kleimo_num1, kleimo_date1;
    private DatabaseReference mDataBase;
    private String IDENTIFY = "Identify";

    private void get_DB_data(){
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    BD_identify ident = ds.getValue(BD_identify.class);
                    chip_num1.setText(ident.chip_num);
                    chip_date1.setText(ident.chip_date);
                    chip_location1.setText(ident.chip_location);
                    tatoo_num1.setText(ident.tatoo_num);
                    tatoo_date1.setText(ident.tatoo_date);
                    kleimo_num1.setText(ident.kleimo_num);
                    kleimo_date1.setText(ident.kleimo_date);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDataBase.addValueEventListener(listener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vetpassport_page3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chip_num1 = view.findViewById(R.id.chip_num);
        chip_date1 = view.findViewById(R.id.chip_date);
        chip_location1 = view.findViewById(R.id.chip_location);
        tatoo_num1 = view.findViewById(R.id.tatoo_num);
        tatoo_date1 = view.findViewById(R.id.tatoo_date);
        kleimo_num1 = view.findViewById(R.id.kleimo_num);
        kleimo_date1 = view.findViewById(R.id.kleimo_date);
        mDataBase = FirebaseDatabase.getInstance().getReference(IDENTIFY);
        get_DB_data();

        Button doc_save_3 = view.findViewById(R.id.save_identify);
        doc_save_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = mDataBase.getKey();
                String chip_date = chip_date1.getText().toString();
                String chip_num = chip_num1.getText().toString();
                String chip_location = chip_location1.getText().toString();
                String tatoo_num = tatoo_num1.getText().toString();
                String tatoo_date = tatoo_date1.getText().toString();
                String kleimo_num = kleimo_num1.getText().toString();
                String kleimo_date = kleimo_date1.getText().toString();
                BD_identify ident = new BD_identify(id, chip_num, chip_date, chip_location, tatoo_num, tatoo_date, kleimo_num, kleimo_date);
                if (!TextUtils.isEmpty(chip_num) && !TextUtils.isEmpty(chip_date) && !TextUtils.isEmpty(chip_location) && !TextUtils.isEmpty(tatoo_date) && !TextUtils.isEmpty(tatoo_num) && !TextUtils.isEmpty(kleimo_date) && !TextUtils.isEmpty(kleimo_num)){
                    mDataBase.push().setValue(ident);
                }
            }
        });
    }
}