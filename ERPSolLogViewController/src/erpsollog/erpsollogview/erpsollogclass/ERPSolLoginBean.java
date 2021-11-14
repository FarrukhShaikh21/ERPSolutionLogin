package erpsollog.erpsollogview.erpsollogclass;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;
import oracle.binding.BindingContainer;


public class ERPSolLoginBean {
    public ERPSolLoginBean() {
        super();
    }
   String ERPSolUserCode;
   String ERPSolPassword;
   String ERPSolResult;

    public String doLoginERPSolApp() {
            // Add event code here...
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("doERPSolutionLogin");
            Object result = operationBinding.execute();
            if (!operationBinding.getErrors().isEmpty()) {
                return null;
            }
            if (getERPSolPassword().toString().equals("ERPSOLYES")) {
                return "ACT-ERPLOGINSUCCESS";
           }
            else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Invalid Login Id / Password"));
            }
            return null;
        }

    public BindingContainer getBindings() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }

    public void setERPSolUserCode(String ERPSolUserCode) {
        this.ERPSolUserCode = ERPSolUserCode;
    }

    public String getERPSolUserCode() {
        return ERPSolUserCode;
    }

    public void setERPSolPassword(String ERPSolPassword) {
        this.ERPSolPassword = ERPSolPassword;
    }

    public String getERPSolPassword() {
        return ERPSolPassword;
    }

    public void setERPSolResult(String ERPSolResult) {
        this.ERPSolResult = ERPSolResult;
    }

    public String getERPSolResult() {
        return ERPSolResult;
    }
}
