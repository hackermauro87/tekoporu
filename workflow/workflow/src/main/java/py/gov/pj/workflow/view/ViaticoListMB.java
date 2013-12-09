package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.ViaticoBC;
import py.gov.pj.workflow.domain.Viatico;

@ViewController
@NextView("/viatico_edit.xhtml")
@PreviousView("/viatico_list.xhtml")
public class ViaticoListMB extends AbstractListPageBean<Viatico, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ViaticoBC viaticoBC;
	
	@Override
	protected List<Viatico> handleResultList() {
		return this.viaticoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				viaticoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}