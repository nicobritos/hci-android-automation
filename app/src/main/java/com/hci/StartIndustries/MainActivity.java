package com.hci.StartIndustries;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.hci.StarkIndustries.R.layout.activity_main);
        BottomNavigationView navView = findViewById(com.hci.StarkIndustries.R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                com.hci.StarkIndustries.R.id.navigation_home, com.hci.StarkIndustries.R.id.navigation_dashboard, com.hci.StarkIndustries.R.id.navigation_notifications)
                .build();

        NavController navController = Navigation.findNavController(this, com.hci.StarkIndustries.R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

}
