package org.apache.athrift.service.type;

import java.nio.ByteBuffer;

import org.apache.athrift.compiler.ConstValue;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

public class BinaryBaseType extends BaseType {
    private ByteBuffer value;
    private static final org.apache.thrift.protocol.TField Binary_SUCCESS_FIELD_DESC =
        new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRING, (short)0);
    
    public String getTypeDescr()
    {
        return "binary";
    }
    
    public Class getClassDescr()
    {
        return byte[].class;
    }
    
    public Object getValue()
    {
        return value;
    }
    
    public TBase deepCopy()
    {
        BinaryBaseType ret = new BinaryBaseType();
        ret.setValue(value);
        return ret;
    }

    public void setValue(Object valueParm) {
        this.value = (ByteBuffer)valueParm;
    }
    
    public byte getTType()
    {
        return org.apache.thrift.protocol.TType.STRING;
    }
    
    public void writeSuccessReturn(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeFieldBegin(Binary_SUCCESS_FIELD_DESC);
        write(oprot, valueParm);
        oprot.writeFieldEnd();
    }
    
    public void write(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeBinary((ByteBuffer)valueParm);
    }
    
    public void read(org.apache.thrift.protocol.TProtocol iprot)
        throws org.apache.thrift.TException
    {
        value = null;
        value = iprot.readBinary();
    }

    @Override
    public Object generateDefaultValue(ConstValue theConstValueParm) {
        return null;
    }
}
