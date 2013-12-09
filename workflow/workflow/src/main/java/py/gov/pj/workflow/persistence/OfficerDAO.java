package py.gov.pj.workflow.persistence;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;

import org.ticpy.tekoporu.pagination.Pagination;
import org.ticpy.tekoporu.stereotype.PersistenceController;
import org.ticpy.tekoporu.template.JPACrud;
import org.ticpy.tekoporu.transaction.Transactional;

import py.gov.pj.workflow.domain.Officer;

@PersistenceController
public class OfficerDAO extends JPACrud<Officer, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@SuppressWarnings("unused")
	private Logger logger;
	

	@Transactional
	public void eliminar(Long id){
		//em.createQuery("update City set cityDel=0 where cityId="+id);
		Officer dt = getEntityManager().getReference(getBeanClass(), id);
		dt.setOffDel(1);
		getEntityManager().merge(dt);
	}
	public List<Officer> listar() {
		final String jpql = "select this from " + getBeanClass().getSimpleName() + " this where off_del=0";
		final Query query = getEntityManager().createQuery(jpql);

		final Pagination pagination = getPagination();
		if (pagination != null) {
			pagination.setTotalResults(this.contar().intValue());
			query.setFirstResult(pagination.getFirstResult());
			query.setMaxResults(pagination.getPageSize());
		}

		List<Officer> lista = query.getResultList();
		return lista;
	}
	private Long contar() {
		final Query query = getEntityManager().createQuery(
				"select count(this) from officer where off_del=0");
		return (Long) query.getSingleResult();
	}

}
