package com.hci.StarkIndustries.Models.DeviceModels;

import com.hci.StarkIndustries.Models.CommonDeviceModel;
import com.hci.StarkIndustries.Models.DeviceType;

import java.util.ArrayList;
import java.util.List;

public class SpeakerModel extends CommonDeviceModel {

    public enum PlayState{
      Playing,Paused,Stopped
    };

    public class SongModel{
        public int duration;
        public int timestamp = 0;
        public String name;
        public String artist;

        public SongModel(int duration, String name, String artist) {
            this.duration = duration;
            this.name = name;
            this.artist = artist;
        }
    }

    public int volume = 3;
    public PlayState playState = PlayState.Playing;
    public int genre = 1;
    public int seletedSong = 2;
    public List<SongModel> songs = new ArrayList<>();

    public int SongDuration;
    public int SongTimestamp;
    public String SongName;
    public String SongArtist;



    public SpeakerModel(String name, String id, String room) {
        super(name, id, room, DeviceType.Speaker,false);

        songs.add(new SongModel(320,"Cancion 1 Cancion 1 Cancion 1 Cancion 1 Cancion 1 Cancion 1 Cancion 1 Cancion 1 Cancion 1 Cancion 1","Artista"));
        songs.add(new SongModel(120,"Cancion 2","Artista2"));
        songs.add(new SongModel(220,"Cancion 3","Artista3"));
        songs.add(new SongModel(420,"Cancion 4","Artista4"));

        loadSong();


    }

    public void loadSong(){
        SongArtist = songs.get(seletedSong).artist;
        SongDuration = songs.get(seletedSong).duration;
        SongName = songs.get(seletedSong).name;
        SongTimestamp = songs.get(seletedSong).timestamp;
    }
}















