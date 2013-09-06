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
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.TransactionUnitHelper;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

import oracle.apps.fnd.framework.webui.beans.table.OAAdvancedTableBean;

import oracle.apps.fnd.framework.webui.beans.table.OATableBean;

import xxfinalcactbank.oracle.apps.fnd.cactbank.server.XxcactTransactionVOImpl;
import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxCactBankDetVOImpl;
import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxCactBankLatestTxnImpl;
import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxcactTxnTestVOImpl;
import xxfinalcactbank.oracle.apps.fnd.cactbank.server.xxcactTxnTestVORowImpl;

/**
 * Controller for ...
 */
public class xxCactBankDetailsCO1 extends OAControllerImpl
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
    OAApplicationModule am=(OAApplicationModule)pageContext.getApplicationModule(webBean);
    
//      TransactionUnitHelper.startTransactionUnit(pageContext,"BankLoginTxn");
//            String userid_v = pageContext.getParameter("UserId");
//      
//      
//          Serializable[] parameters = { userid_v };
//          am.invokeMethod("initDetails", parameters);

    
      //XxcactTransactionVOImpl vo1=(XxcactTransactionVOImpl)am.findViewObject("xxcactTransaction");
  //  xxCactBankDetVOImpl vo2=(xxCactBankDetVOImpl)am.findViewObject("xxCactBankDetVO");
     // vo1.executeQuery();
     // vo2.executeQuery();
   //  System.out.println(vo2.getFetchedRowCount());
//      String par="78946";
//       Serializable[] parameters = { par };
//      System.out.println("ordNumber in CO"+par);
//       am.invokeMethod("initDetails", parameters);
////      
      xxCactBankLatestTxnImpl txn=(xxCactBankLatestTxnImpl)am.findViewObject("xxCactBankLatestTxn");
      System.out.println("Txn obj"+txn);
      txn.executeQuery();
      OATableBean table = (OATableBean)webBean.findChildRecursive("xxcactTxnTestVO");
      System.out.println("table"+table);
      table.queryData(pageContext, true);
      
      am.invokeMethod("createEntry", null);
      System.out.println("Insert method invoked");
     
    
      
      
    
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
     OAApplicationModule am=(OAApplicationModule)pageContext.getApplicationModule(webBean);
//      String rowReference = pageContext.getParameter(OAWebBeanConstants.EVENT_SOURCE_ROW_REFERENCE);
//     xxcactTxnTestVORowImpl poRow1 = (xxcactTxnTestVORowImpl)am.findRowByRef(rowReference);
//      String j=pageContext.getParameter("Debit");
//      poRow1.setAttribute("Balance", j);
//    
    
    if("insert".equals(pageContext.getParameter(EVENT_PARAM)))
    {
    
    
      
        am.invokeMethod("apply");
    
    }
    
  }

}
