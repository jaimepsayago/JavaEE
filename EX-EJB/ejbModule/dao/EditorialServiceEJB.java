package dao;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Editorial;




/**
 * Componente <code>EJB</code> que implementa as operações de negócio da entidade <code>Post</code>.
 * 
 * <p>Herda <code>AbstractPersistence</code> para resolver as operações básicas da persistência de <code>Mercadoria</code>.</p>
 * 
 * @see PostService
 * @author JSH
 */
@Stateless
public class EditorialServiceEJB extends AbstractPersistence<Editorial, Long> implements EditorialService {

	@PersistenceContext
    private EntityManager em;
	
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public EditorialServiceEJB() {
		super(Editorial.class);
	}
	

}
