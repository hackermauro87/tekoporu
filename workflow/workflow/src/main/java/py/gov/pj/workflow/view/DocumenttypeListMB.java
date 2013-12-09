package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.DocumenttypeBC;
import py.gov.pj.workflow.domain.Documenttype;

@ViewController
@NextView("/documenttype_edit.xhtml")
@PreviousView("/documenttype_list.xhtml")
public class DocumenttypeListMB extends AbstractListPageBean<Documenttype, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DocumenttypeBC documenttypeBC;
	
	@Override
	protected List<Documenttype> handleResultList() {
		return this.documenttypeBC.listar();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				documenttypeBC.eliminar(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}