/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package xxfinalcactbank.oracle.apps.fnd.cactbank.webui;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.TransactionUnitHelper;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageStyledTextBean;

import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;

import oracle.jbo.Row;

/**
 * Controller for ...
 */
public class xxcactBankAdminCO extends OAControllerImpl
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

      OAApplicationModule am=pageContext.getApplicationModule(webBean);
      System.out.println("Insert method invoked");
      am.invokeMethod("createEntryTestAdmin", null);
      System.out.println("Insert method invoked");
      am.invokeMethod("createEntryTestAdmin1", null);
      
      /***********Swaping MessageStyledText value************/              
      OAMessageStyledTextBean mstb1=(OAMessageStyledTextBean)webBean.findIndexedChildRecursive("AccNo");
           String s6=(String)mstb1.getValue(pageContext);
      System.out.println("value1");
           OAMessageStyledTextBean mstb2=(OAMessageStyledTextBean)webBean.findChildRecursive("AccNo1");
           mstb2.setValue(pageContext,s6);
     /*************Getting UserId from login page**************/
     String uid= pageContext.getParameter("UserId");
     System.out.println("*************"+uid);
     OAMessageStyledTextBean mstb11=(OAMessageStyledTextBean)webBean.findIndexedChildRecursive("UserId");
     
     
     mstb11.setValue(pageContext,  uid );
         
   
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
      OAApplicationModule am=pageContext.getApplicationModule(webBean);
      if("submitadmin".equals(pageContext.getParameter(EVENT_PARAM)))
      {
           System.out.println("Button Clicked");
           if(Integer.parseInt(pageContext.getParameter("Balance"))<500)
           {
               throw new OAException("Your amount is lessthan 500...", OAException.ERROR);
           }
          OAMessageTextInputBean mstb=(OAMessageTextInputBean)webBean.findIndexedChildRecursive("Balance");
          String like=(mstb.getValue(pageContext)).toString();
          OAViewObject vok=(OAViewObject)am.findViewObject("xxcactbankBankVO");          
          System.out.println("Value of The Balance is "+pageContext.getParameter("Balance"));
          vok.getCurrentRow().setAttribute("Balance", like);
         
          
          
          am.invokeMethod("apply"); 
          OAException confirmMessage = new OAException("CBK","ACCOUNT_STATUS_REQUIRED",null,OAException.CONFIRMATION, null);
          pageContext.putDialogMessage(confirmMessage);
          pageContext.forwardImmediately("OA.jsp?page=/xxfinalcactbank/oracle/apps/fnd/cactbank/webui/xxCactBankLoginPG",
          null,
          OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
          null,
          null,
          true, // retain AM
          OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
          
          
      }
      
      if("cancel".equals(pageContext.getParameter(EVENT_PARAM)))
      {
          am.invokeMethod("rollbackOrder");          
          TransactionUnitHelper.endTransactionUnit(pageContext, "ordCreateTxn");
          
          pageContext.forwardImmediately("OA.jsp?page=/xxfinalcactbank/oracle/apps/fnd/cactbank/webui/xxCactBankLoginPG",
          null,
          OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
          null,
          null,
          true, // retain AM
          OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
      }
  }

}
