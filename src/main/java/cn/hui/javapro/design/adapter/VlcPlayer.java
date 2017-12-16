package cn.hui.javapro.design.adapter;

public class VlcPlayer implements AdvancedMediaPlayer {

    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name:" + fileName);
    }

    // 什么都不做
    public void playMp4(String fileName) {

    }

}