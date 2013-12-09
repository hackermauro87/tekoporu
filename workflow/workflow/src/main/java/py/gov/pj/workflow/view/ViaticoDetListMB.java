package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.ViaticoDetBC;
import py.gov.pj.workflow.domain.ViaticoDet;

@ViewController
@NextView("/viaticoDet_edit.xhtml")
@PreviousView("/viaticoDet_list.xhtml")
public class ViaticoDetListMB extends AbstractListPageBean<ViaticoDet, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ViaticoDetBC viaticoDetBC;
	
	@Override
	protected List<ViaticoDet> handleResultList() {
		return this.viaticoDetBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				viaticoDetBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}