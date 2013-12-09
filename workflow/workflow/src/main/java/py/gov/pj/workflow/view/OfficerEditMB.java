package py.gov.pj.workflow.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.ChargeBC;
import py.gov.pj.workflow.business.OfficerBC;
import py.gov.pj.workflow.business.SectionBC;
import py.gov.pj.workflow.domain.Charge;
import py.gov.pj.workflow.domain.Officer;
import py.gov.pj.workflow.domain.Section;

;

@ViewController
@PreviousView("/officer_list.xhtml")
public class OfficerEditMB extends AbstractEditPageBean<Officer, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OfficerBC officerBC;

	@Inject
	private SectionBC sectionBC;
	private long sectionId;

	@Inject
	private ChargeBC chargeBC;
	private long chargeId;

	public void setSectionId(long sectionId) {

		this.sectionId = sectionId;
	}

	public long getSectionId() {

		return this.sectionId;
	}

	public void setChargeId(long chargeId) {

		this.chargeId = chargeId;
	}

	public long getChargeId() {

		return this.chargeId;
	}

	private List<SelectItem> selectOneItemSection;
	private List<SelectItem> selectOneItemCharge;

	public List<SelectItem> getSelectOneItemSection() {

		this.selectOneItemSection = new ArrayList<SelectItem>();
		List<Section> secciones = sectionBC.listar();
		for (Section sec : secciones) {
			SelectItem selectItem = new SelectItem(sec.getSecId(),
					sec.getSecDesc());
			this.selectOneItemSection.add(selectItem);
		}

		return selectOneItemSection;

	}

	public List<SelectItem> getSelectOneItemCharge() {

		this.selectOneItemCharge = new ArrayList<SelectItem>();
		List<Charge> charges = chargeBC.listar();
		for (Charge cha : charges) {
			SelectItem selectItem = new SelectItem(cha.getChaId(),
					cha.getChaDesc());
			this.selectOneItemCharge.add(selectItem);
		}
		return selectOneItemCharge;
	}

	public List<Section> getSections() {

		return sectionBC.listar();
	}

	public List<Charge> getCharges() {

		return chargeBC.listar();
	}

	@Override
	@Transactional
	public String delete() {

		this.officerBC.eliminar(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {

		Officer obj = getBean();
		Section objs = new Section();
		Charge cha = new Charge();
		obj.setOffDel(0);
		obj.setOffName(obj.getOffName().toUpperCase());
		obj.setOffLastname(obj.getOffLastname().toUpperCase());
		obj.setOffEmail(obj.getOffEmail().toLowerCase());
		obj.setOffAddress(obj.getOffAddress().toUpperCase());
		objs.setSecId(sectionId);
		obj.setSection(objs);
		cha.setChaId(chargeId);
		obj.setCharge(cha);
		this.officerBC.insert(obj);
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {

		Officer obj = getBean();
		Section objs = new Section();
		Charge cha = new Charge();
		obj.setOffName(obj.getOffName().toUpperCase());
		obj.setOffLastname(obj.getOffLastname().toUpperCase());
		obj.setOffEmail(obj.getOffEmail().toLowerCase());
		obj.setOffAddress(obj.getOffAddress().toUpperCase());
		objs.setSecId(sectionId);
		obj.setSection(objs);
		cha.setChaId(chargeId);
		obj.setCharge(cha);
		this.officerBC.update(obj);
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {

		setBean(this.officerBC.load(getId()));
		setSectionId(getBean().getSection().getSecId());
		setChargeId(getBean().getCharge().getChaId());
	}

}
