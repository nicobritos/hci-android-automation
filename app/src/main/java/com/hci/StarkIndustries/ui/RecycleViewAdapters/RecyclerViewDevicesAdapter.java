package com.hci.StarkIndustries.ui.RecycleViewAdapters;

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

import com.hci.StarkIndustries.Models.CommonDeviceModel;
import com.hci.StarkIndustries.Models.DeviceType;
import com.hci.StarkIndustries.R;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewDevicesAdapter extends RecyclerView.Adapter<RecyclerViewDevicesAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewDevicesAdapter";
    private List<CommonDeviceModel> devices = new ArrayList<>();
    private Context mContext;
    private DevicesRecyclerViewClickInteface devicesRecyclerViewClickInteface;

    public RecyclerViewDevicesAdapter(DevicesRecyclerViewClickInteface interf, Context mContext) {
        this.mContext = mContext;
        devicesRecyclerViewClickInteface = interf;
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
        holder.image.setImageResource(getImageResourcesForDevice(model.type));

    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    public void setData(List<CommonDeviceModel> newData) {
        this.devices = newData;
        notifyDataSetChanged();
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    devicesRecyclerViewClickInteface.onItemClick(devices.get(getAdapterPosition()));
                }
            });
        }

    }

    private int getImageResourcesForDevice(DeviceType type){

        switch (type){

            case Door:
                return R.drawable.ic_door_locked;
            case Speaker:
                return R.drawable.ic_speaker_on;
            case Fridge:
                return R.drawable.ic_fridge;
            case Curtains:
                return R.drawable.ic_curtain_open;
            case Lamp:
                return R.drawable.ic_lightbulb_on;
            case AC:
                return R.drawable.ic_air_conditioner_on;
            case Oven:
                return R.drawable.ic_oven_on;
            default:
                return R.drawable.ic_help_black_24dp;
        }
    }
}
