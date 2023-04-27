package com.example.doghelper;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class metrica extends Fragment {
    private EditText puppy_breed, puppy_name, father_name, puppy_birthday, puppy_sex, puppy_color, puppy_kleimo, RKF_father, mother_name, RKF_mother, breeder_FIO, breeder_address, owner_FIO, owner_address, reason;
    private RadioButton radio_yes, radio_no;
    private DatabaseReference mDataBase;
    private String METRICS = "Metrics";

    private void get_DB_data(){
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    BD_metrics puppy = ds.getValue(BD_metrics.class);
                    puppy_breed.setText(puppy.puppy_breed);
                    puppy_name.setText(puppy.puppy_name);
                    puppy_sex.setText(puppy.puppy_sex);
                    puppy_birthday.setText(puppy.puppy_birthday);
                    puppy_color.setText(puppy.puppy_color);
                    father_name.setText(puppy.father_name);
                    puppy_kleimo.setText(puppy.puppy_kleimo);
                    RKF_father.setText(puppy.RKF_father);
                    mother_name.setText(puppy.mother_name);
                    RKF_mother.setText(puppy.RKF_mother);
                    breeder_FIO.setText(puppy.breeder_FIO);
                    breeder_address.setText(puppy.breeder_address);
                    owner_FIO.setText(puppy.owner_FIO);
                    owner_address.setText(puppy.owner_address);
                    reason.setText(puppy.reason);
                    radio_yes.setText(puppy.radio_yes);
                    radio_no.setText(puppy.radio_no);
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
        return inflater.inflate(R.layout.fragment_metrica, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        puppy_breed = view.findViewById(R.id.puppy_poroda);
        puppy_name = view.findViewById(R.id.puppy_name);
        puppy_birthday = view.findViewById(R.id.puppy_date);
        puppy_sex = view.findViewById(R.id.puppy_sex);
        puppy_color = view.findViewById(R.id.puppy_color);
        puppy_kleimo = view.findViewById(R.id.puppy_kleimo);
        father_name = view.findViewById(R.id.father_name);
        RKF_father = view.findViewById(R.id.RKF_number_father);
        mother_name = view.findViewById(R.id.mother_name);
        RKF_mother = view.findViewById(R.id.RKF_number_mother);
        breeder_FIO = view.findViewById(R.id.breeder_FIO);
        breeder_address = view.findViewById(R.id.breeder_address1);
        owner_FIO = view.findViewById(R.id.owner_FIO);
        owner_address = view.findViewById(R.id.owner_address1);
        reason = view.findViewById(R.id.brak_reason);
        radio_yes = view.findViewById(R.id.radio_yes);
        radio_no = view.findViewById(R.id.radio_no);
        mDataBase = FirebaseDatabase.getInstance().getReference(METRICS);
        get_DB_data();

        Button metrics_save = view.findViewById(R.id.save_metrica);
        metrics_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = mDataBase.getKey();
                String name = puppy_name.getText().toString();
                String breed = puppy_breed.getText().toString();
                String date = puppy_birthday.getText().toString();
                String color = puppy_color.getText().toString();
                String sex = puppy_sex.getText().toString();
                String kleimo = puppy_kleimo.getText().toString();
                String f_name = father_name.getText().toString();
                String f_RKF = RKF_father.getText().toString();
                String m_name = mother_name.getText().toString();
                String m_RKF = RKF_mother.getText().toString();
                String breed_FIO = breeder_FIO.getText().toString();
                String breed_address = breeder_address.getText().toString();
                String own_FIO = owner_FIO.getText().toString();
                String own_address = owner_address.getText().toString();
                String brak_reason = reason.getText().toString();
                String rb_yes = radio_yes.getText().toString();
                String rb_no = radio_no.getText().toString();
                BD_metrics puppy = new BD_metrics(id, breed, name, f_name, date, sex, color, kleimo, f_RKF, m_name, m_RKF, breed_FIO, breed_address, own_FIO, own_address, brak_reason, rb_yes, rb_no);
                mDataBase.push().setValue(puppy);
                //else{
                //    Toast.makeText(this, "Одно из полей пусто", Toast.LENGTH_SHORT).show();
                //}
            }
        });
    }
}