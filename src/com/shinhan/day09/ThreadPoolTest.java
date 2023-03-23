package com.shinhan.day09;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTest {

	public static void main(String[] args) {

		String[][] mails = new String[1000][3];
		for(int i=0;i<mails.length;i++) {
			mails[i][0]="admin@my.com";
			mails[i][1]="member"+i+"@my.com";
			mails[i][2]="신상품 입고";
		}
		ExecutorService service = Executors.newFixedThreadPool(5);
		for(int i=1;i<=100;i++) {
			int index = i;
			
			Future<Integer> future = service.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for(int j=1;j<=index;j++) {
						sum += j;
					}
					return sum;
				}
			});
			try {
				int result = future.get();
				System.out.println("future.get() : "+ index + "까지 합계는 "+ result);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		service.shutdown();

	}


}
