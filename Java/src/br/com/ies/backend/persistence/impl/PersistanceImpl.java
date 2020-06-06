package br.com.ies.backend.persistence.impl;

import br.com.ies.backend.persistence.base.IPersistance;

public abstract class PersistanceImpl implements IPersistance {

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
