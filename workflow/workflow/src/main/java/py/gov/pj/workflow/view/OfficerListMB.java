package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.OfficerBC;
import py.gov.pj.workflow.domain.Officer;

@ViewController
@NextView("/officer_edit.xhtml")
@PreviousView("/officer_list.xhtml")
public class OfficerListMB extends AbstractListPageBean<Officer, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OfficerBC officerBC;
	
	@Override
	protected List<Officer> handleResultList() {
		return this.officerBC.listar();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				officerBC.eliminar(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}