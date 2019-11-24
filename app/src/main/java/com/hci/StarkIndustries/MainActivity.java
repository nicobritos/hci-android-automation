package com.hci.StarkIndustries;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hci.StarkIndustries.data.remote.Api;
import com.hci.StarkIndustries.ui.ChangeEndpointFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.AC.ACFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Curtains.CurtainsFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceMenuContainerFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Door.DoorMenuFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Fridge.FridgeFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.IdentifiableFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Lamp.LampFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Oven.OvenFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Speaker.SpeakerFragment;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Map<String, Fragment> fragments = new HashMap<>();

    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getPreferences(MODE_PRIVATE);


        Api.setEndpoint(sharedPreferences.getString("API ENDPOINT",getString(R.string.defaultAPIEndpoint)));



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


//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);



        initializeFragments();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.navigation_settings){
            ChangeEndpointFragment fragment = ChangeEndpointFragment.newInstance();
            Fragment curr = getSupportFragmentManager()
                    .getPrimaryNavigationFragment().getChildFragmentManager().getFragments().get(0);

            fragment.setTargetFragment(curr,1);
            fragment.show(getSupportFragmentManager()
                    .getPrimaryNavigationFragment().getChildFragmentManager(), "Settings");
        }
        else {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
            navController.navigate(R.id.action_mobile_navigation_pop);
        }
        return true;
    }

    public IdentifiableFragment getFragment(String name) {
        return (IdentifiableFragment) fragments.get(adaptName(name));
    }

    private String adaptName(String name) {
        return name.toLowerCase();
    }

    private void initializeFragments() {
        fragments.put(adaptName("AC"), ACFragment.newInstance());
        fragments.put(adaptName("Door"), DoorMenuFragment.newInstance());
        fragments.put(adaptName("Oven"), OvenFragment.newInstance());
        fragments.put(adaptName("Fridge"), FridgeFragment.newInstance());
        fragments.put(adaptName("Curtains"), CurtainsFragment.newInstance());
        fragments.put(adaptName("Lamp"), LampFragment.newInstance());
        fragments.put(adaptName("Speaker"), SpeakerFragment.newInstance());
    }
}
