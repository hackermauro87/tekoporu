package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.DybuttonBC;
import py.gov.pj.workflow.domain.Dybutton;

@ViewController
@NextView("/dybutton_edit.xhtml")
@PreviousView("/dybutton_list.xhtml")
public class DybuttonListMB extends AbstractListPageBean<Dybutton, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DybuttonBC dybuttonBC;
	
	@Override
	protected List<Dybutton> handleResultList() {
		return this.dybuttonBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				dybuttonBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}