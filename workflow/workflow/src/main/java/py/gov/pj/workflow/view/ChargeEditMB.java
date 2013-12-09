package py.gov.pj.workflow.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.ChargeBC;
import py.gov.pj.workflow.domain.Charge;

@ViewController
@PreviousView("/charge_list.xhtml")
public class ChargeEditMB extends AbstractEditPageBean<Charge, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ChargeBC chargeBC;

	@Override
	@Transactional
	public String delete() {

		this.chargeBC.eliminar(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		Charge obj = getBean();
		obj.setChaDel(0);
		obj.setChaDesc(obj.getChaDesc().toUpperCase());
		this.chargeBC.insert(obj);
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {

		Charge obj = getBean();
		obj.setChaDesc(obj.getChaDesc().toUpperCase());
		this.chargeBC.update(obj);
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {

		setBean(this.chargeBC.load(getId()));
	}

}
