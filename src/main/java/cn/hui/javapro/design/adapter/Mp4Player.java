package cn.hui.javapro.design.adapter;

public class Mp4Player implements AdvancedMediaPlayer{

    //什么都不做
	public void playVlc(String fileName) {
		
	}

	public void playMp4(String fileName) {
		System.out.println("Playing mp4 file. Name:"+fileName);
	}

}