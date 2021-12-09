package models.observer;

import java.util.ArrayList;
import java.util.List;

import models.Curso;

public class NotificationManager implements PublisherCheckpointCurso {
	
	List<Listener> listeners = new ArrayList<>();
	
	@Override
	public void subscribe(Listener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void unsubscribe(Listener listener) {
		this.listeners.remove(listener);
		
	}

	@Override
	public void notify(Curso curso) {
		listeners.forEach(listener -> {
			listener.aviseMe(curso);
		});
	}

}
