package erpsollog.erpsollogview.erpsollogclass;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.model.OperationBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.BindingContainer;

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
   
    String ERPSolStrUserCode="";
    String ERPSolStrUserLocationCode;
    String ERPSolStrUserRegionCode;
    String ERPSolStrUserStoreCode;
    
    
    public String doLoginERPSolApp() {
        System.out.println("one");
            // Add event code here...
            BindingContainer bindings = getBindings();
            System.out.println("one-");
            OperationBinding operationBinding =(OperationBinding) bindings.getOperationBinding("doERPSolutionLogin");
            System.out.println("one-1");
            Object result = operationBinding.execute();
            System.out.println("one-2");
            /*if (!operationBinding.getErrors().isEmpty()) {
                return null;
            }*/
            if (getERPSolResult().getValue().toString().equals("ERPSOLYES")) {
                System.out.println("1");
               setERPSolStrUserCode(getERPSolUserCode().getValue().toString());
               System.out.println("2");
               setERPSolStrUserLocationCode(getERPSolUserLocationCode().getValue().toString());
               System.out.println("3");
               setERPSolStrUserRegionCode(getERPSolUserRegionCode().getValue().toString());
               System.out.println("4");
               setERPSolStrUserStoreCode(getERPSolUserStoreCode().getValue().toString());
               System.out.println("5");
               
                return "ACT-ERPSOLLOGIN";
           }
            else {
                System.out.println("two");
                FacesContext context = FacesContext.getCurrentInstance();
                System.out.println("three");
                context.addMessage(null, new FacesMessage("Invalid Login Id / Password"));
                System.out.println("four");
            }
            System.out.println("five");
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
        return ERPSolStrUserCode.toUpperCase();
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
