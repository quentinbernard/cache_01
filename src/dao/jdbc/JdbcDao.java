package dao.jdbc;

import java.util.Collection;

import dao.Dao;

public abstract class JdbcDao <T> implements Dao<T>{
	 @Override
	    public abstract boolean create(T obj);

	    @Override
	    public abstract T find(int unId);

	    @Override
	    public abstract Collection<T> findAll();

	    @Override
	    public abstract boolean update(T obj);
	    
	    @Override
	    public abstract boolean delete(T obj) ;
	        
	    @Override
	    public abstract boolean deleteAll() ;

	    @Override
	    public abstract void close();
}
