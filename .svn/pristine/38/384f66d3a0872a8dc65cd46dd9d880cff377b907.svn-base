package ty.cloud.mq.consumer.utils.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import ty.cloud.mq.consumer.utils.PropertyUtils;

public class SqlDruidDBHelper implements SqlDBHelper {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	DataSource dataSource;

	public SqlDruidDBHelper() throws Exception {
		dataSource = DruidDataSourceFactory.createDataSource(PropertyUtils.load("druid.properties"));
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	@Override
	public int execute(String sql, Object... parameterValues) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = prepareStatement(sql, parameterValues);
			return stmt.executeUpdate();
		} finally {
			close(stmt);

		}

	}

	private void close(PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.getConnection().close();
				stmt.close();
			} catch (SQLException e) {
				logger.error("PreparedStatement close error:" + e.getLocalizedMessage());
			}
		}
	}

	@Override
	public Result query(String sql, Object... parameterValues) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = prepareStatement(sql, parameterValues);
			return ResultSupport.toResult(stmt.executeQuery());
		} finally {
			close(stmt);
		}
	}

	private PreparedStatement prepareStatement(String sql, Object... parameterValues) throws SQLException {
		PreparedStatement stmt = getConnection().prepareStatement(sql);
		if (parameterValues != null) {
			int i = 1;
			for (Object param : parameterValues) {
				stmt.setObject(i++, param);
			}
		}
		return stmt;
	}

	@Override
	public Object scalar(String sql, Object... parameterValues) throws SQLException {
		Result rs = query(sql, parameterValues);
		if (rs != null && rs.getRowsByIndex().length > 0) {
			return rs.getRowsByIndex()[0][0];
		}
		return null;
	}

	@Override
	public int batchInsert(String tabName, List<LinkedHashMap<String, String>> param) throws SQLException {
		int rs = 0;
		PreparedStatement ps = null;
		Connection conn = null;
		StringBuffer first = new StringBuffer();
		String keys, values;
		first.append("insert into  " + tabName + "(");
		StringBuffer last = new StringBuffer();
		last.append(" values (");
		int max = 0;
		LinkedHashMap<String, String> keymap = null;;
		for (LinkedHashMap<String, String> map : param) {
			if(map.size()>max){
				max = map.size();
				keymap = map;
			}
		}
			for (Entry<String, String> entry : keymap.entrySet()) {
				first.append(entry.getKey() + ",");
				last.append("?,");
			}
		
		keys = first.substring(0, first.length() - 1) + ")";
		values = last.substring(0, last.length() - 1) + ")";
		logger.info("批量插入sql" + keys + values);
		try {
			conn = getConnection();
			conn.setAutoCommit(false);// 关闭自动提交
			ps = conn.prepareStatement(keys + values);
			for (LinkedHashMap<String, String> map : param) {
				int count = 1;

				for (Entry<String, String> entry : map.entrySet()) {
					if(entry.getValue()==null||entry.getValue()==""){
						ps.setString(count," " );
					}else{
						ps.setString(count,entry.getValue() );
					}
					count++;
				}

				ps.addBatch();
				rs=1;
			}
			ps.executeBatch();// 同时提交多条数据

			conn.commit();
			logger.info("批量插入" + rs + "数据成功");
		} catch (Exception e) {
			logger.error("sql异常信息："+keys + values);
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return rs;
	}


}
