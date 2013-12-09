package py.gov.pj.workflow.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.RolBC;
import py.gov.pj.workflow.domain.Rol;

@ViewController
@PreviousView("/rol_list.xhtml")
public class RolEditMB extends AbstractEditPageBean<Rol, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private RolBC rolBC;

	@Override
	@Transactional
	public String delete() {

		this.rolBC.eliminar(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {

		Rol rol = getBean();
		rol.setRolDel(0);
		rol.setRolDesc(rol.getRolDesc().toUpperCase());
		this.rolBC.insert(rol);
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		Rol rol = getBean();
		rol.setRolDesc(rol.getRolDesc().toUpperCase());
		this.rolBC.update(rol);
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {

		setBean(this.rolBC.load(getId()));
	}

}
