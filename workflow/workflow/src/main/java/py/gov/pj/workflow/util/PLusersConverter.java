package py.gov.pj.workflow.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import py.gov.pj.workflow.domain.User;


public class PLusersConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		User db= new User();
		db.setUserId(Long.parseLong(arg2));
		return db;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		return String.valueOf(((User) arg2).getUserId());
	}

}
