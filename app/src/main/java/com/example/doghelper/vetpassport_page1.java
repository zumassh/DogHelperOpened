package com.example.doghelper;

import static androidx.navigation.Navigation.findNavController;

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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class vetpassport_page1 extends Fragment {
    private EditText name, surname, country, city, street, house, flat, index;
    private DatabaseReference mDataBase;
    private String OWNER = "Owner";

    private void get_DB_data(){
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    BD_owner person = ds.getValue(BD_owner.class);
                    name.setText(person.name);
                    surname.setText(person.surname);
                    country.setText(person.country);
                    city.setText(person.city);
                    street.setText(person.street);
                    house.setText(person.house);
                    flat.setText(person.flat);
                    index.setText(person.index);
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
        return inflater.inflate(R.layout.fragment_vetpassport_page1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name = view.findViewById(R.id.owner_name);
        surname = view.findViewById(R.id.owner_surname);
        country = view.findViewById(R.id.county);
        city = view.findViewById(R.id.city);
        street = view.findViewById(R.id.street);
        house = view.findViewById(R.id.house);
        flat = view.findViewById(R.id.flat);
        index = view.findViewById(R.id.index);
        mDataBase = FirebaseDatabase.getInstance().getReference(OWNER);
        get_DB_data();

        Button op = view.findViewById(R.id.next_to_describe);
        Button doc_save_1 = view.findViewById(R.id.save_owner);
        op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(view).navigate(R.id.action_vetpassport_page1_to_vetpassport_page2);
            }
        });

        doc_save_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = mDataBase.getKey();
                String owner_name = name.getText().toString();
                String owner_surname = surname.getText().toString();
                String owner_country = country.getText().toString();
                String owner_city = city.getText().toString();
                String owner_street = street.getText().toString();
                String owner_house = house.getText().toString();
                String owner_flat = flat.getText().toString();
                String owner_index = index.getText().toString();
                BD_owner person = new BD_owner(id, owner_name, owner_surname, owner_country, owner_city, owner_street, owner_house, owner_flat, owner_index);
                if (!TextUtils.isEmpty(owner_name) && !TextUtils.isEmpty(owner_country) && !TextUtils.isEmpty(owner_city) && !TextUtils.isEmpty(owner_street) && !TextUtils.isEmpty(owner_flat) && !TextUtils.isEmpty(owner_house) && !TextUtils.isEmpty(owner_surname) && !TextUtils.isEmpty(owner_index)){
                    mDataBase.push().setValue(person);
                }
               //else{
               //    Toast.makeText(this, "Одно из полей пусто", Toast.LENGTH_SHORT).show();
               //}
            }
        });
    }
}