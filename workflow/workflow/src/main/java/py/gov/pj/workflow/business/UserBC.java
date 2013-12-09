package py.gov.pj.workflow.business;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;
import py.gov.pj.workflow.domain.User;
import py.gov.pj.workflow.persistence.UserDAO;

@BusinessController
public class UserBC extends DelegateCrud<User, Long, UserDAO> {
	
	private static final long serialVersionUID = 1L;
	
@Inject UserDAO dt;
	
	public void eliminar(long Id){
		dt.eliminar(Id);
	}
	
	public List<User> listar() {
		return dt.listar();
	}
}
