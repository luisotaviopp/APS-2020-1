package br.com.ies.util;

import java.sql.ResultSet;

public interface Callback {
		
	public void call(ResultSet retorno);
}
