package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.DocAccessBC;
import py.gov.pj.workflow.domain.DocAccess;

@ViewController
@NextView("/docAccess_edit.xhtml")
@PreviousView("/docAccess_list.xhtml")
public class DocAccessListMB extends AbstractListPageBean<DocAccess, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DocAccessBC docAccessBC;
	
	@Override
	protected List<DocAccess> handleResultList() {
		return this.docAccessBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				docAccessBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}