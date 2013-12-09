package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.SectionBC;
import py.gov.pj.workflow.domain.Section;

@ViewController
@NextView("/section_edit.xhtml")
@PreviousView("/section_list.xhtml")
public class SectionListMB extends AbstractListPageBean<Section, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SectionBC sectionBC;
	
	@Override
	protected List<Section> handleResultList() {
		return this.sectionBC.listar();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				sectionBC.eliminar(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}