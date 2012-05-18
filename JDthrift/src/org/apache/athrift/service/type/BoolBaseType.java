package org.apache.athrift.service.type;

import org.apache.athrift.compiler.ConstValue;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

public class BoolBaseType extends BaseType {
    private Boolean value = null;
    private static final org.apache.thrift.protocol.TField Bool_SUCCESS_FIELD_DESC =
        new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.BOOL, (short)0);
    
    public String getTypeDescr()
    {
        return "bool";
    }
    
    public Class getClassDescr()
    {
        return Boolean.class;
    }
    
    public Object getValue()
    {
        return value;
    }
    
    public TBase deepCopy()
    {
        BoolBaseType ret = new BoolBaseType();
        ret.setValue(value);
        return ret;
    }

    public void setValue(Object valueParm) {
        this.value = (Boolean)valueParm;
    }
    
    public byte getTType()
    {
        return org.apache.thrift.protocol.TType.BOOL;
    }
    
    public void writeSuccessReturn(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeFieldBegin(Bool_SUCCESS_FIELD_DESC);
        write(oprot, valueParm);
        oprot.writeFieldEnd();
    }
    
    public void write(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeBool((Boolean)valueParm);
    }
    
    public void read(org.apache.thrift.protocol.TProtocol iprot)
        throws org.apache.thrift.TException
    {
        value = null;
        value = iprot.readBool();
    }
    
    @Override
    public Object generateDefaultValue(ConstValue theConstValueParm) {
        Boolean retBool = Boolean.parseBoolean(
            (String)theConstValueParm.getDefaultValue());
        return retBool;
    }
}
