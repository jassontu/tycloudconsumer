package ty.cloud.mq.consumer;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new ClassPathXmlApplicationContext(new String[] {
		"spring-config.xml" });
		System.in.read();
	}

}
