package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
//import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.POST;

import com.sun.org.apache.bcel.internal.generic.CASTORE;

import javax.enterprise.context.RequestScoped;

import dao.CategoriaService;
import dao.LibroService;
import model.Categoria;
import model.Libro;
import model.Post;

@Named
@RequestScoped
public class LibroController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private LibroService service;
	
	@Inject
	private CategoriaService categoriaService;

	private Libro libro;
	/* private Categoria categoria; */

	DataModel<Libro> lista;

	Long idSelecionado;
	private Long categoriaId;
	private ArrayList<SelectItem> categoriaArray;

	public LibroController() {
		if (libro == null) {
			libro = new Libro();
			
		}

	}

	public DataModel<Libro> getLista() {
		lista = new ListDataModel<Libro>(service.findAll());
		return lista;
	}

	public void setLista(DataModel<Libro> lista) {
		this.lista = lista;
	}

	public String guardar() {
		try {
			System.out.println("service: " + service);
			
			Categoria c = new Categoria();
			c.setId(categoriaId);
		
			libro.setCategoria(c);

			service.save(libro);
		} catch (Exception ex) {
			// log.error("Erro ao salvar mercadoria.", ex);

			System.out.print("error" + ex.getMessage());
			return "";
		}

		return "listaLibro";
	}

	public void editar() {
		if (idSelecionado == null) {
			return;
		}
		libro = service.find(idSelecionado);
		setCategoriaId(libro.getCategoria().getId());
		// log.debug("Pronto pra editar");
	}

	public String remover(ActionEvent e) {
		try {
			libro = new Libro();
			String i = e.getComponent().getAttributes().get("postEliminar").toString();

			Long l = new Long(i);
			System.out.println("*-*-*-*-*-*-" + l);
			libro.setId(l);
			service.remove(libro);
		} catch (Exception ex) {
			// log.error("Erro ao remover mercadoria.", ex);
			System.out.println(ex.getMessage());
			return "";
		}
		// log.debug("Removeu mercadoria "+mercadoria.getId());
		return "listaLibro";
	}

	public ArrayList<SelectItem> getCategoriaArray() {
		if (categoriaArray== null)
			{
			categoriaArray = new ArrayList<SelectItem>();
				for (Categoria obj:categoriaService.findAll())
				{
					categoriaArray.add(new SelectItem(obj.getId(),obj.getDescripcion()));
				}
		
			}
        return categoriaArray;
    }

	public void setCategoriaArray(ArrayList<SelectItem> categoriaArray) {
		this.categoriaArray = categoriaArray;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Long getIdSelecionado() {
		return idSelecionado;
	}

	public void setIdSelecionado(Long idSelecionado) {
		this.idSelecionado = idSelecionado;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	
}
