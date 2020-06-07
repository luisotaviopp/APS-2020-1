package br.com.ies.backend.persistence.impl;

import br.com.ies.backend.persistence.base.IPersistence;

public abstract class PersistenceImpl implements IPersistence {

	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
