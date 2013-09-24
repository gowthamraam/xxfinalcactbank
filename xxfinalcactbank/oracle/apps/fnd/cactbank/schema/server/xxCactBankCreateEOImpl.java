package xxfinalcactbank.oracle.apps.fnd.cactbank.schema.server;

//import com.sun.org.apache.xalan.internal.xsltc.runtime.AttributeList;
import oracle.jbo.server.AttributeDefImpl;
import oracle.apps.fnd.framework.OAAttrValException;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.server.OAEntityDefImpl;
import oracle.apps.fnd.framework.server.OAEntityImpl;
import oracle.apps.fnd.framework.OAAttrValException;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.server.OAEntityDefImpl;
import oracle.apps.fnd.framework.server.OAEntityImpl;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class xxCactBankCreateEOImpl extends OAEntityImpl {
    public static final int USERID = 0;
    public static final int PASSWORD = 1;
    public static final int FIRSTNAME = 2;
    public static final int MIDDLENAME = 3;
    public static final int LASTNAME = 4;
    public static final int MOBILENO = 5;
    public static final int EMAILID = 6;
    public static final int REFNAME = 7;
    public static final int DOB = 8;
    public static final int GENDER = 9;
    public static final int PAN = 10;
    public static final int MARITAL = 11;
    public static final int ANNUALINCOME = 12;
    public static final int OCCUPATION = 13;
    public static final int RESADDRESS1 = 14;
    public static final int RESADDRESS2 = 15;
    public static final int RESCITY = 16;
    public static final int RESDISTRICT = 17;
    public static final int RESSTATE = 18;
    public static final int RESCOUNTRY = 19;
    public static final int RESPINCODE = 20;
    public static final int PERADDRESS1 = 21;
    public static final int PERADDRESS2 = 22;
    public static final int PERCITY = 23;
    public static final int PERDISTRICT = 24;
    public static final int PERSTATE = 25;
    public static final int PERCOUNTRY = 26;
    public static final int PERPINCODE = 27;
    public static final int ACCTYPE = 28;
    public static final int PREFCITY = 29;
    public static final int BRANCH = 30;
    public static final int DOCNAME = 31;
    public static final int ATTRIBUTE1 = 32;
    public static final int ATTRIBUTE2 = 33;
    public static final int ATTRIBUTE3 = 34;
    public static final int ATTRIBUTE4 = 35;
    public static final int ATTRIBUTE5 = 36;
    public static final int ATTRIBUTE6 = 37;
    public static final int ATTRIBUTE7 = 38;
    public static final int ATTRIBUTE8 = 39;
    public static final int ATTRIBUTE9 = 40;
    public static final int ATTRIBUTE10 = 41;
    public static final int LASTUPDATEDATE = 42;
    public static final int LASTUPDATEDBY = 43;
    public static final int CREATIONDATE = 44;
    public static final int CREATEDBY = 45;
    public static final int LASTUPDATELOGIN = 46;
    public static final int APPLDATE = 47;


    private static OAEntityDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove)
     */
    public xxCactBankCreateEOImpl() {
    }


    /**Retrieves the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = 
                    (OAEntityDefImpl)EntityDefImpl.findDefObject("xxfinalcactbank.oracle.apps.fnd.cactbank.schema.server.xxCactBankCreateEO");
        }
        return mDefinitionObject;
    }

    public void create(AttributeList attributeList) {
            super.create(attributeList);
            
            OADBTransaction transaction = getOADBTransaction();
                    setApplDate(transaction.getCurrentDBDate());
        }

    /**Gets the attribute value for UserId, using the alias name UserId
     */
    public String getUserId() {
        return (String)getAttributeInternal(USERID);
    }

    /**Sets <code>value</code> as the attribute value for UserId
     */
    public void setUserId(String value) {
        setAttributeInternal(USERID, value);
    }

    /**Gets the attribute value for Password, using the alias name Password
     */
    public String getPassword() {
        return (String)getAttributeInternal(PASSWORD);
    }

    /**Sets <code>value</code> as the attribute value for Password
     */
    public void setPassword(String value) {
        setAttributeInternal(PASSWORD, value);
    }

    /**Gets the attribute value for FirstName, using the alias name FirstName
     */
    public String getFirstName() {
        return (String)getAttributeInternal(FIRSTNAME);
    }

    /**Sets <code>value</code> as the attribute value for FirstName
     */
    public void setFirstName(String value) {
        setAttributeInternal(FIRSTNAME, value);
    }

    /**Gets the attribute value for MiddleName, using the alias name MiddleName
     */
    public String getMiddleName() {
        return (String)getAttributeInternal(MIDDLENAME);
    }

    /**Sets <code>value</code> as the attribute value for MiddleName
     */
    public void setMiddleName(String value) {
        setAttributeInternal(MIDDLENAME, value);
    }

    /**Gets the attribute value for LastName, using the alias name LastName
     */
    public String getLastName() {
        return (String)getAttributeInternal(LASTNAME);
    }

    /**Sets <code>value</code> as the attribute value for LastName
     */
    public void setLastName(String value) {
        setAttributeInternal(LASTNAME, value);
    }

    /**Gets the attribute value for MobileNo, using the alias name MobileNo
     */
    public Number getMobileNo() {
        return (Number)getAttributeInternal(MOBILENO);
    }

    /**Sets <code>value</code> as the attribute value for MobileNo
     */
    public void setMobileNo(Number value) {
        setAttributeInternal(MOBILENO, value);
    }

    /**Gets the attribute value for EmailId, using the alias name EmailId
     */
    public String getEmailId() {
        return (String)getAttributeInternal(EMAILID);
    }

    /**Sets <code>value</code> as the attribute value for EmailId
     */
    public void setEmailId(String value) {
        setAttributeInternal(EMAILID, value);
    }

    /**Gets the attribute value for RefName, using the alias name RefName
     */
    public String getRefName() {
        return (String)getAttributeInternal(REFNAME);
    }

    /**Sets <code>value</code> as the attribute value for RefName
     */
    public void setRefName(String value) {
        setAttributeInternal(REFNAME, value);
    }

    /**Gets the attribute value for Dob, using the alias name Dob
     */
    public Date getDob() {
        return (Date)getAttributeInternal(DOB);
    }

    /**Sets <code>value</code> as the attribute value for Dob
     */
    public void setDob(Date value) {
        setAttributeInternal(DOB, value);
    }

    /**Gets the attribute value for Gender, using the alias name Gender
     */
    public String getGender() {
        return (String)getAttributeInternal(GENDER);
    }

    /**Sets <code>value</code> as the attribute value for Gender
     */
    public void setGender(String value) {
        setAttributeInternal(GENDER, value);
    }

    /**Gets the attribute value for Pan, using the alias name Pan
     */
    public String getPan() {
        return (String)getAttributeInternal(PAN);
    }

    /**Sets <code>value</code> as the attribute value for Pan
     */
    public void setPan(String value) {
        setAttributeInternal(PAN, value);
    }

    /**Gets the attribute value for Marital, using the alias name Marital
     */
    public String getMarital() {
        return (String)getAttributeInternal(MARITAL);
    }

    /**Sets <code>value</code> as the attribute value for Marital
     */
    public void setMarital(String value) {
        setAttributeInternal(MARITAL, value);
    }

    /**Gets the attribute value for AnnualIncome, using the alias name AnnualIncome
     */
    public String getAnnualIncome() {
        return (String)getAttributeInternal(ANNUALINCOME);
    }

    /**Sets <code>value</code> as the attribute value for AnnualIncome
     */
    public void setAnnualIncome(String value) {
        setAttributeInternal(ANNUALINCOME, value);
    }

    /**Gets the attribute value for Occupation, using the alias name Occupation
     */
    public String getOccupation() {
        return (String)getAttributeInternal(OCCUPATION);
    }

    /**Sets <code>value</code> as the attribute value for Occupation
     */
    public void setOccupation(String value) {
        setAttributeInternal(OCCUPATION, value);
    }

    /**Gets the attribute value for ResAddress1, using the alias name ResAddress1
     */
    public String getResAddress1() {
        return (String)getAttributeInternal(RESADDRESS1);
    }

    /**Sets <code>value</code> as the attribute value for ResAddress1
     */
    public void setResAddress1(String value) {
        setAttributeInternal(RESADDRESS1, value);
    }

    /**Gets the attribute value for ResAddress2, using the alias name ResAddress2
     */
    public String getResAddress2() {
        return (String)getAttributeInternal(RESADDRESS2);
    }

    /**Sets <code>value</code> as the attribute value for ResAddress2
     */
    public void setResAddress2(String value) {
        setAttributeInternal(RESADDRESS2, value);
    }

    /**Gets the attribute value for ResCity, using the alias name ResCity
     */
    public String getResCity() {
        return (String)getAttributeInternal(RESCITY);
    }

    /**Sets <code>value</code> as the attribute value for ResCity
     */
    public void setResCity(String value) {
        setAttributeInternal(RESCITY, value);
    }

    /**Gets the attribute value for ResDistrict, using the alias name ResDistrict
     */
    public String getResDistrict() {
        return (String)getAttributeInternal(RESDISTRICT);
    }

    /**Sets <code>value</code> as the attribute value for ResDistrict
     */
    public void setResDistrict(String value) {
        setAttributeInternal(RESDISTRICT, value);
    }

    /**Gets the attribute value for ResState, using the alias name ResState
     */
    public String getResState() {
        return (String)getAttributeInternal(RESSTATE);
    }

    /**Sets <code>value</code> as the attribute value for ResState
     */
    public void setResState(String value) {
        setAttributeInternal(RESSTATE, value);
    }

    /**Gets the attribute value for ResCountry, using the alias name ResCountry
     */
    public String getResCountry() {
        return (String)getAttributeInternal(RESCOUNTRY);
    }

    /**Sets <code>value</code> as the attribute value for ResCountry
     */
    public void setResCountry(String value) {
        setAttributeInternal(RESCOUNTRY, value);
    }

    /**Gets the attribute value for ResPincode, using the alias name ResPincode
     */
    public Number getResPincode() {
        return (Number)getAttributeInternal(RESPINCODE);
    }

    /**Sets <code>value</code> as the attribute value for ResPincode
     */
    public void setResPincode(Number value) {
        setAttributeInternal(RESPINCODE, value);
    }

    /**Gets the attribute value for PerAddress1, using the alias name PerAddress1
     */
    public String getPerAddress1() {
        return (String)getAttributeInternal(PERADDRESS1);
    }

    /**Sets <code>value</code> as the attribute value for PerAddress1
     */
    public void setPerAddress1(String value) {
        setAttributeInternal(PERADDRESS1, value);
    }

    /**Gets the attribute value for PerAddress2, using the alias name PerAddress2
     */
    public String getPerAddress2() {
        return (String)getAttributeInternal(PERADDRESS2);
    }

    /**Sets <code>value</code> as the attribute value for PerAddress2
     */
    public void setPerAddress2(String value) {
        setAttributeInternal(PERADDRESS2, value);
    }

    /**Gets the attribute value for PerCity, using the alias name PerCity
     */
    public String getPerCity() {
        return (String)getAttributeInternal(PERCITY);
    }

    /**Sets <code>value</code> as the attribute value for PerCity
     */
    public void setPerCity(String value) {
        setAttributeInternal(PERCITY, value);
    }

    /**Gets the attribute value for PerDistrict, using the alias name PerDistrict
     */
    public String getPerDistrict() {
        return (String)getAttributeInternal(PERDISTRICT);
    }

    /**Sets <code>value</code> as the attribute value for PerDistrict
     */
    public void setPerDistrict(String value) {
        setAttributeInternal(PERDISTRICT, value);
    }

    /**Gets the attribute value for PerState, using the alias name PerState
     */
    public String getPerState() {
        return (String)getAttributeInternal(PERSTATE);
    }

    /**Sets <code>value</code> as the attribute value for PerState
     */
    public void setPerState(String value) {
        setAttributeInternal(PERSTATE, value);
    }

    /**Gets the attribute value for PerCountry, using the alias name PerCountry
     */
    public String getPerCountry() {
        return (String)getAttributeInternal(PERCOUNTRY);
    }

    /**Sets <code>value</code> as the attribute value for PerCountry
     */
    public void setPerCountry(String value) {
        setAttributeInternal(PERCOUNTRY, value);
    }

    /**Gets the attribute value for PerPincode, using the alias name PerPincode
     */
    public Number getPerPincode() {
        return (Number)getAttributeInternal(PERPINCODE);
    }

    /**Sets <code>value</code> as the attribute value for PerPincode
     */
    public void setPerPincode(Number value) {
        setAttributeInternal(PERPINCODE, value);
    }

    /**Gets the attribute value for AccType, using the alias name AccType
     */
    public String getAccType() {
        return (String)getAttributeInternal(ACCTYPE);
    }

    /**Sets <code>value</code> as the attribute value for AccType
     */
    public void setAccType(String value) {
        setAttributeInternal(ACCTYPE, value);
    }

    /**Gets the attribute value for PrefCity, using the alias name PrefCity
     */
    public String getPrefCity() {
        return (String)getAttributeInternal(PREFCITY);
    }

    /**Sets <code>value</code> as the attribute value for PrefCity
     */
    public void setPrefCity(String value) {
        setAttributeInternal(PREFCITY, value);
    }

    /**Gets the attribute value for Branch, using the alias name Branch
     */
    public String getBranch() {
        return (String)getAttributeInternal(BRANCH);
    }

    /**Sets <code>value</code> as the attribute value for Branch
     */
    public void setBranch(String value) {
        setAttributeInternal(BRANCH, value);
    }

    /**Gets the attribute value for DocName, using the alias name DocName
     */
    public String getDocName() {
        return (String)getAttributeInternal(DOCNAME);
    }

    /**Sets <code>value</code> as the attribute value for DocName
     */
    public void setDocName(String value) {
        setAttributeInternal(DOCNAME, value);
    }

    /**Gets the attribute value for Attribute1, using the alias name Attribute1
     */
    public String getAttribute1() {
        return (String)getAttributeInternal(ATTRIBUTE1);
    }

    /**Sets <code>value</code> as the attribute value for Attribute1
     */
    public void setAttribute1(String value) {
        setAttributeInternal(ATTRIBUTE1, value);
    }

    /**Gets the attribute value for Attribute2, using the alias name Attribute2
     */
    public String getAttribute2() {
        return (String)getAttributeInternal(ATTRIBUTE2);
    }

    /**Sets <code>value</code> as the attribute value for Attribute2
     */
    public void setAttribute2(String value) {
        setAttributeInternal(ATTRIBUTE2, value);
    }

    /**Gets the attribute value for Attribute3, using the alias name Attribute3
     */
    public String getAttribute3() {
        return (String)getAttributeInternal(ATTRIBUTE3);
    }

    /**Sets <code>value</code> as the attribute value for Attribute3
     */
    public void setAttribute3(String value) {
        setAttributeInternal(ATTRIBUTE3, value);
    }

    /**Gets the attribute value for Attribute4, using the alias name Attribute4
     */
    public String getAttribute4() {
        return (String)getAttributeInternal(ATTRIBUTE4);
    }

    /**Sets <code>value</code> as the attribute value for Attribute4
     */
    public void setAttribute4(String value) {
        setAttributeInternal(ATTRIBUTE4, value);
    }

    /**Gets the attribute value for Attribute5, using the alias name Attribute5
     */
    public String getAttribute5() {
        return (String)getAttributeInternal(ATTRIBUTE5);
    }

    /**Sets <code>value</code> as the attribute value for Attribute5
     */
    public void setAttribute5(String value) {
        setAttributeInternal(ATTRIBUTE5, value);
    }

    /**Gets the attribute value for Attribute6, using the alias name Attribute6
     */
    public String getAttribute6() {
        return (String)getAttributeInternal(ATTRIBUTE6);
    }

    /**Sets <code>value</code> as the attribute value for Attribute6
     */
    public void setAttribute6(String value) {
        setAttributeInternal(ATTRIBUTE6, value);
    }

    /**Gets the attribute value for Attribute7, using the alias name Attribute7
     */
    public String getAttribute7() {
        return (String)getAttributeInternal(ATTRIBUTE7);
    }

    /**Sets <code>value</code> as the attribute value for Attribute7
     */
    public void setAttribute7(String value) {
        setAttributeInternal(ATTRIBUTE7, value);
    }

    /**Gets the attribute value for Attribute8, using the alias name Attribute8
     */
    public String getAttribute8() {
        return (String)getAttributeInternal(ATTRIBUTE8);
    }

    /**Sets <code>value</code> as the attribute value for Attribute8
     */
    public void setAttribute8(String value) {
        setAttributeInternal(ATTRIBUTE8, value);
    }

    /**Gets the attribute value for Attribute9, using the alias name Attribute9
     */
    public String getAttribute9() {
        return (String)getAttributeInternal(ATTRIBUTE9);
    }

    /**Sets <code>value</code> as the attribute value for Attribute9
     */
    public void setAttribute9(String value) {
        setAttributeInternal(ATTRIBUTE9, value);
    }

    /**Gets the attribute value for Attribute10, using the alias name Attribute10
     */
    public String getAttribute10() {
        return (String)getAttributeInternal(ATTRIBUTE10);
    }

    /**Sets <code>value</code> as the attribute value for Attribute10
     */
    public void setAttribute10(String value) {
        setAttributeInternal(ATTRIBUTE10, value);
    }

    /**Gets the attribute value for LastUpdateDate, using the alias name LastUpdateDate
     */
    public Date getLastUpdateDate() {
        return (Date)getAttributeInternal(LASTUPDATEDATE);
    }

    /**Sets <code>value</code> as the attribute value for LastUpdateDate
     */
    public void setLastUpdateDate(Date value) {
        setAttributeInternal(LASTUPDATEDATE, value);
    }

    /**Gets the attribute value for LastUpdatedBy, using the alias name LastUpdatedBy
     */
    public Number getLastUpdatedBy() {
        return (Number)getAttributeInternal(LASTUPDATEDBY);
    }

    /**Sets <code>value</code> as the attribute value for LastUpdatedBy
     */
    public void setLastUpdatedBy(Number value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**Gets the attribute value for CreationDate, using the alias name CreationDate
     */
    public Date getCreationDate() {
        return (Date)getAttributeInternal(CREATIONDATE);
    }

    /**Sets <code>value</code> as the attribute value for CreationDate
     */
    public void setCreationDate(Date value) {
        setAttributeInternal(CREATIONDATE, value);
    }

    /**Gets the attribute value for CreatedBy, using the alias name CreatedBy
     */
    public Number getCreatedBy() {
        return (Number)getAttributeInternal(CREATEDBY);
    }

    /**Sets <code>value</code> as the attribute value for CreatedBy
     */
    public void setCreatedBy(Number value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**Gets the attribute value for LastUpdateLogin, using the alias name LastUpdateLogin
     */
    public Number getLastUpdateLogin() {
        return (Number)getAttributeInternal(LASTUPDATELOGIN);
    }

    /**Sets <code>value</code> as the attribute value for LastUpdateLogin
     */
    public void setLastUpdateLogin(Number value) {
        setAttributeInternal(LASTUPDATELOGIN, value);
    }

    /**Gets the attribute value for ApplDate, using the alias name ApplDate
     */
    public Date getApplDate() {
        return (Date)getAttributeInternal(APPLDATE);
    }

    /**Sets <code>value</code> as the attribute value for ApplDate
     */
    public void setApplDate(Date value) {
        validateStartDate(value);
        setAttributeInternal(APPLDATE, value);
    }


    protected void validateStartDate(Date value)
    {
    // BC4J ensures that this mandatory attribute has a non-null value.
    if (value != null)
    {
    OADBTransaction transaction = getOADBTransaction();
    // Note that we want to truncate these values to allow for the possibility
    // that we're trying to set them to be the same day. Calling
    // dateValue( ) does not include time. Were we to want the time element,
    // we would call timestampValue(). Finally, you cannot compare
    // oracle.jbo.domain.Date objects directly. Instead, convert the value to
    // a long as shown.
    long sysdate = transaction.getCurrentDBDate().dateValue().getTime();
    long startDate = value.dateValue().getTime();
    if (startDate < sysdate)
    {
    throw new OAException("Date Validation failed",OAException.ERROR);
    
     }
     }
     }
    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case USERID:
            return getUserId();
        case PASSWORD:
            return getPassword();
        case FIRSTNAME:
            return getFirstName();
        case MIDDLENAME:
            return getMiddleName();
        case LASTNAME:
            return getLastName();
        case MOBILENO:
            return getMobileNo();
        case EMAILID:
            return getEmailId();
        case REFNAME:
            return getRefName();
        case DOB:
            return getDob();
        case GENDER:
            return getGender();
        case PAN:
            return getPan();
        case MARITAL:
            return getMarital();
        case ANNUALINCOME:
            return getAnnualIncome();
        case OCCUPATION:
            return getOccupation();
        case RESADDRESS1:
            return getResAddress1();
        case RESADDRESS2:
            return getResAddress2();
        case RESCITY:
            return getResCity();
        case RESDISTRICT:
            return getResDistrict();
        case RESSTATE:
            return getResState();
        case RESCOUNTRY:
            return getResCountry();
        case RESPINCODE:
            return getResPincode();
        case PERADDRESS1:
            return getPerAddress1();
        case PERADDRESS2:
            return getPerAddress2();
        case PERCITY:
            return getPerCity();
        case PERDISTRICT:
            return getPerDistrict();
        case PERSTATE:
            return getPerState();
        case PERCOUNTRY:
            return getPerCountry();
        case PERPINCODE:
            return getPerPincode();
        case ACCTYPE:
            return getAccType();
        case PREFCITY:
            return getPrefCity();
        case BRANCH:
            return getBranch();
        case DOCNAME:
            return getDocName();
        case ATTRIBUTE1:
            return getAttribute1();
        case ATTRIBUTE2:
            return getAttribute2();
        case ATTRIBUTE3:
            return getAttribute3();
        case ATTRIBUTE4:
            return getAttribute4();
        case ATTRIBUTE5:
            return getAttribute5();
        case ATTRIBUTE6:
            return getAttribute6();
        case ATTRIBUTE7:
            return getAttribute7();
        case ATTRIBUTE8:
            return getAttribute8();
        case ATTRIBUTE9:
            return getAttribute9();
        case ATTRIBUTE10:
            return getAttribute10();
        case LASTUPDATEDATE:
            return getLastUpdateDate();
        case LASTUPDATEDBY:
            return getLastUpdatedBy();
        case CREATIONDATE:
            return getCreationDate();
        case CREATEDBY:
            return getCreatedBy();
        case LASTUPDATELOGIN:
            return getLastUpdateLogin();
        case APPLDATE:
            return getApplDate();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case USERID:
            setUserId((String)value);
            return;
        case PASSWORD:
            setPassword((String)value);
            return;
        case FIRSTNAME:
            setFirstName((String)value);
            return;
        case MIDDLENAME:
            setMiddleName((String)value);
            return;
        case LASTNAME:
            setLastName((String)value);
            return;
        case MOBILENO:
            setMobileNo((Number)value);
            return;
        case EMAILID:
            setEmailId((String)value);
            return;
        case REFNAME:
            setRefName((String)value);
            return;
        case DOB:
            setDob((Date)value);
            return;
        case GENDER:
            setGender((String)value);
            return;
        case PAN:
            setPan((String)value);
            return;
        case MARITAL:
            setMarital((String)value);
            return;
        case ANNUALINCOME:
            setAnnualIncome((String)value);
            return;
        case OCCUPATION:
            setOccupation((String)value);
            return;
        case RESADDRESS1:
            setResAddress1((String)value);
            return;
        case RESADDRESS2:
            setResAddress2((String)value);
            return;
        case RESCITY:
            setResCity((String)value);
            return;
        case RESDISTRICT:
            setResDistrict((String)value);
            return;
        case RESSTATE:
            setResState((String)value);
            return;
        case RESCOUNTRY:
            setResCountry((String)value);
            return;
        case RESPINCODE:
            setResPincode((Number)value);
            return;
        case PERADDRESS1:
            setPerAddress1((String)value);
            return;
        case PERADDRESS2:
            setPerAddress2((String)value);
            return;
        case PERCITY:
            setPerCity((String)value);
            return;
        case PERDISTRICT:
            setPerDistrict((String)value);
            return;
        case PERSTATE:
            setPerState((String)value);
            return;
        case PERCOUNTRY:
            setPerCountry((String)value);
            return;
        case PERPINCODE:
            setPerPincode((Number)value);
            return;
        case ACCTYPE:
            setAccType((String)value);
            return;
        case PREFCITY:
            setPrefCity((String)value);
            return;
        case BRANCH:
            setBranch((String)value);
            return;
        case DOCNAME:
            setDocName((String)value);
            return;
        case ATTRIBUTE1:
            setAttribute1((String)value);
            return;
        case ATTRIBUTE2:
            setAttribute2((String)value);
            return;
        case ATTRIBUTE3:
            setAttribute3((String)value);
            return;
        case ATTRIBUTE4:
            setAttribute4((String)value);
            return;
        case ATTRIBUTE5:
            setAttribute5((String)value);
            return;
        case ATTRIBUTE6:
            setAttribute6((String)value);
            return;
        case ATTRIBUTE7:
            setAttribute7((String)value);
            return;
        case ATTRIBUTE8:
            setAttribute8((String)value);
            return;
        case ATTRIBUTE9:
            setAttribute9((String)value);
            return;
        case ATTRIBUTE10:
            setAttribute10((String)value);
            return;
        case LASTUPDATEDATE:
            setLastUpdateDate((Date)value);
            return;
        case LASTUPDATEDBY:
            setLastUpdatedBy((Number)value);
            return;
        case CREATIONDATE:
            setCreationDate((Date)value);
            return;
        case CREATEDBY:
            setCreatedBy((Number)value);
            return;
        case LASTUPDATELOGIN:
            setLastUpdateLogin((Number)value);
            return;
        case APPLDATE:
            setApplDate((Date)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Creates a Key object based on given key constituents
     */
    public static Key createPrimaryKey(String userId) {
        return new Key(new Object[]{userId});
    }
}
