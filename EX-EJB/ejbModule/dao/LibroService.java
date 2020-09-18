package dao;

import java.util.List;

import javax.ejb.Local;

import model.Libro;




/**
 * Determina a interface de negócio para estipular o serviço da entidade <code>Post Interface</code>.
 * 
 * <p>Indica o uso da interface <code>Local</code> para o serviço <code>EJB</code>.
 * 
 * @author JSH
 */
@Local
public interface LibroService {

	public Libro save(Libro p);
	
	public void remove(Libro p);
	
	public Libro find(Long id);
	
	public List<Libro> findAll();
	


}
