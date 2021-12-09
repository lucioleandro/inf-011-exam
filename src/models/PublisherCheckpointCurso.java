package models;

public interface PublisherCheckpointCurso {
	void subscribe(Listener listener);
	void unsubscribe(Listener listener);
	void notfy(Curso curso);
}
