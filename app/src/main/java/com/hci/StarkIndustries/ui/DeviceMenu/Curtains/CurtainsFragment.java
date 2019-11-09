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

import com.hci.StarkIndustries.Models.DeviceModels.CurtainsModel;
import com.hci.StarkIndustries.R;

public class CurtainsFragment extends Fragment {

    private CurtainsViewModel viewModel;

    public static CurtainsFragment newInstance() {

        Bundle args = new Bundle();

        CurtainsFragment fragment = new CurtainsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        viewModel = ViewModelProviders.of(this).get(CurtainsViewModel.class);

        View root = inflater.inflate(R.layout.fragment_courtains_menu, container,false);



        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CurtainsViewModel model = ViewModelProviders.of(this).get(CurtainsViewModel.class);

        model.getModel("9999").observe(this,new LoadModelObserver(view) );




    }



    private class LoadModelObserver implements Observer<CurtainsModel> {

        private View view;
        public LoadModelObserver(View view) {
            this.view = view;
        }

        @Override
        public void onChanged(CurtainsModel curtainsModel) {

            Button button  = view.findViewById(R.id.curtainsButton);
            ImageView image = view.findViewById(R.id.curtainsImage);

            if(curtainsModel.isOpen){
                image.setImageResource(R.drawable.ic_curtain_open);
                button.setText("Cerrar");
            }else {
                image.setImageResource(R.drawable.ic_curtain_closed);
                button.setText("Abrir");
            }

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button button  = view.findViewById(R.id.curtainsButton);
                    ImageView image = view.findViewById(R.id.curtainsImage);

                    if(button.getText() == "Abrir"){
                        button.setText("Cerrar");
                        image.setImageResource(R.drawable.ic_curtain_open);
                    }
                    else{
                        button.setText("Abrir");
                        image.setImageResource(R.drawable.ic_curtain_closed);
                    }
                }
            });

        }
    }
}
