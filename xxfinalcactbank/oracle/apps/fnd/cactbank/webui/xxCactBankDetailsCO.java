/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package xxfinalcactbank.oracle.apps.fnd.cactbank.webui;

import com.sun.rowset.internal.Row;

import java.io.Serializable;

import java.sql.CallableStatement;

import java.sql.SQLException;

import java.sql.Types;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAMessageTextInputHelper;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.TransactionUnitHelper;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

import oracle.apps.fnd.framework.webui.beans.message.OAMessageStyledTextBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;
import oracle.apps.fnd.framework.webui.beans.table.OAAdvancedTableBean;

import oracle.apps.fnd.framework.webui.beans.table.OATableBean;

import oracle.jbo.RowSetIterator;

 
import oracle.jbo.domain.Number;
import xxfinalcactbank.oracle.apps.fnd.cactbank.server.XxcactTransactionVOImpl;
import xxfinalcactbank.oracle.apps.fnd.cactbank.server.XxcactTransactionVORowImpl;
import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxCactBankDetVOImpl;
import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxCactBankDetVORowImpl;
import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxCactBankLatestTxnImpl;
import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxcactBankValiVORowImpl;
import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxcactTxnTestVOImpl;
import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxcactTxnTestVO1Impl;
import com.sun.rowset.internal.Row;

import oracle.apps.fnd.framework.server.OAViewRowImpl;

import oracle.jbo.AttributeDef;

import xxfinalcactbank.oracle.apps.fnd.cactbank.poplist.server.xxcactTxnTypeVOImpl;
import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxcactBankValiVOImpl;


import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxcactTxnTestVO1RowImpl;
import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxcactTxnTestVO2Impl;
import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxcactTxnTestVORowImpl;
import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxcactbanktxntestBalanceVOImpl;

/**
 * Controller for ...
 */
public class xxCactBankDetailsCO extends OAControllerImpl
{
  public static final String RCS_ID="$Header$";
  public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
   String j=null;
    Number n=null;
        String  ls=null;
       
        
       
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
  
  System.out.println("Ctrlr Invoked");
  
      
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

    super.processRequest(pageContext, webBean);
    OAApplicationModule am=(OAApplicationModule)pageContext.getApplicationModule(webBean);
      TransactionUnitHelper.startTransactionUnit(pageContext,"BankLoginTxn");
                String userid_v = pageContext.getParameter("UserId");
              Serializable[] parameters = { userid_v };
              am.invokeMethod("initDetails", parameters);
      
      

      //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                
         /*  Strating the VO to execute in order to Query the VO   */
              
          xxcactbanktxntestBalanceVOImpl bbjkhkj=(xxcactbanktxntestBalanceVOImpl)am.findViewObject("xxcactbanktxntestBalanceVO");
          bbjkhkj.executeQuery();
      
      

      //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



                   
      //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      /*  Starting the VO to execute in order to Query the VO .  This is for the page to get Refresh when we reload the page by pressing the SubTab  */
      
        xxcactTxnTestVOImpl txn1=(xxcactTxnTestVOImpl)am.findViewObject("xxcactTxnTestVO");     
          
          txn1.executeQuery();
          
      //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
          
          
      //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      /*  Making the Table region to Query itself by the below coding   */
            
          
          
          OATableBean table1 = (OATableBean)webBean.findChildRecursive("xxcactTxnTestVO");
          System.out.println("table"+table1);
          table1.queryData(pageContext, true);
          
      //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


      //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
       /*  Logic to create a row in VO only once when the page gets loaded  */
               
      if(pageContext.getParameter(EVENT_PARAM).equals("submit")&&pageContext.getParameter(SOURCE_PARAM).equals("Submit") )
      {
            am.invokeMethod("createEntryTestCredit", null);
           am.invokeMethod("createEntryTestDebit", null);
           System.out.println("Insert method invoked");
      }
           
        
          
          OADBTransaction txn1235644=(OADBTransaction)am.getOADBTransaction();
          
          
       
        
          //**************************************************
          /* Setting Account Number  for in Money Transaction */
          OAMessageStyledTextBean j1=(OAMessageStyledTextBean)webBean.findChildRecursive("AccNo2");
          
          OAMessageStyledTextBean j=(OAMessageStyledTextBean)webBean.findChildRecursive("AccNo");
          ls=(String)j.getValue(pageContext);
          
          j1.setValue(pageContext, ls);
          j1.getValue(pageContext); 
          
