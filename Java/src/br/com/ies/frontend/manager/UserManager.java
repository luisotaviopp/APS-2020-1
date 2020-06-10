package br.com.ies.frontend.manager;

import br.com.ies.backend.entity.EventoEntity;
import br.com.ies.backend.entity.UsuarioEntity;

public class UserManager {

	private UsuarioEntity usuario;
	private EventoEntity evento;
	
	public UserManager() {
		usuario = null;
		evento = null;
	}
	
	public UsuarioEntity getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public EventoEntity getEvento() {
		return evento;
	}

	public void setEvento(EventoEntity evento) {
		this.evento = evento;
	}
	
	
}
