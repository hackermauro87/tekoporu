package py.gov.pj.workflow.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.HistoryBC;
import py.gov.pj.workflow.domain.History;

@ViewController
@PreviousView("/history_list.xhtml")
public class HistoryEditMB extends AbstractEditPageBean<History, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private HistoryBC historyBC;
	
	@Override
	@Transactional
	public String delete() {
		this.historyBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.historyBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.historyBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.historyBC.load(getId()));
	}

}