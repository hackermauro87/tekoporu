package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.LocalityBC;
import py.gov.pj.workflow.domain.Locality;

@ViewController
@NextView("/locality_edit.xhtml")
@PreviousView("/locality_list.xhtml")
public class LocalityListMB extends AbstractListPageBean<Locality, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private LocalityBC localityBC;
	
	@Override
	protected List<Locality> handleResultList() {
		return this.localityBC.listar();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				localityBC.eliminar(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}
}