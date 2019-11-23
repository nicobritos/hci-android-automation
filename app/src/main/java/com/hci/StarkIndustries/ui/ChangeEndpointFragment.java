package com.hci.StarkIndustries.ui;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.hci.StarkIndustries.MainActivity;
import com.hci.StarkIndustries.R;

import java.util.regex.Pattern;


public class ChangeEndpointFragment extends DialogFragment {


    public interface OnInputSelected{
        void sendInput(String newAdress);
    }

    private static final String TAG = "ChangeEndpointFragment";
    public OnInputSelected mOnInputSelected;

    static public ChangeEndpointFragment newInstance(){
        return new ChangeEndpointFragment();
    }

    public ChangeEndpointFragment() {
        // Required empty public constructor
    }

    EditText textInput;
    Button doneBtn,cancelBtn, restoreBtn;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_endpoint, container, false);

        textInput = view.findViewById(R.id.changeEndpointInput);
        restoreBtn = view.findViewById(R.id.changeEndpointBtnReloadEnpoint);

        textInput.setText(((MainActivity)getActivity()).sharedPreferences.getString("API ENDPOINT",getString(R.string.defaultAPIEndpoint)));


        restoreBtn.setOnClickListener(list->{
            textInput.setText(R.string.defaultAPIEndpoint);
        });

        doneBtn = view.findViewById(R.id.changeEndpointBtnDone);

        doneBtn.setOnClickListener(l->{
            if(Patterns.WEB_URL.matcher(textInput.getText()).matches()){
                mOnInputSelected.sendInput(textInput.getText().toString());
                getDialog().dismiss();
            }else {
                textInput.setError( getString(R.string.EndpointError));
            }

        });

        cancelBtn = view.findViewById(R.id.changeEndpointBtnCancel);

        cancelBtn.setOnClickListener(l->{
            getDialog().dismiss();
        });



        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            mOnInputSelected = (OnInputSelected) getTargetFragment();
        }catch (ClassCastException ex){
            Log.e(TAG, "onAttach: ClassCastException: ",ex );
        }
    }
}
