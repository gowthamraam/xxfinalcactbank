/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package xxfinalcactbank.oracle.apps.fnd.cactbank.webui;

import com.sun.java.util.collections.HashMap;

import java.io.Serializable;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import oracle.apps.fnd.common.MessageToken;
import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.common.server.UserIdLOVAMImpl;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;
import oracle.apps.fnd.functionSecurity.UserIdCache;

import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxcactbanktxntestBalanceVOImpl;


/**
 * Controller for ...
 */
public class xxCactBankLoginCO extends OAControllerImpl
{
  public static final String RCS_ID="$Header$";
  public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processRequest(pageContext, webBean);
    
      OAMessageTextInputBean mtib1 = (OAMessageTextInputBean)webBean.findChildRecursive("UserId");
      mtib1.setValue(pageContext, null);
      OAMessageTextInputBean mtib2 = (OAMessageTextInputBean)webBean.findChildRecursive("Password");
      mtib2.setValue(pageContext, null);
  }

  /**
   * Procedure to handle form submissions for form elements in
   * a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processFormRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processFormRequest(pageContext, webBean);

            String outParamValue = null;  
    OAApplicationModule am = pageContext.getApplicationModule(webBean);
    Boolean i=true;
    Boolean j=true;
      if (pageContext.getParameter(EVENT_PARAM).equals("submit"))
      {

      if(i)
      {
             OAApplicationModule Am = (OAApplicationModule)pageContext.getApplicationModule(webBean);
              OAViewObject LogVO = (OAViewObject)Am.findViewObject("xxCactBankCreateVO");
       
              LogVO.setWhereClause(null);
              LogVO.setWhereClauseParams(null);
              LogVO.setWhereClause("USER_ID = :1 and PASSWORD=:2");
              LogVO.setWhereClauseParam(0,pageContext.getParameter("UserId"));  
              LogVO.setWhereClauseParam(1,pageContext.getParameter("Password"));
              LogVO.executeQuery();
              LogVO.first();

              System.out.println(LogVO.getRowCount());

              if(LogVO.getCurrentRow() != null){
              pageContext.setRedirectURL("OA.jsp?page=/xxfinalcactbank/oracle/apps/fnd/cactbank/webui/xxcactBankAdminPG");
              
             }
              else{
              throw new OAException("Invalid username & password",OAException.ERROR);
              }       

      }

      

      if(j)
         {
          String userid_v = pageContext.getParameter("UserId");
          String password_v = pageContext.getParameter("Password");
      
      
          
          Serializable[] param = { userid_v, password_v};
          am.invokeMethod("InsertProc286", param);        
          HashMap hm=new HashMap();
                 hm.put("userid", userid_v);
               

                 OADBTransaction txn =      (OADBTransaction)((OAApplicationModuleImpl)am).getDBTransaction();
                 CallableStatement callableStatement =  txn.createCallableStatement("declare\n" + 
                 "        atere number;\n" + 
                 "        begin\n" + 
                 "        select acc_no into :1 from xxcact_bank where user_id=:2;\n" + 
                 "        end;",OADBTransaction.DEFAULT);  
                 System.out.println("Callable stmt"+callableStatement);
                 
                 System.out.println("Value from the AccNo"+userid_v);
               try{
                   callableStatement.setString(1, userid_v);  
                     
                   callableStatement.setString(2, userid_v);  
                   callableStatement.registerOutParameter(1, Types.VARCHAR);  
               
               
                   
               
                 callableStatement.execute();  
               
                 outParamValue = (callableStatement.getString(1)).toString();  
                    System.out.println("outParamValueooooooooooooooooooooooooooooooooo"+outParamValue);
               }
               catch(SQLException c)
               { 
                 System.out.println("Sql Exception Occured"+c);
               }
               System.out.println("outParamValueooooooooooooooooooooooooooooooooo"+outParamValue);
               HashMap hm1=new HashMap();
               hm1.put("userid", outParamValue);
               
               
                 OAViewObject vo1=(OAViewObject)am.findViewObject("xxcactTxnTestVO");
               Serializable[] params = {outParamValue};                
                 am.invokeMethod("tableInst", params);
                 
          OAViewObject vo6=(OAViewObject)am.findViewObject("xxcactbanktxntestBalanceVO");
               Serializable[] params123 = {outParamValue};
               am.invokeMethod("tableInstBal", params123);
                
          
          
          pageContext.setForwardURL("OA.jsp?page=/xxfinalcactbank/oracle/apps/fnd/cactbank/webui/xxCactBankDetailsPG",
          null,
          //OAWebBeanConstants.KEEP_MENU_CONTEXT,
          OAWebBeanConstants. KEEP_NO_DISPLAY_MENU_CONTEXT,
          null,
          null, 
          true,
          OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
          OAWebBeanConstants.IGNORE_MESSAGES);
          }
      } 
    
    
//    if (pageContext.getParameter(EVENT_PARAM).equals("submit"))
//    {
//    
//        String userid_v = pageContext.getParameter("UserId");
//        String password_v = pageContext.getParameter("Password");
//   
//   
//        
//        Serializable[] param = { userid_v, password_v};
//        am.invokeMethod("InsertProc286", param);        
//        HashMap hm=new HashMap();
//               hm.put("userid", userid_v);
//             
//
//               OADBTransaction txn =      (OADBTransaction)((OAApplicationModuleImpl)am).getDBTransaction();
//               CallableStatement callableStatement =  txn.createCallableStatement("declare\n" + 
//               "        atere number;\n" + 
//               "        begin\n" + 
//               "        select acc_no into :1 from xxcact_bank where user_id=:2;\n" + 
//               "        end;",OADBTransaction.DEFAULT);  
//               System.out.println("Callable stmt"+callableStatement);
//               
//               System.out.println("Value from the AccNo"+userid_v);
//             try{
//                 callableStatement.setString(1, userid_v);  
//                   
//                 callableStatement.setString(2, userid_v);  
//                 callableStatement.registerOutParameter(1, Types.VARCHAR);  
//             
//             
//                 
//             
//               callableStatement.execute();  
//             
//               outParamValue = (callableStatement.getString(1)).toString();  
//                  System.out.println("outParamValueooooooooooooooooooooooooooooooooo"+outParamValue);
//             }
//             catch(SQLException c)
//             { 
//               System.out.println("Sql Exception Occured"+c);
//             }
//             System.out.println("outParamValueooooooooooooooooooooooooooooooooo"+outParamValue);
//             HashMap hm1=new HashMap();
//             hm1.put("userid", outParamValue);
//             
//             
//               OAViewObject vo1=(OAViewObject)am.findViewObject("xxcactTxnTestVO");
//             Serializable[] params = {outParamValue};                
//               am.invokeMethod("tableInst", params);
//               
//        OAViewObject vo6=(OAViewObject)am.findViewObject("xxcactbanktxntestBalanceVO");
//             Serializable[] params123 = {outParamValue};
//             am.invokeMethod("tableInstBal", params123);
//              
//        
//        
//        pageContext.setForwardURL("OA.jsp?page=/xxcactbank/oracle/apps/fnd/cactbank/webui/xxCactBankDetailsPG",
//        null,
//        //OAWebBeanConstants.KEEP_MENU_CONTEXT,
//        OAWebBeanConstants. KEEP_NO_DISPLAY_MENU_CONTEXT,
//        null,
//        null, 
//        true,
//        OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
//        OAWebBeanConstants.IGNORE_MESSAGES);
//    
//    }
      
      if (pageContext.getParameter(EVENT_PARAM).equals("createaccount"))
      {

        pageContext.setForwardURL("OA.jsp?page=/xxfinalcactbank/oracle/apps/fnd/cactbank/webui/xxCactBankCustDetPG",
        null,
        //OAWebBeanConstants.KEEP_MENU_CONTEXT,
         OAWebBeanConstants. KEEP_NO_DISPLAY_MENU_CONTEXT,
        null,
        null, 
        true,
        OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
        OAWebBeanConstants.IGNORE_MESSAGES);
      }
   /* {
      String username = (String) pageContext.getParameter("UserId");
      String Password = (String) pageContext.getParameter("Password");
      
      System.out.println("---->username"+username);
      System.out.println("---->password"+Password);
//      Serializable[] params = {username,Password};                
//      am.invokeMethod("initVOQuery", params);
//      pageContext.setForwardURL("OA.jsp?page=/xxcactbank/oracle/apps/fnd/cactbank/webui/xxCactBankCustDetPG",
//      null,
//      OAWebBeanConstants.KEEP_MENU_CONTEXT,
//      null,
//      null, 
//      true,
//      OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
//      OAWebBeanConstants.IGNORE_MESSAGES);
      System.out.println("success login");
    OAViewObject vo = (OAViewObject)am.findViewObject("xxCactBankLoginVO");
      //xxCactBankLoginVOImpl vo = (xxCactBankLoginVOImpl)getxxCactBankLoginVO();
        
          
          if (vo == null)
          {
          MessageToken[] errTokens = {new MessageToken("OBJECT_NAME", "CityVO1")};
          throw new OAException("AK", "FWK_TBX_OBJECT_NOT_FOUND", errTokens);
           }
          vo.setWhereClause(null);
          vo.setWhereClauseParams(null);
           if ((username.equals("$T"))||(Password.equals("$T"))) {
          vo.setWhereClause("1 = 2");
         
           }
           if (vo!=null)
           {
      vo.setWhereClause("USER_ID= :1 AND PASSWORD= :2 ");
      vo.setWhereClauseParams(null); // Always reset
      vo.setWhereClauseParam(0, username);
      vo.setWhereClauseParam(1, Password);
      System.out.println("*****************");
      System.out.println(username);
      System.out.println(Password);
       
      System.out.println("****************");
      
            vo.executeQuery();  
              System.out.println("$$$$$$$$$$$$$$$$$$");
          pageContext.setForwardURL("OA.jsp?page=/xxcactbank/oracle/apps/fnd/cactbank/webui/xxCactBankCustDetPG",
          null,
          OAWebBeanConstants.KEEP_MENU_CONTEXT,
          null,
          null, 
          true,
          OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
          OAWebBeanConstants.IGNORE_MESSAGES);
          }       
}*/
  }
}