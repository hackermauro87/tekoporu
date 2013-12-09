package py.gov.pj.workflow.business;

import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.pj.workflow.domain.Documenttype;
import py.gov.pj.workflow.persistence.DocumenttypeDAO;

@BusinessController
public class DocumenttypeBC extends DelegateCrud<Documenttype, Long, DocumenttypeDAO> {
	
	private static final long serialVersionUID = 1L;
	@Inject DocumenttypeDAO dt;
	public void eliminar(long Id){
		dt.eliminar(Id);
	}
	
	public List<Documenttype> listar() {
		return dt.listar();
	}
	
}
