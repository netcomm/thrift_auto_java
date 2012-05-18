package org.apache.athrift.service.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.athrift.compiler.ConstValue;
import org.apache.athrift.compiler.FieldType_HMap;
import org.apache.athrift.service.ThriftServicesParser;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.json.JSONObject;


public class MapBaseType extends BaseType {
    private static final org.apache.thrift.protocol.TField Map_SUCCESS_FIELD_DESC =
        new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.MAP, (short)0);
    
    private BaseType keyType;
    private BaseType valueType;
    private HashMap valueHMap;

    public MapBaseType()
    {
        
    }
    
    public MapBaseType(FieldType_HMap theFieldTypeParm,
        ThriftServicesParser theThriftServicesParserParm)
        throws Exception
    {
        keyType = TypeFactory.generateOneType(theFieldTypeParm.getKeyType(),
            theThriftServicesParserParm);
        valueType = TypeFactory.generateOneType(theFieldTypeParm.getValueType(),
            theThriftServicesParserParm);
    }
    
    protected void addOneItem(BaseType theKeyParm, BaseType theValueParm)
    {
        if (valueHMap == null)
        {
            valueHMap = new HashMap();
        }
        
        valueHMap.put(theKeyParm, theValueParm);
    }
    
    public String getTypeDescr()
    {
        return "map";
    }
    
    public Class getClassDescr()
    {
        return HashMap.class;
    }
    
    public Object getValue()
    {
        return valueHMap;
    }
    
    public TBase deepCopy()
    {
        MapBaseType ret = new MapBaseType();
        ret.setKeyType((BaseType)keyType.deepCopy());
        ret.setValueType((BaseType)valueType.deepCopy());
        
        HashMap tmpCloneValueHMap = new HashMap();
        for (Iterator iter = valueHMap.keySet().iterator(); iter.hasNext();) {
            BaseType tmpKey = (BaseType)iter.next();
            BaseType tmpValue = (BaseType)valueHMap.get(tmpKey);
            BaseType tmpNewKeyTypeIns = (BaseType)tmpKey.deepCopy();
            BaseType tmpNewValueTypeIns = (BaseType)tmpValue.deepCopy();
            tmpCloneValueHMap.put(tmpNewKeyTypeIns, tmpNewValueTypeIns);
        }
        
        ret.setValue(tmpCloneValueHMap);
        return ret;
    }

    public void setKeyType(BaseType keyType) {
        this.keyType = keyType;
    }

    public void setValueType(BaseType valueType) {
        this.valueType = valueType;
    }

    public void setValue(Object valueHMapParm) {
        this.valueHMap = (HashMap)valueHMapParm;
    }
    
    public byte getTType()
    {
        return org.apache.thrift.protocol.TType.MAP;
    }
    
    public void writeSuccessReturn(TProtocol oprot, Object valueParm) throws TException {
        oprot.writeFieldBegin(Map_SUCCESS_FIELD_DESC);
        {
            write(oprot, valueParm);
        }
        oprot.writeFieldEnd();
    }
    
    public void write(TProtocol oprot, Object valueParm) throws TException {
        HashMap<Object, Object> tmpValueHMap = (HashMap)valueParm;
        oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(
            keyType.getTType(), valueType.getTType(), tmpValueHMap.size()));
        for (Map.Entry<Object, Object> tmpOneItem : tmpValueHMap.entrySet())
        {
            keyType.write(oprot, tmpOneItem.getKey());
            valueType.write(oprot, tmpOneItem.getValue());
        }
        oprot.writeMapEnd();
    }
    
    public void read(org.apache.thrift.protocol.TProtocol iprot)
        throws org.apache.thrift.TException
    {
        valueHMap = null;
        org.apache.thrift.protocol.TMap _map6 = iprot.readMapBegin();
        valueHMap = new HashMap(2 * _map6.size);
        for (int _i7 = 0; _i7 < _map6.size; ++_i7)
        {
            keyType.read(iprot);
            Object tmpOneKey = keyType.getValue();
            valueType.read(iprot);
            Object tmpOneValue = valueType.getValue();
            valueHMap.put(tmpOneKey, tmpOneValue);
        }
        iprot.readMapEnd();
    }
    
    @Override
    public Object generateDefaultValue(ConstValue theConstValueParm) {
        HashMap retHMap = new HashMap();
        
        HashMap<ConstValue, ConstValue> tmpHashMapValue =
            (HashMap)theConstValueParm.getDefaultValue();
        for (Map.Entry<ConstValue, ConstValue> tmpOneItem : tmpHashMapValue.entrySet())
        {
            retHMap.put(keyType.generateDefaultValue(tmpOneItem.getKey()),
                        valueType.generateDefaultValue(tmpOneItem.getValue()));
        }
        
        return retHMap;
    }
}
