package br.com.ies;

import java.sql.SQLException;

import br.com.ies.builder.QueryBuilder;
import br.com.ies.dto.QueryDTO;
import br.com.ies.entity.LocalEntity;
import br.com.ies.manager.PersistanceManager;
import br.com.ies.postgres.ConnectionFactory;
import br.com.ies.type.StringType;

public class Main {

	private static final PersistanceManager PERSISTANCE_MANAGER = new PersistanceManager();
	private static final ConnectionFactory CONNECTION_FACTORY = new ConnectionFactory(StringType.DATABASE_URL.getText(), "postgres", "postgres");

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, SQLException {
		
		LocalEntity localEntity = new LocalEntity();
		
		localEntity.setLocBairro("Campinas");
		localEntity.setLocCidade("Sao Jose");
		localEntity.setLocCodigo(14);
		localEntity.setLocNumero("158");
		localEntity.setLocLogradouro("Rua: Nada");
		localEntity.setLocLotacaoMaxima(40000);
		localEntity.setLocUf("SC");
		
		QueryDTO queryDTO = QueryBuilder.build(localEntity);
		PERSISTANCE_MANAGER.getPersistanceList().forEach(p -> p.persist(queryDTO));
	}

	public static ConnectionFactory getConnectionFactory() {
		return CONNECTION_FACTORY;
	}
}
