package com.jaxrs.livre.ressource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jaxrs.livre.service.LivreService;
import com.jaxrs.livre.model.Livre;

@Path("/livres")
public class LivreResource {
	LivreService livreService = new LivreService();
	
	@GET
	@Path("/getalljson") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Livre> getLivresjson(){
		return livreService.getAllLivres();
	}
	@GET 
	@Path( "/getallxml" ) 
	@Produces(MediaType.APPLICATION_XML)
	public List<Livre> getLivresxml(){ 
		return livreService.getAllLivres(); 
	}
	
	@GET
	@Path("/getbyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Livre getLivreById(@PathParam("id") int id){ 
		return livreService.getLivreById(id);
	}
	@POST
	@Path("/addlivre")
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.APPLICATION_JSON)
	public Livre addLivre(Livre livre){
		int id=livreService.getAllLivres().size()+1;
		livreService.AjoutLivre(id, livre);
		return livreService.getLivreById(id);
	}
	
	@POST	
	@Path("/ajoutlivre/{code}/{titre}/{auteur}/{prix}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Livre ajoutLivre(@PathParam("code") int code, @PathParam("titre") String titre, 
			@PathParam("auteur") String auteur, @PathParam("prix") double prix ){ 		
		Livre l1 =new Livre(code,titre,auteur,prix);
		int indice=livreService.getAllLivres().size()+1;
		livreService.AjoutLivre(indice, l1);
		
		return livreService.getLivreById(indice);
	}
	
	@DELETE		
	@Path("/delbyid/{id}")				//OK
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	 public List<Livre> deleteLivreById(@PathParam("id") int id) {
	   livreService.removreLivreById(id);
	   return livreService.getAllLivres();
	   
	 }
	
	// Définir la méthode qui permet de modifier un livre par code.
	@PUT
	@Path("/putlivre/{id}")
	@Consumes(MediaType.APPLICATION_JSON)	@Produces(MediaType.APPLICATION_JSON)
	public Livre putLivre(@PathParam("id") int id, Livre livre){
		livre.setCode(id);
		livreService.modifLivre(id, livre);
		return livreService.getLivreById(id);
	}	
	
	@GET 
	@Path("/getbytitre/{titre}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Livre getLivreByTitre(@PathParam("titre") String titre){ 
		return livreService.getLivreByTitre(titre);
	}
	@GET 
	@Path("/getbyauteur/{auteur}") 
	@Produces(MediaType.APPLICATION_JSON)
	public List getLivreByAuteur(@PathParam("auteur") String auteur){ 
		return livreService.getLivreByAuteur(auteur); 
	}
}
