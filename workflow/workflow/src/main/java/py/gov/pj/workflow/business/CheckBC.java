package py.gov.pj.workflow.business;

import java.util.List;
import java.util.zip.Checksum;
import javax.inject.Inject;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.pj.workflow.domain.Check;
import py.gov.pj.workflow.domain.Notification;
import py.gov.pj.workflow.persistence.CheckDAO;

@BusinessController
public class CheckBC extends DelegateCrud<Check, Long, CheckDAO> {
	
	private static final long serialVersionUID = 1L;
	@Inject private CheckDAO chkDAO;
	
	
	public List<Check> listar(long idrou){
		return chkDAO.listar(idrou);
	}
}
