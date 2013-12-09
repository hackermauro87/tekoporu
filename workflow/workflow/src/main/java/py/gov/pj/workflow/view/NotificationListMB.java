package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.NotificationBC;
import py.gov.pj.workflow.domain.Notification;

@ViewController
@NextView("/notification_edit.xhtml")
@PreviousView("/notification_list.xhtml")
public class NotificationListMB extends AbstractListPageBean<Notification, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private NotificationBC notificationBC;
	
	@Override
	protected List<Notification> handleResultList() {
		return this.notificationBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				notificationBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}