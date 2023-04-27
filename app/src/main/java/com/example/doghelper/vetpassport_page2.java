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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class vetpassport_page2 extends Fragment {
    private EditText nickname, breed, sex, birthday, color;
    private DatabaseReference mDataBase;
    private String DESCRIBE = "Describe";

    private void get_DB_data(){
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    BD_describe pet = ds.getValue(BD_describe.class);
                    nickname.setText(pet.nickname);
                    breed.setText(pet.breed);
                    sex.setText(pet.sex);
                    birthday.setText(pet.birthday);
                    color.setText(pet.color);
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
        return inflater.inflate(R.layout.fragment_vetpassport_page2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nickname = view.findViewById(R.id.pet_name);
        breed = view.findViewById(R.id.pet_poroda);
        sex = view.findViewById(R.id.pet_sex);
        birthday = view.findViewById(R.id.pet_birthday);
        color = view.findViewById(R.id.pet_color);
        mDataBase = FirebaseDatabase.getInstance().getReference(DESCRIBE);
        get_DB_data();

        Button op = view.findViewById(R.id.next_to_identify);
        Button doc_save_2 = view.findViewById(R.id.save_discribing);

        op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(view).navigate(R.id.action_vetpassport_page2_to_vetpassport_page3);
            }
        });

        doc_save_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = mDataBase.getKey();
                String pet_nickname = nickname.getText().toString();
                String pet_breed = breed.getText().toString();
                String pet_sex = sex.getText().toString();
                String pet_birthday = birthday.getText().toString();
                String pet_color = color.getText().toString();
                BD_describe pet = new BD_describe(id, pet_nickname, pet_breed, pet_sex, pet_birthday, pet_color);
                if (!TextUtils.isEmpty(pet_nickname) && !TextUtils.isEmpty(pet_breed) && !TextUtils.isEmpty(pet_sex) && !TextUtils.isEmpty(pet_birthday) && !TextUtils.isEmpty(pet_color)){
                    mDataBase.push().setValue(pet);
                }
                //else{
                //    Toast.makeText(this, "Одно из полей пусто", Toast.LENGTH_SHORT).show();
                //}
            }
        });
    }
}