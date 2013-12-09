package py.gov.pj.workflow.business;

import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.pj.workflow.domain.Document;
import py.gov.pj.workflow.persistence.DocumentDAO;

@BusinessController
public class DocumentBC extends DelegateCrud<Document, Long, DocumentDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
