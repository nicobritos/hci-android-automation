package com.hci.StarkIndustries.data.Models.devices.DeviceModels;

import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;

public class SpeakerModel extends CommonDeviceModel {
    public static final int MAX_VOLUME = 10;
    public static final int MIN_VOLUME = 0;

    public static final String GENRE_CLASSICAL = "classical";
    public static final String GENRE_COUNTRY = "country";
    public static final String GENRE_DANCE = "dance";
    public static final String GENRE_LATINA = "latina";
    public static final String GENRE_POP = "pop";
    public static final String GENRE_ROCK = "rock";

    private SpeakerState state;

    public String getStatus() {
        return this.state.getStatus();
    }

    public PlayState getPlayState() {
        return this.state.getPlayState();
    }

    public String getGenre() {
        return this.state.getGenre();
    }

    public Integer getVolume() {
        return this.state.getVolume();
    }

    public SpeakerSong getCurrentSong() {
        return this.state.getCurrentSong();
    }

    public enum PlayState {
        Playing(), Paused(), Stopped();
    }

    private class SpeakerState {
        private String status, genre;
        private Integer volume;
        private SpeakerSong song;

        public String getStatus() {
            return status != null ? status : "";
        }

        public PlayState getPlayState() {
            switch (this.getStatus()) {
                case "playing": return PlayState.Playing;
                case "paused": return PlayState.Paused;
                default: return PlayState.Stopped;
            }
        }

        public String getGenre() {
            return genre != null ? genre : "";
        }

        public Integer getVolume() {
            return volume != null ? volume : MIN_VOLUME;
        }

        public SpeakerSong getCurrentSong() {
            return song;
        }
    }

    public class SpeakerSong {
        private String title, artist, album, duration, progress;

        public String getTitle() {
            return title != null ? title : "";
        }

        public String getArtist() {
            return artist != null ? artist : "";
        }

        public String getAlbum() {
            return album != null ? album : "";
        }

        public String getDuration() {
            return duration != null ? duration : "";
        }

        public String getProgress() {
            return progress != null ? progress : "";
        }
    }
}
