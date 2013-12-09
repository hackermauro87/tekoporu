package py.gov.pj.workflow.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.DocumentBC;
import py.gov.pj.workflow.domain.Document;

@ViewController
@PreviousView("/document_list.xhtml")
public class DocumentEditMB extends AbstractEditPageBean<Document, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DocumentBC documentBC;
	
	@Override
	@Transactional
	public String delete() {
		this.documentBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.documentBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.documentBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.documentBC.load(getId()));
	}

}