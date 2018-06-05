package ty.cloud.mq.consumer.service.dao.wl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ty.cloud.mq.consumer.service.dao.wl.entity.Car;
import ty.cloud.mq.consumer.service.dao.wl.entity.CarStation;
import ty.cloud.mq.consumer.utils.db.impl.SqlDB;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;





public class CarDao {
	private static Logger logger = LoggerFactory.getLogger(CarDao.class);
	
	public int insert(String data) {
		int count = 0;
		if (data != null) {
			String insertSql = "INSERT INTO car (uID,carUID,carID,carNo,carTypeID,pumpTypeID,belongTo,lastBackTime," +
					"carStatus,maxCube,terminalID,sIM,orderNum,isUse,isGPSInBack,duty,checkDate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			JSONArray arr = JSONObject.parseArray(data);
			PreparedStatement pstmt = null;
			Connection conn = null;
			try {
				conn = SqlDB.sqldb().getConnection();
				conn.setAutoCommit(false);// 关闭自动提交
				 pstmt = conn.prepareStatement(insertSql);
				for (Object obj : arr) {
					Car car = JSONObject.parseObject(obj.toString(), Car.class);
					pstmt.setString(1, car.getUID());
					pstmt.setString(2, car.getCarUID());
					pstmt.setString(3, car.getCarID());
					pstmt.setString(4, car.getCarNo());
					pstmt.setString(5, car.getCarTypeID());
					pstmt.setString(6, car.getPumpTypeID());
					pstmt.setString(7, car.getBelongTo());
					pstmt.setString(8, car.getLastBackTime());
					pstmt.setString(9, car.getCarStatus());
					pstmt.setString(10, car.getMaxCube());
					pstmt.setString(11, car.getTerminalID());
					pstmt.setString(12, car.getSIM());
					pstmt.setString(13, car.getOrderNum());
					pstmt.setString(14, car.getIsUse());
					pstmt.setString(15, car.getIsGPSInBack());
					pstmt.setString(16, car.getDuty());
					pstmt.setString(17, car.getCheckDate());
					pstmt.addBatch();
					count++;
				}
				pstmt.executeBatch();
				conn.commit();
			} catch (SQLException e) {
				logger.error("CarDao error" + e.getMessage());
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(conn);
			}
		}
		return count;
	}

	private void close(PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				logger.error("PreparedStatement close error:" + e.getLocalizedMessage());
			}
		}
	}

	private void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("conn close error:" + e.getLocalizedMessage());
			}
		}
	}
}
