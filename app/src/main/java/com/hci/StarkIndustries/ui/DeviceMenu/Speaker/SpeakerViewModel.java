package com.hci.StarkIndustries.ui.DeviceMenu.Speaker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hci.StarkIndustries.Models.DeviceModels.SpeakerModel;
import com.hci.StarkIndustries.R;

public class SpeakerViewModel extends ViewModel {

    private MutableLiveData<SpeakerModel> mSpeaker;
    private String id = "";

    private SpeakerModel speaker;


    public LiveData<SpeakerModel> getModel(String id){

        if(mSpeaker ==  null){
            mSpeaker = new MutableLiveData<>();
            speaker = new SpeakerModel("PARLANTE",id,"ROOM2");
            this.id= id;
            loadModel();
        }

        return mSpeaker;
    }

    private void loadModel(){
        mSpeaker.setValue(speaker);
    }

    // IMPLEMENTAR EL RESTO DE  LA API

    public void setPlayState(SpeakerModel.PlayState state){
        speaker.playState = state;
        loadModel();
    }

    public void nextSong(){
        speaker.seletedSong = (1+speaker.seletedSong) % speaker.songs.size();
        speaker.loadSong();
        loadModel();
    }

    public void incrementProgress(){
        speaker.SongTimestamp++;
        loadModel();
    }


    public void prevSong(){
        speaker.seletedSong = (speaker.seletedSong >= 1) ? speaker.seletedSong -1 : speaker.songs.size()-1;
        speaker.loadSong();
        loadModel();
    }

    public void stop(){
        speaker.SongTimestamp = 0;
        speaker.SongDuration = 0;
        speaker.SongArtist = "";
        speaker.playState = SpeakerModel.PlayState.Stopped;
        loadModel();
    }

    public void setVolume(int volume){
        speaker.volume = volume;
        loadModel();
    }

    public void setGenre(int genre){
        speaker.genre = genre;
        loadModel();
    }

}
