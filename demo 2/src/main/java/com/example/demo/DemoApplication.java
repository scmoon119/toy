package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class DemoApplication {

	public static void shuffleArray(String[] array) {
		Random rnd = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// swap array[i] and array[index]
			String temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
	}
	public static void main(String[] args) {
		String[] strArray = {"김성곤", "김태효", "김현주", "노민호", "문희", "박기찬", "박세완", "박유진", "신문석", "신윤섭",
				"이시정", "이아람", "이원호", "이제훈", "정나리", "정수빈", "정진웅", "정태인", "조성준", "최세훈", "최호정",
				"허진녕", "홍규혁", "변지윤"};

		shuffleArray(strArray);

		for(int i = 0 ;i < strArray.length; i ++){
			System.out.println((i+1) + " : "  + strArray[i]);
		}

	}

}
