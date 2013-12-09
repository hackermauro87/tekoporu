package py.gov.pj.workflow.business;

import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.pj.workflow.domain.Rol;
import py.gov.pj.workflow.persistence.RolDAO;

@BusinessController
public class RolBC extends DelegateCrud<Rol, Long, RolDAO> {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private RolDAO rol;
	
	public void eliminar(Long id) {
		rol.eliminar(id);
	}
	
	public List<Rol> listar(){
		return rol.listar();
	}
}
