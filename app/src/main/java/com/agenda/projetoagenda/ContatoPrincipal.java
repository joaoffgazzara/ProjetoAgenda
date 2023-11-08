package com.agenda.projetoagenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import com.agenda.projetoagenda.databinding.ActivityContatoPrincipalBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ContatoPrincipal extends AppCompatActivity {

    ActivityContatoPrincipalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContatoPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new ContatoFragment());

        binding.bottomView.setOnItemSelectedListener(item -> {

            int id = item.getItemId();

                if (id == R.id.contato_menu) {
                    replaceFragment(new ContatoFragment());
                } else if (id == R.id.feed) {
                    replaceFragment(new FeedFragment());
                } else if (id == R.id.perfil) {
                    replaceFragment(new PerfilFragment());
                }

            return true;
        });


    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}