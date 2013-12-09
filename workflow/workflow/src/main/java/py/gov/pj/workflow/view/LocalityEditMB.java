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
import py.gov.pj.workflow.business.LocalityBC;
import py.gov.pj.workflow.domain.City;
import py.gov.pj.workflow.domain.Department;
import py.gov.pj.workflow.domain.Locality;

@ViewController
@PreviousView("/locality_list.xhtml")
public class LocalityEditMB extends AbstractEditPageBean<Locality, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private LocalityBC localityBC;

	@Inject
	private CityBC cityBC;
	private long citId;

	@Inject
	private DepartmentBC depabc;
	private long dep_Id;

	public void setCitId(long citId) {

		this.citId = citId;
	}

	public long getCitId() {

		return this.citId;
	}

	public void setDepId(Long depId) {

		this.dep_Id = depId;
	}

	public Long getDepId() {

		return dep_Id;
	}

	private List<SelectItem> selectOneItemCity;

	public List<SelectItem> getSelectOneItemCity() {

		this.selectOneItemCity = new ArrayList<SelectItem>();
		List<City> citys = cityBC.listar();
		for (City cit : citys) {
			SelectItem selectItem = new SelectItem(cit.getCitId(),
					cit.getCitDesc());
			this.selectOneItemCity.add(selectItem);
		}
		return selectOneItemCity;
	}

	public List<City> getCitys() {

		return cityBC.listar();
	}

//	public List<Department> getDepartments() {
//
//		return depabc.listar();
//	}
	
	@Override
	@Transactional
	public String delete() {
		this.localityBC.eliminar(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		Locality locality = getBean();
		City cit = cityBC.load(citId);
		locality.setLocDel(0);
		locality.setLocDesc(locality.getLocDesc().toUpperCase());
		locality.setCity(cit);
		locality.setDepId(cit.getDepartment().getDepId());
		this.localityBC.insert(locality);
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		Locality locality = getBean();
		City cit = cityBC.load(citId);
		locality.setLocDesc(locality.getLocDesc().toUpperCase());
		locality.setCity(cit);
		locality.setDepId(cit.getDepartment().getDepId());
		this.localityBC.update(locality);
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {

		setBean(this.localityBC.load(getId()));
		setCitId(getBean().getCity().getCitId());
	}

}
