package com.jaxrs.livre.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jaxrs.livre.dao.DaoClass;
import com.jaxrs.livre.model.Livre;

public class LivreService {
	
	private Map<Integer,Livre> livres; 
	
	public LivreService(){
		Initialiser_livres();
	}
	public void Initialiser_livres(){
		if(livres==null) {
			livres=DaoClass.getLivres();
			livres.put(1,new Livre(1,"Java-RS","Alain",450));
			livres.put(2,new Livre(2,"WS-RS","Alain",350));
			livres.put(3,new Livre(3,"Json","Jon",300));
		}
	}
	
	public List<Livre> getAllLivres(){ 
		return new ArrayList<Livre>(livres.values()); 
	}
	
	public Livre getLivreById(int id){ 
		return livres.get(id); 
	}
	
	public Livre getLivreByTitre(String titre){ 
		List<Livre> tablivre=new ArrayList<Livre>(livres.values()); 
		for(Livre livre:tablivre){
			if(livre.getTitre().equals(titre))
				return livre;
		}
		return null;
	}	
	public List <Livre> getLivreByAuteur(String auteur){
		List<Livre> tablivre=new ArrayList<Livre>(livres.values());
		List<Livre> listaut=new ArrayList<Livre>();
		
		for(Livre livre:tablivre){
			if(livre.getAuteur().equals(auteur))
				listaut.add(livre);
		}
		return listaut;
	}
	public void removreLivreById(int id){
		livres.remove(id);
	}	
	public void modifLivre(int id, Livre livre){
		livres.replace(id, livre);
	}	
	public void AjoutLivre(int indice, Livre livre)
	{ 
		livres.put(indice, livre); 
	}
}
