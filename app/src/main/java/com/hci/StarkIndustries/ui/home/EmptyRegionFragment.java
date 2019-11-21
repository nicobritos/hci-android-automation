package com.hci.StarkIndustries.ui.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hci.StarkIndustries.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmptyRegionFragment extends Fragment {


    public EmptyRegionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_empty_region, container, false);
    }

}
