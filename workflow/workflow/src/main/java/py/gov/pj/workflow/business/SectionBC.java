package py.gov.pj.workflow.business;

import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.pj.workflow.domain.Section;
import py.gov.pj.workflow.persistence.SectionDAO;

@BusinessController
public class SectionBC extends DelegateCrud<Section, Long, SectionDAO> {
	
	private static final long serialVersionUID = 1L;
	
	
	@Inject SectionDAO dt;
	public void eliminar(long Id){
		dt.eliminar(Id);
	}
	
	public List<Section> listar() {
		return dt.listar();
	}
}
