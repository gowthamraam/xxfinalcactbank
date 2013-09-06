package xxfinalcactbank.oracle.apps.fnd.cactbank.schema.server;

import oracle.apps.fnd.framework.server.OAEntityDefImpl;
import oracle.apps.fnd.framework.server.OAEntityImpl;

import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.RowID;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class xxcactTxnTestEOImpl extends OAEntityImpl {
    public static final int SNO = 0;
    public static final int TRANSACTIONTYPE = 1;
    public static final int TRANSACTIONID = 2;
    public static final int ACCNO = 3;
    public static final int TRANSFERACCNO = 4;
    public static final int AMOUNTFROMACC = 5;
    public static final int CREDIT = 6;
    public static final int DEBIT = 7;
    public static final int BALANCE = 8;
    public static final int ATTRIBUTE1 = 9;
    public static final int ATTRIBUTE2 = 10;
    public static final int ATTRIBUTE3 = 11;
    public static final int ATTRIBUTE4 = 12;
    public static final int ATTRIBUTE5 = 13;
    public static final int ATTRIBUTE6 = 14;
    public static final int ATTRIBUTE7 = 15;
    public static final int ATTRIBUTE8 = 16;
    public static final int ATTRIBUTE9 = 17;
    public static final int ATTRIBUTE10 = 18;
    public static final int LASTUPDATEDATE = 19;
    public static final int LASTUPDATEDBY = 20;
    public static final int CREATIONDATE = 21;
    public static final int CREATEDBY = 22;
    public static final int LASTUPDATELOGIN = 23;
    public static final int ROWID = 24;
    private static OAEntityDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove)
     */
    public xxcactTxnTestEOImpl() {
    }

    /**Retrieves the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = 
                    (OAEntityDefImpl)EntityDefImpl.findDefObject("xxfinalcactbank.oracle.apps.fnd.cactbank.schema.server.xxcactTxnTestEO");
        }
        return mDefinitionObject;
    }

    /**Gets the attribute value for Sno, using the alias name Sno
     */
    public Number getSno() {
        return (Number)getAttributeInternal(SNO);
    }

    /**Sets <code>value</code> as the attribute value for Sno
     */
    public void setSno(Number value) {
        setAttributeInternal(SNO, value);
    }

    /**Gets the attribute value for TransactionType, using the alias name TransactionType
     */
    public String getTransactionType() {
        return (String)getAttributeInternal(TRANSACTIONTYPE);
    }

    /**Sets <code>value</code> as the attribute value for TransactionType
     */
    public void setTransactionType(String value) {
        setAttributeInternal(TRANSACTIONTYPE, value);
    }

    /**Gets the attribute value for TransactionId, using the alias name TransactionId
     */
    public Number getTransactionId() {
        return (Number)getAttributeInternal(TRANSACTIONID);
    }

    /**Sets <code>value</code> as the attribute value for TransactionId
     */
    public void setTransactionId(Number value) {
        setAttributeInternal(TRANSACTIONID, value);
    }

    /**Gets the attribute value for AccNo, using the alias name AccNo
     */
    public Number getAccNo() {
        return (Number)getAttributeInternal(ACCNO);
    }

    /**Sets <code>value</code> as the attribute value for AccNo
     */
    public void setAccNo(Number value) {
        setAttributeInternal(ACCNO, value);
    }

    /**Gets the attribute value for TransferAccNo, using the alias name TransferAccNo
     */
    public Number getTransferAccNo() {
        return (Number)getAttributeInternal(TRANSFERACCNO);
    }

    /**Sets <code>value</code> as the attribute value for TransferAccNo
     */
    public void setTransferAccNo(Number value) {
        setAttributeInternal(TRANSFERACCNO, value);
    }

    /**Gets the attribute value for AmountFromAcc, using the alias name AmountFromAcc
     */
    public Number getAmountFromAcc() {
        return (Number)getAttributeInternal(AMOUNTFROMACC);
    }

    /**Sets <code>value</code> as the attribute value for AmountFromAcc
     */
    public void setAmountFromAcc(Number value) {
        setAttributeInternal(AMOUNTFROMACC, value);
    }

    /**Gets the attribute value for Credit, using the alias name Credit
     */
    public Number getCredit() {
        return (Number)getAttributeInternal(CREDIT);
    }

    /**Sets <code>value</code> as the attribute value for Credit
     */
    public void setCredit(Number value) {
        setAttributeInternal(CREDIT, value);
    }

    /**Gets the attribute value for Debit, using the alias name Debit
     */
    public Number getDebit() {
        return (Number)getAttributeInternal(DEBIT);
    }

    /**Sets <code>value</code> as the attribute value for Debit
     */
    public void setDebit(Number value) {
        setAttributeInternal(DEBIT, value);
    }

    /**Gets the attribute value for Balance, using the alias name Balance
     */
    public Number getBalance() {
        return (Number)getAttributeInternal(BALANCE);
    }

    /**Sets <code>value</code> as the attribute value for Balance
     */
    public void setBalance(Number value) {
        setAttributeInternal(BALANCE, value);
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

    /**Gets the attribute value for RowID, using the alias name RowID
     */
    public RowID getRowID() {
        return (RowID)getAttributeInternal(ROWID);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case SNO:
            return getSno();
        case TRANSACTIONTYPE:
            return getTransactionType();
        case TRANSACTIONID:
            return getTransactionId();
        case ACCNO:
            return getAccNo();
        case TRANSFERACCNO:
            return getTransferAccNo();
        case AMOUNTFROMACC:
            return getAmountFromAcc();
        case CREDIT:
            return getCredit();
        case DEBIT:
            return getDebit();
        case BALANCE:
            return getBalance();
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
        case ROWID:
            return getRowID();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case SNO:
            setSno((Number)value);
            return;
        case TRANSACTIONTYPE:
            setTransactionType((String)value);
            return;
        case TRANSACTIONID:
            setTransactionId((Number)value);
            return;
        case ACCNO:
            setAccNo((Number)value);
            return;
        case TRANSFERACCNO:
            setTransferAccNo((Number)value);
            return;
        case AMOUNTFROMACC:
            setAmountFromAcc((Number)value);
            return;
        case CREDIT:
            setCredit((Number)value);
            return;
        case DEBIT:
            setDebit((Number)value);
            return;
        case BALANCE:
            setBalance((Number)value);
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
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }
}