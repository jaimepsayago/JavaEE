package dao;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Autor;


/**
 * Componente <code>EJB</code> que implementa as operações de negócio da entidade <code>Post</code>.
 * 
 * <p>Herda <code>AbstractPersistence</code> para resolver as operações básicas da persistência de <code>Mercadoria</code>.</p>
 * 
 * @see PostService
 * @author JSH
 */
@Stateless
public class AutorServiceEJB extends AbstractPersistence<Autor, Long> implements AutorService {

	@PersistenceContext
    private EntityManager em;
	
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public AutorServiceEJB() {
		super(Autor.class);
	}
	

}