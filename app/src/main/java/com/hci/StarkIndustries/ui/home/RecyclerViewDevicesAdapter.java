package com.hci.StartIndustries.ui.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hci.StartIndustries.Models.CommonDeviceModel;
import com.hci.StarkIndustries.R;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewDevicesAdapter extends RecyclerView.Adapter<RecyclerViewDevicesAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewDevicesAdapter";
    private List<CommonDeviceModel> devices = new ArrayList<>();
    private Context mContext;

    public RecyclerViewDevicesAdapter(List<CommonDeviceModel> devices, Context mContext) {
        this.devices = devices;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_device_miniature,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        final CommonDeviceModel model = devices.get(position);

        holder.roomName.setText( model.Room);
        holder.deviceName.setText(model.Name);
        holder.image.setImageResource(R.drawable.ic_home_black_24dp);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick:  Clicked on " + model.Name );
                Toast.makeText(mContext,devices.get(position).Name,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView deviceName;
        private TextView roomName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.DeviceImage);
            deviceName = itemView.findViewById(R.id.DeviceName);
            roomName = itemView.findViewById(R.id.Room);
        }
    }
}
