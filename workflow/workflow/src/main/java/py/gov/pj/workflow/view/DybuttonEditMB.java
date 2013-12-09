package py.gov.pj.workflow.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.DybuttonBC;
import py.gov.pj.workflow.domain.Dybutton;

@ViewController
@PreviousView("/dybutton_list.xhtml")
public class DybuttonEditMB extends AbstractEditPageBean<Dybutton, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DybuttonBC dybuttonBC;
	
	@Override
	@Transactional
	public String delete() {
		this.dybuttonBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.dybuttonBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.dybuttonBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.dybuttonBC.load(getId()));
	}

}