package dao;

import java.util.List;

import javax.ejb.Local;

import model.Editorial;


/**
 * Determina a interface de negócio para estipular o serviço da entidade <code>Post Interface</code>.
 * 
 * <p>Indica o uso da interface <code>Local</code> para o serviço <code>EJB</code>.
 * 
 * @author JSH
 */
@Local
public interface EditorialService {

	public Editorial save(Editorial p);
	
	public void remove(Editorial p);
	
	public Editorial find(Long id);
	
	public List<Editorial> findAll();
	


}
