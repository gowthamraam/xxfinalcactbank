/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package xxfinalcactbank.oracle.apps.fnd.cactbank.webui;

import java.io.Serializable;

import oracle.apps.fnd.common.MessageToken;
import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OADialogPage;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.TransactionUnitHelper;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.form.OAFormValueBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageChoiceBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageStyledTextBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;

/**
 * Controller for ...
 */
public class xxCactBankDocDetCO extends OAControllerImpl
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

      System.out.println("bank doc page event param----------->"+pageContext.getParameter(EVENT_PARAM)); 
//      if (!TransactionUnitHelper.isTransactionUnitInProgress(pageContext, "empUpdateTxn", true))
//      { 
//         // Please use a custom message for the dialog page!
//         OADialogPage dialogPage = new OADialogPage(STATE_LOSS_ERROR); 
//         pageContext.redirectToDialogPage(dialogPage); 
//      }
 if (!pageContext.isBackNavigationFired(false) &&
       (!"goto".equals(pageContext.getParameter(EVENT_PARAM))))
 {  
      OAApplicationModule am=pageContext.getApplicationModule(webBean);
      am.invokeMethod("createRecord");
      
      
      
      OAMessageChoiceBean dtype= (OAMessageChoiceBean)webBean.findChildRecursive("DocType");
     // OAMessageChoiceBean cyear = (OAMessageChoiceBean)webBean.findChildRecursive("Expiry");
      dtype.setSelectedIndex(5);
      //cyear.setSelectedIndex(19);
       
  }
       
       else
       {
           /******get session****/
           /*****For Email***/
            OAFormValueBean Projectno1 = (OAFormValueBean)webBean.findIndexedChildRecursive("EmailId");
            System.out.println("Projectno1 is"+Projectno1);
            String valuefromsession =(String)pageContext.getSessionValue("MySessionProjectNO");
            System.out.println("projectnumber is: "+valuefromsession);       
            Projectno1.setValue(pageContext,valuefromsession);
           System.out.println("valuefromsession"+valuefromsession);
           /*****For UserId***/
           OAFormValueBean Projectno2 = (OAFormValueBean)webBean.findIndexedChildRecursive("UserId");
           System.out.println("Projectno2 is"+Projectno2);
           String valuefromsession1 =(String)pageContext.getSessionValue("MySessionProjectNO1");
           System.out.println("projectnumber is: "+valuefromsession1);       
           Projectno2.setValue(pageContext,valuefromsession1);
           System.out.println("valuefromsession1"+valuefromsession1);
           /*****Fo FirstName***/
            OAFormValueBean Projectno3 = (OAFormValueBean)webBean.findIndexedChildRecursive("FirstName");            
            System.out.println("Projectno3 is"+Projectno3);
            String valuefromsession2 =(String)pageContext.getSessionValue("MySessionProjectNO2");
            System.out.println("projectnumber is: "+valuefromsession2);       
            Projectno3.setValue(pageContext,valuefromsession2);
            System.out.println("valuefromsession"+valuefromsession2);
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
    OAApplicationModule am = pageContext.getApplicationModule(webBean);
    OAViewObject vo= (OAViewObject)am.findViewObject("xxCactBankCreateVO");
    
//      /*********messagechoice validation*********/
//      if (pageContext.getParameter("DocType")==null || pageContext.getParameter("FileUpload")==null )
//      {
//      throw new OAException("Invalid Document Name or File Upload", OAException.ERROR);
//      }
//      if(pageContext.getParameter("Submit") != null) {
//          OAMessageStyledTextBean mstb2=(OAMessageStyledTextBean)webBean.findIndexedChildRecursive("UserId");
//          System.out.println("mstb2"+mstb2);
//              String s2=(String)mstb2.getValue(pageContext);
//              System.out.println("s2"+s2);  
//      }
     
      /*********Apply button***********/
      if (pageContext.getParameter("Submit") != null)
      {
//          /*********messagechoice validation*********/
//          if (pageContext.getParameter("DocType")==null || pageContext.getParameter("FileUpload")==null )
//          {
//          throw new OAException("Invalid Document Name or File Upload", OAException.ERROR);
//          }
 

      /**************E-mail notification**********************/
          OAFormValueBean mstb1 = (OAFormValueBean)webBean.findIndexedChildRecursive("EmailId");
          System.out.println("for email---->"+mstb1);
          String s1=(String)mstb1.getValue(pageContext);
          System.out.println("s1---->"+s1);
          
          OAFormValueBean mstb2 = (OAFormValueBean)webBean.findIndexedChildRecursive("UserId");
          System.out.println("for userid---->"+mstb2);
          String s2=(String)mstb2.getValue(pageContext);
          System.out.println("s2---->"+s2);
          
          /**for password***/
      String s="";
      Serializable[] par = {s};
      String retVals1 = (String)am.invokeMethod("dataSumAction",par);
      System.out.println("get pwd------->"+retVals1);
      
      OAFormValueBean mstb3 = (OAFormValueBean)webBean.findIndexedChildRecursive("Password");
      System.out.println("For password---->"+mstb3);
      mstb3.setValue(pageContext,retVals1);
      String s3=(String)mstb3.getValue(pageContext);
      System.out.println("s3---->"+s3);
         
          OAFormValueBean mstb4 = (OAFormValueBean)webBean.findIndexedChildRecursive("FirstName");
          System.out.println("for first name---->"+mstb4);
          String s4=(String)mstb4.getValue(pageContext);
          System.out.println("s4---->"+s4);
          String from = "p.davidrichards@gmail.com" , to =s1, subject = "Cactes bank Confirmation", 
          text = "Dear"+" "+s4+", "+"Thank you for registering in CACTES BANK.You may now login into cactes bank using the following information."+"\n"+"User id: "+s2+" "+"Password: "+s3;  
          System.out.println("text:"+text);
          Serializable[] param = {from,to,subject,text}; 
          am.invokeMethod("sendMail", param);
          am.invokeMethod("send");
          System.out.println("mail sent----------->");
//      am.invokeMethod("EmailProc", param);  
      
      String userid = null;      
      am.invokeMethod("apply", null);
      System.out.println("/*******************************After commit*************************************");
      // am.getOADBTransaction().commit();
      //throw new OAException("record saved", OAException.CONFIRMATION);            
      String  fname = (String )vo.getCurrentRow().getAttribute("FirstName");
      String  lname = (String )vo.getCurrentRow().getAttribute("LastName");
      String  fullname = fname+lname;
      System.out.println("*******"+fullname);
      // String orderNum = String.valueOf(userid.intValue());      
      MessageToken[] tokens = { new MessageToken("ORD_NUMBER", fullname)};
      OAException confirmMessage = new OAException("CBK",
      "CACTES_CREATE_CONFIRM",tokens,OAException.CONFIRMATION, null);
      pageContext.putDialogMessage(confirmMessage);
      
      // pageContext.setForwardURL("OA.jsp?page=/xxcactbank/oracle/apps/fnd/cactbank/webui/xxCactBankLoginPG",
      pageContext.forwardImmediately("OA.jsp?page=/xxfinalcactbank/oracle/apps/fnd/cactbank/webui/xxCactBankLoginPG",
      null,
      //OAWebBeanConstants.KEEP_MENU_CONTEXT,
      OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
      null,
      null,
      true, // retain AM
      OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
      
      }
     
      /*********Cancel button***********/
      if (pageContext.getParameter("Cancel") != null) 
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
