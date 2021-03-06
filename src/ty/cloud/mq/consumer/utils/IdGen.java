package ty.cloud.mq.consumer.utils;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.UUID;


/**
 * 封装各种生成唯一性ID算法的工具类.
 * @author 
 * @version 2013-01-15
 */

public class IdGen {
	
	private static SecureRandom random = new SecureRandom();
	
	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间�?-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}



}
