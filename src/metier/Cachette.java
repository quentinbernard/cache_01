package metier;

import java.time.LocalDate;
import java.sql.Date;

public class Cachette {
	
	private int idt_cache;
	private String nom_cache;
	private String coordonnees_cache;
	private String etat_cache;
	private String description_cache;
	private LocalDate date_creation;
	private LocalDate date_validation;
	private LocalDate date_fermeture;
	private LocalDate date_suspension;
	private int id_createur;
	
	public Cachette()
	{
		
	}
	public Cachette(int idt_cache, String nom_cache, String coordonnees_cache, String etat_cache, LocalDate date_creation, LocalDate date_validatoin,LocalDate date_fermeture,LocalDate date_suspension, String description_cache, int id_createur) {
		super();
		this.idt_cache = idt_cache;
		this.nom_cache = nom_cache;
		this.coordonnees_cache = coordonnees_cache;
		this.etat_cache = etat_cache;
		this.id_createur = id_createur;
		/*this.date_creation = date_creation;
		this.date_fermeture = date_fermeture;
		this.date_suspension = date_suspension;
		this.date_validation = date_validation;*/
		this.description_cache = description_cache;
	}
	public Cachette(int idt_cache, String nom_cache, String coordonnees_cache, String etat_cache,  String description_cache, int id_createur) {
		super();
		this.idt_cache = idt_cache;
		this.nom_cache = nom_cache;
		this.coordonnees_cache = coordonnees_cache;
		this.etat_cache = etat_cache;
		this.id_createur = id_createur;
		this.description_cache = description_cache;
	}
	public Cachette( String nom_cache, String coordonnees_cache, String etat_cache,  String description_cache, int id_createur) {
	
		this.nom_cache = nom_cache;
		this.coordonnees_cache = coordonnees_cache;
		this.etat_cache = etat_cache;
		this.date_creation = LocalDate.now();
		this.id_createur = id_createur;
		this.description_cache = description_cache;
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
	public LocalDate getDate_fermeture() {
		return date_fermeture;
	}
	public void setDate_fermeture(LocalDate date_fermeture) {
		this.date_fermeture = date_fermeture;
	}
	public LocalDate getDate_suspension() {
		return date_suspension;
	}
	public void setDate_suspension(LocalDate date_suspension) {
		this.date_suspension = date_suspension;
	}
	public String getDescription_cache() {
		return description_cache;
	}
	public void setDescription_cache(String description_cache) {
		this.description_cache = description_cache;
	}
	public int getIdt_cache() {
		return idt_cache;
	}
	public void setIdt_cache(int idt_cache) {
		this.idt_cache = idt_cache;
	}
	public String getNom_cache() {
		return nom_cache;
	}
	public void setNom_cache(String nom_cache) {
		this.nom_cache = nom_cache;
	}
	public String getCoordonnees_cache() {
		return coordonnees_cache;
	}
	public void setCoordonnees_cache(String coordonnees_cache) {
		this.coordonnees_cache = coordonnees_cache;
	}
	public String getEtat_cache() {
		return etat_cache;
	}
	public void setEtat_cache(String etat_cache) {
		this.etat_cache = etat_cache;
	}
	public int getId_createur() {
		return id_createur;
	}
	public void setId_createur(int id_createur) {
		this.id_createur = id_createur;
	}
	
}
