package org.apache.athrift.service.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.athrift.compiler.ConstValue;
import org.apache.athrift.compiler.FieldType_Set;
import org.apache.athrift.service.ThriftServicesParser;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.json.JSONArray;

public class SetBaseType extends BaseType {
    private static final org.apache.thrift.protocol.TField Set_SUCCESS_FIELD_DESC =
        new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.SET, (short)0);
    private BaseType type;
    private Set valueSet = null;
    
    public SetBaseType()
    {
        
    }
    
    public SetBaseType(FieldType_Set theFieldTypeParm, ThriftServicesParser theThriftServicesParserParm)
        throws Exception
    {
        type = TypeFactory.generateOneType(theFieldTypeParm.getType(),
            theThriftServicesParserParm);
    }
    
    protected void addOneItem(BaseType theTypeParm)
    {
        if (valueSet == null)
        {
            valueSet = new HashSet();
        }
        
        valueSet.add(theTypeParm);
    }
    
    public String getTypeDescr()
    {
        return "set";
    }
    
    public Class getClassDescr()
    {
        return HashSet.class;
    }
    
    public Object getValue()
    {
        return valueSet;
    }
    
    public TBase deepCopy()
    {
        SetBaseType ret = new SetBaseType();
        ArrayList tmpValueList = new ArrayList();
        HashSet tmpNewSet = new HashSet();
        BaseType tmpOneCloneType = null;
        for (Iterator iter = valueSet.iterator(); iter.hasNext();) {
            BaseType tmpValue = (BaseType)iter.next();
            BaseType tmpNewValueTypeIns = (BaseType)tmpValue.deepCopy();
            tmpNewSet.add(tmpNewValueTypeIns);
        }
        ret.setValue(tmpNewSet);
        return ret;
    }

    public void setValue(Object valueSetParm) {
        this.valueSet = (Set)valueSetParm;
    }
    
    public byte getTType()
    {
        return org.apache.thrift.protocol.TType.SET;
    }
    
    public void writeSuccessReturn(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeFieldBegin(Set_SUCCESS_FIELD_DESC);
        {
            write(oprot, valueParm);
        }
        oprot.writeFieldEnd();
    }
    
    public void write(TProtocol oprot, Object valueParm) throws TException {
        HashSet tmpValueSet = (HashSet)valueParm;
        
        oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRING,
            tmpValueSet.size()));
        for (Object tmpOneValue : tmpValueSet)
        {
            type.write(oprot, tmpOneValue);
        }
        oprot.writeSetEnd();
    }
    
    public void read(org.apache.thrift.protocol.TProtocol iprot)
        throws org.apache.thrift.TException
    {
        valueSet = null;
        org.apache.thrift.protocol.TSet _set10 = iprot.readSetBegin();
        valueSet = new HashSet(2 * _set10.size);
        for (int _i11 = 0; _i11 < _set10.size; ++_i11)
        {
            type.read(iprot);
            valueSet.add(type.getValue());
        }
        iprot.readSetEnd();
    }
    
    @Override
    public Object generateDefaultValue(ConstValue theConstValueParm) {
        HashSet retSet = new HashSet();
        
        ArrayList<ConstValue> tmpItemList =
            (ArrayList)theConstValueParm.getDefaultValue();
        for (ConstValue tmpOneConstValue: tmpItemList)
        {
            retSet.add(type.generateDefaultValue(tmpOneConstValue));
        }
        
        return retSet;
    }
}
