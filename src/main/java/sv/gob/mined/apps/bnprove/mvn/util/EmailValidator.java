package sv.gob.mined.apps.bnprove.mvn.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import sv.gob.mined.apps.bnprove.mvn.util.JsfUtil;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.validate.ClientValidator;

@FacesValidator("custom.emailValidator")
public class EmailValidator implements Validator, ClientValidator {

    private Pattern pattern;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + 
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        if (value == null) {
            return;
        }

        if (!pattern.matcher(value.toString()).matches()) {
            try{
                JsfUtil.addErrorStyle("frmPrincipal", component.getId() , InputText.class, "");
            }catch(Exception ee){
                ee.printStackTrace();
            }catch(Error ee){
                ee.printStackTrace();
            }
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    value + " no es un E-Mail valido"));
        }
    }

    @Override
    public Map<String, Object> getMetadata() {
	 Map<String,Object> data = new HashMap<String,Object>();
	 data.put("prime", 50);
	 return data;
    }
    @Override
    public String getValidatorId() {
        return "custom.emailValidator";
    }
}
