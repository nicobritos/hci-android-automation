package com.hci.StarkIndustries.ui.DeviceMenu;

import androidx.fragment.app.Fragment;

public abstract class IdentifiableFragment extends Fragment {
    private String id;

    public String getID() {
        return this.id;
    }

    public void setID(String id) {
        this.id = id;
    }
}
