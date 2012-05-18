package org.apache.athrift.service.type;

import org.apache.athrift.CommonStruct;
import org.apache.athrift.compiler.ConstValue;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

public class I64BaseType extends BaseType {
    private static final org.apache.thrift.protocol.TField I64_SUCCESS_FIELD_DESC =
        new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.I64, (short)0);
    private Long value = null;
    
    public String getTypeDescr()
    {
        return "i64";
    }
    
    public void read(org.apache.thrift.protocol.TProtocol iprot)
        throws org.apache.thrift.TException
    {
        value = null;
        value = iprot.readI64();
    }
    
    public Class getClassDescr()
    {
        return long.class;
    }
    
    public Object getValue()
    {
        return value;
    }
    
    public TBase deepCopy()
    {
        I64BaseType ret = new I64BaseType();
        ret.setValue(value);
        return ret;
    }

    public void setValue(Object valueParm) {
        this.value = (Long)valueParm;
    }
    
    public byte getTType()
    {
        return org.apache.thrift.protocol.TType.I64;
    }
    
    public void writeSuccessReturn(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeFieldBegin(I64_SUCCESS_FIELD_DESC);
        write(oprot, valueParm);
        oprot.writeFieldEnd();
    }
    
    public void write(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeI64((Long)valueParm);
    }
    
    @Override
    public Object generateDefaultValue(ConstValue theConstValueParm) {
        Long ret = Long.parseLong((String)theConstValueParm.getDefaultValue());
        return ret;
    }
}
