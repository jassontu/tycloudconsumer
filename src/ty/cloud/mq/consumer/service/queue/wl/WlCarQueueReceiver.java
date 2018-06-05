package ty.cloud.mq.consumer.service.queue.wl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.BytesMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ty.cloud.mq.consumer.service.dao.wl.CarDao;

@Service("WlCarQueueReceiver")
public class WlCarQueueReceiver  implements MessageListener {

	private Logger logger = LoggerFactory.getLogger(WlStationQueueReceiver.class);

	ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);

	public static final int expiretime = 3600 * 24;// 

	@Override
	public void onMessage(Message message) {
		try {
			if(message instanceof TextMessage)
			{
				final String body = ((TextMessage) message).getText();
				fixedThreadPool.execute(new Runnable() {
					@Override
					public void run() {
						savedata(body);
					}
				});
				logger.info("接收到消息:{}", body);
			}
			if (message instanceof BytesMessage) {
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void savedata(String data) {
		CarDao carDao = new CarDao();
		carDao.insert(data);
	}

}
