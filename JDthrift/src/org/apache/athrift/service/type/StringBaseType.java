package org.apache.athrift.service.type;

import org.apache.athrift.compiler.ConstValue;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;


public class StringBaseType extends BaseType {
    private static final org.apache.thrift.protocol.TField String_SUCCESS_FIELD_DESC =
        new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRING, (short)0);
    private String value = null;
    
    public String getTypeDescr()
    {
        return "string";
    }
    
    public void read(org.apache.thrift.protocol.TProtocol iprot)
        throws org.apache.thrift.TException
    {
        value = null;
        value = iprot.readString();
    }
    
    public Class getClassDescr()
    {
        return String.class;
    }
    
    public Object getValue()
    {
        return value;
    }
    
    public BaseType cloneWithJsonValue(Object jsonObjParm) throws Exception
    {
        StringBaseType ret = new StringBaseType();
        ret.setValue((String)jsonObjParm);
        return ret;
    }

    public void setValue(Object valueParm) {
        this.value = (String)valueParm;
    }
    
    public TBase deepCopy()
    {
        StringBaseType ret = new StringBaseType();
        ret.setValue(value);
        return ret;
    }
    
    public byte getTType()
    {
        return org.apache.thrift.protocol.TType.STRING;
    }
    
    public void writeSuccessReturn(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeFieldBegin(String_SUCCESS_FIELD_DESC);
        write(oprot, valueParm);
        oprot.writeFieldEnd();
    }
    
    public void write(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeString((String)valueParm);
    }
    
    @Override
    public Object generateDefaultValue(ConstValue theConstValueParm) {
        String ret = (String)theConstValueParm.getDefaultValue();
        return ret;
    }
}
