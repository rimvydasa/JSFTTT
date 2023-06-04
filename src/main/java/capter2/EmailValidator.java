package capter2;

import org.apache.maven.surefire.shade.org.apache.commons.lang3.StringUtils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator(value = "emailValidator")
public class EmailValidator implements Validator {

  @Override
  public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

    org.apache.commons.validator.EmailValidator emailValidator = org.apache.commons.validator.EmailValidator.getInstance();
    HtmlInputText htmlInputText = (HtmlInputText) uiComponent;
    String mail = (String) o;

    if (!StringUtils.isEmpty(mail)) {
      if(!emailValidator.isValid(mail)) {
        FacesMessage facesMessage = new FacesMessage(htmlInputText.getLabel() + "Email format not valid");
        throw new ValidatorException(facesMessage);
      }
    }
  }

}
