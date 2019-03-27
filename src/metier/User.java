/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.time.LocalDate;

/**
 *
 * @author noumalla
 */
public class User {
	  private int id; 
      private String nom;
      private String prenom;
      private String mail;
      private String pseudo;
      private String password;
  	  private LocalDate date_creation;
  	  private LocalDate date_validation;
      private String valid;
      private String type;

      // (1,'CURIE','Marie','mcurie@centralelille.fr','mcurie','mcmc','2018-10-12','2018-10-12','V','A',NULL,0,0)
      
      public User() {
    	  
      }
      
      public User(int id, String pseudo, String etat, String type) {
    	  super();
    	  this.id = id;
    	  this.pseudo = pseudo;
    	  this.valid = etat;
    	  this.type = type;
      }

	public User(String nom, String prenom, String mail, String pseudo, String password, LocalDate date_creation,
			LocalDate date_validation, String valid, String type) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.pseudo = pseudo;
		this.password = password;
		this.date_creation = date_creation;
		this.date_validation = date_validation;
		this.valid = valid;
		this.type = type;
	}
    
    

  public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public LocalDate getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(LocalDate date_creation) {
		this.date_creation = date_creation;
	}

	public LocalDate getDate_validation() {
		return date_validation;
	}

	public void setDate_validation(LocalDate date_validation) {
		this.date_validation = date_validation;
	}



	public String getValid() {
		return valid;
	}



	public void setValid(String valid) {
		this.valid = valid;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isValid() {
		return (this.valid == "V");
	}

}
