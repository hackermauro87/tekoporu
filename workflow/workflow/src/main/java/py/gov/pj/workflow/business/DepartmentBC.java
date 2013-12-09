package py.gov.pj.workflow.business;

import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.pj.workflow.domain.Department;
import py.gov.pj.workflow.domain.Documenttype;
import py.gov.pj.workflow.persistence.DepartmentDAO;

@BusinessController
public class DepartmentBC extends DelegateCrud<Department, Long, DepartmentDAO> {
	
	private static final long serialVersionUID = 1L;
	@Inject DepartmentDAO dep;
	public void eliminar(long Id){
		dep.eliminar(Id);
	}
	
	public List<Department> listar() {
		return dep.listar();
	}
	
	
}
