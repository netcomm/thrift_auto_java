package org.apache.athrift.service.type;

import org.apache.athrift.compiler.ConstValue;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

public class ByteBaseType extends BaseType {
    private static final org.apache.thrift.protocol.TField Byte_SUCCESS_FIELD_DESC =
        new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.BYTE, (short)0);
    private Byte value = null;
    
    public String getTypeDescr()
    {
        return "byte";
    }
    
    public Class getClassDescr()
    {
        return byte.class;
    }
    
    public Object getValue()
    {
        return value;
    }
    
    public TBase deepCopy()
    {
        ByteBaseType ret = new ByteBaseType();
        ret.setValue(value);
        return ret;
    }

    public void setValue(Object valueParm) {
        this.value = (Byte)valueParm;
    }
    
    public byte getTType()
    {
        return org.apache.thrift.protocol.TType.BYTE;
    }
    
    public void writeSuccessReturn(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeFieldBegin(Byte_SUCCESS_FIELD_DESC);
        write(oprot, valueParm);
        oprot.writeFieldEnd();
    }
    
    public void write(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeByte((Byte)valueParm);
    }
    
    public void read(org.apache.thrift.protocol.TProtocol iprot)
        throws org.apache.thrift.TException
    {
        value = null;
        value = iprot.readByte();
    }

    @Override
    public Object generateDefaultValue(ConstValue theConstValueParm) {
        Byte ret = Byte.parseByte((String)theConstValueParm.getDefaultValue());
        return ret;
    }
}
