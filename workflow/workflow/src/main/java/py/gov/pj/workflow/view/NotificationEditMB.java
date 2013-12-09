package py.gov.pj.workflow.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.NotificationBC;
import py.gov.pj.workflow.domain.Notification;

@ViewController
@PreviousView("/notification_list.xhtml")
public class NotificationEditMB extends AbstractEditPageBean<Notification, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private NotificationBC notificationBC;
	
	@Override
	@Transactional
	public String delete() {
		this.notificationBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.notificationBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.notificationBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.notificationBC.load(getId()));
	}

}