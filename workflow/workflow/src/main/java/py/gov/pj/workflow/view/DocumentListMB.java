package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.DocumentBC;
import py.gov.pj.workflow.domain.Document;

@ViewController
@NextView("/document_edit.xhtml")
@PreviousView("/document_list.xhtml")
public class DocumentListMB extends AbstractListPageBean<Document, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DocumentBC documentBC;
	
	@Override
	protected List<Document> handleResultList() {
		return this.documentBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				documentBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}