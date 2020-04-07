package br.com.ies.persistence.impl;

import br.com.ies.persistence.base.IPersistance;

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
