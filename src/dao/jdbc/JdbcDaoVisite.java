package dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
		PreparedStatement statement;
		try {
			//statement = JdbcConnexion.getInstance().createStatement();
			String txtRequete = "INSERT INTO t_visite(date_visite,commentaire_visite,id_user,id_cache,resultat_visite) VALUES ('"+LocalDate.now()+"','"+obj.getCommentaire_visite()+"','"+obj.getId_user()+"','"+obj.getId_cache()+"',"+obj.getResultat_visite()+")";
			System.out.print("Requete :"+txtRequete);
			statement = JdbcConnexion.getInstance().prepareStatement(txtRequete,Statement.RETURN_GENERATED_KEYS);
			
			statement.executeUpdate(txtRequete,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet res = statement.getGeneratedKeys(); /* Récupération de l'identifiant de la visite */
			
			if (res.next()) {
                int idVisite = res.getInt(1);
                obj.setIdt_visite(idVisite);
            }
            res.close();
            statement.close();
            
            
            return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	public Collection<Visite> findByUser(int idUser) {
		Collection<Visite> lesVisites = new ArrayList<Visite>();
		try {
			Statement statement = JdbcConnexion.getInstance().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM t_visite WHERE id_user="+idUser);
			while (result.next())
            {
				lesVisites.add(new Visite(result.getInt("IDT_VISITE"), result.getTimestamp("DATE_VISITE").toLocalDateTime().toLocalDate(), result.getString("COMMENTAIRE_VISITE"),result.getInt("ID_USER"),result.getInt("ID_CACHE"),result.getString("RESULTAT_VISITE")));
                
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
		PreparedStatement statement;
		try {
			
			String txtRequete = "UPDATE T_VISITE SET COMMENTAIRE_VISITE=?,ID_USER=?,ID_CACHE=?,RESULTAT_VISITE=? WHERE IDT_VISITE=?";
			statement = JdbcConnexion.getInstance().prepareStatement(txtRequete);
			statement.setString(1, obj.getCommentaire_visite());
			statement.setInt(2, obj.getId_user());
			statement.setInt(3, obj.getId_cache());
			statement.setString(4, obj.getResultat_visite());
			statement.setInt(5, obj.getIdt_visite());
			
			statement.executeUpdate();
			
            statement.close();
            
            
            return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
