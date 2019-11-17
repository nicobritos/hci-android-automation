package com.hci.StarkIndustries.ui.DeviceMenu.Curtains;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.CurtainsModel;
import com.hci.StarkIndustries.R;

public class CurtainsFragment extends Fragment {

    private CurtainsViewModel viewModel;

    protected CurtainsFragment(){}

    public static CurtainsFragment newInstance(String id) {

        CurtainsFragment f = new CurtainsFragment();
        Bundle arg = new Bundle();
        arg.putString("id",id);
        f.setArguments(arg);
        return f;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        viewModel = ViewModelProviders.of(this).get(CurtainsViewModel.class);

        View root = inflater.inflate(R.layout.fragment_courtains_menu, container,false);

        Button button  = root.findViewById(R.id.curtainsButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CurtainsModel model = viewModel.getModel(getID()).getValue();

                viewModel.setState(!model.isOpen);
            }
        });


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CurtainsViewModel model = ViewModelProviders.of(this).get(CurtainsViewModel.class);

        model.getModel(getID()).observe(this, new Observer<CurtainsModel>() {
            @Override
            public void onChanged(CurtainsModel curtainsModel) {

                Button button  = getView().findViewById(R.id.curtainsButton);
                ImageView image = getView().findViewById(R.id.curtainsImage);

                if(curtainsModel.isOpen){
                    image.setImageResource(R.drawable.ic_curtain_open);
                    button.setText(R.string.CourtainsButtonClose);
                }else {
                    image.setImageResource(R.drawable.ic_curtain_closed);
                    button.setText(R.string.CourtainsButtonOpen);
                }

            }
        });
    }


    private String getID(){
        return getArguments().getString("id");
    }

}
