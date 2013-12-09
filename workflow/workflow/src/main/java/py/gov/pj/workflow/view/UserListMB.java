package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.UserBC;
import py.gov.pj.workflow.domain.User;

@ViewController
@NextView("/user_edit.xhtml")
@PreviousView("/user_list.xhtml")
public class UserListMB extends AbstractListPageBean<User, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserBC userBC;
	
	@Override
	protected List<User> handleResultList() {
		return this.userBC.listar();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				userBC.eliminar(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}