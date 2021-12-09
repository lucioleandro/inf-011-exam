package models.state;

import models.Curso;
import models.observer.NotificationManager;

public class StateSuspenso extends State {
	
	private NotificationManager notificador;
	
	@Override
	public void checkPoint(Curso curso) {
		this.checks.add(curso.createSnapShot());
		this.notificador.notify(curso);
	}
	
	@Override
	public void restore(Curso curso) {
		this.checks.pop().restore();;
		this.notificador.notify(curso);
	}

}
