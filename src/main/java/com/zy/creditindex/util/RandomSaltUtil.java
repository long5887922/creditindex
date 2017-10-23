package com.zy.creditindex.util;

import java.util.Random;

/**
 * 
 * @作者
 * @随机生成盐
 */
public class RandomSaltUtil {
	public static String getRandomSalt(int n) {
		// 定义一个字符数组
		char[] randomCode = "qwertyuiopasdfghjklzxcvbnm12345".toCharArray();
		// 随机数
		Random random = new Random();
		String randomSalt = "";
		for (int i = 0; i < n; i++) {
			randomSalt += randomCode[random.nextInt(randomCode.length)];
		}
		return randomSalt;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String randomSalt = getRandomSalt(4);
		System.out.println(randomSalt);

	}

}
