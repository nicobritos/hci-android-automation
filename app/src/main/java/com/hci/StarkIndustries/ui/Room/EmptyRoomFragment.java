package com.hci.StarkIndustries.ui.Room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.hci.StarkIndustries.R;

public class EmptyRoomFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_empty_room, container, false);
    }

}
