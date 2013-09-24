/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package xxfinalcactbank.oracle.apps.fnd.cactbank.webui;


import java.io.Serializable;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OADialogPage;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageChoiceBean;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.TransactionUnitHelper;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageChoiceBean;

import oracle.jbo.Row;

import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxCactBankCreateVOImpl;

/**
 * Controller for ...
 */
public class xxCactBankAccDetCO extends OAControllerImpl
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

      System.out.println("Bank Account page event param----------->"+pageContext.getParameter(EVENT_PARAM));
      
      if (!pageContext.isBackNavigationFired(false) &&
            (!"goto".equals(pageContext.getParameter(EVENT_PARAM))))
      {         
    OAApplicationModule am = (OAApplicationModule) pageContext.getApplicationModule(webBean); 
    xxCactBankCreateVOImpl vo=(xxCactBankCreateVOImpl)am.findViewObject("xxCactBankCreateVO");
    vo.executeQuery();
    //am.invokeMethod("createAcc");
      //city
       OAMessageChoiceBean city = (OAMessageChoiceBean) webBean.findChildRecursive("PrefCity");
       city.setPickListCacheEnabled(false);
      //branch
       OAMessageChoiceBean branch = (OAMessageChoiceBean) webBean.findChildRecursive("Branch");
       branch.setPickListCacheEnabled(false); 
      }
          else
          {
            // Guard agains the user being able to perform a form submit on this page
            // after the transaction is completed.  If the user navigates back to this
            // page using the browser Back button after successfully committing, the
            // OA Framework will detect this navigation and step through processRequest()
            // first when the user tries to perform any action that causes the
            // form to be submitted.  This will display a state loss error dialog
            // if this happens.
            if (!TransactionUnitHelper.isTransactionUnitInProgress(pageContext, "empUpdatetxn", true))
            {
              // Please use a custom message for the dialog page! The more explicit,
              // the better.
              OADialogPage dialogPage = new OADialogPage(STATE_LOSS_ERROR);
              pageContext.redirectToDialogPage(dialogPage);
            } 
          }
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
           String message = "";
           OAWebBean regionbean = webBean.findChildRecursive("MainRN"); 
           OAApplicationModule am = (OAApplicationModule) pageContext.getApplicationModule(regionbean);  
           
      /*********Dependend messagechoice validation*********/
            if ("update".equals(pageContext.getParameter(OAWebBeanConstants.EVENT_PARAM))) 
           {
           String value_selected = (String) pageContext.getParameter("PrefCity");            
           System.out.println("value_selected"+value_selected);            
           if (!(("".equals(value_selected)) || (value_selected == null))) 
            {                               
            Serializable[] params = {value_selected};                
            am.invokeMethod("initEnameVOQuery", params);         
            }        
           } 
           
      /*********messagechoice validation*********/     
      if (pageContext.getParameter("AccType")==null || pageContext.getParameter("PrefCity")==null || pageContext.getParameter("Branch")==null)
      {
      throw new OAException("Invalid Type of Account or Preferred City or Branch", OAException.ERROR);
      }
  }

}
