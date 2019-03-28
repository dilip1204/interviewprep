package com.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader{
	INSTANCE;
	
	private Semaphore semaphore = new Semaphore(6, true);
	
	public void downloadData() {
		try {
			semaphore.acquire();
			download();
		} catch (Exception e) {
		e.printStackTrace();
		}
		finally {
			semaphore.release(); 
		}
	}
	
	public void download() {
		System.out.println("downlaod data from web");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

public class SemaphoresTest {
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		
		for(int i=0;i<10;i++) {
			exec.execute(new Runnable() {
				
				@Override
				public void run() {
					Downloader.INSTANCE.downloadData();
				}
			});
		}
	}

}
