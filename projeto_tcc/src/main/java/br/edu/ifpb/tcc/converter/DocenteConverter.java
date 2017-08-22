package br.edu.ifpb.tcc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import br.edu.ifpb.tcc.entity.Docente;

@FacesConverter("DocenteConverter")
public class DocenteConverter  extends SelectItemsBaseConverter{

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && value instanceof Docente)
			return ((Docente) value).getId().toString();
		else
			return null;
	}

}
