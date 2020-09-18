package controller;



import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import dao.PostService;
import model.Post;


@Named
@RequestScoped
public class MantControllerPost implements Serializable{
	


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


@Inject
PostService service;



public MantControllerPost() {
	
}

Long idSelecionado;


Post post;

List<Post> lista;

public List<Post> getLista() {

	System.out.println("service: "+service);
	if (lista == null) {
		lista = service.findAll();
		//lista = new ListDataModel<Post>(service.findAll());
	}
	return lista;
}



public void setLista(List<Post> lista) {
	this.lista = lista;
}


public String guardar() {
	try {
		System.out.println("service: "+service);
		service.save(post);
	} catch(Exception ex) {
		//log.error("Erro ao salvar mercadoria.", ex);
	
		System.out.print("error"+ ex.getMessage());
		return "";
	}
	
	return "lista";
}


public Post getPost() {
	return post;
}



public void setPost(Post post) {
	this.post = post;
}



public Long getIdSelecionado() {
	return idSelecionado;
}



public void setIdSelecionado(Long idSelecionado) {
	this.idSelecionado = idSelecionado;
}






}
