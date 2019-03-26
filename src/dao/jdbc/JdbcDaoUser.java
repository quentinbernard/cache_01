/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.jdbc;

import metier.User;
import dao.UserDao;
import dao.jdbc.JdbcDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
	    
         
	    
      System.out.println("Your user name is " + username);          
      System.out.println("Your password is " + password);
	    
      try 
      {
         PreparedStatement statement = dao.jdbc.JdbcConnexion.getInstance().prepareStatement("SELECT * FROM T_USER WHERE PSEUDO=?");// AND PASSWORD=?");
         statement.setString(1,username);
         //statement.setString(2,password);
         ResultSet result = statement.executeQuery();
         boolean more = result.next();
         System.out.println(more);
         
         if(!more)
         {
             System.out.println("Désole, vous n'êtes pas un utilisateur enregistré! créer un compte dabord");
             utilisateur.setValid(false);
         }
         
         else if (more) 
         {
            String firstName = result.getString("Nom");
            String lastName = result.getString("Prenom");
	     	
            System.out.println("Bonjour " + firstName);
            utilisateur.setPrenom(firstName);
            utilisateur.setNom(lastName);
            utilisateur.setValid(true);
            
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

    
    public void register(User utilisateur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User find(int unId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
