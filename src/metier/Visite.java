package metier;

import java.io.File;
import java.time.LocalDate;

public class Visite {
	
	private int idt_visite;
	private LocalDate date_visite;
	private String commentaire_visite;
	private int id_user;
	private int id_cache;
	private String resultat_visite;
	private File piece_attachee_01;
	
	public Visite() {
		
	}
	
	public Visite(int idt_visite, LocalDate date_visite, String commentaire_visite, int id_user, int id_cache,
			String resultat_visite) {
		super();
		this.idt_visite = idt_visite;
		this.date_visite = date_visite;
		this.commentaire_visite = commentaire_visite;
		this.id_user = id_user;
		this.id_cache = id_cache;
		this.resultat_visite = resultat_visite;
		// this.piece_attachee_01 = new File();
	}
	
	public Visite(int idt_visite, String commentaire_visite, int id_user, int id_cache,
			String resultat_visite) {
		super();
		this.idt_visite = idt_visite;
		// this.date_visite = date_visite;
		this.commentaire_visite = commentaire_visite;
		this.id_user = id_user;
		this.id_cache = id_cache;
		this.resultat_visite = resultat_visite;
		// this.piece_attachee_01 = new File();
	}

	public int getIdt_visite() {
		return idt_visite;
	}

	public void setIdt_visite(int idt_visite) {
		this.idt_visite = idt_visite;
	}

	public LocalDate getDate_visite() {
		return date_visite;
	}

	public void setDate_visite(LocalDate date_visite) {
		this.date_visite = date_visite;
	}

	public String getCommentaire_visite() {
		return commentaire_visite;
	}

	public void setCommentaire_visite(String commentaire_visite) {
		this.commentaire_visite = commentaire_visite;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_cache() {
		return id_cache;
	}

	public void setId_cache(int id_cache) {
		this.id_cache = id_cache;
	}

	public String getResultat_visite() {
		return resultat_visite;
	}

	public void setResultat_visite(String resultat_visite) {
		this.resultat_visite = resultat_visite;
	}

	public File getPiece_attachee_01() {
		return piece_attachee_01;
	}

	public void setPiece_attachee_01(File piece_attachee_01) {
		this.piece_attachee_01 = piece_attachee_01;
	}
	
	

}
