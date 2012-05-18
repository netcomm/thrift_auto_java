package org.apache.athrift.service.type;

import org.apache.athrift.compiler.ConstValue;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

public class I16BaseType extends BaseType {
    private static final org.apache.thrift.protocol.TField I16_SUCCESS_FIELD_DESC =
        new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.I16, (short)0);
    private Integer value = null;
    
    public String getTypeDescr()
    {
        return "i16";
    }
    
    public void read(org.apache.thrift.protocol.TProtocol iprot)
        throws org.apache.thrift.TException
    {
        value = null;
        value = new Integer(iprot.readI16());
    }
    
    public Class getClassDescr()
    {
        return int.class;
    }
    
    public Object getValue()
    {
        return value;
    }
    
    public TBase deepCopy()
    {
        I16BaseType ret = new I16BaseType();
        ret.setValue(value);
        return ret;
    }

    public void setValue(Object valueParm) {
        this.value = (Integer)valueParm;
    }
    
    public byte getTType()
    {
        return org.apache.thrift.protocol.TType.I16;
    }
    
    public void writeSuccessReturn(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeFieldBegin(I16_SUCCESS_FIELD_DESC);
        write(oprot, valueParm);
        oprot.writeFieldEnd();
    }
    
    public void write(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeI16(((Short)valueParm));
    }
    
    @Override
    public Object generateDefaultValue(ConstValue theConstValueParm) {
        Integer ret = Integer.parseInt((String)theConstValueParm.getDefaultValue());
        return ret;
    }
}
