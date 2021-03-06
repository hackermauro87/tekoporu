package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.DycheckoptionBC;
import py.gov.pj.workflow.domain.Dycheckoption;

@ViewController
@NextView("/dycheckoption_edit.xhtml")
@PreviousView("/dycheckoption_list.xhtml")
public class DycheckoptionListMB extends AbstractListPageBean<Dycheckoption, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DycheckoptionBC dycheckoptionBC;
	
	@Override
	protected List<Dycheckoption> handleResultList() {
		return this.dycheckoptionBC.listarChecks();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				dycheckoptionBC.eliminar(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}