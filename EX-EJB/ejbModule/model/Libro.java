package model;


import javax.persistence.*;


/**
 * The persistent class for the libro database table.
 * 
 */
@Entity
@NamedQuery(name="Libro.findAll", query="SELECT l FROM Libro l")
public class Libro implements AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String anio;

	@Column(name="ejemplares_disponibles")
	private String ejemplaresDisponibles;

	private String idioma;

	private String isbn;

	private String numero;

	@Column(name="numero_ejemplares")
	private String numeroEjemplares;

	private String titulo;

	//bi-directional many-to-one association to Autor
	@ManyToOne
	@JoinColumn(name="id_autor")
	private Autor autor;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;

	//bi-directional many-to-one association to Editorial
	@ManyToOne
	@JoinColumn(name="id_editorial")
	private Editorial editorial;

	public Libro() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getEjemplaresDisponibles() {
		return this.ejemplaresDisponibles;
	}

	public void setEjemplaresDisponibles(String ejemplaresDisponibles) {
		this.ejemplaresDisponibles = ejemplaresDisponibles;
	}

	public String getIdioma() {
		return this.idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumeroEjemplares() {
		return this.numeroEjemplares;
	}

	public void setNumeroEjemplares(String numeroEjemplares) {
		this.numeroEjemplares = numeroEjemplares;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return this.autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Editorial getEditorial() {
		return this.editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

}