package py.gov.pj.workflow.business;

import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.pj.workflow.domain.ViaticoDet;
import py.gov.pj.workflow.persistence.ViaticoDetDAO;

@BusinessController
public class ViaticoDetBC extends DelegateCrud<ViaticoDet, Long, ViaticoDetDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
