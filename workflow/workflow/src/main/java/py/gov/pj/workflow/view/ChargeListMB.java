package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.ChargeBC;
import py.gov.pj.workflow.domain.Charge;

@ViewController
@NextView("/charge_edit.xhtml")
@PreviousView("/charge_list.xhtml")
public class ChargeListMB extends AbstractListPageBean<Charge, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ChargeBC chargeBC;
	
	@Override
	protected List<Charge> handleResultList() {
		return this.chargeBC.listar();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				chargeBC.eliminar(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}