package py.gov.pj.workflow.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.DocAccessBC;
import py.gov.pj.workflow.domain.DocAccess;

@ViewController
@PreviousView("/docAccess_list.xhtml")
public class DocAccessEditMB extends AbstractEditPageBean<DocAccess, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DocAccessBC docAccessBC;
	
	@Override
	@Transactional
	public String delete() {
		this.docAccessBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.docAccessBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.docAccessBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.docAccessBC.load(getId()));
	}

}