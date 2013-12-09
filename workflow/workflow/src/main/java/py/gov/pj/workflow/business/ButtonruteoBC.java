package py.gov.pj.workflow.business;

import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.pj.workflow.domain.Buttonruteo;
import py.gov.pj.workflow.persistence.ButtonruteoDAO;

@BusinessController
public class ButtonruteoBC extends DelegateCrud<Buttonruteo, Long, ButtonruteoDAO> {
	
	private static final long serialVersionUID = 1L;
	@Inject ButtonruteoDAO brDAO;
    /*
     * idrou es el id del routing.. de este modo nos devuelve solo los botones que pertenecen al 
     * routing que se esta editando 
     */
	public List<Buttonruteo> listar(long idrou){
		return brDAO.listar(idrou);
	}
}
