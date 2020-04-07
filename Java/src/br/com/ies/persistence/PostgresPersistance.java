package br.com.ies.persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import br.com.ies.Main;
import br.com.ies.dto.QueryDTO;
import br.com.ies.persistence.impl.PersistanceImpl;
import br.com.ies.type.QueryParameterType;
import br.com.ies.type.QueryType;
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
			
			String insertQuery = QueryType.INSERT_QUERY.getQuery().replace(QueryParameterType.TABLE.getText(), queryDTO.getSchema().concat(".").concat(queryDTO.getTabela())).replace(QueryParameterType.TABLE_VALUES.getText(), Utils.fillColunasNameByColumnValueList(queryDTO.getColumnValue())).replace(QueryParameterType.VALUES.getText(), Utils.fillCharInString('?', queryDTO.getColumnValue().size()));
			String updateQuery = QueryType.UPDATE_QUERY.getQuery().replace(QueryParameterType.VALUES.getText(), Utils.fillColunasAndValuesFromColumnStringList(columnValueStringList));
			String conflictQuery = QueryType.CONFLICT_QUERY.getQuery().replace(QueryParameterType.INSERT_QUERY.getText(), insertQuery).replace(QueryParameterType.PRIMARY_KEY.getText(), Utils.getColunaFromField(queryDTO.getChavePrimaria()).nome()).replace(QueryParameterType.UPDATE.getText(), updateQuery);
			
			PreparedStatement preparedStatement  = Main.getConnectionFactory().getPreparedStatement(conflictQuery);
			IntStream.range(0, queryDTO.getColumnValue().size()).forEachOrdered(i -> Utils.setParameter(preparedStatement, i + 1, queryDTO.getColumnValue().get(i).getValue()));
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object select(Integer primaryKeyId, Object fromObject) {
		return null;
	}
}
