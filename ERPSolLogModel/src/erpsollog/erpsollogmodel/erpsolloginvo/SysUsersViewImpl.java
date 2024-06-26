package erpsollog.erpsollogmodel.erpsolloginvo;

import erpsollog.erpsollogmodel.erpsolloginvo.common.SysUsersView;

import java.sql.CallableStatement;

import java.sql.SQLException;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Nov 14 19:26:37 PKT 2021
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SysUsersViewImpl extends ViewObjectImpl implements SysUsersView {
    /**
     * This is the default constructor (do not remove).
     */
    public SysUsersViewImpl() {
    }
    public String doERPSolutionLogin(String pUserCode, String pUserassword) {
        setWhereClause("Userid =UPPER('"+pUserCode+"') AND Password='"+pUserassword+"'");
        System.out.println(getWhereClause());
        executeQuery();
        if (getRowCount()>0) {
            /* String ERPSolPLSQL="begin insert into sys_login_info(userid,  datetime) values(UPPER('"+pUserCode+"'),sysdate); commit; end; ";
            System.out.println(ERPSolPLSQL);
            CallableStatement cs=getDBTransaction().createCallableStatement(ERPSolPLSQL, 1);
            try {
                cs.executeUpdate();
            } catch (SQLException e) {
            }
            finally{
                try {
                    cs.close();
                } catch (SQLException e) {
                }
            } */
            if (first().getAttribute("ActiveStatus").toString().equals("N")) {
               return "ERPSOLLOCK";
           }
            return "ERPSOLYES";
       }
        return "NO";
    }
}

