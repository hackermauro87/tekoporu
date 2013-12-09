package py.gov.pj.workflow.business;

import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.pj.workflow.domain.History;
import py.gov.pj.workflow.persistence.HistoryDAO;

@BusinessController
public class HistoryBC extends DelegateCrud<History, Long, HistoryDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
