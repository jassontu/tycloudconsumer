package ty.cloud.mq.consumer.service.dao.wl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ty.cloud.mq.consumer.service.dao.wl.entity.CarStation;
import ty.cloud.mq.consumer.service.dao.wl.entity.Station;
import ty.cloud.mq.consumer.utils.db.impl.SqlDB;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;




public class CarStationDao {
	private static Logger logger = LoggerFactory.getLogger(CarStationDao.class);
	
	public int insert(String data) {
		int count = 0;
		if (data != null) {
			String insertSql = "INSERT INTO carstation (stationID,carUID) values(?,?)";
			JSONArray arr = JSONObject.parseArray(data);
			PreparedStatement pstmt = null;
			Connection conn = null;
			try {
				conn = SqlDB.sqldb().getConnection();
				conn.setAutoCommit(false);// 关闭自动提交
				 pstmt = conn.prepareStatement(insertSql);
				for (Object obj : arr) {
					CarStation cs = JSONObject.parseObject(obj.toString(), CarStation.class);
					pstmt.setString(1, cs.getStationID());
					pstmt.setString(2, cs.getCarUID());
					pstmt.addBatch();
					count++;
				}
				pstmt.executeBatch();
				conn.commit();
			} catch (SQLException e) {
				logger.error("StationDao error" + e.getMessage());
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
