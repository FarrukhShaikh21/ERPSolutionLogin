package erpsollog.erpsollogview.erpsollogclass;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;
import oracle.binding.BindingContainer;


public class ERPSolLoginBean {
    public ERPSolLoginBean() {
        super();
    }
   RichInputText ERPSolUserCode;
   RichInputText ERPSolPassword;
   RichInputText ERPSolResult;
   RichInputText ERPSolUserLocationCode;
   RichInputText ERPSolUserRegionCode;
   RichInputText ERPSolUserStoreCode;
   
    String ERPSolStrUserCode;
    String ERPSolStrUserLocationCode;
    String ERPSolStrUserRegionCode;
    String ERPSolStrUserStoreCode;
    
    
    public String doLoginERPSolApp() {
            // Add event code here...
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("doERPSolutionLogin");
            Object result = operationBinding.execute();
            if (!operationBinding.getErrors().isEmpty()) {
                return null;
            }
            if (getERPSolResult().getValue().toString().equals("ERPSOLYES")) {
                
               setERPSolStrUserCode(getERPSolUserCode().getValue().toString());
               setERPSolStrUserLocationCode(getERPSolUserLocationCode().getValue().toString());
               setERPSolStrUserRegionCode(getERPSolUserRegionCode().getValue().toString());
               setERPSolStrUserStoreCode(getERPSolUserStoreCode().getValue().toString());
               
                return "ACT-ERPSOLLOGIN";
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

    public void setERPSolUserCode(RichInputText ERPSolUserCode) {
        this.ERPSolUserCode = ERPSolUserCode;
    }

    public RichInputText getERPSolUserCode() {
        return ERPSolUserCode;
    }

    public void setERPSolPassword(RichInputText ERPSolPassword) {
        this.ERPSolPassword = ERPSolPassword;
    }

    public RichInputText getERPSolPassword() {
        return ERPSolPassword;
    }

    public void setERPSolResult(RichInputText ERPSolResult) {
        this.ERPSolResult = ERPSolResult;
    }

    public RichInputText getERPSolResult() {
        return ERPSolResult;
    }

    public void setERPSolUserLocationCode(RichInputText ERPSolUserLocationCode) {
        this.ERPSolUserLocationCode = ERPSolUserLocationCode;
    }

    public RichInputText getERPSolUserLocationCode() {
        return ERPSolUserLocationCode;
    }

    public void setERPSolUserStoreCode(RichInputText ERPSolUserStoreCode) {
        this.ERPSolUserStoreCode = ERPSolUserStoreCode;
    }

    public RichInputText getERPSolUserStoreCode() {
        return ERPSolUserStoreCode;
    }

    public void setERPSolUserRegionCode(RichInputText ERPSolUserRegionCode) {
        this.ERPSolUserRegionCode = ERPSolUserRegionCode;
    }

    public RichInputText getERPSolUserRegionCode() {
        return ERPSolUserRegionCode;
    }

    public void setERPSolStrUserCode(String ERPSolStrUserCode) {
        this.ERPSolStrUserCode = ERPSolStrUserCode;
    }

    public String getERPSolStrUserCode() {
        return ERPSolStrUserCode;
    }

    public void setERPSolStrUserLocationCode(String ERPSolStrUserLocationCode) {
        this.ERPSolStrUserLocationCode = ERPSolStrUserLocationCode;
    }

    public String getERPSolStrUserLocationCode() {
        return ERPSolStrUserLocationCode;
    }

    public void setERPSolStrUserRegionCode(String ERPSolStrUserRegionCode) {
        this.ERPSolStrUserRegionCode = ERPSolStrUserRegionCode;
    }

    public String getERPSolStrUserRegionCode() {
        return ERPSolStrUserRegionCode;
    }

    public void setERPSolStrUserStoreCode(String ERPSolStrUserStoreCode) {
        this.ERPSolStrUserStoreCode = ERPSolStrUserStoreCode;
    }

    public String getERPSolStrUserStoreCode() {
        return ERPSolStrUserStoreCode;
    }

    public void doSetERPSolLoginSessionGlobals() {
        ADFContext.getCurrent().getPageFlowScope().put("GLOB_USER_CODE", getERPSolStrUserCode());
        ADFContext.getCurrent().getPageFlowScope().put("GLOB_USER_REGION", getERPSolStrUserRegionCode());
        ADFContext.getCurrent().getPageFlowScope().put("GLOB_USER_LOCATION", getERPSolStrUserLocationCode());
        ADFContext.getCurrent().getPageFlowScope().put("GLOB_USER_STORE", getERPSolStrUserStoreCode());

    }
}
