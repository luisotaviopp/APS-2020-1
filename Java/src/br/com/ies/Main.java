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
		localEntity.setLocCidade("Palhoca");
		localEntity.setLocCodigo(14);
		localEntity.setLocNumero("158");
		localEntity.setLocLogradouro("Rua: Nada2");
		localEntity.setLocLotacaoMaxima(80000);
		localEntity.setLocUf("SC");
		
		QueryDTO queryDTO = QueryBuilder.build(localEntity);
		PERSISTANCE_MANAGER.getPersistanceList().forEach(p -> p.persist(queryDTO));
		
		
		  //Select do file
		
		/*
		PersistanceParameterDTO<Integer> persistanceParameterDTO = new PersistanceParameterDTO<>();
		persistanceParameterDTO.setObject(localEntity);
		persistanceParameterDTO.setParameter(14);
		
		PERSISTANCE_MANAGER.getPersistanceList().get(0).select(persistanceParameterDTO, (object) -> {
			System.out.println(object.toString());
		});
		*/
		
		
		// Select do postgres
		
	/*	
	    PersistanceParameterDTO<String> persistanceParameterDTO = new PersistanceParameterDTO<>();
		persistanceParameterDTO.setObject(localEntity);
		persistanceParameterDTO.setParameter("SELECT * FROM evento.local");
		
		PERSISTANCE_MANAGER.getPersistanceList().get(1).select(persistanceParameterDTO, (object) ->{
			List<Object[]> objetos = (List<Object[]>) object;
			for(int i =0;i<objetos.size();i++) {
				for(Object t : objetos.get(i)) {
					System.out.println(t);
				}
			}
		});
		*/
	}

	public static ConnectionFactory getConnectionFactory() {
		return CONNECTION_FACTORY;
	}
}
