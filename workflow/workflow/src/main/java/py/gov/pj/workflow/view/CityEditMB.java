package py.gov.pj.workflow.view;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.CityBC;
import py.gov.pj.workflow.business.DepartmentBC;
import py.gov.pj.workflow.domain.City;
import py.gov.pj.workflow.domain.Department;

@ViewController
@PreviousView("/city_list.xhtml")
public class CityEditMB extends AbstractEditPageBean<City, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private CityBC cityBC;

	@Inject
	private DepartmentBC depaBC;
	private long depId;

	public void setDepId(long depId) {

		this.depId = depId;
	}

	public long getDepId() {

		return depId;
	}

	private List<SelectItem> selectOneItemDepartment;

	public List<SelectItem> getSelectOneItemDepartment() {

		this.selectOneItemDepartment = new ArrayList<SelectItem>();
		List<Department> departments = depaBC.listar();
		for (Department dep : departments) {
			SelectItem selectItem = new SelectItem(dep.getDepId(),
					dep.getDepDesc());
			this.selectOneItemDepartment.add(selectItem);
		}
		return selectOneItemDepartment;
	}

	public List<Department> getDepartmets() {

		return this.depaBC.listar();
	}

	@Override
	@Transactional
	public String delete() {

		this.cityBC.eliminar(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {

		City obj = getBean();
		Department dep = new Department();
		obj.setCitDel(0);
		obj.setCitDesc(obj.getCitDesc().toUpperCase());
		dep.setDepId(depId);
		obj.setDepartment(dep);
		this.cityBC.insert(obj);
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {

		City obj = getBean();
		Department dep = new Department();
		obj.setCitDesc(obj.getCitDesc().toUpperCase());
		dep.setDepId(depId);
		obj.setDepartment(dep);
		this.cityBC.update(obj);
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {

		setBean(this.cityBC.load(getId()));
		setDepId(getBean().getDepartment().getDepId());
	}

}
