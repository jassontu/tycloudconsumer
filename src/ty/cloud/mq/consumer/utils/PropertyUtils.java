package ty.cloud.mq.consumer.utils;



import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
	public static Properties load(String filePath) throws IOException {
		InputStream in = PropertyUtils.class.getClassLoader()
				.getResourceAsStream(filePath);
		Properties props = new Properties();
		props.load(in);
		return props;
	}
}
