package com.example.demo.并发;

import javax.servlet.annotation.HandlesTypes;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @program: demo
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-07-18 15:35
 **/
public class CallableTest implements Callable {

	@Override
	public Object call() throws Exception {
		for (int i = 0; i < 3; i++) {
			String s = "hello"+i;
			System.out.println(s);
			return s;
		}
		//System.out.println(s);
		return null;
	}

	public static void main(String[] args){
		new Thread(()->{
			CallableTest callableTest = new CallableTest();
			try {
				callableTest.call();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();

	}
}
