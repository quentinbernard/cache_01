package dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import dao.VisiteDao;
import metier.Cachette;
import metier.Visite;

public class JdbcDaoVisite extends JdbcDao<Visite> implements VisiteDao {
	
	private static JdbcDaoVisite instance;
	
	public static JdbcDaoVisite getInstance()
    {
        if (instance == null)
        {
            instance = new JdbcDaoVisite();
        }
        return instance;
    }

	@Override
	public Visite find(int idVisite) {
		Visite v = new Visite();
		try {
			PreparedStatement statement = JdbcConnexion.getInstance().prepareStatement("SELECT * FROM T_VISITE WHERE IDT_VISITE=?");
			statement.setInt(1, idVisite);
			ResultSet result = statement.executeQuery();
			while (result.next())
            {
                v = new Visite(result.getInt("IDT_VISITE"),result.getString("COMMENTAIRE_VISITE"),result.getInt("ID_USER"),result.getInt("ID_CACHE"),result.getString("RESULTAT_VISITE"));
                
            }
			statement.close();
            return v;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean create(Visite obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Visite> findAll() {
		Collection<Visite> lesVisites = new ArrayList<Visite>();
		try {
			Statement statement = JdbcConnexion.getInstance().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM t_visite");
			while (result.next())
            {
				lesVisites.add(new Visite(result.getInt("IDT_VISITE"),result.getString("COMMENTAIRE_VISITE"),result.getInt("ID_USER"),result.getInt("ID_CACHE"),result.getString("RESULTAT_VISITE")));
                
            }
			statement.close();
            return lesVisites;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Visite obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Visite obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Visite> findAllActives() {
		// TODO Auto-generated method stub
		return null;
	}

}
