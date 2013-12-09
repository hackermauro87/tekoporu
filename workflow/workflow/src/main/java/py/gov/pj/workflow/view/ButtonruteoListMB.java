package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.ButtonruteoBC;
import py.gov.pj.workflow.domain.Buttonruteo;

@ViewController
@NextView("/buttonruteo_edit.xhtml")
@PreviousView("/buttonruteo_list.xhtml")
public class ButtonruteoListMB extends AbstractListPageBean<Buttonruteo, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ButtonruteoBC buttonruteoBC;
	
	@Override
	protected List<Buttonruteo> handleResultList() {
		return this.buttonruteoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				buttonruteoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}