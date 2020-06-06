package br.com.ies.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import br.com.ies.Main;
import br.com.ies.dto.QueryDTO;
import br.com.ies.persistence.impl.PersistanceImpl;
import br.com.ies.type.QueryType;
import br.com.ies.util.Callback;
import br.com.ies.util.Utils;

public class PostgresPersistance extends PersistanceImpl {

	private final String PERSISTANCE_NAME = new String("Postgres");

	public PostgresPersistance() {
		super.setName(PERSISTANCE_NAME);
	}

	@Override
	public void persist(QueryDTO queryDTO) {
		try {
			List<String> columnValueStringList = queryDTO.getColumnValue().stream().map(cv -> cv.getColumn() + "=" + (cv.getValue() == null ? null : "'" + cv.getValue() + "'")).collect(Collectors.toList());
			String insertQuery = String.format(QueryType.INSERT_QUERY.getQuery(), queryDTO.getSchema().concat(".").concat(queryDTO.getTabela()), Utils.fillColunasNameByColumnValueList(queryDTO.getColumnValue()), Utils.fillCharInString('?', queryDTO.getColumnValue().size()));
			String updateQuery = String.format(QueryType.UPDATE_QUERY.getQuery(), Utils.fillColunasAndValuesFromColumnStringList(columnValueStringList));
			String conflictQuery = String.format(QueryType.CONFLICT_QUERY.getQuery(), insertQuery, Utils.getColunaFromField(queryDTO.getChavePrimaria()).nome(), updateQuery);
			PreparedStatement preparedStatement  = Main.getConnectionFactory().getPreparedStatement(conflictQuery);
			IntStream.range(0, queryDTO.getColumnValue().size()).forEachOrdered(i -> Utils.setParameter(preparedStatement, i + 1, queryDTO.getColumnValue().get(i).getValue()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void select(String sql, Callback callback) {
		PreparedStatement preparedStatement  = Main.getConnectionFactory().getPreparedStatement(sql);
		ResultSet rs = null;
		
		try {
			rs = preparedStatement.executeQuery();
			List<Object[]> lista = resultSetToList(rs);
			
			callback.call(lista);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private List<Object[]> resultSetToList(ResultSet rs) throws SQLException {
	    ResultSetMetaData md = rs.getMetaData();
	    int columns = md.getColumnCount();
	    List<Object[]> rows = new ArrayList<Object[]>();
	    while (rs.next()){
	    	Object[] row = new Object[columns];
	        for(int i = 1; i <= columns; ++i){
	        	row[i - 1] = rs.getObject(i);
	        }
	        rows.add(row);
	    }
	    return rows;
	}
}
