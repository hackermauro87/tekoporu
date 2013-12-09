package py.gov.pj.workflow.business;

import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;
import py.gov.pj.workflow.domain.Locality;
import py.gov.pj.workflow.persistence.LocalityDAO;

@BusinessController
public class LocalityBC extends DelegateCrud<Locality, Long, LocalityDAO> {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private LocalityDAO loc;
	
	public void eliminar(long Id){
		loc.eliminar(Id);
	}
	
	public List<Locality> listar() {
		return loc.listar();
	}
}
