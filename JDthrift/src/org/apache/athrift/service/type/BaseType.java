package org.apache.athrift.service.type;

import java.nio.ByteBuffer;

import org.apache.athrift.compiler.ConstValue;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.protocol.TProtocol;


public abstract class BaseType implements TBase {
    public Object getDefaultValue()
    {
        return null;
    }
    
    public void parseDefaultValue(String defaultValueParm)
    {
        
    }
    
    public String getTypeDescr()
    {
        return "";
    }
    
    public abstract byte getTType();
    
    public Class getClassDescr()
    {
        return null;
    }
    
    public Object getValue()
    {
        return null;
    }
    
    public abstract void setValue(Object valueParm);
    
    public abstract Object generateDefaultValue(ConstValue theConstValueParm);
    
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void read(TProtocol iprot) throws TException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void write(TProtocol oprot) throws TException {
        // TODO Auto-generated method stub
        
    }
    
    public void write(TProtocol oprot, Object valueParm) throws TException {
        // TODO Auto-generated method stub
        
    }
    
    public void writeSuccessReturn(TProtocol oprot, Object valueParm) throws TException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public TFieldIdEnum fieldForId(int fieldId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isSet(TFieldIdEnum field) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object getFieldValue(TFieldIdEnum field) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setFieldValue(TFieldIdEnum field, Object value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public TBase deepCopy() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }
}
