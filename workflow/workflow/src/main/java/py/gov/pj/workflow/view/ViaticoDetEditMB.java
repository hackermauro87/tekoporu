package py.gov.pj.workflow.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.ViaticoDetBC;
import py.gov.pj.workflow.domain.ViaticoDet;

@ViewController
@PreviousView("/viaticoDet_list.xhtml")
public class ViaticoDetEditMB extends AbstractEditPageBean<ViaticoDet, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ViaticoDetBC viaticoDetBC;
	
	@Override
	@Transactional
	public String delete() {
		this.viaticoDetBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.viaticoDetBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.viaticoDetBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.viaticoDetBC.load(getId()));
	}

}