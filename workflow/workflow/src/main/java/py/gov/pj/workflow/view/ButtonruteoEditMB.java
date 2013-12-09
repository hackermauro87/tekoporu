package py.gov.pj.workflow.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.ButtonruteoBC;
import py.gov.pj.workflow.domain.Buttonruteo;

@ViewController
@PreviousView("/buttonruteo_list.xhtml")
public class ButtonruteoEditMB extends AbstractEditPageBean<Buttonruteo, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ButtonruteoBC buttonruteoBC;
	
	@Override
	@Transactional
	public String delete() {
		this.buttonruteoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.buttonruteoBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.buttonruteoBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.buttonruteoBC.load(getId()));
	}

}