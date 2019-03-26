/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import metier.User;

/**
 *
 * @author noumalla
 */
public interface UserDao extends Dao<User>{
    public User login( User utilisateur );
    /*public void logout( User utilisateur ) throws DaoException;
    public void register( User utilisateur ) throws DaoException;*/
}
