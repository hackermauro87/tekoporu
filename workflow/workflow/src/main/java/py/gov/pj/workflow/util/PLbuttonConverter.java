package py.gov.pj.workflow.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import py.gov.pj.workflow.domain.Dybutton;

public class PLbuttonConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Dybutton db= new Dybutton();
		db.setDybId(Long.parseLong(arg2));
		return db;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

	
		return String.valueOf(((Dybutton) arg2).getDybId());
	}

}
