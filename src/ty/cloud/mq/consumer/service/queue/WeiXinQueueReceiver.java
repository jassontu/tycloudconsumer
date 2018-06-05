package ty.cloud.mq.consumer.service.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ty.cloud.mq.consumer.utils.WeiXinTokenUtil;
import ty.cloud.mq.consumer.utils.wx.SendTemplateMessageBus;
import ty.cloud.mq.consumer.utils.wx.bean.JsonResult;

/**
 * @description Queque消息监听器
 */
@Service("weiXinQueueReceiver")
public class WeiXinQueueReceiver implements MessageListener {

	private Logger logger = LoggerFactory.getLogger(WeiXinQueueReceiver.class);

	ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
	/*ExecutorService areaRemindFixedThreadPool = Executors.newFixedThreadPool(6);
	ExecutorService carStopRemindFixedThreadPool = Executors.newFixedThreadPool(6);
	ExecutorService messageSendThreadPool = Executors.newFixedThreadPool(6);
	ExecutorService lineWarnFixedThreadPool = Executors.newFixedThreadPool(6);*/

	public static final int expiretime = 3600 * 24;// 设置过期时间,单位秒
	public String token = "";
	JsonResult jsonResult = new JsonResult();
	@Override
	public void onMessage(Message message) {
		token = WeiXinTokenUtil.getToken();
		try {
			if(message instanceof TextMessage)
			{
				final String body = ((TextMessage) message).getText();
				String[] params = body.split("content=");
				if(params.length>0)
				{
					final String content = params[1];
					System.out.println(content);
					fixedThreadPool.execute(new Runnable() {
						@Override
						public void run() {
							send(content);
						}
					});
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void send(String data) {
		/*try {
			jsonResult = SendTemplateMessageBus.sendMessage(token, "POST", data);
			String code = jsonResult.getMessage();
			System.out.println("模板消息返回的success:"+jsonResult.isSuccess());
			System.out.println("模板消息返回结果:"+code);
			logger.info("模板消息:"+data);
			logger.info("模板消息返回的success:"+jsonResult.isSuccess());
			logger.info("模板消息返回的success:"+jsonResult.isSuccess());
		} catch (Exception e) {
			logger.info("WeiXinQueneReceiver异常:", e.getMessage());
		}*/
		
	}

}
