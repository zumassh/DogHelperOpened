package com.example.doghelper;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class vetpassport_menu extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vetpassport_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button op = view.findViewById(R.id.open_vetpasport);
        op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(view).navigate(R.id.action_vetpassport_menu_to_vetpassport_page1);
            }
        });
    }
}