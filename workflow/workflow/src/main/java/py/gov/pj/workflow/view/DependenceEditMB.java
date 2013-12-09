package py.gov.pj.workflow.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.DependenceBC;
import py.gov.pj.workflow.domain.Dependence;

@ViewController
@PreviousView("/dependence_list.xhtml")
public class DependenceEditMB extends AbstractEditPageBean<Dependence, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DependenceBC dependenceBC;
	
	@Override
	@Transactional
	public String delete() {
		this.dependenceBC.eliminar(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		Dependence dep = getBean();
		dep.setDepenDel(0);
		dep.setDepenDesc(dep.getDepenDesc().toUpperCase());
		this.dependenceBC.insert(dep);
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		Dependence dep = getBean();
		dep.setDepenDesc(dep.getDepenDesc().toUpperCase());
		this.dependenceBC.update(dep);
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.dependenceBC.load(getId()));
	}

}