/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package xxfinalcactbank.oracle.apps.fnd.cactbank.webui;

import java.io.Serializable;
import oracle.apps.fnd.framework.webui.OADialogPage;
import oracle.apps.fnd.framework.webui.TransactionUnitHelper;
import oracle.apps.fnd.common.MessageToken;
import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.TransactionUnitHelper;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.form.OAFormValueBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageChoiceBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageRadioButtonBean;

import oracle.apps.fnd.framework.webui.beans.message.OAMessageStyledTextBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

//import oracle.jbo.domain.Date;
//import java.sql.Date;


import oracle.jbo.domain.Date;

import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxCactBankCreateVOImpl;

/**
 * Controller for ...
 */
public class xxCactBankCustDetCO extends OAControllerImpl
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

      OAApplicationModule am = pageContext.getApplicationModule(webBean);
      ViewObject vo = am.findViewObject("xxCactBankCreateVO");
      if(vo!=null )
      {
      vo.executeQuery();
      Row row = vo.createRow();
      vo.insertRow(row);
      vo.setCurrentRow(row);
      row.setAttribute("managed", Boolean.valueOf(false));
      row.setAttribute("UserId",am.getSequenceValue("xxcact_customer_uid_s"));
      //row.setAttribute("Password",am.getSequenceValue("xxcact_customer_uid_s"));
      row.setAttribute("peraddrn", Boolean.valueOf(false)); 
      row.setAttribute("peraddrn1", Boolean.valueOf(false));
      }

    
     ///// Radio Button for Gender
      OAMessageRadioButtonBean maleButton =  (OAMessageRadioButtonBean)webBean.findChildRecursive("Male"); //First Radio Button  
      maleButton.setName("GENDER");  
      maleButton.setValue("MALE");  
                    
      OAMessageRadioButtonBean femaleButton =  (OAMessageRadioButtonBean)webBean.findChildRecursive("Female"); //Second Radio Button  
      femaleButton.setName("GENDER");  
      femaleButton.setValue("FEMALE");  
      
      /////////// Radio Button for Marital Status
       OAMessageRadioButtonBean YesButton =  (OAMessageRadioButtonBean)webBean.findChildRecursive("Married"); //First Radio Button  
       YesButton.setName("MARITAL");  
       YesButton.setValue("MARRIED");  
                     
       OAMessageRadioButtonBean NoButton =  (OAMessageRadioButtonBean)webBean.findChildRecursive("Single"); //Second Radio Button  
       NoButton.setName("MARITAL");  
       NoButton.setValue("SINGLE"); 
      
      ///Radio Button for Pan
       OAMessageRadioButtonBean PYesButton =  (OAMessageRadioButtonBean)webBean.findChildRecursive("Yes"); //Second Radio Button  
       PYesButton.setName("PAN");  
       PYesButton.setValue("YES"); 
       
      OAMessageRadioButtonBean PNoButton =  (OAMessageRadioButtonBean)webBean.findChildRecursive("No"); //Second Radio Button  
      PNoButton.setName("PAN");  
      PNoButton.setValue("NO"); 
      
      // Radio Button for Address Copy
      
       OAMessageRadioButtonBean CYesButton =  (OAMessageRadioButtonBean)webBean.findChildRecursive("Copy"); //Second Radio Button  
       CYesButton.setName("PAN");  
       CYesButton.setValue("YES"); 
       
       OAMessageRadioButtonBean CNoButton =  (OAMessageRadioButtonBean)webBean.findChildRecursive("NoCopy"); //Second Radio Button
       CNoButton.setName("PAN");
       CNoButton.setValue("NO");
       
     /* OAMessageChoiceBean annual= (OAMessageChoiceBean)webBean.findChildRecursive("AnnualIncome");
            annual.setSelectedIndex(7);
            OAMessageChoiceBean occ= (OAMessageChoiceBean)webBean.findChildRecursive("Occupation");
            occ.setSelectedIndex(6);*/
                          
            
            //////////////////david code from 
            
            // xxCactBankCreateVOImpl vo=(xxCactBankCreateVOImpl)am.findViewObject("xxCactBankCreateVO");
            //vo.executeQuery();
             //am.invokeMethod("createAcc");
               //city
                OAMessageChoiceBean city = (OAMessageChoiceBean) webBean.findChildRecursive("PrefCity");
                city.setPickListCacheEnabled(false);
               //branch
               OAMessageChoiceBean branch = (OAMessageChoiceBean) webBean.findChildRecursive("Branch");
                branch.setPickListCacheEnabled(false); 
                
                //////////back button
                
