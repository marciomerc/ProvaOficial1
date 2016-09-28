package domain;

import java.util.List;

public interface Persistible<T> {
	void save(T entity);

	T getOne(long id);

	List<T> getAll();

	void delete(T entity);

	void update(T entity);
	
	
}
