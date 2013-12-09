package py.gov.pj.workflow.business;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.model.DualListModel;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;
import org.ticpy.tekoporu.transaction.Transactional;

import py.gov.pj.workflow.domain.Buttonruteo;
import py.gov.pj.workflow.domain.Check;
import py.gov.pj.workflow.domain.Dybutton;
import py.gov.pj.workflow.domain.Dycheckoption;
import py.gov.pj.workflow.domain.Notification;
import py.gov.pj.workflow.domain.Routing;
import py.gov.pj.workflow.domain.User;
import py.gov.pj.workflow.persistence.RoutingDAO;

@BusinessController
public class RoutingBC extends DelegateCrud<Routing, Long, RoutingDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject private DybuttonBC dbc;
	@Inject private UserBC userbc;
	@Inject private DycheckoptionBC dcheckBC;
	@Inject private RoutingDAO rDAO;
	
	@Inject private ButtonruteoBC butrutBC;
	@Inject private NotificationBC notiBC;
	@Inject private CheckBC chkBC;
	
	public List<Dybutton> allButtons(){
		return dbc.listarbotones();
	}
	
	public List<User> getUsers(){
		return userbc.listar();
	}
	
	public List<Dycheckoption> getChecks(){
		return dcheckBC.listarChecks();
	}
	
	@Transactional
	public void insertar(Routing routing, DualListModel<User> user, DualListModel<Dybutton> buttons, DualListModel<Dycheckoption> checks) {
		
		routing.setRouDel(0);
		routing.setRouDesc(routing.getRouDesc().toUpperCase());
		List<Notification> notificar = new ArrayList<Notification>();
		Notification notif;
		
		
		List<Buttonruteo> botones = new ArrayList<Buttonruteo>();
		
		Buttonruteo boton;
		
		List<Check> chks = new ArrayList<Check>();
		Check ck;
		
		for (Dybutton ddbb : buttons.getTarget()) {
			
				boton = new Buttonruteo();
				boton.setDybutton(ddbb);
				boton.setButtonruteoDel(0);
				boton.setRouting(routing);
				botones.add(boton);
			
			
		}
		
		for ( User uuss : user.getTarget() ){
			 notif = new Notification();
			 notif.setUser(uuss);
			 notif.setNotDel(0);
			 notif.setNotDesc("");
			 notif.setRouting(routing);
			 notificar.add(notif);
		}
		
		for ( Dycheckoption cckk : checks.getTarget() ){
			ck = new Check();
			ck.setDycheckoption(cckk);
			ck.setChkDel(0);
			ck.setRouting(routing);
			chks.add(ck);
		}
		
		rDAO.insertar(routing, notificar, botones, chks);
		
		
		
	}

	public void actualizar(Routing routing, DualListModel<User> user,DualListModel<Dybutton> buttons, DualListModel<Dycheckoption> checks) {
		routing.setRouDesc(routing.getRouDesc().toUpperCase());
		for(Buttonruteo br : butrutBC.listar(routing.getRouId())){
			butrutBC.delete(br.getButtonruteoId());
		}
		for(Notification nt : notiBC.listar(routing.getRouId())){
			notiBC.delete(nt.getNotId());
		}
		for(Check ck : chkBC.listar(routing.getRouId())){
			chkBC.delete(ck.getChkId());
		}
		List<Notification> notificar = new ArrayList<Notification>();
		Notification notif;
		
		
		List<Buttonruteo> botones = new ArrayList<Buttonruteo>();
		Buttonruteo boton;
		
		List<Check> chks = new ArrayList<Check>();
		Check ck;
		
		for (Dybutton ddbb : buttons.getTarget()) {
			
				boton = new Buttonruteo();
				boton.setDybutton(ddbb);
				boton.setButtonruteoDel(0);
				boton.setRouting(routing);
				botones.add(boton);
			
			
		}
		
		for ( User uuss : user.getTarget() ){
			 notif = new Notification();
			 notif.setUser(uuss);
			 notif.setNotDel(0);
			 notif.setNotDesc("");
			 notif.setRouting(routing);
			 notificar.add(notif);
		}
		
		for ( Dycheckoption cckk : checks.getTarget() ){
			ck = new Check();
			ck.setDycheckoption(cckk);
			ck.setChkDel(0);
			ck.setRouting(routing);
			chks.add(ck);
		}
		rDAO.actualizar(routing, notificar, botones, chks);
		 
	}
	
	public void eliminar(Long id){
		rDAO.eliminar(id, notiBC.listar(id), butrutBC.listar(id), chkBC.listar(id));
	}
	
	public List<Routing> listar(){
		return rDAO.listar();
	}
}
