package br.com.ies.backend.dto;

public class PersistenceParameterDTO<T> {

	private Object object;
	private T parameter;

	public PersistenceParameterDTO() {
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public T getParameter() {
		return parameter;
	}

	public void setParameter(T parameter) {
		this.parameter = parameter;
	}

}
