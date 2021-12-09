package models.observer;

import models.Curso;

public interface Listener {

	void aviseMe(Curso curso);
	String getNome();
	String getEmail();
}
