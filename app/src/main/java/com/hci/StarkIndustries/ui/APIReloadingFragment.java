package com.hci.StarkIndustries.ui;

import android.util.Log;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.hci.StarkIndustries.MainActivity;
import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.data.remote.Api;

public abstract class APIReloadingFragment extends Fragment implements ChangeEndpointFragment.OnInputSelected {

    @Override
    public void sendInput(String newAdress) {
        Api.setEndpoint(newAdress);
        final MainActivity act = (MainActivity) getActivity();
        final String oldAddress = act.sharedPreferences.getString("API ENDPOINT",getString(R.string.defaultAPIEndpoint));
        act.sharedPreferences.edit().putString("API ENDPOINT",newAdress).commit();


        Snackbar snackbar = Snackbar.make(getActivity().findViewById(R.id.coordinatorLayour)
                ,R.string.newEndpointText,Snackbar.LENGTH_LONG);
        snackbar.setAction(R.string.newEndpointUndo,l->{

            Api.setEndpoint(oldAddress);
            act.sharedPreferences.edit().putString("API ENDPOINT",oldAddress).commit();
           // reloadPage();

        });

        snackbar.show();

        //reloadPage();
    }

    abstract protected void reloadPage();
}
