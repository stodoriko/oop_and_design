package ru.netology;

public class Radio {

    private int radioChannelMin = 0;
    private int radioChannelMax;
    private int totalChannel;
    private int currentChannel;

    private int volumeMin = 0;
    private int volumeMax = 10;
    private int currentVolume;

    private boolean on;


    public Radio() {
        this.totalChannel = 10;
        this.radioChannelMax = totalChannel - 1;
    }
    public Radio(int totalChannel) {
        this.totalChannel = totalChannel;
        this.radioChannelMax = totalChannel - 1;
    }

    public void switchToNextChannel() {
        if (getCurrentChannel() == getRadioChannelMax()) {
            setCurrentChannel(radioChannelMin);
        } else if (getCurrentChannel() < getRadioChannelMax()) {
            currentChannel++;
            setCurrentChannel(currentChannel);
        } else {
            setCurrentChannel(radioChannelMax);
        }
    }

    public void switchToPrevChannel() {
        if (getCurrentChannel() == radioChannelMin) {
            setCurrentChannel(radioChannelMax);
        } else if (getCurrentChannel() > radioChannelMin) {
            currentChannel--;
            setCurrentChannel(currentChannel);
        } else {
            setCurrentChannel(radioChannelMin);
        }
    }

    public void increaseVolume() {
        if (getCurrentVolume() == volumeMax) {
            setCurrentVolume(getCurrentVolume());
        } else {
            setCurrentVolume(currentVolume + 1);
        }
    }

    public void decreaseVolume() {
        if (getCurrentVolume() == volumeMin) {
            currentVolume = getCurrentVolume();
        } else {
            setCurrentVolume(currentVolume - 1);
        }
    }


    public int getRadioChannelMin() {
        return radioChannelMin;
    }

    public int getRadioChannelMax() {
        return radioChannelMax;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getVolumeMin() {
        return volumeMin;
    }

    public void setCurrentChannel(int currentChannel) {
        this.currentChannel = currentChannel;
        if (getCurrentChannel() > radioChannelMax) {
            return;
        }
        if (getCurrentChannel() < radioChannelMin) {
            return;
        }
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public int getVolumeMax() {
        return volumeMax;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

}
