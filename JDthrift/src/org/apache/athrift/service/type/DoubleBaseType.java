package org.apache.athrift.service.type;

import org.apache.athrift.compiler.ConstValue;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

public class DoubleBaseType extends BaseType {
    private static final org.apache.thrift.protocol.TField Double_SUCCESS_FIELD_DESC =
        new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.DOUBLE, (short)0);
    private Double value = null;
    
    public String getTypeDescr()
    {
        return "double";
    }
    
    public Class getClassDescr()
    {
        return double.class;
    }
    
    public Object getValue()
    {
        return value;
    }
    
    public TBase deepCopy()
    {
        DoubleBaseType ret = new DoubleBaseType();
        ret.setValue(value);
        return ret;
    }

    public void setValue(Object valueParm) {
        this.value = (Double)valueParm;
    }
    
    public byte getTType()
    {
        return org.apache.thrift.protocol.TType.DOUBLE;
    }
    
    public void writeSuccessReturn(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeFieldBegin(Double_SUCCESS_FIELD_DESC);
        write(oprot, valueParm);
        oprot.writeFieldEnd();
    }
    
    public void write(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeDouble((Double)valueParm);
    }
    
    public void read(org.apache.thrift.protocol.TProtocol iprot)
        throws org.apache.thrift.TException
    {
        value = null;
        value = iprot.readDouble();
    }
    
    @Override
    public Object generateDefaultValue(ConstValue theConstValueParm) {
        Double ret = Double.parseDouble((String)theConstValueParm.getDefaultValue());
        return ret;
    }
}
