package dao.jdbc;

import java.util.ArrayList;
import java.util.Collection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import dao.CachetteDao;
import metier.Cachette;

public class JdbcDaoCachette extends JdbcDao<Cachette> implements CachetteDao{

	private static JdbcDaoCachette instance;
	
	public static JdbcDaoCachette getInstance()
    {
        if (instance == null)
        {
            instance = new JdbcDaoCachette();
        }
        return instance;
    }

	@Override
	public Cachette find(int idCachette) {
		Cachette c = new Cachette();
		try {
			PreparedStatement statement = JdbcConnexion.getInstance().prepareStatement("SELECT * FROM T_CACHE WHERE IDT_CACHE=?");
			statement.setInt(1, idCachette);
			ResultSet result = statement.executeQuery();
			while (result.next())
            {
                c = new Cachette(result.getInt("IDT_CACHE"),result.getString("NOM_CACHE"),result.getString("COORDONNEES_CACHE"),result.getString("ETAT_CACHE"),result.getString("DESCRIPTION_CACHE"),result.getInt("ID_CREATEUR"));
                
            }
			statement.close();
            return c;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean create(Cachette obj) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		try {
			//statement = JdbcConnexion.getInstance().createStatement();
			String txtRequete = "INSERT INTO t_cache(nom_cache,coordonnees_cache,date_creation,etat_cache,description_cache,id_createur) VALUES ('"+obj.getNom_cache()+"','"+obj.getCoordonnees_cache()+"','"+obj.getDate_creation()+"','"+obj.getEtat_cache()+"','"+obj.getDescription_cache()+"',"+obj.getId_createur()+")";
			System.out.print("Requete :"+txtRequete);
			statement = JdbcConnexion.getInstance().prepareStatement(txtRequete,Statement.RETURN_GENERATED_KEYS);
			
			statement.executeUpdate(txtRequete,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet res = statement.getGeneratedKeys(); /* R�cup�ration de l'identifiant de la cachette */
			
			if (res.next()) {
                int idCache = res.getInt(1);
                obj.setIdt_cache(idCache);;
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
	public Collection<Cachette> findAll() {
		Collection<Cachette> lesCachettes = new ArrayList<Cachette>();
		try {
			Statement statement = JdbcConnexion.getInstance().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM t_cache");
			while (result.next())
            {
                lesCachettes.add(new Cachette(result.getInt("IDT_CACHE"),result.getString("NOM_CACHE"),result.getString("COORDONNEES_CACHE"),result.getString("ETAT_CACHE"),result.getString("DESCRIPTION_CACHE"),result.getInt("ID_CREATEUR")));
                
            }
			statement.close();
            return lesCachettes;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Cachette obj) {
		
		PreparedStatement statement;
		try {
			
			String txtRequete = "UPDATE T_CACHE SET NOM_CACHE=?,COORDONNEES_CACHE=?,ETAT_CACHE=?,DESCRIPTION_CACHE=?,ID_CREATEUR=? WHERE IDT_CACHE=?";
			statement = JdbcConnexion.getInstance().prepareStatement(txtRequete);
			statement.setString(1, obj.getNom_cache());
			statement.setString(2, obj.getCoordonnees_cache());
			statement.setString(3,obj.getEtat_cache());
			statement.setString(4, obj.getDescription_cache());
			statement.setInt(5, obj.getId_createur());
			statement.setInt(6, obj.getIdt_cache());
			
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
	public boolean delete(Cachette obj) {
		boolean result = true;
        String requete = "DELETE FROM T_CACHE WHERE IDT_CACHE=?";
        PreparedStatement pstmt;
		try {
			pstmt = JdbcConnexion.getInstance().prepareStatement(requete);
			pstmt.setInt(1, obj.getIdt_cache());		      
            pstmt.executeUpdate();
            pstmt.close();
            return true;
			}
	        catch (SQLException ex)
	        {
	            System.out.println("Erreur sur requete de suppression de la cache " + ex.getMessage());
	            result = false;           
	        }
	        return result;
	}

	@Override
	public boolean deleteAll() {
		boolean result = true;
        String requete = "DELETE FROM T_CACHE";
        PreparedStatement pstmt;
		try {
			pstmt = JdbcConnexion.getInstance().prepareStatement(requete);
            pstmt.executeUpdate();
            pstmt.close();
            return true;
			}
	        catch (SQLException ex)
	        {
	            System.out.println("Erreur sur requete de suppression de la cache " + ex.getMessage());
	            result = false;           
	        }
	        return result;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Cachette> findAllActives() {
		Collection<Cachette> lesCachettes = new ArrayList<Cachette>();
		try {
			Statement statement = JdbcConnexion.getInstance().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM t_cache WHERE ETAT_CACHE='V'");
			while (result.next())
            {
                lesCachettes.add(new Cachette(result.getInt("IDT_CACHE"),result.getString("NOM_CACHE"),result.getString("COORDONNEES_CACHE"),result.getString("ETAT_CACHE"),result.getString("DESCRIPTION_CACHE"),result.getInt("ID_CREATEUR")));
                
            }
			statement.close();
            return lesCachettes;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<Cachette> findByUser(int idUser) {
		Collection<Cachette> lesCachettes = new ArrayList<Cachette>();
		try {
			PreparedStatement statement;
			
			String query = "SELECT * FROM t_cache WHERE id_createur=?";
			statement = JdbcConnexion.getInstance().prepareStatement(query);
			statement.setInt(1, idUser);
			statement.execute();
			
			ResultSet result = statement.getResultSet();
			
			while (result.next())
            {
                lesCachettes.add(new Cachette(result.getInt("IDT_CACHE"),result.getString("NOM_CACHE"),result.getString("COORDONNEES_CACHE"),result.getString("ETAT_CACHE"),result.getString("DESCRIPTION_CACHE"),result.getInt("ID_CREATEUR")));
                
            }
			statement.close();
            return lesCachettes;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}
