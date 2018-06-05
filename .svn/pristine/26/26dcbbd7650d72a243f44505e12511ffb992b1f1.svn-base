package ty.cloud.mq.consumer.service.dao.wl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import ty.cloud.mq.consumer.service.dao.wl.entity.GpsRealData;
import ty.cloud.mq.consumer.utils.db.impl.SqlDB;

public class GpsRealDataDao {
	private static Logger logger = LoggerFactory
			.getLogger(GpsRealDataDao.class);

	public int execute(String data) throws SQLException {
		Connection conn = SqlDB.sqldb().getConnection();
		int count = 0;
		JSONArray arr = JSONObject.parseArray(data);
		for (Object obj : arr) {
			GpsRealData gps = JSONObject.parseObject(obj.toString(),GpsRealData.class);
			//判断是否存在记录
			if(findExits(gps.getUid(),conn)){
				//存在
				count+=update(gps,conn);
			}else{
				//不存在
				count+=insert(gps,conn);
			}
		}
		close(conn);
		return count;
	}

	public int insert(GpsRealData gps,Connection conn ) {
		int rs = 0;
		if (gps != null) {
			String insertSql = "INSERT INTO gps_gpsrealdata("
					+ "uid,simNo,plateNo,sendTime,longitude,latitude,velocity,"
					+ "direction,status,alarmState,isValid,mileage,oil,"
					+ "recordVelocity,location,online,baiduLongitude,baiduLatitude,"
					+ "acc,positive) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = null;
			
			try {
				pstmt = conn.prepareStatement(insertSql);
				pstmt.setString(1, gps.getUid());
				pstmt.setString(2, gps.getSimNo());
				pstmt.setString(3, gps.getPlateNo());
				pstmt.setString(4, gps.getSendTime());
				pstmt.setString(5, gps.getLongitude());
				pstmt.setString(6, gps.getLatitude());
				pstmt.setString(7, gps.getVelocity());
				pstmt.setString(8, gps.getDirection());
				pstmt.setString(9, gps.getStatus());
				pstmt.setString(10, gps.getAlarmState());
				pstmt.setString(11, gps.getIsValid());
				pstmt.setString(12, gps.getMileage());
				pstmt.setString(13, gps.getOil());
				pstmt.setString(14, gps.getRecordVelocity());
				pstmt.setString(15, gps.getLocation());
				pstmt.setString(16, gps.getOnline());
				pstmt.setString(17, gps.getBaiduLongitude());
				pstmt.setString(18, gps.getBaiduLatitude());
				pstmt.setString(19, gps.getAcc());
				pstmt.setString(20, gps.getPositive());
				rs = pstmt.executeUpdate();
			} catch (SQLException e) {
				logger.error("gpsRealDataDao error" + e.getMessage());
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		}
		return rs;
	}

	private void close(PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				logger.error("PreparedStatement close error:"
						+ e.getLocalizedMessage());
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

	private boolean findExits(String uid,Connection conn) throws SQLException {
		boolean flag = false;
		PreparedStatement pst = null;
		String str = "select uid from gps_gpsrealdata where uid =?";
		pst = conn.prepareStatement(str);

		pst.setString(1, uid);

		ResultSet rs = null;
		rs = pst.executeQuery();

		while (rs.next()) {
			
			flag = true;
		}
		rs.close();
		pst.close();
		return flag;
	}

	private static int update(GpsRealData gps,Connection conn) throws SQLException {
		int rs = 0;
		String sql = "update gps_gpsrealdata"
				+ " set SendTime = ?,Longitude = ?,Latitude = ?,Velocity = ?,"
				+ "Direction = ?,Status = ?,Mileage = ?,Oil = ?,BaiduLongitude = ?,"
				+ "BaiduLatitude = ?,Acc = ?,Positive = ?" + " where UID = ?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, gps.getSendTime());
			pstmt.setString(2, gps.getLongitude());
			pstmt.setString(3, gps.getLatitude());
			pstmt.setString(4, gps.getVelocity());
			pstmt.setString(5, gps.getDirection());
			pstmt.setString(6, gps.getStatus());
			pstmt.setString(7, gps.getMileage());
			pstmt.setString(8, gps.getOil());
			pstmt.setString(9, gps.getBaiduLongitude());
			pstmt.setString(10, gps.getBaiduLatitude());
			pstmt.setString(11, gps.getAcc());
			pstmt.setString(12, gps.getPositive());
			pstmt.setString(13, gps.getUid());
			rs = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
