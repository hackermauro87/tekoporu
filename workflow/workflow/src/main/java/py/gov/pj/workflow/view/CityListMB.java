package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.CityBC;
import py.gov.pj.workflow.domain.City;

@ViewController
@NextView("/city_edit.xhtml")
@PreviousView("/city_list.xhtml")
public class CityListMB extends AbstractListPageBean<City, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private CityBC cityBC;
	
	@Override
	protected List<City> handleResultList() {
		return this.cityBC.listar();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				cityBC.eliminar(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}