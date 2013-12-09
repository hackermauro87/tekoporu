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
import py.gov.pj.workflow.domain.Documenttype;

@PersistenceController
public class DepartmentDAO extends JPACrud<Department, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	@SuppressWarnings("unused")
	private Logger logger;

	@Transactional
	public void eliminar(Long id) {

		Department dp = getEntityManager().getReference(getBeanClass(), id);
		dp.setDepDel(1);
		getEntityManager().merge(dp);
	}

	public List<Department> listar() {

		final String jpql = "select this from "
				+ getBeanClass().getSimpleName() + " this where dep_del=0";
		final Query query = getEntityManager().createQuery(jpql);

		final Pagination pagination = getPagination();
		if (pagination != null) {
			pagination.setTotalResults(this.contar().intValue());
			query.setFirstResult(pagination.getFirstResult());
			query.setMaxResults(pagination.getPageSize());
		}

		List<Department> lista = query.getResultList();
		return lista;
	}

	private Long contar() {

		final Query query = getEntityManager().createQuery(
				"select count(this) from department where dep_del=0");
		return (Long) query.getSingleResult();
	}

}
