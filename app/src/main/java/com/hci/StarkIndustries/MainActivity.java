package com.hci.StarkIndustries;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Map<String, Fragment> fragments = new HashMap<>();

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

        initializeFragments();
    }

//    public Fragment getFragment(String name){
//        return fragments.get(adaptName(name));
//    }

    private String adaptName(String name) {
        return name.toLowerCase();
    }

    private void initializeFragments() {

//        fragments.put(adaptName("AC"), ACFragment.newInstance());
//        fragments.put(adaptName("Door"), DoorMenuFragment.newInstance());
//        fragments.put(adaptName("Oven"), OvenFragment.newInstance());
//        fragments.put(adaptName("Fridge"), FridgeFragment.newInstance());
//        fragments.put(adaptName("Curtains"), CurtainsFragment.newInstance());
//        fragments.put(adaptName("Lamp"), LampFragment.newInstance());
//        fragments.put(adaptName("Speaker"), SpeakerFragment.newInstance());


    }

}
