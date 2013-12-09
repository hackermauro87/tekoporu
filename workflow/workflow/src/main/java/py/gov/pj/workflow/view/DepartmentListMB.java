package py.gov.pj.workflow.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.DepartmentBC;
import py.gov.pj.workflow.domain.Department;

@ViewController
@NextView("/department_edit.xhtml")
@PreviousView("/department_list.xhtml")
public class DepartmentListMB extends AbstractListPageBean<Department, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DepartmentBC departmentBC;
	
	@Override
	protected List<Department> handleResultList() {
		return this.departmentBC.listar();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				departmentBC.eliminar(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}