package py.gov.pj.workflow.view;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.DependenceBC;
import py.gov.pj.workflow.business.SectionBC;
import py.gov.pj.workflow.domain.Department;
import py.gov.pj.workflow.domain.Dependence;
import py.gov.pj.workflow.domain.Section;

@ViewController
@PreviousView("/section_list.xhtml")
public class SectionEditMB extends AbstractEditPageBean<Section, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SectionBC sectionBC;
	
	@Inject
	private DependenceBC depeBC;
	private Long depenId;
	
	public void setDepenId(Long depenId) {

		this.depenId = depenId;
	}

	public Long getDepenId() {

		return depenId;
	}
	
	private List<SelectItem> selectOneItemDependence;

	public List<SelectItem> getSelectOneItemDependence() {

		this.selectOneItemDependence = new ArrayList<SelectItem>();
		List<Dependence> dependences = depeBC.listar();
		for (Dependence depe : dependences) {
			SelectItem selectItem = new SelectItem(depe.getDepenId(),
					depe.getDepenDesc());
			this.selectOneItemDependence.add(selectItem);
		}
		return selectOneItemDependence;
	}
	
	public List<Dependence> getDepartmets() {

		return this.depeBC.listar();
	}
	
	@Override
	@Transactional
	public String delete() {
		this.sectionBC.eliminar(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		Section obj = getBean();
		Dependence depe = new Dependence();
		obj.setSecDel(0);
		obj.setSecDesc(obj.getSecDesc().toUpperCase());
		depe.setDepenId(depenId);
		obj.setDependence(depe);
		this.sectionBC.insert(obj);
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		Section obj = getBean();
		Dependence depe = new Dependence();
		obj.setSecDesc(obj.getSecDesc().toUpperCase());
		depe.setDepenId(depenId);
		obj.setDependence(depe);
		this.sectionBC.update(obj);
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.sectionBC.load(getId()));
		setDepenId(getBean().getDependence().getDepenId());
	}


}