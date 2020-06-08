package br.com.ies.backend;

import java.sql.SQLException;

import br.com.ies.backend.entity.LocalEntity;
import br.com.ies.backend.factory.ConnectionFactory;
import br.com.ies.backend.manager.PersistenceManager;
import br.com.ies.backend.type.StringType;
import br.com.ies.backend.util.PersistenceUtil;


public class Main {

	private static final PersistenceManager PERSISTENCE_MANAGER = new PersistenceManager();
	private static final ConnectionFactory CONNECTION_FACTORY = new ConnectionFactory(StringType.DATABASE_URL.getText(),
			"postgres", "postgres");

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, SQLException {

		LocalEntity localEntity = new LocalEntity();

		localEntity.setLocBairro("Campinas");
		localEntity.setLocCidade("Palhoca23");
		localEntity.setLocNumero("120");
		localEntity.setLocLogradouro("Rua: Vinicius2");
		localEntity.setLocLotacaoMaxima(80000);
		localEntity.setLocUf("SC3");
		localEntity.setLocCep("2020202-");
		
		PersistenceUtil.persist(localEntity);
		
		// Select do file

		/*
		 * PersistanceParameterDTO<Integer> persistanceParameterDTO = new
		 * PersistanceParameterDTO<>();
		 * 
		 * persistanceParameterDTO.setObject(localEntity);
		 * persistanceParameterDTO.setParameter(17);
		 * 
		 * PERSISTANCE_MANAGER.getPersistanceList().get(0).select(
		 * persistanceParameterDTO, (object) -> { System.out.println(object.toString());
		 * });
		 */

		// Select do postgres
/*
		PersistanceParameterDTO<String> persistanceParameterDTO = new PersistanceParameterDTO<>();
		persistanceParameterDTO.setObject(localEntity);
		persistanceParameterDTO.setParameter("SELECT * FROM evento.local");

		PERSISTANCE_MANAGER.getPersistanceList().get(1).select(persistanceParameterDTO, (object) -> {
			List<Object[]> objetos = (List<Object[]>) object;
			for (int i = 0; i < objetos.size(); i++) {
				for (Object t : objetos.get(i)) {
					System.out.println(t);
				}
			}
		});
*/
	}

	public static ConnectionFactory getConnectionFactory() {
		return CONNECTION_FACTORY;
	}
	public static final PersistenceManager getPersistenceManager() {
		return PERSISTENCE_MANAGER;
	}
}
