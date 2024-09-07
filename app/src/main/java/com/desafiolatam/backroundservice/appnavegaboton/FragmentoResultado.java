package com.desafiolatam.backroundservice.appnavegaboton;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentoResultado extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflar el layout para este fragmento
        return inflater.inflate(R.layout.fragmento_resultado, container, false);
    }
}