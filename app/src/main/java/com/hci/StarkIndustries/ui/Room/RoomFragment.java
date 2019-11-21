package com.hci.StarkIndustries.ui.Room;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hci.StarkIndustries.Models.RoomModel;
import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.ui.Miniatures.RoomDevices.RoomDevicesListFragment;


public class RoomFragment extends Fragment {

    private String id = "";
    private RoomViewModel mViewModel;

    public RoomFragment() {
        // Required empty public constructor
    }


    public static RoomFragment newInstance() {
        RoomFragment fragment = new RoomFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getString("id");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_room, container, false);

        RoomDevicesListFragment fragment = (RoomDevicesListFragment) getChildFragmentManager().findFragmentById(R.id.RoomDevicesFragmentContainer);

        fragment.setID(id);

//        ActionBar actionBar = getActivity().getActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

        return root;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
        navController.navigate(R.id.action_room_to_navigation_home);
        return true;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RoomViewModel.class);

        mViewModel.getModel(id).observe(this, new Observer<RoomModel>() {
            @Override
            public void onChanged(RoomModel roomModel) {
                ((TextView)getView().findViewById(R.id.RoomTitle)).setText(roomModel.name);

                RoomDevicesListFragment fragment = (RoomDevicesListFragment) getChildFragmentManager()
                        .findFragmentById(R.id.RoomDevicesFragmentContainer);

            }
        });


    }
}
