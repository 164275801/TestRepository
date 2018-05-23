package com.lanou.thread;

public class MyThread {
	
	public static Thread t1 = new Thread(new Runnable() {

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println(i);
			}
		}
	});
	
	
	public void finalize(){
		System.out.println(this+"被回收了");
		
	}

	public static void main(String[] args) { 
		t1.start();
		System.out.println("_________________________");
		new Thread((Runnable) () -> {
			for (int i = 0; i++ < 10; System.out.println(i*10));	
		}).start();
		
		new MyThread();
		new MyThread();
		new MyThread();
		new MyThread();
		System.gc();
		new MyThread();
	}

} 
