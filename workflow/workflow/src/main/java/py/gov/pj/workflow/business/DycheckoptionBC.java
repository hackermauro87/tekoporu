package py.gov.pj.workflow.business;

import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.pj.workflow.domain.Dybutton;
import py.gov.pj.workflow.domain.Dycheckoption;
import py.gov.pj.workflow.persistence.DycheckoptionDAO;

@BusinessController
public class DycheckoptionBC extends DelegateCrud<Dycheckoption, Long, DycheckoptionDAO> {
	
	private static final long serialVersionUID = 1L;
	@Inject DycheckoptionDAO dchDAO;
	
	public List<Dycheckoption> listarChecks(){
		
		return dchDAO.listar();
	}
	public void eliminar(long Id){
		 dchDAO.eliminar(Id);
	}
}
