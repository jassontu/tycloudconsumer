package ty.cloud.mq.consumer.utils.wx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ty.cloud.mq.consumer.utils.wx.bean.JsonResult;
import ty.cloud.mq.consumer.utils.wx.bean.MyX509TrustManager;


public class SendTemplateMessageBus {

	
	private static Log log = LogFactory.getLog(SendTemplateMessageBus.class);
	private static MyX509TrustManager my = new MyX509TrustManager();
	/**
	 * @desc 推送模板信息
	 * @param token
	 * @param msg
	 * @return
	 * @throws NoSuchProviderException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 * @throws IOException
	 */
	public static JsonResult sendMessage(String token, String requestMethod,String jsonContent) throws NoSuchAlgorithmException,
			NoSuchProviderException, KeyManagementException, IOException {
		String sendMsgUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
		String errcode = "";
		JsonResult jsonResult = new JsonResult();
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		InputStream inputStream = null;
		HttpsURLConnection httpUrlConn = null;
		try {
			StringBuffer buffer = new StringBuffer();
			JSONObject jsonObject = null;
			TrustManager[] tm = { my };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			sendMsgUrl = sendMsgUrl.replace("ACCESS_TOKEN", token);
			URL url = new URL(sendMsgUrl);
			httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);
			if ("POST".equalsIgnoreCase(requestMethod)) {
				httpUrlConn.connect();
			}
			// 当有数据需要提交时
			OutputStream outputStream = httpUrlConn.getOutputStream();
			System.out.println("模板消息："+jsonContent);
			outputStream.write(jsonContent.getBytes("UTF-8"));
			outputStream.close();
			// 将返回的输入流转换成字符串
			inputStream = httpUrlConn.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			jsonObject = JSONObject.fromObject(buffer.toString());
			errcode = jsonObject.getString("errcode");
			if("0".equals(errcode))
			{
				jsonResult.setSuccess(true);
			}
			else
			{
				jsonResult.setSuccess(false);
				jsonResult.setMessage(errcode);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			jsonResult.setSuccess(false);
			jsonResult.setMessage(e.getMessage());
		}
		finally
		{
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
		}
		return jsonResult;
	}

}