//                 if (!pageContext.isBackNavigationFired(false))
//                 {
//                 TransactionUnitHelper.startTransactionUnit(pageContext, "empCreateTxn");
//                 }
//                 
//      if (!TransactionUnitHelper.isTransactionUnitInProgress(pageContext,
//      "empCreateTxn", true))
//      {
//      OADialogPage dialogPage = new OADialogPage(NAVIGATION_ERROR);
//      pageContext.redirectToDialogPage(dialogPage);
//      }
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
      
      /****Date Validation******/    
      if(pageContext.getParameter(EVENT_PARAM).equalsIgnoreCase("date"))
      {
      Date ddate = (Date)am.findViewObject("xxCactBankCreateVO").first().getAttribute("Dob");
      Date adate = (Date)am.findViewObject("xxCactBankCreateVO").first().getAttribute("ApplDate");
      System.out.println("****DOB*******"+ddate);
      System.out.println("*****APPL DATE******"+adate);
      
      long applDate = adate.dateValue().getTime();
      System.out.println("long applDate--->"+applDate);
      long dobDate = ddate.dateValue().getTime();
      System.out.println("long dobDate--->"+dobDate);
      if ( dobDate >= applDate  ) {
      
      throw new OAException("Invalid DOB ", OAException.ERROR);
      
      }
      }
                          /*********Apply button***********/
      if (pageContext.getParameter("Apply") != null) 
      {
               /**************E-mail notification**********************/
          OAMessageTextInputBean mstb1=(OAMessageTextInputBean)webBean.findIndexedChildRecursive("EmailId");
                  OAMessageStyledTextBean mstb2=(OAMessageStyledTextBean)webBean.findIndexedChildRecursive("UserId");
          String s="";    
               Serializable[] par = { s}; 
               String retVals1 = (String)am.invokeMethod("dataSumAction",par);
               System.out.println("------->"+retVals1);
               OAFormValueBean mstb3 = (OAFormValueBean)webBean.findIndexedChildRecursive("Password");
               System.out.println("---->"+mstb3);
                mstb3.setValue(pageContext,retVals1);
                  OAMessageTextInputBean mstb4=(OAMessageTextInputBean)webBean.findIndexedChildRecursive("FirstName");
                            String s1=(String)mstb1.getValue(pageContext);
                            String s2=(String)mstb2.getValue(pageContext);
                            String s3=(String)mstb3.getValue(pageContext);
                            String s4=(String)mstb4.getValue(pageContext);         
                    Serializable[] param = {s1,s2, s3,s4};
                    //OAApplicationModule am = pageContext.getApplicationModule(webBean);
                     am.invokeMethod("EmailProc", param);

                             
                             
                                                  /*********messagechoice validation*********/
                           if (pageContext.getParameter("AnnualIncome")==null || pageContext.getParameter("Occupation")==null )
                           {                   
                           throw new OAException("Invalid AnnualIncome or OccupationType", OAException.ERROR);
                           }
                           
                         if (pageContext.getParameter("AccType")==null || pageContext.getParameter("PrefCity")==null || pageContext.getParameter("Branch")==null)
                         {                   
                           throw new OAException("Invalid Type of Account or Preferred City or Branch", OAException.ERROR);
                          }
                          
                          if (pageContext.getParameter("DocType")==null || pageContext.getParameter("FileUpload")==null )
                          {                   
                          throw new OAException("Invalid Document Name or File Upload", OAException.ERROR);
                          }
                                                         /****Date Validation******/
                                                          Date ddate = (Date)am.findViewObject("xxCactBankCreateVO").first().getAttribute("Dob");
                                                          Date adate = (Date)am.findViewObject("xxCactBankCreateVO").first().getAttribute("ApplDate");
                                                          System.out.println("****DOB*******"+ddate);
                                                          System.out.println("*****APPL DATE******"+adate);
                                                          System.out.println("**************************************************");
                                                          java.sql.Date sdate = (java.sql.Date) ddate.dateValue();
                                                          java.sql.Date cdate = (java.sql.Date) adate.dateValue();
                                                          System.out.println("****DOB*******"+sdate);
                                                          System.out.println("*****APPL DATE******"+cdate); 
                                                          //Serializable[] dateparam={sdate,cdate};
                                                           //(
                                                          //int days =Integer.parseInt(am.invokeMethod("daysBetween",dateparam)+"");
                                                          System.out.println("Appl-------->"+cdate.getTime());     
                                                          System.out.println("Dob--------->"+sdate.getTime());
                                                
                                                          int days =(int)( (cdate.getTime()-sdate.getTime() ) / (1000 * 60 * 60 * 24));
                                                          System.out.println("int days***********"+days);
                                                          int yy=(int)(days/365);
                                                          System.out.println("year ------------>"+yy);
                                                          if(yy<18)
                                                          {
                                                              throw new OAException("You are under 18 years", OAException.ERROR);
                                                          }


 
 String userid = null;
 
 am.invokeMethod("apply", null);
              // am.getOADBTransaction().commit(); 
          //throw new OAException("record saved", OAException.CONFIRMATION);
          
          
           String  fname = (String )vo.getCurrentRow().getAttribute("FirstName");
                    String  lname = (String )vo.getCurrentRow().getAttribute("LastName");
                    String  fullname = fname+lname; 
                    System.out.println("*******"+fullname);
                   // String orderNum = String.valueOf(userid.intValue());
                    
                    MessageToken[] tokens = { new MessageToken("ORD_NUMBER", fullname)};
                    OAException confirmMessage = new OAException("DEM288",
                    "ORDLINES_ORD_CREATE_CONFIRM",tokens,OAException.CONFIRMATION, null);
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
          if (pageContext.getParameter("Cancel") != null) {
          
                      am.invokeMethod("rollbackOrder");          
                      TransactionUnitHelper.endTransactionUnit(pageContext, "ordCreateTxn");
                      
                      pageContext.forwardImmediately("OA.jsp?page=/xxfinalcactbank/oracle/apps/fnd/cactbank/webui/xxCactBankLoginPG",
                      null,
                      OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
                      null,
                      null,
                      true, // retain AM
                      OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
          
//                      pageContext.setForwardURL("OA.jsp?page=/xxcactbank/oracle/apps/fnd/cactbank/webui/xxCactBankLoginPG",
//                      null,
//                      OAWebBeanConstants.KEEP_MENU_CONTEXT,
//                      null,
//                      null, 
//                      true,
//                      OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
//                      OAWebBeanConstants.IGNORE_MESSAGES);
                      
                           
                  }                   
    
                          /***********Address Copy YES**********/
      if("copy".equals(pageContext.getParameter(EVENT_PARAM))) {
               System.out.println("Hai"); 
            String ResAddress1 = pageContext.getParameter("ResAddress1");
              System.out.println("------------->"+ResAddress1);
            String ResAddress21 = pageContext.getParameter("ResAddress21");
            String ResCity1 = pageContext.getParameter("ResCity1");
              String ResDistrict1 = pageContext.getParameter("ResDistrict1");
             String ResState1 = pageContext.getParameter("ResState1");
              String ResCountry1 = pageContext.getParameter("ResCountry1");
               String ResPincode1 = pageContext.getParameter("ResPincode1");                
                  Row row =null;
                  if(vo!= null){row =vo.getCurrentRow();}
                  if(row!= null){row.setAttribute("peraddrn", Boolean.valueOf(true)); 
                                  row.setAttribute("peraddrn1", Boolean.valueOf(false)); } 
                      OAMessageStyledTextBean mtib1 = (OAMessageStyledTextBean)webBean.findChildRecursive("PerAddress11");
                      mtib1.setValue(pageContext, ResAddress1);
                      OAMessageStyledTextBean mtib2 = (OAMessageStyledTextBean)webBean.findChildRecursive("PerAddress21");
                      mtib2.setValue(pageContext, ResAddress21);
                      OAMessageStyledTextBean mtib3 = (OAMessageStyledTextBean)webBean.findChildRecursive("PerCity1");
                      mtib3.setValue(pageContext, ResCity1);
                      OAMessageStyledTextBean mtib4 = (OAMessageStyledTextBean)webBean.findChildRecursive("PerDistrict1");
                      mtib4.setValue(pageContext, ResDistrict1);
                      OAMessageStyledTextBean mtib5 = (OAMessageStyledTextBean)webBean.findChildRecursive("PerState1");
                      mtib5.setValue(pageContext, ResState1 );
                      OAMessageStyledTextBean mtib6 = (OAMessageStyledTextBean)webBean.findChildRecursive("PerCountry1");
                      mtib6.setValue(pageContext, ResCountry1);
                      OAMessageStyledTextBean mtib7 = (OAMessageStyledTextBean)webBean.findChildRecursive("PerPincode1");
                      mtib7.setValue(pageContext, ResPincode1);
                      }
          
                            /********* Address Copy NO***********/
       if("NoCopy".equals(pageContext.getParameter(EVENT_PARAM))) { 
          System.out.println("No Copy");
          Row row =null;
          if(vo!= null){row =vo.getCurrentRow();}
          if(row!= null){row.setAttribute("peraddrn1", Boolean.valueOf(true)); 
                         row.setAttribute("peraddrn", Boolean.valueOf(false));}
                              OAMessageTextInputBean mtib1 = (OAMessageTextInputBean)webBean.findChildRecursive("PerAddress111");
                              mtib1.setValue(pageContext,null);
                              OAMessageTextInputBean mtib2 = (OAMessageTextInputBean)webBean.findChildRecursive("PerAddress211");
                              mtib2.setValue(pageContext, null);
                              OAMessageTextInputBean mtib3 = (OAMessageTextInputBean)webBean.findChildRecursive("PerCity11");
                              mtib3.setValue(pageContext, null);
                              OAMessageTextInputBean mtib4 = (OAMessageTextInputBean)webBean.findChildRecursive("PerDistrict11");
                              mtib4.setValue(pageContext, null);
                              OAMessageTextInputBean mtib5 = (OAMessageTextInputBean)webBean.findChildRecursive("PerState11");
                              mtib5.setValue(pageContext, null );
                              OAMessageTextInputBean mtib6 = (OAMessageTextInputBean)webBean.findChildRecursive("PerCountry11");
                              mtib6.setValue(pageContext, null);
                              OAMessageTextInputBean mtib7 = (OAMessageTextInputBean)webBean.findChildRecursive("PerPincode11");
                              mtib7.setValue(pageContext, null);                          
                          
                          }
          
          
          /******** Partial Page Radio Button for Pan YES*******/
     if(pageContext.getParameter(EVENT_PARAM).equalsIgnoreCase("pan")) 
     {
     System.out.println("HaiPan");
     Row row =null;
     if(vo!= null) {row =vo.getCurrentRow();}
     if(row!= null) { row.setAttribute("managed", Boolean.valueOf(true));}
     }
    
         /******** Partial Page Radio Button for Pan NO********/  
      if(pageContext.getParameter(EVENT_PARAM).equalsIgnoreCase("pan1")) 
      {
      System.out.println("HaiPan");
      Row row =null;
      if(vo!= null){row =vo.getCurrentRow();}
      if(row!= null){row.setAttribute("managed", Boolean.valueOf(false));}
      }
    
      
         /******prefered city*********/
   
          //String message = "";
         //OAWebBean regionbean = webBean.findChildRecursive("MainRN");            
         //OAApplicationModule am = (OAApplicationModule) pageContext.getApplicationModule(regionbean);
          if ("update".equals(pageContext.getParameter(OAWebBeanConstants.EVENT_PARAM))) 
         {
         String value_selected = pageContext.getParameter("PrefCity");            
         System.out.println("value_selected"+value_selected);            
         if (!(("".equals(value_selected)) || (value_selected == null))) 
        {                               
          Serializable[] params = {value_selected};                
          am.invokeMethod("initEnameVOQuery", params);         
          }        
         }  
    
  
  }

   
}


