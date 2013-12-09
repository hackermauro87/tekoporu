package py.gov.pj.workflow.business;

import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.pj.workflow.domain.Charge;
import py.gov.pj.workflow.domain.City;
import py.gov.pj.workflow.persistence.CityDAO;

@BusinessController
public class CityBC extends DelegateCrud<City, Long, CityDAO> {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private CityDAO cityDAO;
	
	@Inject
	private DepartmentBC depabc;
	private long depId;
	
	public void eliminar(long Id){
		cityDAO.eliminar(Id);
	}
	
	public List<City> listar() {
		return cityDAO.listar();
	}
	
}
