package com.hci.StarkIndustries.ui.Miniatures.Routines;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hci.StarkIndustries.data.Models.RoutinesListModel;
import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.ui.RecycleViewAdapters.RecyclerViewRoutinesAdapter;

public class RoutinesListFragment extends Fragment {

    protected RoutinesListViewModel mViewModel;

    public static RoutinesListFragment newInstance() {
        return new RoutinesListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.routines_list_fragment, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL,false);
        RecyclerView recyclerView =  view.findViewById(R.id.RecyclerViewRoutines);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewRoutinesAdapter adapter = new RecyclerViewRoutinesAdapter(this.getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void LoadViewModel(){
        mViewModel = ViewModelProviders.of(this).get(RoutinesListViewModel.class);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LoadViewModel();

        mViewModel.getModel().observe(this, new Observer<RoutinesListModel>() {
            @Override
            public void onChanged(RoutinesListModel model) {
                RecyclerView recyclerView =  getView().findViewById(R.id.RecyclerViewRoutines);
                ((RecyclerViewRoutinesAdapter)recyclerView.getAdapter()).setData(model.getRoutines());
            }
        });


        // TODO: Use the ViewModel
    }




}
