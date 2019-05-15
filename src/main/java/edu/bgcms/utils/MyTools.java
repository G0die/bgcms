package edu.bgcms.utils;

import edu.bgcms.model.user.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.List;
import java.util.UUID;
public class MyTools {
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	public static User getCurUser(){
		Subject subject = SecurityUtils.getSubject();
		return (User) subject.getPrincipal();
	}
	public static Boolean isFollow(List<String> follwPerson){
		boolean followFlag = false;
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		for (String id : follwPerson) {
			if (id.equals(user.getUuid())){
				followFlag = true ;
			}
		}
		return followFlag;
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
