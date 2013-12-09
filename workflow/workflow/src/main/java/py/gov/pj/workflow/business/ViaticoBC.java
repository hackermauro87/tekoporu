package py.gov.pj.workflow.business;

import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.pj.workflow.domain.Viatico;
import py.gov.pj.workflow.persistence.ViaticoDAO;

@BusinessController
public class ViaticoBC extends DelegateCrud<Viatico, Long, ViaticoDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
