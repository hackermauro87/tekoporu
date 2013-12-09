package py.gov.pj.workflow.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.DocumenttypeBC;
import py.gov.pj.workflow.domain.Department;
import py.gov.pj.workflow.domain.Documenttype;

@ViewController
@PreviousView("/documenttype_list.xhtml")
public class DocumenttypeEditMB extends AbstractEditPageBean<Documenttype, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DocumenttypeBC documenttypeBC;
	
	@Override
	@Transactional
	public String delete() {
		this.documenttypeBC.eliminar(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		Documenttype tipdoc = getBean();
		tipdoc.setDoctypeDel(0);
		tipdoc.setDoctypeDesc(tipdoc.getDoctypeDesc().toUpperCase());
		this.documenttypeBC.insert(tipdoc);
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		Documenttype obj = getBean();
		obj.setDoctypeDesc(obj.getDoctypeDesc().toUpperCase());
		this.documenttypeBC.update(obj);
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.documenttypeBC.load(getId()));
	}

}