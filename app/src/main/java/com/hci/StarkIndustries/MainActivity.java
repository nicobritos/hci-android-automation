package com.hci.StarkIndustries;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hci.StarkIndustries.ui.DeviceMenu.AC.ACFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Curtains.CurtainsFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Door.DoorMenuFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Fridge.FridgeFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.IPassableID;
import com.hci.StarkIndustries.ui.DeviceMenu.Lamp.LampFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Oven.OvenFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Speaker.SpeakerFragment;
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
    }

    public IPassableID getFragment(String name){
        return (IPassableID)fragments.get(adaptName(name));
    }

    private String adaptName(String name) {
        return name.toLowerCase();
    }
}
