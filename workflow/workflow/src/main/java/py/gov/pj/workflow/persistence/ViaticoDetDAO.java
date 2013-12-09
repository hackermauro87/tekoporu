package py.gov.pj.workflow.persistence;

import javax.inject.Inject;

import org.slf4j.Logger;

import org.ticpy.tekoporu.stereotype.PersistenceController;
import org.ticpy.tekoporu.template.JPACrud;

import py.gov.pj.workflow.domain.ViaticoDet;

@PersistenceController
public class ViaticoDetDAO extends JPACrud<ViaticoDet, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@SuppressWarnings("unused")
	private Logger logger;

}
