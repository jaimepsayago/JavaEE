package dao;

import java.util.List;

import javax.ejb.Local;

import model.Autor;



/**
 * Determina a interface de negócio para estipular o serviço da entidade <code>Post Interface</code>.
 * 
 * <p>Indica o uso da interface <code>Local</code> para o serviço <code>EJB</code>.
 * 
 * @author JSH
 */
@Local
public interface AutorService {

	public Autor save(Autor p);
	
	public void remove(Autor p);
	
	public Autor find(Long id);
	
	public List<Autor> findAll();
	


}
