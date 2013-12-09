package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.HistoryBC;
import py.gov.pj.workflow.domain.History;

@ViewController
@NextView("/history_edit.xhtml")
@PreviousView("/history_list.xhtml")
public class HistoryListMB extends AbstractListPageBean<History, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private HistoryBC historyBC;
	
	@Override
	protected List<History> handleResultList() {
		return this.historyBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				historyBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}