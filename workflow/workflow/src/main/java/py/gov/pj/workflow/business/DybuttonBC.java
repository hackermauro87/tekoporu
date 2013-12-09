package py.gov.pj.workflow.business;

import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.pj.workflow.domain.Dybutton;
import py.gov.pj.workflow.persistence.DybuttonDAO;

@BusinessController
public class DybuttonBC extends DelegateCrud<Dybutton, Long, DybuttonDAO> {
	
	private static final long serialVersionUID = 1L;
	@Inject private DybuttonDAO dbdao;
	
	public List<Dybutton> listarbotones(){
		
		return dbdao.listar();
	}
}
