package dao;

public abstract class DaoFactory {
	public abstract CachetteDao getCachetteDao ();
	public abstract VisiteDao getVisiteDao ();
	public abstract UserDao getUserDao();
	public static DaoFactory getDaoFactory(sourceData type)  
    {
        switch (type)
        {
            case JPA :
                //return new DaoFactoryJPA();
            	return null;
            case JDBC:
                return new DaoFactoryJdbc();
            default:
                break;
        }
        return null;
    }

}
