package br.com.ies.backend.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import br.com.ies.backend.Main;
import br.com.ies.backend.dto.PersistenceDTO;
import br.com.ies.backend.dto.PersistenceParameterDTO;
import br.com.ies.backend.persistence.impl.PersistenceImpl;
import br.com.ies.backend.type.QueryType;
import br.com.ies.backend.util.PersistenceUtil;
import br.com.ies.backend.util.ReflectionUtil;
import br.com.ies.backend.util.Util;
import br.com.ies.backend.util.lib.Callback;

public class PostgresPersistence extends PersistenceImpl {

	private final String PERSISTENCE_NAME = new String("Postgres");

	public PostgresPersistence() {
		super.setName(PERSISTENCE_NAME);
	}
	
	@Override
	public void persist(PersistenceDTO queryDTO) {
		try {
			List<String> columnValueStringList = queryDTO.getColumnValue().stream().map(cv -> cv.getColumn() + "=" + (cv.getValue() == null ? null : "'" + cv.getValue() + "'")).collect(Collectors.toList());
			String insertQuery = String.format(QueryType.INSERT_QUERY.getQuery(), queryDTO.getSchema().concat(".").concat(queryDTO.getTabela()), Util.fillColunasNameByColumnValueList(queryDTO.getColumnValue()), Util.fillCharInString('?', queryDTO.getColumnValue().size()));
			String updateQuery = String.format(QueryType.UPDATE_QUERY.getQuery(), Util.fillColunasAndValuesFromColumnStringList(columnValueStringList));
			String conflictQuery = String.format(QueryType.CONFLICT_QUERY.getQuery(), insertQuery, ReflectionUtil.getColunaFromField(queryDTO.getChavePrimaria()).nome(), updateQuery);
			PreparedStatement preparedStatement  = Main.getConnectionFactory().getPreparedStatement(conflictQuery);
			IntStream.range(0, queryDTO.getColumnValue().size()).forEachOrdered(i -> PersistenceUtil.setParameter(preparedStatement, i + 1, queryDTO.getColumnValue().get(i).getValue()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public <T> void select(PersistenceParameterDTO<T> select, Callback callback) {
		PreparedStatement preparedStatement  = Main.getConnectionFactory().getPreparedStatement(select.getParameter().toString());
		ResultSet resultSet = null;
		
		try {
			resultSet = preparedStatement.executeQuery();
			List<Object[]> lista = PersistenceUtil.resultSetToList(resultSet);
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
