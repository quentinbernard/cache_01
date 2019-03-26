package dao;

import dao.jdbc.JdbcDaoCachette;
import dao.jdbc.JdbcDaoVisite;
import dao.jdbc.JdbcDaoUser;

public class DaoFactoryJdbc extends DaoFactory {
	public CachetteDao getCachetteDao()
    {
        return JdbcDaoCachette.getInstance();
    }

	@Override
	public VisiteDao getVisiteDao() {
		return JdbcDaoVisite.getInstance();
	}

	@Override
	public UserDao getUserDao() {
		return JdbcDaoUser.getInstance();
	}
}
