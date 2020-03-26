package br.com.ies.builder;

import java.lang.reflect.Field;
import java.util.HashSet;

import br.com.ies.annotation.Coluna;
import br.com.ies.annotation.Tabela;
import br.com.ies.dto.ColunaValorDTO;
import br.com.ies.dto.QueryDTO;
import br.com.ies.util.Utils;

public class QueryBuilder {

	private Object object;

	public QueryBuilder(Object object) {
		this.object = object;
	}

	public QueryDTO construir() throws IllegalArgumentException, IllegalAccessException {
		QueryDTO queryDto = new QueryDTO();
		
		Tabela tabela = Utils.getTabelaFromClass(object.getClass());
		HashSet<ColunaValorDTO> setColunaValor = new HashSet<>();

		queryDto.setSchema(tabela.schema());
		queryDto.setTabela(tabela.nome());
		

		for(Field field : Utils.getDeclaredFieldsByAnnotation(object.getClass(), Coluna.class)) {
			ColunaValorDTO colunaValorDto = new ColunaValorDTO();
			colunaValorDto.setColuna(Utils.getColunaFromField(field).nome());
			colunaValorDto.setValor(Utils.getFieldValue(field, object));
			
			setColunaValor.add(colunaValorDto);
		}
		
		queryDto.setColunaValor(setColunaValor);

		return queryDto;
	}
}
