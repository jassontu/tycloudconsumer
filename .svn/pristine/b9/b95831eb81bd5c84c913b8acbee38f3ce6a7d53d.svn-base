package ty.cloud.mq.consumer.utils.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.jsp.jstl.sql.Result;

public interface SqlDBHelper {
	public int execute(String sql, Object... parameterValues)
			throws SQLException;

	public Result query(String sql, Object... parameterValues)
			throws SQLException;

	public Object scalar(String sql, Object... parameterValues)
			throws SQLException;
	public Connection getConnection() throws SQLException;
	/*public int batchInsert(String sql,List<List<Object>> param)throws SQLException;*/
	public int batchInsert(String tabName, List<LinkedHashMap<String, String>> param)throws SQLException;
}
