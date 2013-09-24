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
import oracle.apps.fnd.framework.webui.beans.OABodyBean;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.layout.OAPageLayoutBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;
import oracle.apps.fnd.framework.webui.beans.nav.OAGlobalButtonBarBean;
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
    static String  c ="0";

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processRequest(pageContext, webBean);
    
    OABodyBean ob=(OABodyBean)pageContext.getRootWebBean();
      
      pageContext.putJavaScriptFunction("click()", 
          "var message=\"Due to security reason, Right Click is not allowed\";"+
            "function right2(){\n"+
                 "if (event.button==2){\n"+
                      "alert(\"Right Click is not allowed.\");\n"+
                      "return false;\n"+
                  "}\n"+
             "}\n"+
       "function rightClickTest (e) \n" +
       "{\n" +
            "if (document.layers||document.getElementById&&!document.all){ \n"+
              "if (e.which==2||e.which==3){\n"+
                  "alert(\"You do not have permission to right click.\");\n" +
                  "return false;\n" +
              "}\n"+
            "}\n"+
        "}\n"+
        "if (document.layers) {" +
            "document.captureEvents(Event.MOUSEDOWN);\n" +
            "document.onmousedown=rightClickTest;\n"+
        "}\n"+
        "else if (document.all&&!document.getElementById){" +
            "document.onmousedown=right2;\n"+
        "}\n"+
        "document.oncontextmenu=new Function(\"alert(message);return false;\")"
       );
      OAPageLayoutBean page = null;
      page=(OAPageLayoutBean)pageContext.getPageLayoutBean(); 
      if(!page.equals(null))
      {
          System.out.println("Comes Inside ADV"+page);
        page.prepareForRendering(pageContext);
          System.out.println("Comes Inside ADV after"+page);
         
      }
      
      if(c.equals("0"))
      {
      System.out.println("Enetered");
      OAGlobalButtonBarBean buttons = (OAGlobalButtonBarBean)page.getGlobalButtons();
      System.out.println("Just a Try"+buttons);
      if(!buttons.equals(null))
      {
      System.out.println("Comes Inside");
      buttons.setRendered(false);
          System.out.println("Comes Inside After");
          c="Some";
      }
      }
      
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
              System.out.println("LogVO.getCurrentRow()----->"+LogVO.getCurrentRow());
              if(LogVO.getCurrentRow() != null){
              System.out.println("before adminPG");
              pageContext.setRedirectURL("OA.jsp?page=/xxfinalcactbank/oracle/apps/fnd/cactbank/webui/xxcactBankAdminPG");
                 System.out.println("after adminPG");
             }
              else{
              throw new OAException("Invalid username & password",OAException.ERROR);
              }       

      }

      

      if(j)
         {
          String userid_v = pageContext.getParameter("UserId");
          String password_v = pageContext.getParameter("Password");
              System.out.println("ooooooooooooooooooooooooooooooooo");
              System.out.println("111111000000001");
          
          Serializable[] param = { userid_v, password_v};
          am.invokeMethod("InsertProc286", param);        
          HashMap hm=new HashMap();
                 hm.put("userid", userid_v);
               
              System.out.println("1111111111111111111");
              
                 OADBTransaction txn =      (OADBTransaction)((OAApplicationModuleImpl)am).getDBTransaction();
                 CallableStatement callableStatement =  txn.createCallableStatement("declare\n" + 
                 "        atere number;\n" + 
                 "        begin\n" + 
                 "        select acc_no into :1 from xxcact_bank where user_id=:2;\n" + 
                 "        end;",OADBTransaction.DEFAULT);  
              System.out.println("22222222222222");
                 System.out.println("Callable stmt"+callableStatement);
              System.out.println("333333333333333");
                 System.out.println("Value from the AccNo"+userid_v);
               try{
                   System.out.println("4444444444444");
                   callableStatement.setString(1, userid_v);  
                     
                   callableStatement.setString(2, userid_v);  
                   callableStatement.registerOutParameter(1, Types.VARCHAR);  
               
               
                   
               
                 callableStatement.execute();  
                   System.out.println("55555555555555555");
                 outParamValue = (callableStatement.getString(1)).toString();  
                    System.out.println("outParamValueooooooooooooooooooooooooooooooooo"+outParamValue);
                   System.out.println("66666666666666666");
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
          
          OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
          null,
          null, 
          true,
          OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
          OAWebBeanConstants.IGNORE_MESSAGES);
          }
      } 
      
      if (pageContext.getParameter(EVENT_PARAM).equals("createaccount"))
      {

        pageContext.setForwardURL("OA.jsp?page=/xxfinalcactbank/oracle/apps/fnd/cactbank/webui/xxCactBankCustDetPG",
        null,
        //OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
         OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
        null,
        null, 
        true,
        OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
        OAWebBeanConstants.IGNORE_MESSAGES);
      }
   
  }
}