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
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageChoiceBean;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
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
  }

}
