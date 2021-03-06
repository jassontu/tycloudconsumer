package ty.cloud.mq.consumer.utils.db.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ty.cloud.mq.consumer.exp.BusiException;
import ty.cloud.mq.consumer.utils.db.SqlDBHelper;
import ty.cloud.mq.consumer.utils.db.SqlDruidDBHelper;


public class SqlDB {
	private static Logger logger = LoggerFactory.getLogger(SqlDB.class);

	private static Object lockObj = new Object();
	
	static SqlDBHelper _sqDbHelper = null;

	//static MongoDBHelper _syncDbHelper = null;

	//static MongoDBHelper _asyncDbHelper = null;

	public static SqlDBHelper sqldb() {
		if (_sqDbHelper == null) {
			synchronized (lockObj) {
				if (_sqDbHelper == null) {
					try {
						_sqDbHelper = new SqlDruidDBHelper();
						
						
					} catch (Exception e) {
						logger.error(e.getMessage());
						throw new BusiException(e);
					}

				}
			}
		}
		return _sqDbHelper;
	}

	
}
