package py.gov.pj.workflow.persistence;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;

import org.ticpy.tekoporu.pagination.Pagination;
import org.ticpy.tekoporu.stereotype.PersistenceController;
import org.ticpy.tekoporu.template.JPACrud;
import org.ticpy.tekoporu.transaction.Transactional;

import py.gov.pj.workflow.domain.Department;
import py.gov.pj.workflow.domain.Dependence;

@PersistenceController
public class DependenceDAO extends JPACrud<Dependence, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@SuppressWarnings("unused")
	private Logger logger;
	
	@Transactional
	public void eliminar(Long id) {

		Dependence dep = getEntityManager().getReference(getBeanClass(), id);
		dep.setDepenDel(1);
		getEntityManager().merge(dep);
	}

	public List<Dependence> listar() {

		final String jpql = "select this from "
				+ getBeanClass().getSimpleName() + " this where depen_del=0";
		final Query query = getEntityManager().createQuery(jpql);

		final Pagination pagination = getPagination();
		if (pagination != null) {
			pagination.setTotalResults(this.contar().intValue());
			query.setFirstResult(pagination.getFirstResult());
			query.setMaxResults(pagination.getPageSize());
		}

		List<Dependence> lista = query.getResultList();
		return lista;
	}

	private Long contar() {

		final Query query = getEntityManager().createQuery(
				"select count(this) from dependence where depen_del=0");
		return (Long) query.getSingleResult();
	}


}
