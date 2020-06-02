package br.com.ies.dto;

public class PersistanceParameterDTO<T> {

	private Object object;
	private T parameter;

	public PersistanceParameterDTO() {
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
