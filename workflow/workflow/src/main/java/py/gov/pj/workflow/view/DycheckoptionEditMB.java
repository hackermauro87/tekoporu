package py.gov.pj.workflow.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.DycheckoptionBC;
import py.gov.pj.workflow.domain.Dycheckoption;

@ViewController
@PreviousView("/dycheckoption_list.xhtml")
public class DycheckoptionEditMB extends
		AbstractEditPageBean<Dycheckoption, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DycheckoptionBC dycheckoptionBC;

	@Override
	@Transactional
	public String delete() {

		this.dycheckoptionBC.eliminar(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		Dycheckoption dychec = getBean();
		dychec.setDychkDel(0);
		dychec.setDychkDesc(dychec.getDychkDesc().toUpperCase());
		this.dycheckoptionBC.insert(dychec);
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		Dycheckoption dychec = getBean();
		dychec.setDychkDesc(dychec.getDychkDesc().toUpperCase());
		this.dycheckoptionBC.update(dychec);
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {
		setBean(this.dycheckoptionBC.load(getId()));
	}

}
