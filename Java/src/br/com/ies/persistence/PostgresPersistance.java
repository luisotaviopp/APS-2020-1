package br.com.ies.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import br.com.ies.Main;
import br.com.ies.dto.PersistanceParameterDTO;
import br.com.ies.dto.QueryDTO;
import br.com.ies.persistence.impl.PersistanceImpl;
import br.com.ies.type.QueryType;
import br.com.ies.util.Callback;
import br.com.ies.util.Util;

public class PostgresPersistance extends PersistanceImpl {

	private final String PERSISTANCE_NAME = new String("Postgres");

	public PostgresPersistance() {
		super.setName(PERSISTANCE_NAME);
	}

	@Override
	public void persist(QueryDTO queryDTO) {
		try {
			List<String> columnValueStringList = queryDTO.getColumnValue().stream().map(cv -> cv.getColumn() + "=" + (cv.getValue() == null ? null : "'" + cv.getValue() + "'")).collect(Collectors.toList());
			String insertQuery = String.format(QueryType.INSERT_QUERY.getQuery(), queryDTO.getSchema().concat(".").concat(queryDTO.getTabela()), Util.fillColunasNameByColumnValueList(queryDTO.getColumnValue()), Util.fillCharInString('?', queryDTO.getColumnValue().size()));
			String updateQuery = String.format(QueryType.UPDATE_QUERY.getQuery(), Util.fillColunasAndValuesFromColumnStringList(columnValueStringList));
			String conflictQuery = String.format(QueryType.CONFLICT_QUERY.getQuery(), insertQuery, Util.getColunaFromField(queryDTO.getChavePrimaria()).nome(), updateQuery);
			PreparedStatement preparedStatement  = Main.getConnectionFactory().getPreparedStatement(conflictQuery);
			IntStream.range(0, queryDTO.getColumnValue().size()).forEachOrdered(i -> Util.setParameter(preparedStatement, i + 1, queryDTO.getColumnValue().get(i).getValue()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public <T> void select(PersistanceParameterDTO<T> select, Callback callback) {
		PreparedStatement preparedStatement  = Main.getConnectionFactory().getPreparedStatement(select.getParameter().toString());
		ResultSet resultSet = null;
		
		try {
			resultSet = preparedStatement.executeQuery();
			List<Object[]> lista = Util.resultSetToList(resultSet);
			callback.call(lista);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
