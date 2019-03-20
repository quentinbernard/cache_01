package dao;

import dao.jdbc.JdbcDaoCachette;
import dao.jdbc.JdbcDaoVisite;

public class DaoFactoryJdbc extends DaoFactory {
	public CachetteDao getCachetteDao()
    {
        return JdbcDaoCachette.getInstance();
    }

	@Override
	public VisiteDao getVisiteDao() {
		return JdbcDaoVisite.getInstance();
	}
}
