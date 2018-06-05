package ty.cloud.mq.consumer.service.dao.wl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import ty.cloud.mq.consumer.service.dao.wl.entity.UserStation;
import ty.cloud.mq.consumer.utils.db.impl.SqlDB;



public class UserStationDao {

	private static Logger logger = LoggerFactory.getLogger(UserStationDao.class);

	public int insert(String data) {
		int count = 0;
		if (data != null) {
			String insertSql = "INSERT INTO CloudUserStation( UserStationID,UserID,"
				+ "StationID,GroupID,AssociationID,stype) VALUES (?,?,?,?,?,?)";
 			JSONArray arr = JSONObject.parseArray(data);
			PreparedStatement pstmt = null;
			Connection conn = null;
			try {
				conn = SqlDB.sqldb().getConnection();
				conn.setAutoCommit(false);// 关闭自动提交
				 pstmt = conn.prepareStatement(insertSql);
				
				for (Object obj : arr) {
					UserStation us = JSONObject.parseObject(obj.toString(), UserStation.class);		
					
					pstmt.setString(1,us.getUserStationId());
					pstmt.setString(2,us.getUserId());
					pstmt.setString(3, us.getStationId());
					pstmt.setString(4, us.getGroupId());
					pstmt.setString(5, us.getAssociationId());
					pstmt.setString(6, us.getStype());
					pstmt.addBatch();
					//pstmt.executeUpdate();
					count++;
				}
				pstmt.executeBatch();// 同时提交多条数据
				conn.commit();
			} catch (SQLException e) {
				logger.error("UserStationDao error" + e.getMessage());
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
