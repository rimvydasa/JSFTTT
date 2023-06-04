package com.book;

import org.apache.maven.surefire.shade.org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;


@Named
@RequestScoped
public class AlphaValidator {

    public void validateAlpha(FacesContext facesContext,
            UIComponent uiComponent,
            Object value) throws ValidatorException {
        if (!StringUtils.isAlphaSpace((String) value)) {
            HtmlInputText htmlInputText = (HtmlInputText) uiComponent;
            FacesMessage facesMessage = new FacesMessage(htmlInputText.
                    getLabel()
                    + ": only alphabetic characters are allowed.");
            throw new ValidatorException(facesMessage);
        }
    }

    public void validAbc(FacesContext context, UIComponent uiComponent, Object value) {
        HtmlInputText inputText = (HtmlInputText) uiComponent;
        String actualValue = (String) value;
        if (!StringUtils.isAlphaSpace((String) actualValue)) {
            FacesMessage facesMessage = new FacesMessage(inputText.getLabel() + " Testas");
            throw new ValidatorException(facesMessage);
        }
    }

}
