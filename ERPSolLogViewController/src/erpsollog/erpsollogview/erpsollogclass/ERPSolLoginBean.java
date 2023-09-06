package erpsollog.erpsollogview.erpsollogclass;

import erpsolglob.erpsolglobview.erpclass.ERPSolGlobalViewBean;

import java.sql.CallableStatement;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.BindingContainer;

import oracle.binding.BindingContainer;

import oracle.jbo.ApplicationModule;
import oracle.jbo.server.DBTransaction;
import javax.servlet.http.HttpServletRequest;

import org.apache.myfaces.trinidad.context.Agent;
import org.apache.myfaces.trinidad.context.RequestContext;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

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
                
               setERPSolStrUserCode(getERPSolUserCode().getValue().toString());
               System.out.println("2");
               setERPSolStrUserLocationCode(getERPSolUserLocationCode().getValue().toString());
               System.out.println("3");
               setERPSolStrUserRegionCode(getERPSolUserRegionCode().getValue().toString());
               System.out.println("4");
               setERPSolStrUserStoreCode(getERPSolUserStoreCode().getValue().toString());
               System.out.println("5");

               RequestContext requestCtx = RequestContext.getCurrentInstance();
                                  Agent agent = requestCtx.getAgent();
                                  String version = agent.getAgentVersion();
                                  String browser = agent.getAgentName();
                                  String platform = agent.getPlatformName();
                                  String platformVersion = agent.getPlatformVersion();
                                  FacesContext fctx = FacesContext.getCurrentInstance();
                                  HttpServletRequest request = (HttpServletRequest) fctx.getExternalContext().getRequest();
                                  /*   StringBuilder detailMsg =
                                      new StringBuilder("<html><body><b>Browser Agent and the the IP Address Details</b><br>");
                                  detailMsg.append("<ul><li><b>Browser : </b>" + browser + "</li><li><b>Version-</b>" + version +
                                                   "</li><li><b>Plateform : </b>" + platform + "</li>");
                                  detailMsg.append("<li><b>Plateform Version : </b>" + platformVersion + "</li><li><b>Server IP : </b>" +
                                                   request.getLocalAddr() + "</li><li><b>Client IP : </b>" + request.getRemoteAddr() +
                                                   "</li></ul>");
                                  detailMsg.append("</body></html>");
                                  FacesMessage errMsg = new FacesMessage(detailMsg.toString());
                                  errMsg.setSeverity(FacesMessage.SEVERITY_INFO);
                                  fctx.addMessage(null, errMsg); */
                                  
               BindingContainer ERPSolbind = ERPSolGlobalViewBean.doGetERPBindings();
               DCIteratorBinding ERPSolIter =(DCIteratorBinding) ERPSolbind.get("SysUsersLoginROIterator");
               ApplicationModule ERPSolAm=ERPSolIter.getViewObject().getApplicationModule();
               DBTransaction ERPSolDBT=(DBTransaction)ERPSolAm.getTransaction();
               String ERPSolPLSQL="begin insert into sys_login_info(userid,  datetime,IP_ADDRESS,HOST_NAME,Os_Name,WINDOWS_VERSION,BROWSER_NAME) values ";
               ERPSolPLSQL+= "(UPPER('"+getERPSolUserCode().getValue().toString()+"'),sysdate,'"+request.getLocalAddr()+"','"+request.getRemoteAddr()+"','"+platform+"','"+platformVersion+"','"+browser+"'); commit; end; ";
               System.out.println(ERPSolPLSQL);
               CallableStatement ERPSolCS = null;
            try {
                ERPSolCS=ERPSolDBT.createCallableStatement(ERPSolPLSQL, 1);
                ERPSolCS.executeUpdate();
            } catch (SQLException e) {
                
            }
            finally{
                try {
                    ERPSolCS.close();
                } catch (SQLException e) {
                }
            }
            return "ACT-ERPSOLLOGIN";
           }
            else {
                System.out.println("two");
                FacesContext context = FacesContext.getCurrentInstance();
                System.out.println("three");
                context.addMessage(null, new FacesMessage(getERPSolResult().getValue().toString().equals("ERPSOLLOCK")?"Account Is Locked.":"Invalid Login Id / Password"));
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
    
    public String doOpenServiceModule() {
        doErpSolOpenReportTab("http://app.deploy.com.pk:50500/DeployService/faces/Login");
        return null;
    }
    public void doErpSolOpenReportTab(String url) {
    ExtendedRenderKitService erks =
    Service.getRenderKitService(FacesContext.getCurrentInstance(), ExtendedRenderKitService.class);
    StringBuilder strb = new StringBuilder("window.open('" + url + "');");
    erks.addScript(FacesContext.getCurrentInstance(), strb.toString());
    }  
    
}
