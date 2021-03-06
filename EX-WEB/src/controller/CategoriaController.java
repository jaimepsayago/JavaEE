package controller;




import java.io.Serializable;

import javax.faces.event.ActionEvent;
//import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;



import javax.inject.Inject;
import javax.inject.Named;

import javax.enterprise.context.RequestScoped;

import model.Categoria;

import dao.CategoriaService;





@Named
@RequestScoped
public class CategoriaController implements Serializable{
		
	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;

	
	@Inject
	private CategoriaService service;
	

	private Categoria categoria;
	
	DataModel<Categoria> lista;
	
	Long idSelecionado;

	public CategoriaController() {
		if (categoria == null){
			categoria= new Categoria();
		}
	
	}

	public DataModel<Categoria> getLista() {
		lista= new ListDataModel<Categoria>(service.findAll());
		return lista;
	}

	
	
	public void setLista(DataModel<Categoria> lista) {
		this.lista = lista;
	}
	
	public String guardar() {
		try {
			System.out.println("service: "+service);
			service.save(categoria);
		} catch(Exception ex) {
			//log.error("Erro ao salvar mercadoria.", ex);
		
			System.out.print("error"+ ex.getMessage());
			return "";
		}
		
		return "listaCategoria";
	}
	
	public void editar() {
		if (idSelecionado == null) {
			return;
		}
		categoria = service.find(idSelecionado);
		//log.debug("Pronto pra editar");
	}
	
	public String remover(ActionEvent e) {
		try {
			categoria = new Categoria();
			String i = e.getComponent().getAttributes().get("postEliminar").toString();
			
			Long l= new Long(i);
			System.out.println("*-*-*-*-*-*-"+l);
			categoria.setId(l);
			service.remove(categoria);
		} catch(Exception ex) {
			//log.error("Erro ao remover mercadoria.", ex);
			System.out.println(ex.getMessage());
			return "";
		}
		//log.debug("Removeu mercadoria "+mercadoria.getId());
		return "listaCategoria";
	}
	
	

	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getIdSelecionado() {
		return idSelecionado;
	}



	public void setIdSelecionado(Long idSelecionado) {
		this.idSelecionado = idSelecionado;
	}
	

}
