package br.com.ies.backend;

import br.com.ies.backend.factory.ConnectionFactory;
import br.com.ies.backend.manager.PersistenceManager;
import br.com.ies.backend.type.StringType;
import br.com.ies.frontend.manager.UserManager;


public class Main {

	private static final PersistenceManager PERSISTENCE_MANAGER = new PersistenceManager();
	private static final ConnectionFactory CONNECTION_FACTORY = new ConnectionFactory(StringType.DATABASE_URL.getText(),
			"postgres", "postgres");
	private static final UserManager userManager = new UserManager();

	public static ConnectionFactory getConnectionFactory() {
		return CONNECTION_FACTORY;
	}
	public static final PersistenceManager getPersistenceManager() {
		return PERSISTENCE_MANAGER;
	}
	public static UserManager getUserManager() {
		return userManager;
	}
}
