package com.hci.StarkIndustries.ui.DeviceMenu.Speaker;

import com.hci.StarkIndustries.data.Models.devices.DeviceModels.SpeakerModel;
import com.hci.StarkIndustries.data.domain.DeviceRepository;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;

public class SpeakerViewModel extends DeviceViewModel<SpeakerModel> {
    private static final int GENRE_CLASSICAL = 0;
    private static final int GENRE_COUNTRY = 1;
    private static final int GENRE_DANCE = 2;
    private static final int GENRE_LATINA = 3;
    private static final int GENRE_POP = 4;
    private static final int GENRE_ROCK = 5;

    public void setPlayState(SpeakerModel.PlayState playState) {
        if (model.getPlayState().equals(playState)) return;

        DeviceRepository.SpeakerActions action;
        switch (playState) {
            case Playing:
                action = model.getPlayState().equals(SpeakerModel.PlayState.Paused) ?
                        DeviceRepository.SpeakerActions.RESUME : DeviceRepository.SpeakerActions.PLAY;
                break;
            case Paused:
                action = DeviceRepository.SpeakerActions.PAUSE;
                break;
            default:
                action = DeviceRepository.SpeakerActions.STOP;
                break;
        }

        this.performActionOnDevice(action.getCommand());
    }

    public void nextSong() {
        if (!model.getPlayState().equals(SpeakerModel.PlayState.Playing)) return;
        this.performActionOnDevice(DeviceRepository.SpeakerActions.NEXT_SONG.getCommand());
    }

    public void previousSong() {
        if (!model.getPlayState().equals(SpeakerModel.PlayState.Playing)) return;
        this.performActionOnDevice(DeviceRepository.SpeakerActions.PREVIOUS_SONG.getCommand());
    }

    public void setVolume(int volume) {
        if (volume == this.model.getVolume() || volume < SpeakerModel.MIN_VOLUME || volume > SpeakerModel.MAX_VOLUME)
            return;

        DeviceRepository.SpeakerActions action = DeviceRepository.SpeakerActions.SET_VOLUME;
        this.performActionOnDevice(action.getCommand(), action.getField(), volume);
    }

    public void setGenre(int position) {
        String genre;

        switch (position) {
            case GENRE_CLASSICAL:
                genre = SpeakerModel.GENRE_CLASSICAL;
                break;
            case GENRE_COUNTRY:
                genre = SpeakerModel.GENRE_COUNTRY;
                break;
            case GENRE_DANCE:
                genre = SpeakerModel.GENRE_DANCE;
                break;
            case GENRE_LATINA:
                genre = SpeakerModel.GENRE_LATINA;
                break;
            case GENRE_POP:
                genre = SpeakerModel.GENRE_POP;
                break;
            case GENRE_ROCK:
                genre = SpeakerModel.GENRE_ROCK;
                break;
            default: return;
        }

        if (this.model.getGenre().equals(genre)) return;
        DeviceRepository.SpeakerActions action = DeviceRepository.SpeakerActions.SET_GENRE;
        this.performActionOnDevice(action.getCommand(), action.getField(), genre);
    }

    public int getGenreInt() {
        switch (this.model.getGenre()) {
            case SpeakerModel.GENRE_CLASSICAL: return GENRE_CLASSICAL;
            case SpeakerModel.GENRE_COUNTRY: return GENRE_COUNTRY;
            case SpeakerModel.GENRE_DANCE: return GENRE_DANCE;
            case SpeakerModel.GENRE_LATINA: return GENRE_LATINA;
            case SpeakerModel.GENRE_POP: return GENRE_POP;
            default: return GENRE_ROCK;
        }
    }
}
