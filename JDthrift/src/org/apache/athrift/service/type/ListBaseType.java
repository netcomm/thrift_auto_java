package org.apache.athrift.service.type;

import java.util.ArrayList;

import org.apache.athrift.compiler.ConstValue;
import org.apache.athrift.compiler.FieldType_List;
import org.apache.athrift.service.ThriftServicesParser;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.json.JSONArray;

public class ListBaseType extends BaseType {
    private static final org.apache.thrift.protocol.TField List_SUCCESS_FIELD_DESC =
        new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.LIST, (short)0);
    private BaseType type;
    private ArrayList valueList = null;
    
    public ListBaseType()
    {
        
    }
    
    public ListBaseType(FieldType_List theFieldTypeParm, ThriftServicesParser theThriftServicesParserParm)
        throws Exception
    {
        type = TypeFactory.generateOneType(theFieldTypeParm.getType(),
            theThriftServicesParserParm);
    }
    
    protected void addOneItem(BaseType theTypeParm)
    {
        if (valueList == null)
        {
            valueList = new ArrayList();
        }
        
        valueList.add(theTypeParm);
    }
    
    public String getTypeDescr()
    {
        return "list";
    }
    
    public Class getClassDescr()
    {
        return ArrayList.class;
    }
    
    public Object getValue()
    {
        return valueList;
    }
    
    public TBase deepCopy()
    {
        ListBaseType ret = new ListBaseType();
        ArrayList tmpValueList = new ArrayList();
        BaseType tmpOneType = null;
        BaseType tmpOneCloneType = null;
        for (int i = 0; i < valueList.size(); i++)
        {
            tmpOneType = (BaseType)valueList.get(i);
            tmpOneCloneType = (BaseType)tmpOneType.deepCopy();
            tmpValueList.add(tmpOneCloneType);
        }
        ret.setValue(tmpValueList);
        return ret;
    }

    public void setValue(Object valueListParm) {
        this.valueList = (ArrayList)valueListParm;
    }
    
    public byte getTType()
    {
        return org.apache.thrift.protocol.TType.LIST;
    }
    
    public void writeSuccessReturn(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeFieldBegin(List_SUCCESS_FIELD_DESC);
        {
            write(oprot, valueParm);
        }
        oprot.writeFieldEnd();
    }
    
    public void write(TProtocol oprot, Object valueParm) throws TException {
        ArrayList tmpValueList = (ArrayList)valueParm;
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(
            org.apache.thrift.protocol.TType.STRING, tmpValueList.size()));
        for (Object tmpOneValue : tmpValueList)
        {
            type.write(oprot, tmpOneValue);
        }
        oprot.writeListEnd();
    }
    
    public void read(org.apache.thrift.protocol.TProtocol iprot)
        throws org.apache.thrift.TException
    {
        valueList = null;
        valueList = new ArrayList();
        org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
        for (int _i1 = 0; _i1 < _list0.size; ++_i1)
        {
            type.read(iprot);
            valueList.add(type.getValue());
        }
        iprot.readListEnd();
    }
    
    @Override
    public Object generateDefaultValue(ConstValue theConstValueParm) {
        ArrayList retList = new ArrayList();
        
        ArrayList<ConstValue> tmpItemList =
            (ArrayList)theConstValueParm.getDefaultValue();
        for (ConstValue tmpOneConstValue: tmpItemList)
        {
            retList.add(type.generateDefaultValue(tmpOneConstValue));
        }
        
        return retList;
    }
}
