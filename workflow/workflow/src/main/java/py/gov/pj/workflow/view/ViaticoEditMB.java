package py.gov.pj.workflow.view;

import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.ChargeBC;
import py.gov.pj.workflow.business.DependenceBC;
import py.gov.pj.workflow.business.OfficerBC;
import py.gov.pj.workflow.business.ViaticoBC;
import py.gov.pj.workflow.business.ViaticoDetBC;
import py.gov.pj.workflow.domain.Charge;
import py.gov.pj.workflow.domain.Dependence;
import py.gov.pj.workflow.domain.Officer;
import py.gov.pj.workflow.domain.Viatico;
import py.gov.pj.workflow.domain.ViaticoDet;

@ViewController
@PreviousView("/viatico_list.xhtml")
public class ViaticoEditMB extends AbstractEditPageBean<Viatico, Long> {

	private static final long serialVersionUID = 1L;

	@Inject private ViaticoBC viaticoBC;
	@Inject private DependenceBC dependenciaBC;
	@Inject private OfficerBC funcionarioBC;
	@Inject private ChargeBC cargosBC;
	@Inject private ViaticoDetBC viaticoDetBC;
	
	private long dependencia; 
	private long funcionario;
	private long cargo;
	
	private List<SelectItem> listDependencias;
	private List<SelectItem> listOfficers;
	private List<SelectItem> listCharges;
	private List<ViaticoDet> listViaticoDet;
	
	
	
	
	@Override
	@Transactional
	public String delete() {
		this.viaticoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.viaticoBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.viaticoBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.viaticoBC.load(getId()));
	}

	public long getDependencia() {
		
		return dependencia;
	}

	public void setDependencia(long dependencia) {

		this.dependencia = dependencia;
	}

	public List<SelectItem> getListDependencias() {
		listDependencias = new ArrayList<SelectItem>();
		List <Dependence> alldep = dependenciaBC.listar();
		SelectItem selectIt;
		for (Dependence dependence : alldep) {
			selectIt = new SelectItem(dependence.getDepenId(),dependence.getDepenDesc());
			this.listDependencias.add(selectIt);
		}
		
		return listDependencias;
	}

	public void setListDependencias(List<SelectItem> listDependencias) {

		this.listDependencias = listDependencias;
	}

	public long getFuncionario() {

		return funcionario;
	}

	public void setFuncionario(long funcionario) {

		this.funcionario = funcionario;
	}

	public long getCargo() {

		return cargo;
	}

	public void setCargo(long cargo) {

		this.cargo = cargo;
	}

	public List<SelectItem> getListOfficers() {
		listOfficers = new ArrayList<SelectItem>();
		List <Officer> alloff = funcionarioBC.listar();
		SelectItem selectIt;
		for (Officer officer : alloff) {
			selectIt = new SelectItem(officer.getOffId(),officer.getOffCi()+" - "+officer.getOffName()+" "+officer.getOffLastname());
			this.listOfficers.add(selectIt);
		} 
		return listOfficers;
	}

	public void setListOfficers(List<SelectItem> listOfficers) {

		this.listOfficers = listOfficers;
	}

	public List<SelectItem> getListCharges() {
		
		listCharges = new ArrayList<SelectItem>();
		List <Charge> allcha = cargosBC.listar();
		SelectItem selectIt;
		for (Charge charge : allcha) {
			selectIt = new SelectItem(charge.getChaId(),charge.getChaDesc());
			this.listCharges.add(selectIt);
		}
		return listCharges;
	}

	public void setListCharges(List<SelectItem> listCharges) {

		this.listCharges = listCharges;
	}

	public List<ViaticoDet> getListViaticoDet() {
		
		return listViaticoDet;
	}

	public void setListViaticoDet(List<ViaticoDet> listViaticoDet) {
		
		this.listViaticoDet = listViaticoDet;
	}
	
	public void addOfficerToList(ActionEvent av){
		System.out.println("####################################ADDEDsssssssssssssssssssssssssssssss");
//		ViaticoDet newreg = new ViaticoDet();
//		newreg.setCharge(cargosBC.load(cargo));
//		newreg.setOfficer(funcionarioBC.load(funcionario));
//		listViaticoDet.add(newreg);
	}
}