package py.gov.pj.workflow.persistence;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;

import org.ticpy.tekoporu.pagination.Pagination;
import org.ticpy.tekoporu.stereotype.PersistenceController;
import org.ticpy.tekoporu.template.JPACrud;
import org.ticpy.tekoporu.transaction.Transactional;


import py.gov.pj.workflow.domain.Buttonruteo;
import py.gov.pj.workflow.domain.Check;
import py.gov.pj.workflow.domain.Notification;
import py.gov.pj.workflow.domain.Routing;

@PersistenceController
public class RoutingDAO extends JPACrud<Routing, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@SuppressWarnings("unused")
	private Logger logger;
	
	public List<Routing> listar() {
		final String jpql = "select this from " + getBeanClass().getSimpleName() + " this where rou_del=0 order by pos_origin asc";
		final Query query = getEntityManager().createQuery(jpql);

		final Pagination pagination = getPagination();
		if (pagination != null) {
			pagination.setTotalResults(this.contar().intValue());
			query.setFirstResult(pagination.getFirstResult());
			query.setMaxResults(pagination.getPageSize());
		}

		List<Routing> lista = query.getResultList();
		return lista;
	}
	private Long contar() {
		final Query query = getEntityManager().createQuery(
				"select count(this) from routing where rou_del=0");
		return (Long) query.getSingleResult();
	}
	
	
	@Transactional
	public void insertar(Routing routing, List<Notification> notificar, List<Buttonruteo> botones,List<Check> checks) {
		getEntityManager().persist(routing);
		
		for(Notification n : notificar){
			getEntityManager().persist(n);
		}
		for(Buttonruteo b : botones){
			getEntityManager().persist(b);
		}
		for(Check c : checks){
			getEntityManager().persist(c);
		}
	}
	
	@Transactional
	public void actualizar(Routing routing, List<Notification> notificar,
			List<Buttonruteo> botones, List<Check> checks) {

		getEntityManager().merge(routing);
		
		for(Notification n : notificar){
			getEntityManager().merge(n);
		}
		for(Buttonruteo b : botones){
			getEntityManager().merge(b);
		}
		for(Check c : checks){
			getEntityManager().merge(c);
		}
		
	}
	
	@Transactional
	public void eliminar(Long id, List<Notification> notificar, List<Buttonruteo> botones, List<Check> checks){
		Routing routing= getEntityManager().getReference(getBeanClass(), id);
		routing.setRouDel(1);
		getEntityManager().merge(routing);
		for(Notification n : notificar){
			n.setNotDel(1);
			getEntityManager().merge(n);
		}
		for(Buttonruteo b : botones){
			b.setButtonruteoDel(1);
			getEntityManager().merge(b);
		}
		for(Check c : checks){
			c.setChkDel(1);
			getEntityManager().merge(c);
		}
		
		
	}
}
