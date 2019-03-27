/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.jdbc;

import metier.Cachette;
import metier.User;
import metier.Visite;
import dao.UserDao;
import dao.jdbc.JdbcDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Collection;
/**
 *
 * @author noumalla
 */
public class JdbcDaoUser extends JdbcDao<User> implements UserDao{
    
    private static JdbcDaoUser instance; 
	
	public static JdbcDaoUser getInstance()
    {
        if (instance == null)
        {
            instance = new JdbcDaoUser();
        }
        return instance;
    }

        
    @Override
    public User login(User utilisateur) {    
	
         String username = utilisateur.getPseudo();    
         String password = utilisateur.getPassword();   
	    
         
	    
      System.out.println("Your username is " + username);          
      System.out.println("Your password is " + password);
	    
      try 
      {
         PreparedStatement statement = dao.jdbc.JdbcConnexion.getInstance().prepareStatement("SELECT * FROM T_USER WHERE PSEUDO=? AND PASSWORD=?");
         statement.setString(1, username);
         statement.setString(2, password);
         ResultSet result = statement.executeQuery();
         boolean more = result.next();
         
         if(!more)
         {
             System.out.println("Désole, vous n'êtes pas un utilisateur enregistré! créer un compte dabord");
             utilisateur.setValid("E");
         }
         
         else if (more) 
         {
        	int id = result.getInt("idt_user");
            String firstName = result.getString("Nom");
            String lastName = result.getString("Prenom");
            String type = result.getString("type_user");
	     	
            System.out.println("Bonjour " + firstName);
            utilisateur.setPrenom(firstName);
            utilisateur.setNom(lastName);
            utilisateur.setId(id);
            utilisateur.setType(type);
            utilisateur.setValid("V");
            
            statement.close();
         }
      } 

      catch (Exception ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      } 
	    return utilisateur;
    }

    
    public void logout(User utilisateur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User find(int idUser) {
        User c = new User();
		try {
			PreparedStatement statement = JdbcConnexion.getInstance().prepareStatement("SELECT * FROM T_USER WHERE IDT_USER=?");
			statement.setInt(1, idUser);
			ResultSet result = statement.executeQuery();
			while (result.next())
            {
                c = new User(result.getInt("IDT_USER"),result.getString("PSEUDO"),result.getString("ETAT_USER"),result.getString("TYPE_USER"));
                
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
    public boolean create(User obj) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		try {
			//statement = JdbcConnexion.getInstance().createStatement();
			String txtRequete = "INSERT INTO t_user (nom,prenom,mail,pseudo,password,date_creation,date_validation,etat_user,type_user) VALUES "
					+ "('"+obj.getNom()+"','"+obj.getPrenom()+"','"+obj.getMail()+"','"+obj.getPseudo()+"',"+obj.getPassword()+""
							+ "','"+obj.getDate_creation()+"','"+obj.getDate_validation()+"','"+obj.getValid()+"',"+obj.getType() + ")";
			System.out.print("Requete :"+txtRequete);
			statement = JdbcConnexion.getInstance().prepareStatement(txtRequete,Statement.RETURN_GENERATED_KEYS);
			
			statement.executeUpdate(txtRequete,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet res = statement.getGeneratedKeys(); /* R�cup�ration de l'identifiant de la visite */
			
			if (res.next()) {
                int idUser = res.getInt(1);
                obj.setId(idUser);
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
	public Collection<User> findAll() {
		Collection<User> lesUsers = new ArrayList<User>();
		try {
			Statement statement = JdbcConnexion.getInstance().createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM t_user");
			while (result.next())
            {
                lesUsers.add(new User(result.getInt("IDT_USER"),result.getString("PSEUDO"),result.getString("ETAT_USER"),result.getString("TYPE_USER")));
                
            }
			statement.close();
            return lesUsers;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public boolean update(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
