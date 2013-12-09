package py.gov.pj.workflow.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import py.gov.pj.workflow.domain.Dycheckoption;


public class PLchecksConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {

		Dycheckoption db= new Dycheckoption();
		db.setDychkId(Long.parseLong(arg2));
		return db;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return String.valueOf(((Dycheckoption) arg2).getDychkId());
	
	}

}
