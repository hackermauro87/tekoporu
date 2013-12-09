package py.gov.pj.workflow.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.CheckBC;
import py.gov.pj.workflow.domain.Check;

@ViewController
@PreviousView("/check_list.xhtml")
public class CheckEditMB extends AbstractEditPageBean<Check, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private CheckBC checkBC;
	
	@Override
	@Transactional
	public String delete() {
		this.checkBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.checkBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.checkBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.checkBC.load(getId()));
	}

}