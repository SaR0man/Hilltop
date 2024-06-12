package com.top.springapp;

import java.util.List;

public class MusicPlayer {
    private Music music;
    private List<Music> musicList;  // список музыки
    private String name;  // марка плеера
    private int volume;  // громкость

    public MusicPlayer() {
    }

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    //// выводим инфо о плеере
    public void printInfo() {
        System.out.println(
                "Model         : " + this.name + "\n" +
                "Volume        : " + this.volume + "\n" +
                "List of music : ");

        for (Music music : musicList) {
            System.out.println(music.getSong());
        }
    }
}
