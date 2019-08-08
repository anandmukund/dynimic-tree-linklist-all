package com.algo1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleETest {
	ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
	{
		exec.scheduleAtFixedRate(new Runnable() {
		  @Override
		  public void run() {
		   add(4);
		  }
		}, 0, 50, TimeUnit.SECONDS);
	}
	
	public int add(int no){
		int h = 0 ;
		for (int i = 0; i < 10 ; i++){
			if(h<20){
				h = 3*i;
				System.out.println(h);
			}
			else{
				System.out.println("kaam ho gaya");
				exec.shutdown();
			}
		}
		return 0;
	}
	public static void main(String d[]){
		new SingleETest();
	}
}
