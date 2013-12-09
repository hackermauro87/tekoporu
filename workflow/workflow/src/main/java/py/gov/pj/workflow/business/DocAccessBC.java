package py.gov.pj.workflow.business;

import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.pj.workflow.domain.DocAccess;
import py.gov.pj.workflow.persistence.DocAccessDAO;

@BusinessController
public class DocAccessBC extends DelegateCrud<DocAccess, Long, DocAccessDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
