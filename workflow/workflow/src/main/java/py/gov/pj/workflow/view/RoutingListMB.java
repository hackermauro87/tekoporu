package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.RoutingBC;
import py.gov.pj.workflow.domain.Routing;

@ViewController
@NextView("/routing_edit.xhtml")
@PreviousView("/routing_list.xhtml")
public class RoutingListMB extends AbstractListPageBean<Routing, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private RoutingBC routingBC;
	
	@Override
	protected List<Routing> handleResultList() {
		return this.routingBC.listar();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				routingBC.eliminar(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}