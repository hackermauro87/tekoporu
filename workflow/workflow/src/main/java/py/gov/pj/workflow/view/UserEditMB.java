package py.gov.pj.workflow.view;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.util.HashUtils;
import py.gov.pj.workflow.business.OfficerBC;
import py.gov.pj.workflow.business.RolBC;
import py.gov.pj.workflow.business.UserBC;
import py.gov.pj.workflow.domain.Officer;
import py.gov.pj.workflow.domain.Rol;
import py.gov.pj.workflow.domain.User;

@ViewController
@PreviousView("/user_list.xhtml")
public class UserEditMB extends AbstractEditPageBean<User, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserBC userBC;

	@Inject
	private RolBC rolBC;

	private Long rolId;

	@Inject
	private OfficerBC officerBC;
	private Long officerId;


	public void setRolId(Long rolId) {

		this.rolId = rolId;
	}

	public Long getRolId() {

		return rolId;
	}

	public void setOfficerId(Long officerId) {

		this.officerId = officerId;
	}

	public Long getOfficerId() {

		return officerId;
	}

	private List<SelectItem> selectOneItemSection;

	public List<SelectItem> getSelectOneItemSection() {

		this.selectOneItemSection = new ArrayList<SelectItem>();
		List<Rol> roles = rolBC.listar();
		for (Rol sec : roles) {
			SelectItem selectItem = new SelectItem(sec.getRolId(),
					sec.getRolDesc());
			this.selectOneItemSection.add(selectItem);
		}

		return selectOneItemSection;
	}

	private List<SelectItem> selectOneItemOfficer;

	public List<SelectItem> getSelectItemOfficer() {

		this.selectOneItemOfficer = new ArrayList<SelectItem>();
		List<Officer> funcionarios = officerBC.listar();
		for (Officer func : funcionarios) {
			SelectItem selectItem = new SelectItem(func.getOffId(),
					func.getOffName());
			this.selectOneItemOfficer.add(selectItem);
		}
		return selectOneItemOfficer;
	}

	public List<Officer> getOfficers() {

		return officerBC.listar();
	}

	public List<Rol> getRoles() {

		return rolBC.listar();
	}

	@Override
	@Transactional
	public String delete() {

		this.userBC.eliminar(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {

		User obj = getBean();
		Officer func = new Officer();
		Rol objs = new Rol();
		obj.setUserDel(0);
		obj.setUserNick(obj.getUserNick().toUpperCase());
//		obj.setUserPwd(obj.getUserPwd().toUpperCase());
		obj.setUserPwd(HashUtils.md5(obj.getUserPwd()));
		func.setOffId(officerId);
		obj.setOfficer(func);
		objs.setRolId(rolId);
		obj.setRol(objs);
		this.userBC.insert(obj);
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {

		User obj = getBean();
		Officer func = new Officer();
		Rol objs = new Rol();
		obj.setUserNick(obj.getUserNick().toUpperCase());
		obj.setUserPwd(HashUtils.md5(obj.getUserPwd()));
		func.setOffId(officerId);
		obj.setOfficer(func);
		objs.setRolId(rolId);
		obj.setRol(objs);
		this.userBC.update(obj);
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {
		setBean(this.userBC.load(getId()));
		setRolId(getBean().getRol().getRolId());
		setOfficerId(getBean().getOfficer().getOffId());
	}

}
