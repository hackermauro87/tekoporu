package py.gov.pj.workflow.business;

import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;
import py.gov.pj.workflow.domain.Charge;
import py.gov.pj.workflow.persistence.ChargeDAO;

@BusinessController
public class ChargeBC extends DelegateCrud<Charge, Long, ChargeDAO> {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private ChargeDAO chargeDAO;
	
	public void eliminar(long Id){
		chargeDAO.eliminar(Id);
	}
	
	public List<Charge> listar() {
		return chargeDAO.listar();
	}
	
}
