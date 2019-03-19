package dao;

import dao.jdbc.JdbcDaoCachette;

public class DaoFactoryJdbc extends DaoFactory {
	public CachetteDao getCachetteDao()
    {
        return JdbcDaoCachette.getInstance();
    }
}
