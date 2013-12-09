package py.gov.pj.workflow.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.DepartmentBC;
import py.gov.pj.workflow.domain.Department;
import py.gov.pj.workflow.domain.Section;

@ViewController
@PreviousView("/department_list.xhtml")
public class DepartmentEditMB extends AbstractEditPageBean<Department, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DepartmentBC departmentBC;
	
	@Override
	@Transactional
	public String delete() {
		this.departmentBC.eliminar(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		Department obj = getBean();
		obj.setDepDel(0);
		obj.setDepDesc(obj.getDepDesc().toUpperCase());
		
		this.departmentBC.insert(obj);
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		Department obj = getBean();
		obj.setDepDesc(obj.getDepDesc().toUpperCase());
		this.departmentBC.update(obj);
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.departmentBC.load(getId()));
	}

}