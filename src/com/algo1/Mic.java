package com.algo1;

import java.io.DataInputStream;

import javax.sound.sampled.*;

public class Mic extends Thread{
    boolean flag;
    TargetDataLine mic;
    byte[] buffer;
    AudioFormat format;

    public static void main(String[] args) {
       Mic a=new Mic();
       a.start();
    }
    @Override
    public void run()
    {
        flag=true;
        startMic();
        while(flag)
        {
            send();
        }
    }
    public void send()
    {
        try{
            mic.read(buffer,0,512);
            System.out.println("1. "+buffer[0]);
        }catch(Exception ex)
        {

        }
    }
    public void startMic()
    {
        try{
            format=new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,8000.0F,16,2,4,8000.0F,true);
            DataLine.Info info=new DataLine.Info(TargetDataLine.class,format);
            mic=(TargetDataLine)AudioSystem.getLine(info);
            mic.open();
            mic.start();
            buffer=new byte[512];
            
         // Create an AudioDataStream to play back
         AudioInputStream audioStream = new AudioInputStream(mic);
         // Play the sound
         audioStream.read(buffer);
           System.out.println(audioStream);
        }catch(Exception exx)
        {
            System.out.println("exx");
        }

    }
}