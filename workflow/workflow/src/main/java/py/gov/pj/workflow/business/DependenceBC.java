package py.gov.pj.workflow.business;

import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.pj.workflow.domain.Department;
import py.gov.pj.workflow.domain.Dependence;
import py.gov.pj.workflow.persistence.DependenceDAO;

@BusinessController
public class DependenceBC extends DelegateCrud<Dependence, Long, DependenceDAO> {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private DependenceDAO depeDAO;
	
	public void eliminar(long Id){
		depeDAO.eliminar(Id);
	}
	
	public List<Dependence> listar() {
		return depeDAO.listar();
	}
	
}
