package org.apache.athrift.service.type;

import org.apache.athrift.compiler.ConstType;
import org.apache.athrift.compiler.ConstValue;
import org.apache.athrift.service.ThriftServicesParser;
import org.json.JSONArray;
import org.json.JSONObject;

public class ThriftConstant {
    private String name;
    private Object theConstantValue;
    private BaseType type;
    private Object defaultValue;
    
    public ThriftConstant(ConstType theConstTypeParm,
            ThriftServicesParser theThriftServicesParserParm) throws Exception
    {
        name = theConstTypeParm.getName();
        type = TypeFactory.generateOneType(theConstTypeParm.getFieldType(),
            theThriftServicesParserParm);
        ConstValue tmpConstValue = theConstTypeParm.getConstValue();
        defaultValue = type.generateDefaultValue(tmpConstValue);
    }

    public String getName() {
        return name;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }
}
