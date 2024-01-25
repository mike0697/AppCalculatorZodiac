package com.michele.appcalculatorzodiac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.michele.appcalculatorzodiac.databinding.ActivityMainBinding;
import com.michele.appcalculatorzodiac.databinding.ActivityMenuBinding;

public class Menu extends AppCompatActivity {

    ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.homeMenu){
                replaceFragment(new HomeFragment());
            }
            if(item.getItemId() == R.id.segni){
                replaceFragment(new SchedaSegnoFragment());
            }
            if(item.getItemId() == R.id.crediti){
                replaceFragment(new CreditiFragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();

    }
}