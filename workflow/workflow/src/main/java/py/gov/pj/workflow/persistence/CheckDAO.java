package py.gov.pj.workflow.persistence;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;

import org.ticpy.tekoporu.pagination.Pagination;
import org.ticpy.tekoporu.stereotype.PersistenceController;
import org.ticpy.tekoporu.template.JPACrud;

import py.gov.pj.workflow.domain.Check;
import py.gov.pj.workflow.domain.Notification;

@PersistenceController
public class CheckDAO extends JPACrud<Check, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@SuppressWarnings("unused")
	private Logger logger;

	
	public List<Check> listar(long idrou) {
		final String jpql = "select this from " + getBeanClass().getSimpleName() + " this where rou_id="+idrou;
		final Query query = getEntityManager().createQuery(jpql);

		final Pagination pagination = getPagination();
		if (pagination != null) {
			pagination.setTotalResults(this.contar(idrou).intValue());
			query.setFirstResult(pagination.getFirstResult());
			query.setMaxResults(pagination.getPageSize());
		}

		List<Check> lista = query.getResultList();
		return lista;
	}
	private Long contar(long idrou) {
		final Query query = getEntityManager().createQuery(
				"select count(this) from checks where rou_id="+idrou);
		return (Long) query.getSingleResult();
	}
}
