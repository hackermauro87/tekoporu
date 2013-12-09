package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.DependenceBC;
import py.gov.pj.workflow.domain.Dependence;

@ViewController
@NextView("/dependence_edit.xhtml")
@PreviousView("/dependence_list.xhtml")
public class DependenceListMB extends AbstractListPageBean<Dependence, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DependenceBC dependenceBC;
	
	@Override
	protected List<Dependence> handleResultList() {
		return this.dependenceBC.listar();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				dependenceBC.eliminar(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}