package py.gov.pj.workflow.persistence;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;

import org.ticpy.tekoporu.pagination.Pagination;
import org.ticpy.tekoporu.stereotype.PersistenceController;
import org.ticpy.tekoporu.template.JPACrud;

import py.gov.pj.workflow.domain.Dybutton;
import py.gov.pj.workflow.domain.Officer;

@PersistenceController
public class DybuttonDAO extends JPACrud<Dybutton, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@SuppressWarnings("unused")
	private Logger logger;
	
	
	public List<Dybutton> listar() {
		final String jpql = "select this from " + getBeanClass().getSimpleName() + " this where dyb_del=0";
		final Query query = getEntityManager().createQuery(jpql);

		final Pagination pagination = getPagination();
		if (pagination != null) {
			pagination.setTotalResults(this.contar().intValue());
			query.setFirstResult(pagination.getFirstResult());
			query.setMaxResults(pagination.getPageSize());
		}

		List<Dybutton> lista = query.getResultList();
		return lista;
	}
	private Long contar() {
		final Query query = getEntityManager().createQuery(
				"select count(this) from dybutton where dyb_del=0");
		return (Long) query.getSingleResult();
	}
}
