package com.desafiolatam.backroundservice.appnavegaboton;


import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.desafiolatam.backroundservice.appnavegaboton.databinding.FragmentoInicialBinding;

public class FragmentoInicial extends Fragment {

    private NavController navController;
    private FragmentoInicialBinding binding;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // Inicializa algo que necesite el contexto
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inicializa variables
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentoInicialBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerListener();
    }

    private void registerListener() {
        binding.passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence cs, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                binding.showButton.setEnabled(charSequence.length() > 5 && contieneMayuscula(charSequence));
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        binding.showButton.setOnClickListener(v -> {
            navController.navigate(R.id.fragmento_resultado);
        });
    }

    private boolean contieneMayuscula(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (Character.isUpperCase(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}