          //**************************************************
          /* Setting Balance for in Money Transaction */
          OAMessageStyledTextBean jbal=(OAMessageStyledTextBean)webBean.findChildRecursive("Balance");
            String  lsbal=(String)jbal.getValue(pageContext);
            System.out.println("Obtained the Bean Value from Balance"+lsbal);
          OAMessageStyledTextBean jbalup=(OAMessageStyledTextBean)webBean.findChildRecursive("Balance3");
          System.out.println(jbalup+"My val gets Printed");
          jbalup.setValue(pageContext, lsbal);
          //**************************************************
            
    
          

      

  }

  /**
   * Procedure to handle form submissions for form elements in
   * a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) throws OAException
  {
    super.processFormRequest(pageContext, webBean);
    System.out.println("This happens thro");
          OAApplicationModule am=(OAApplicationModule)pageContext.getApplicationModule(webBean);
              System.out.println("Event has Occured--------------------->"+EVENT_PARAM);
              System.out.println("Source Paramer--------------->"+SOURCE_PARAM); 
          
    

     /*************submit button*********/
     if("submit".equals(pageContext.getParameter(EVENT_PARAM)))
     {
   
         boolean gpdf=true;
        System.out.println("TransferAccNo------------>"+pageContext.getParameter("TransferAccNo3"));
         System.out.println("Amount------------>"+pageContext.getParameter("Debit2"));
         if ((pageContext.getParameter("TransferAccNo3").equals(null) || pageContext.getParameter("TransferAccNo3").equals("") ) || 
         (pageContext.getParameter("Debit2").equals(null) || pageContext.getParameter("Debit2").equals("") ) )
         {                   
         throw new OAException("Invalid AccNo or Amount", OAException.ERROR);
         }
     
     else
     {
     
         
         

                System.out.println("Control Came to Account Validate");
                 xxCactBankDetailsCO cactCO=new xxCactBankDetailsCO();
                 OAViewObject ReqVO   =   (OAViewObject)am.findViewObject("xxcactBankValiVO");
                OAViewRowImpl lo=(OAViewRowImpl)ReqVO.first();
                System.out.println(lo);
                 OAMessageTextInputBean a=(OAMessageTextInputBean)webBean.findChildRecursive("TransferAccNo3");
                 String column="AccNo";
                 String k1=cactCO.accountValidation(pageContext,  webBean, ReqVO, a, lo, column);
                 System.out.println(k1);
                 
        
             
            
                 System.out.println("Control Came to Amount Validate");
                 xxCactBankDetailsCO cactCO1=new xxCactBankDetailsCO();
                  OAViewObject ReqVO1   =   (OAViewObject)am.findViewObject("xxcactBankValiVO");
                 OAViewRowImpl lo1=(OAViewRowImpl)ReqVO.first();
                 System.out.println(lo);
                 OAMessageTextInputBean a1=(OAMessageTextInputBean)webBean.findChildRecursive("Debit2");
                 String column1="Debit";
                 String k2=cactCO.amountValidation(pageContext,  webBean, ReqVO1, a1, lo1, column1);
                 System.out.println(k2);
                       
           
                  
               
     if(k1.equals("1")&&k2.equals("1"))
     {
     
     
     
     
     
     
     
     
     
     
         //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------     
             
          ///* Setting Value for Balance in  the First VO on First Row  */
        
         OAViewObject voBalance=(OAViewObject)am.findViewObject("xxcactTxnTestVO1");   //First VO where there is data (Source VO)
         int n258=Integer.valueOf((voBalance.getCurrentRow().getAttribute("Balance")).toString());  //Obtaining the Debit Value to make changes in Balance
         int n852=Integer.valueOf((voBalance.getCurrentRow().getAttribute("Debit")).toString());   // Obtaining Value from Balance
           String lpr=Integer.toString(n258);  //Making a simple Calculation that Balance-Debit
         System.out.println("The Updated Balance is "+lpr);
         System.out.println(voBalance.getCurrentRow().getAttribute("Balance")); //Obtaining the value before the balance 
         voBalance.getCurrentRow().setAttribute("Balance", lpr);   //Setting the Current Balance
         
         //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------     
          
     
          
         //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------     
             
          //**************************************************
          /* Setting Account Number  for in Money Transaction */
          OADBTransaction txn=(OADBTransaction)am.getOADBTransaction(); //Obtaining the Transaction Object to 
          
          Number seqNoSno=txn.getSequenceValue("txn_test_sno_s");
          
          System.out.println("seqNoTxnId----------------------------------------------------------------------?>"+seqNoSno);
          
         xxcactTxnTestVO1Impl vow=(xxcactTxnTestVO1Impl)am.findViewObject("xxcactTxnTestVO1");
         vow.getCurrentRow().setAttribute("Sno", seqNoSno);
    //**************************************************
          
          
           //**************************************************
          /* Setting Transaction Id Number  for in Money Transaction */
           String aas=(txn.getSequenceValue("xxcact_transaction_txn_ss")).toString();
           vow.getCurrentRow().setAttribute("TransactionId", aas);
          System.out.println("Sequence No is ----------------------------------------------------------------------------------->"+aas);
          //**************************************************
          
          

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      

    /* Logic for inserting the second row for updating the Balance */
                    
             
          OAViewObject voIter=(OAViewObject)am.findViewObject("xxcactTxnTestVO1");   //First VO where there is data (Source VO)
                
              
                    System.out.println("voIter.getAttributeIndexOf(\"Acc_no\");"+voIter.getAttributeIndexOf("Acc_no")); //Obtaining Index of Account number
            System.out.println(voIter.getAttributeDef(8).getName());  //Obtaining column name from the index account number
                  int jgr=voIter.getAttributeCount();  //Obtaining the Attribute Count
                  System.out.println("The Value of J is "+jgr); //Displaying the Attribute Count
               AttributeDef[] attrDefs = voIter.getAttributeDefs(); //Obtaining the Attribute Definitions
                int attrCount = (attrDefs == null)? 0 : attrDefs.length; //Obtaining the attribute Count (Another Way)
              
            OAViewObject destvo=(OAViewObject)am.findViewObject("xxcactTxnTestVO2");  //Second VO which is the Destination where data is to be copied
           
                  
                  for(int i=0;i<(attrCount-1);i++) //looping Attributes
                  {
                         System.out.println("The Value of I is This Comes to testing :**********"+i);   //Obtaining the index numbers for looping 
                      System.out.println("AttrDefs "+attrDefs[i]);
                      System.out.println("AttrDefs Testing Obtaining name"+attrDefs[i].getName());
                      System.out.println("AttrDefs Testing Obtaining Property"+attrDefs[i].getProperty(attrDefs[i].getName()));
                        xxcactTxnTestVO1RowImpl roloe=(xxcactTxnTestVO1RowImpl)voIter.getCurrentRow();//Registering the current row to the View Object here the current row is the create row
                      System.out.println("AttrDefs Testing Otaining value by row wise "+roloe.getAttribute(attrDefs[i].getName()));
                      System.out.println("AttrDefs Testing Otaining name by row wise "+attrDefs[i].getName());

                       if((attrDefs[i].getName()).equals("TransferAccNo"))  //Making my Own Modifications If You want to just copy without Modyfying just use the Logic in ELSE
                       {
                           destvo.getCurrentRow().setAttribute(attrDefs[i-1].getName(), roloe.getAttribute(attrDefs[i].getName())) ;
                       }
                      else if((attrDefs[i].getName()).equals("AccNo"))
                      {
                          destvo.getCurrentRow().setAttribute(attrDefs[i+1].getName(), roloe.getAttribute(attrDefs[i].getName())) ;
                      }
                     
                     else if((attrDefs[i].getName()).equals("Debit"))
                     {
                         destvo.getCurrentRow().setAttribute(attrDefs[i-1].getName(), roloe.getAttribute(attrDefs[i].getName())) ;
                     }
                     else if((attrDefs[i].getName()).equals("Credit"))
                      {
                         System.out.println("Credit Looped");
                      }
                      
                       else if((attrDefs[i].getName()).equals("Balance"))
                       {
                         OAMessageTextInputBean tip=(OAMessageTextInputBean)webBean.findChildRecursive("TransferAccNo3");
                         String k=(tip.getValue(pageContext)).toString();
         
                         OAViewObject iop=(OAViewObject)am.findViewObject("xxcactbanktxntestBalanceVO");
                         System.out.println("The Value of Iop is "+iop);
                         iop.setWhereClauseParam(0, k);
                         iop.setWhereClauseParam(1, k);
                          iop.executeQuery();
                         iop.first();
                         String iol=(iop.getCurrentRow().getAttribute("Balance")).toString();
                         
                         System.out.println("The receiving person's balance is "+iol);
                           int lre=Integer.parseInt((roloe.getAttribute("Debit")).toString());                      
                           int lwer=Integer.parseInt((iop.getCurrentRow().getAttribute("Balance")).toString());
                           int klol=0;
                           klol=lwer+lre;
                           System.out.println("The Current Balance Obtained is "+klol);
                           String cbal1=Integer.toString(klol);
                           System.out.println("Somehow we obtain the Debit value and Balance for the receving person "+lre+"The Balance is "+lwer);
                           destvo.getCurrentRow().setAttribute(attrDefs[i].getName(), cbal1) ;//Setting the name and attributes for a row\
                         
         
                       }
                      else{
                     destvo.getCurrentRow().setAttribute(attrDefs[i].getName(), roloe.getAttribute(attrDefs[i].getName())) ;//Setting the name and attributes for a row
                      }
                     System.out.println("Getting the setted Attribute from the second VO object"+destvo.getCurrentRow().getAttribute(attrDefs[i].getName()) );
                    
                      
                  }

         //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------     
            
            
     am.invokeMethod("apply");
     OAException confirmMessage = new OAException("CBK","ACCOUNT_STATUS_REQUIRED",null,OAException.CONFIRMATION, null);
     pageContext.putDialogMessage(confirmMessage);
     
         System.out.println("The Account number is "+ls);
         Serializable[] lk={ls};
             am.invokeMethod("tableInstBal", lk);
     
     pageContext.forwardImmediately("OA.jsp?page=/xxfinalcactbank/oracle/apps/fnd/cactbank/webui/xxCactBankDetailsPG",
     null,
    
     OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
     null,
     null,
     true, // retain AM
     OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
     }
     // }
     }
     }

     /*********Cancel button***********/
     if (pageContext.getParameter("Cancel") != null) {
     
     am.invokeMethod("rollbackOrder");
     TransactionUnitHelper.endTransactionUnit(pageContext, "ordCreateTxn");
    
     pageContext.forwardImmediately("OA.jsp?page=/xxfinalcactbank/oracle/apps/fnd/cactbank/webui/xxCactBankLoginPG",
     null,
     //OAWebBeanConstants.KEEP_MENU_CONTEXT,
     OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
     null,
     null,
     false, // retain AM
     OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
     
      
     
     }


     
     

        if("accountvalidate".equals(pageContext.getParameter(EVENT_PARAM)))
        {
            System.out.println("Control Came to Account Validate");
            xxCactBankDetailsCO cactCO=new xxCactBankDetailsCO();
            OAViewObject ReqVO   =   (OAViewObject)am.findViewObject("xxcactBankValiVO");
           OAViewRowImpl lo=(OAViewRowImpl)ReqVO.first();
           System.out.println(lo);
            OAMessageTextInputBean a=(OAMessageTextInputBean)webBean.findChildRecursive("TransferAccNo3");
            String column="AccNo";
            String k1=cactCO.accountValidation(pageContext,  webBean, ReqVO, a, lo, column);
            System.out.println(k1);
            
        } 
        
        
          if("amountValidate".equals(pageContext.getParameter(EVENT_PARAM)))
          {
            System.out.println("Control Came to Amount Validate");
            xxCactBankDetailsCO cactCO=new xxCactBankDetailsCO();
                    OAViewObject ReqVO   =   (OAViewObject)am.findViewObject("xxcactBankValiVO");
            OAViewRowImpl lo=(OAViewRowImpl)ReqVO.first();
            System.out.println(lo);
            OAMessageTextInputBean a=(OAMessageTextInputBean)webBean.findChildRecursive("Debit2");
            String column="Debit";       
            String k2=cactCO.amountValidation(pageContext,  webBean, ReqVO, a, lo, column);
            System.out.println(k2);
              OAMessageStyledTextBean jbal=(OAMessageStyledTextBean)webBean.findChildRecursive("Balance");
                       
            
                  
          }
             
          
     
     
     
//     
//     /*
//     
//     
//      if("validate1".equals(pageContext.getParameter(EVENT_PARAM)))
//      {
//      System.out.println("Validation Event Occured"+EVENT_PARAM);
//      int dummyAccNo =200; //A Dummy Variable for Comparison
//      OAViewObject vo1 =(OAViewObject)am.findViewObject("xxcactBankValiVO"); // Obtaining VO instance for iterating the values
//      System.out.println("Vo Executed"+vo1);
//      xxcactBankValiVORowImpl row = null; //Assigning a variable for Row to get Attributes
//      vo1.getRowCount(); //Getting the Values of Row Count This is important because when FetchedRowCount() method is called
//      int fetchedRowCount132 = vo1.getFetchedRowCount(); //Obtaining the Fetched Row Count
//      System.out.println("Value Of Fetched Row Count "+fetchedRowCount132);
//      RowSetIterator rowsetiterator = vo1.createRowSetIterator("MyTestIter");
//      System.out.println("Vo Executed My Delete Ieteradfjkhnjnjshfuhj"+rowsetiterator);
//      if (fetchedRowCount132 > 0)
//      {
//      rowsetiterator.setRangeStart(0); //Assiging the Range
//      rowsetiterator.setRangeSize(fetchedRowCount132);
//      for (int i = 0; i < fetchedRowCount132; i++)
//      {
//      row = (xxcactBankValiVORowImpl)rowsetiterator.getRowAtRangeIndex(i); //Iterating and passing values for each row to get printed
//      System.out.println("xxcactBankValiVO Current Row ------------------------------------------------------------->"+vo1.getCurrentRowIndex()+"Acc No Before"+row.getAccNo()+"Something");
//           System.out.println("xxcactBankValiVO Current Row ------------------------------------------------------------->"+vo1.getCurrentRowIndex());
//          System.out.println("xxcactBankValiVO Current Row ------------------------------------------------------------->"+vo1.first());
//          System.out.println("xxcactBankValiVO Current Row ------------------------------------------------------------->"+vo1.getCurrentRowIndex()+"Acc No After"+row.getAccNo());
//          System.out.println("xxcactBankValiVO Current Row ------------------------------------------------------------->"+vo1.getCurrentRowIndex());
//      //        System.out.println("xxcactBankValiVO Current Row ------------------------------------------------------------->"+vo1.getCurrentRowIndex());
//      System.out.println("Obtaining the from Row Set Iterator"+row);
//      Number primaryKey = row.getAccNo();// Getting the Value of Each Attributes
//      Number a=row.getBalance();
//      int b=row.getAttributeCount();
//      System.out.println("Value of Account Number"+primaryKey+" Value of Balance"+a+"Value of Attribute Count "+b);
//      if (primaryKey.compareTo(dummyAccNo) == 0)
//      {
//      System.out.println("Values Match"+primaryKey);
//      break; // only one possible selected row in this case
//      }
//      }
//      }
//      // Always close the iterator when you’re done.
//      rowsetiterator.closeRowSetIterator();
//      }
//     
//     
//     
//     */
//     
//    /*
//        if("validate1".equals(pageContext.getParameter(EVENT_PARAM)))
//        {
//        System.out.println("Validation Event Occured"+EVENT_PARAM);
//        int dummyAccNo =200; //A Dummy Variable for Comparison
//        OAViewObject vo1 =(OAViewObject)am.findViewObject("xxcactBankValiVO"); // Obtaining VO instance for iterating the values
//        System.out.println("Vo Executed"+vo1);
//        xxcactBankValiVORowImpl row = null; //Assigning a variable for Row to get Attributes
//        vo1.getRowCount(); //Getting the Values of Row Count This is important because when FetchedRowCount() method is called
//        int fetchedRowCount132 = vo1.getFetchedRowCount(); //Obtaining the Fetched Row Count
//        System.out.println("Value Of Fetched Row Count "+fetchedRowCount132);
//        RowSetIterator rowsetiterator = vo1.createRowSetIterator("MyTestIter");
//        System.out.println("Vo Executed My Delete Ieteradfjkhnjnjshfuhj"+rowsetiterator);
//        if (fetchedRowCount132 > 0)
//        {
//        rowsetiterator.setRangeStart(0); //Assiging the Range
//        rowsetiterator.setRangeSize(fetchedRowCount132);
//        for (int i = 0; i < fetchedRowCount132; i++)
//        {
//        row = (xxcactBankValiVORowImpl)rowsetiterator.getRowAtRangeIndex(i); //Iterating and passing values for each row to get printed
//        System.out.println("xxcactBankValiVO Current Row ------------------------------------------------------------->"+vo1.getCurrentRowIndex()+"Acc No Before"+row.getAccNo()+"Something");
//             System.out.println("xxcactBankValiVO Current Row ------------------------------------------------------------->"+vo1.getCurrentRowIndex());
//            System.out.println("xxcactBankValiVO Current Row ------------------------------------------------------------->"+vo1.first());
//            System.out.println("xxcactBankValiVO Current Row ------------------------------------------------------------->"+vo1.getCurrentRowIndex()+"Acc No After"+row.getAccNo());
//            System.out.println("xxcactBankValiVO Current Row ------------------------------------------------------------->"+vo1.getCurrentRowIndex());
//    //        System.out.println("xxcactBankValiVO Current Row ------------------------------------------------------------->"+vo1.getCurrentRowIndex());
//        System.out.println("Obtaining the from Row Set Iterator"+row);
//        Number primaryKey = row.getAccNo();// Getting the Value of Each Attributes
//        Number a=row.getBalance();
//        int b=row.getAttributeCount();
//        System.out.println("Value of Account Number"+primaryKey+" Value of Balance"+a+"Value of Attribute Count "+b);
//        if (primaryKey.compareTo(dummyAccNo) == 0)
//        {
//        System.out.println("Values Match"+primaryKey);
//        break; // only one possible selected row in this case
//        }
//        }
//        }
//        // Always close the iterator when you’re done.
//        rowsetiterator.closeRowSetIterator();
//        }
//    */
//
//
//
//    //       if (null!=ReqVO) {
//    //           Row ReqRow = ReqVO.first();            
//    //           if (null != ReqRow) {
//    //                       
//    //           int idx = ReqVO.getRowCount();
//    //  
//    //           for (int xx = 0; xx < idx; xx++) {
//    //               if (null != ReqRow) {
//    //                  // Do some work....
//    //                  ReqRow = ReqVO.next();
//    //               } 
//    //               else {}
//    //           }
//    //         }
//    //       }
//    //    
//        
//        
//
//        /*
//             if("validate123".equals(pageContext.getParameter(EVENT_PARAM)))
//             {
//              System.out.println("Event Parameter -------->"+EVENT_PARAM);
//              OAMessageTextInputBean a=(OAMessageTextInputBean)webBean.findChildRecursive("TransferAccNo");
//              String k=(a.getValue(pageContext)).toString();
//              System.out.println("kkkkkkkkkkkkkkkkkkk----------->"+EVENT_PARAM+k+a);
//                 {
//                    OAViewObject vo1 =(OAViewObject)am.findViewObject("xxcactBankValiVO");
//                    System.out.println("VO Object Created----------->"+vo1);
//         
//                     vo1.executeQuery();
//                       xxcactBankValiVORowImpl row = null;
//                     fetchedRowCount = vo1.getFetchedRowCount();
//                     System.out.println("Fetched Row Count for our Info"+fetchedRowCount);
//                  
//                 if(vo1.getCurrentRow()!= null){
//                  fetchedRowCount = vo1.getFetchedRowCount();
//                  
//                  System.out.println("GetCurrent Row is no t null"+fetchedRowCount);
//                 }
//                 else
//                 {
//                     System.out.println("GetCurrent Row is  null" );
//                 }
//                    // String rowReference =pageContext.getParameter(OAWebBeanConstants.EVENT_SOURCE_ROW_REFERENCE);
//                          
//                 System.out.println(vo1.getRowCount());
//                 
//                     
//                 fetchedRowCount = vo1.getFetchedRowCount();
//                 System.out.println("Get Fetched Row Count+++++++++++++"+vo1.getFetchedRowCount());
//                 
//                     System.out.println("Get Fetched Row Count+++++++++++++"+fetchedRowCount);
//                 RowSetIterator deleteIter = vo1.createRowSetIterator("RowIteerasdfaw");
//                 System.out.println("hasuidhrfuwisfjknalseuiyhl"+deleteIter);
//                  //   System.out.println("GetCurrent Row is  null");
//                 // We use a separate iterator -- even though we could step through
//                 // rows without it -- because we don't want to affect row currency.
//              
//               
//                 if (fetchedRowCount > 0)
//                 {
//                     System.out.println("Fetched row count  is greater than zero");
//                System.out.println("Delete Iter Range Start"+deleteIter.setRangeStart(0)); 
//               
//              //   System.out.println("Delete Iter setRange Size"+deleteIter.setRangeSize(fetchedRowCount));
//                 for (int i = 0; i <= fetchedRowCount; i++)
//                 {
//                        
//                     System.out.println("looping Takes place------------------------->"+i);
//                 row = (xxcactBankValiVORowImpl)deleteIter.getRowAtRangeIndex(i);
//                     System.out.println("Looped Values"+deleteIter.getRowAtRangeIndex(i)+"Number varies jlkasj"+i+"Row values"+row);
//     
//                   
//                   vo1.first();
//                  deleteIter.setRangeStart(0);
//                  System.out.println(row);
//              //    deleteIter.setRangeSize(fetchedRowCount);
//                 String primaryKey = (row.getAccNo()).toString();
//                     if(primaryKey==null)
//                     {
//                        primaryKey="0";
//                     }
//                 System.out.println("Sting Obtained"+primaryKey+"fetchedRowCount"+fetchedRowCount+"The Current Row Index is "+ vo1.getCurrentRowIndex());
//                 System.out.println("Stirng k-------------->"+k);
//                
//                 if (primaryKey.compareTo(k) == 0)
//                 {
//                 
//                System.out.println("Values Match and "+primaryKey);
//                        
//                         lemon++;
//    //                 OAException message = new OAException("This is a valid number.",OAException.INFORMATION);
//    //                 pageContext.putDialogMessage(message);
//                         break;
//                 }else
//                 {
//                // throw new OAException("Value not Found");
//                 }
//                 
//                 } 
//                 }      deleteIter.closeRowSetIterator();
//                         System.out.println("This is Counter Variable "+lemon);
//                 if(lemon==0)
//                 {
//                     OAException message = new OAException("This is a invalid number.",OAException.ERROR);
//                     pageContext.putDialogMessage(message);
//                 }
//                 } 
//                
//                 }
//             
//                 // Always close the iterator when you're done.
//                */
//                  
//             
//             
//        
//
//     
//        
//    //        
//    //      System.out.println("enter under apply");
//    //      OADBTransaction tranx =      (OADBTransaction)((OAApplicationModuleImpl)am).getDBTransaction();
//    //     // OADBTransaction tranx = (OADBTransaction)getDBTransaction();
//    //      
//    //
//    //      String sql="begin INSERTPROC286(:1, :2); end;";
//    //
//    //      CallableStatement csmt;
//    //
//    //      csmt=tranx.createCallableStatement(sql,1);
//    //
//    //      try
//    //
//    //      {
//    //
//    //      csmt.setString(1,username_v);
//    //
//    //      csmt.setString(2,password_v);
//    //
//    //
//    //      csmt.execute();
//    //
//    //      }catch(SQLException e){ throw new OAException("Invalid UserId or Password",OAException.ERROR);}
//    //
//    //      
//    //          OAViewObject vo =(OAViewObject)am.findViewObject("XxcactTransactionVO");
//    //          {
//    //          OAMessageTextInputBean k=(OAMessageTextInputBean)webBean.findChildRecursive("Amount");
//    //          String lock=(k.getValue(pageContext)).toString();
//    //          if ((lock != null) &&
//    //          (!("".equals(lock.trim()))))
//    //          {
//    //          // Do the following conversion for type consistency.
//    //
//    //          vo.setWhereClause("Balance = :1 AND SNO=(SELECT MAX(SNO)) FROM TXN_TEST");
//    //          vo.setWhereClauseParams(null); // Always reset
//    //          vo.setWhereClauseParam(0, lock);
//    //          vo.executeQuery();
//    //          }
//    //          
//    //      
//    //          System.out.println("Event has Occured"+EVENT_PARAM);
//    //          System.out.println("Source Paramer"+SOURCE_PARAM);  
//    //      }
//    //   
//
//           //**************************************************
//          
//    //       OAMessageStyledTextBean jbal=(OAMessageStyledTextBean)webBean.findChildRecursive("Balance");
//    //         String  lsbal=(String)jbal.getValue(pageContext);
//    //         int jj=Integer.parseInt(lsbal);
//    //         int lk=jj-l;
//    //         lsbal=Integer.toString(lk);
//    //         System.out.println("Obtained the Bean Value from Balance"+lsbal);
//    //       OAMessageStyledTextBean jbalup=(OAMessageStyledTextBean)webBean.findChildRecursive("Balance3");
//    //       jbalup.setValue(pageContext, lsbal);
//    //       //**************************************************
//    //
//    //
//    //  } /* Setting Balance for in Money Transaction */
//    //
    }


     //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

     /* Using Callable Statement */
     

        /* Logic for Iterating the Row and validating whether it is valid */
        
         /*  Tested Works Fine  */

     public String amountValidation(OAPageContext pageContext, OAWebBean webBean, OAViewObject vo, OAMessageTextInputBean a, OAViewRowImpl row, String Column)
     {
        OAApplicationModule am=(OAApplicationModule)pageContext.getApplicationModule(webBean);
      //  String OAPageContext pageContext, OAWebBean webBean, OAViewObject vo, OAMessageTextInputBean a, OAViewRowImpl row, String Column;     
         System.out.println("We are in Amount Validate ---------------");
         int counter=0;
         OADBTransaction txn = (OADBTransaction)((OAApplicationModuleImpl)am).getDBTransaction();   //Obtaining OADBTransaction from Controller 
      //   System.out.println("This is txn objectt"+txn);
         // OADBTransaction txn = getDBTransaction();  //This part is to call in AM
         // OAMessageTextInputBean a=(OAMessageTextInputBean)webBean.findChildRecursive("Debit2");
        //  System.out.println("The Value of Amount"+a);
          String k=(a.getValue(pageContext)).toString();
          int l=Integer.parseInt(k);
               CallableStatement callableStatement =  txn.createCallableStatement("declare begin :outVariable := xx_function(:2); end;",OADBTransaction.DEFAULT);  //Refer to the Syntax where the String is a procedure
               
          //    System.out.println("Callable stmt"+callableStatement);
              try {  
              OAMessageStyledTextBean bn=(OAMessageStyledTextBean)webBean.findChildRecursive("AccNo");
              String valuetobePassed=(bn.getValue(pageContext)).toString();
              System.out.println("Value from the AccNo"+valuetobePassed);
                  callableStatement.registerOutParameter(1, Types.VARCHAR);  
                     callableStatement.setString(2, valuetobePassed);  
                String outParamValue = null; 
                System.out.println("Out param Val"+outParamValue);
                callableStatement.execute();  
                outParamValue = (callableStatement.getString(1)).toString();  
                   System.out.println("The Out Parameter Obtained from the Procedure is "+outParamValue);
                  int j=Integer.parseInt(outParamValue);
                  System.out.println("Value of l that is "+l+"Value of j is "+j);   
                  if((j>l)&&(j>500))
                   {   
                      System.out.println("The Transactio is Valid");
                      counter++;
                      
                     // return "valid";
                  }
                 
                  else
                  {
                      OAException message = new OAException("You Do not have Sufficient Balance .",OAException.ERROR);
                      pageContext.putDialogMessage(message);
                   }
                 
                  int lk=j-l;
                 
                  System.out.println("Obtained the Bean Value from Balance"+lk);
                  OAMessageStyledTextBean jbalup=(OAMessageStyledTextBean)webBean.findChildRecursive("Balance3");
                  jbalup.setValue(pageContext, lk);
            System.out.println("Something happens");
                callableStatement.close();  
            
              } catch (SQLException sqle) {

                   System.out.println("Exception occured");
                   try {
                       callableStatement.close();
                   } catch (SQLException e) {
                    System.out.println(e);
                   }
     }
       
     
     return ""+counter;
     }
     
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     /* Method -- 1 */
     

        /* Logic for Iterating the Row and validating whether it is valid */
        
         /*  Tested Works Fine  */
                        

        public String account2Validation(OAPageContext pageContext, OAWebBean webBean, OAViewObject vo, OAMessageTextInputBean a, OAViewRowImpl row, String Column)
        {
             int counter=0;
             String k=null;
             if(a!=null)
             {
                  k=(a.getValue(pageContext)).toString();
             }
             if((vo!=null))
             {
             
             //for(xxcactBankValiVORowImpl row=(xxcactBankValiVORowImpl)vo.first(); row!=null; row=(xxcactBankValiVORowImpl)vo.next())//Where the class is rowImpl which can be used within the controller code
                 for(row = (OAViewRowImpl) vo.first(); row!=null; row = (OAViewRowImpl) vo.next()) //Iterating using For loop 
                {
               String  primaryKey=(row.getAttribute("AccNo")).toString();
             //     String  primaryKey=(row.getAccNo()).toString();  //This apples when the variable is declared with directly with the class like --> (xxcactBankValiVORowImpl row)
                System.out.println("Value of the Obtained Value"+(row.getAttribute("AccNo")).toString());
                if (primaryKey.compareTo(k) == 0)
                {
                     System.out.println("Values Match and "+primaryKey);                     
                     counter++;
                     break;
                }
                else
                {
                    System.out.println();
                }
              
              }
              try{
                   if(counter==0)
                   {
                       OAException message = new OAException("This is a invalid number.",OAException.ERROR);
                      // return "invalid";
                       pageContext.putDialogMessage(message);
                   }
              }
              catch(OAException e)
              {
                  System.out.println(e);
              }
              
              }
              return counter+""; //This is Actually a  fastest method to convert a int to String
        }
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                 

        
        
        
        

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
          
     /* Method --> 2 */
        /* Logic for Iterating the Row and validating whether it is valid */
        
         /*  Tested Works Fine  */
                        
       
        public String account1Validation(OAPageContext pageContext, OAWebBean webBean, OAViewObject vo, OAMessageTextInputBean a, OAViewRowImpl row1, String col)
        {
             System.out.println("Control came to Account Validation");
             int counter=0;  // Introducing a counter variable for us to count
             String iteratedval=null;  //Iteration varable
             String k=(a.getValue(pageContext)).toString(); //Obtaining Value From Text Box
             System.out.println(k);
             if((vo!=null)&&(a!=null))
             {
                      vo.first();  
                      while(vo.hasNext())  // Loop through VO rows                    
                      {
                          if(vo.getCurrentRow().getAttribute(col)!=null)  
                          iteratedval=(vo.getCurrentRow().getAttribute(col).toString());
                          System.out.println("---------------------------------------------->"+vo.getCurrentRow().getAttribute(col)+"Something Comes in "+iteratedval);
                          if (iteratedval.compareTo(k) == 0)
                          {
                                               System.out.println("Values Match and "+iteratedval);
                                               counter++;
                                               break;
                          }
                          vo.next();  
                      } 
                      try
                      {
                        if(counter==0)
                        {
                            OAException message = new OAException("This is a invalid number.",OAException.ERROR);
                            pageContext.putDialogMessage(message);                       
                        }
                      }
                      catch(OAException e)
                      {
                          System.out.println(e);
                      }
             }
        return counter+""; //This is Actually a  fastest method to convert a int to String
        }
        
        
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------






     //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
           
      /* Method --> 3 */

         /* Logic for Iterating the Row and validating whether it is valid  */
         
          /*  Tested Works Fine Implemented by RowSet Iterator */



     public String accountValidation(OAPageContext pageContext, OAWebBean webBean, OAViewObject vo, OAMessageTextInputBean a, OAViewRowImpl row1, String col)
     {
         int counter = 0;
         System.out.println("Validation Event Occured"+EVENT_PARAM);
         int k=Integer.parseInt((a.getValue(pageContext)).toString()); //Obtaining Value From Text Box 
         xxcactBankValiVORowImpl row = null; //Assigning a variable for Row to get Attributes
         vo.getRowCount(); //Getting the Values of Row Count This is important because when FetchedRowCount() method is called
         int fetchedRowCount = vo.getFetchedRowCount(); //Obtaining the Fetched Row Count
         System.out.println("Value Of Fetched Row Count "+fetchedRowCount);
         RowSetIterator rowsetiterator = vo.createRowSetIterator("MyTestIter"); //creating a Iterator
         System.out.println("Row Iterator has been Created"+rowsetiterator);
         if (fetchedRowCount > 0)
         {
         rowsetiterator.setRangeStart(0); //Assiging the Range
         rowsetiterator.setRangeSize(fetchedRowCount);
         for (int i = 0; i < fetchedRowCount; i++)
         {
         row = (xxcactBankValiVORowImpl)rowsetiterator.getRowAtRangeIndex(i); //Iterating and passing values for each row to get printed
         System.out.println("xxcactBankValiVO Current Row ------------------------------------------------------------->"+vo.getCurrentRowIndex()+"Acc No Before"+row.getAccNo());
              //System.out.println("xxcactBankValiVO Current Row ------------------------------------------------------------->"+vo.getCurrentRowIndex());
            // System.out.println("xxcactBankValiVO Current Row ------------------------------------------------------------->"+vo.first());
          //   System.out.println("xxcactBankValiVO Current Row ------------------------------------------------------------->"+vo.getCurrentRowIndex()+"Acc No After"+row.getAccNo());
     
         System.out.println("Obtaining the from Row Set Iterator"+row);
         Number primaryKey = row.getAccNo();// Getting the Value of Each Attributes
         int b=row.getAttributeCount(); //Obtainging the Attribute Count
         System.out.println("Value of Account Number"+primaryKey+" Value of Balance"+a+"Value of Attribute Count "+b);
         if (primaryKey.compareTo(k) == 0)
         {
             System.out.println("Values Match and "+primaryKey);
             counter++;
             break;
         }
         }
            
        
         }
         
             try
             {
               if(counter==0)
               {
                   OAException message = new OAException("This is a invalid number.",OAException.ERROR);
                   pageContext.putDialogMessage(message);                       
               }
             }
             catch(OAException e)
             {
                 System.out.println(e);
             }
         // Always close the iterator when you’re done.
         rowsetiterator.closeRowSetIterator();
         return counter+"";
     



    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    /*
     public void doSomething() {
         ViewObject vo = getViewObject1();
         RowSetIterator iter = vo.createRowSetIterator(null);
         
             while(iter.hasNext()) {
                 Row row = iter.next();
                 //your custom code
             }
         }  

    */

     }      
    }