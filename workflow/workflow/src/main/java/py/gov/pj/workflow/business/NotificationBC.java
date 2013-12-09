package py.gov.pj.workflow.business;

import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.pj.workflow.domain.Buttonruteo;
import py.gov.pj.workflow.domain.Notification;
import py.gov.pj.workflow.persistence.NotificationDAO;

@BusinessController
public class NotificationBC extends DelegateCrud<Notification, Long, NotificationDAO> {
	
	private static final long serialVersionUID = 1L;
	@Inject private NotificationDAO notifDAO;
	
	
	public List<Notification> listar(long idrou){
		return notifDAO.listar(idrou);
	}
	
}
