package models.observer;

import models.Curso;

public interface PublisherCheckpointCurso {
	void subscribe(Listener listener);
	void unsubscribe(Listener listener);
	void notify(Curso curso);
}
