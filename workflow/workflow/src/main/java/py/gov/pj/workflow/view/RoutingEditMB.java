package py.gov.pj.workflow.view;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.model.DualListModel;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.ButtonruteoBC;
import py.gov.pj.workflow.business.CheckBC;
import py.gov.pj.workflow.business.NotificationBC;
import py.gov.pj.workflow.business.RoutingBC;
import py.gov.pj.workflow.domain.Buttonruteo;
import py.gov.pj.workflow.domain.Check;
import py.gov.pj.workflow.domain.Dybutton;
import py.gov.pj.workflow.domain.Dycheckoption;
import py.gov.pj.workflow.domain.Notification;
import py.gov.pj.workflow.domain.Routing;
import py.gov.pj.workflow.domain.User;

@ViewController
@PreviousView("/routing_list.xhtml")
public class RoutingEditMB extends AbstractEditPageBean<Routing, Long> {

	private static final long serialVersionUID = 1L;
	
	
	
	private DualListModel<Dybutton> bindb;
	private DualListModel<User> uindb;
	private DualListModel<Dycheckoption> cindb;
	

	@Inject
	private RoutingBC routingBC;
	@Inject
	private ButtonruteoBC brbc;
	@Inject
	private NotificationBC notifBC;
	@Inject
	private CheckBC chkBC;
	
	public RoutingEditMB(){
		
	}



	
	@Override
	@Transactional
	public String delete() {
		this.routingBC.eliminar(getBean().getRouId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.routingBC.insertar(getBean(),uindb,bindb,cindb);
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() { 
		this.routingBC.actualizar(getBean(),uindb,bindb,cindb);
//		this.routingBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		
		setBean(this.routingBC.load(getId()));
	}


	public DualListModel<Dybutton> getBindb() {
		
		List<Dybutton> bSource = new ArrayList<Dybutton>();  
		List<Dybutton> btarget = new ArrayList<Dybutton>();
		
		List<Buttonruteo> lbr = new ArrayList<Buttonruteo>();
		
		if(!isUpdateMode()){
	        for(Dybutton bdb:this.routingBC.allButtons()){
	        	bSource.add(bdb);
	        }
		}else{
			lbr=brbc.listar(getBean().getRouId());
			int b;
			for(Dybutton bdb:this.routingBC.allButtons()){
				b=0;
				for (int i = 0; i < lbr.size(); i++) {
					if(lbr.get(i).getDybutton().equals(bdb)){
						btarget.add(bdb);
						b=1;
					}
				}
				if(b==0){
					bSource.add(bdb);
				}
	        }
			
			
    	}
		bindb = new DualListModel<Dybutton>(bSource,btarget);
		
		return bindb;
	}
	public DualListModel<User> getUindb() {
		List<User> uSource = new ArrayList<User>();  
        List<User> utarget = new ArrayList<User>();
        
        List<Notification> lbr = new ArrayList<Notification>();
        
        if(!isUpdateMode()){
        	for(User udb:this.routingBC.getUsers()){
            	uSource.add(udb);
            }
		}else{
			
			lbr=notifBC.listar(getBean().getRouId());
			int b;
			for(User udb:this.routingBC.getUsers()){
				b=0;
				for (int i = 0; i < lbr.size(); i++) {
					if(lbr.get(i).getUser().equals(udb)){
						utarget.add(udb);b=1;
					}
				}
				if(b==0){uSource.add(udb);}
	        }
			
			
    	}
        
		uindb = new DualListModel<User>(uSource,utarget);
		return uindb;
	}
	public DualListModel<Dycheckoption> getCindb() {
		List<Dycheckoption> cSource = new ArrayList<Dycheckoption>();  
        List<Dycheckoption> ctarget = new ArrayList<Dycheckoption>();
        
        List<Check> lbr = new ArrayList<Check>();
        
        if(!isUpdateMode()){
        	 for(Dycheckoption cdb:this.routingBC.getChecks()){
             	cSource.add(cdb);
             }
		}else{
			
			lbr=chkBC.listar(getBean().getRouId());
			int b;
			for(Dycheckoption cdb:this.routingBC.getChecks()){
				b=0;
				for (int i = 0; i < lbr.size(); i++) {
					if(lbr.get(i).getDycheckoption().equals(cdb)){
						ctarget.add(cdb);
						b=1;
					}
				}
				if(b==0){cSource.add(cdb);}
	        }
		}
        
       
		cindb = new DualListModel<Dycheckoption>(cSource,ctarget);
		return cindb;
	}
	
	
	public void setBindb(DualListModel<Dybutton> bindb) {

		this.bindb = bindb;
	}




	
	public void setUindb(DualListModel<User> uindb) {
	
		this.uindb = uindb;
	}




	
	public void setCindb(DualListModel<Dycheckoption> cindb) {
	
		this.cindb = cindb;
	}
	
}