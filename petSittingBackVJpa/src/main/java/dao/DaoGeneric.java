package dao;
import java.util.List;

public interface DaoGeneric<T,K> {
	public T selectById(K key);
	public List<T> selectAll();
	public void insert(T obj);
	public T update(T obj);
	public void delete(T obj);
	public void deleteById(K key);
	
}
