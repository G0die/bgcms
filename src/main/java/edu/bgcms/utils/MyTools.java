package edu.bgcms.utils;
import java.util.UUID;
public class MyTools {
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	public static void main(String[] args) {
		/*
		 * uuid是一个字符串
		 * 特点：永远不会重复
		 */
		String uuid=UUID.randomUUID().toString();
		System.out.println(uuid);
		System.out.println("--------------");
		System.out.println(uuid.replace("-", ""));
		System.out.println("--------------");
		System.out.println(uuid.replace("-", "").length());
	}
}
