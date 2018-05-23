package com.lanou.te;

public class MyRun implements Runnable {
	private String name;
	private int age;

	public MyRun() {
	}

	public MyRun(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			System.out.println(Thread.currentThread().getId() + Thread.currentThread().getName() + "------循环操作------"
					+ count + "==姓名：" + this.name + "==年龄：" + this.age);
			if (count >= 5) {
				break;
			}
			// 如果是线程t1，而且count==2的时候，把name变成aaa
			if (count == 2 && "t1".equals(Thread.currentThread().getName())) {
				this.name = "aaa";
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
		}
	}



public static void main(String[] args) {
		//对多线程而言，如果是单例，成员变量是共享的，
		//任何一个线程，只要改变成员变量，对所有的线程而言，对象的成员都会改变
		//而且存在同步问题（改变和读取有冲突）
		MyRun myRun = new MyRun("abc", 16);
		Thread t1 = new Thread(myRun,"t1");
		Thread t2 = new Thread(myRun,"t2");
		t1.start();
		t2.start();

		
	}
}
