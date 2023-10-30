package com.jaxrs.livre.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Livre {
	public Livre() {
		super();
	}
	private int code;
	private String titre;
	private String auteur;
	private double prix;
	
	public Livre(int code, String titre, String auteur, double prix) {
		this.code=code;
		this.titre=titre;
		this.auteur=auteur;
		this.prix=prix;	
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Livre [code=" + code + ", titre=" + titre + ", auteur=" + auteur + ", prix=" + prix + "]";
	}
}
