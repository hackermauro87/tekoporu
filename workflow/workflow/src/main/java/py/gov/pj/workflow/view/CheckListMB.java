package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.CheckBC;
import py.gov.pj.workflow.domain.Check;

@ViewController
@NextView("/check_edit.xhtml")
@PreviousView("/check_list.xhtml")
public class CheckListMB extends AbstractListPageBean<Check, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private CheckBC checkBC;
	
	@Override
	protected List<Check> handleResultList() {
		return this.checkBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				checkBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}