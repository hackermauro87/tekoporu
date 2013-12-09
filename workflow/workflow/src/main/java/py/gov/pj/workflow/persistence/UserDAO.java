package py.gov.pj.workflow.persistence;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.ticpy.tekoporu.pagination.Pagination;
import org.ticpy.tekoporu.stereotype.PersistenceController;
import org.ticpy.tekoporu.template.JPACrud;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.domain.User;

@PersistenceController
public class UserDAO extends JPACrud<User, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@SuppressWarnings("unused")
	private Logger logger;
	
	@Transactional
	public void eliminar(Long id){
		//em.createQuery("update City set cityDel=0 where cityId="+id);
		User dt = getEntityManager().getReference(getBeanClass(), id);
		dt.setUserDel(1);
		getEntityManager().merge(dt);
	}
	public List<User> listar() {
		final String jpql = "select this from " + getBeanClass().getSimpleName() + " this where user_del=0";
		final Query query = getEntityManager().createQuery(jpql);

		final Pagination pagination = getPagination();
		if (pagination != null) {
			pagination.setTotalResults(this.contar().intValue());
			query.setFirstResult(pagination.getFirstResult());
			query.setMaxResults(pagination.getPageSize());
		}

		List<User> lista = query.getResultList();
		return lista;
	}
	private Long contar() {
		final Query query = getEntityManager().createQuery(
				"select count(this) from user where user_del=0");
		return (Long) query.getSingleResult();
	}
}
