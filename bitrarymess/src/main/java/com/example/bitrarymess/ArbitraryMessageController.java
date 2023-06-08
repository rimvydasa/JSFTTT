package com.example.bitrarymess;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ArbitraryMessageController implements Serializable {

    @Inject
    private FacesContext facesContext;

    public void saveData() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data saved successfully",
                "All Data successfully saved.");
        facesContext.addMessage(null,message);
    }
}
