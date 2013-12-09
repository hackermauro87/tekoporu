package py.gov.pj.workflow.view;

import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import py.gov.pj.workflow.domain.Dybutton;
 
@FacesConverter("buttonsConverter")
public class ButtonsConverter implements Converter {
 
    private static final Logger LOG = LoggerFactory.getLogger(ButtonsConverter.class);
 
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        LOG.trace("String value: {}", value);
 
        return getObjectFromUIPickListComponent(component,value);
    }
 
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        String string;
        LOG.trace("Object value: {}", object);
        if(object == null){
            string="";
        }else{
            try{
                string = String.valueOf(((Dybutton)object).getDybId());
            }catch(ClassCastException cce){
                throw new ConverterException();
            }
        }
        return string;
    }
 
    @SuppressWarnings("unchecked")
    private Dybutton getObjectFromUIPickListComponent(UIComponent component, String value) {
        final DualListModel<Dybutton> dualList;
        try{
            dualList = (DualListModel<Dybutton>) ((PickList)component).getValue();
            Dybutton dyb = getObjectFromList(dualList.getSource(),Integer.valueOf(value));
            if(dyb==null){
                dyb = getObjectFromList(dualList.getTarget(),Integer.valueOf(value));
            }
             
            return dyb;
        }catch(ClassCastException cce){
            throw new ConverterException();
        }catch(NumberFormatException nfe){
            throw new ConverterException();
        }
    }
 
    private Dybutton getObjectFromList(final List<?> list, final Integer identifier) {
        for(final Object object:list){
            final Dybutton dyb = (Dybutton) object;
            if(dyb.getDybId().equals(identifier)){
                return dyb;
            }
        }
        return null;
    }
}