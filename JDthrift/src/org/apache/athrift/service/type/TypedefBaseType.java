package org.apache.athrift.service.type;

import org.apache.athrift.compiler.ConstValue;
import org.apache.athrift.compiler.Typedef;
import org.apache.athrift.service.ThriftServicesParser;

public class TypedefBaseType extends BaseType {
    private String name;
    private BaseType definitionType = null;
    
    public TypedefBaseType(Typedef theOneTypedefParm,
            ThriftServicesParser theThriftServicesParserParm)
        throws Exception
    {
        name = theOneTypedefParm.getName();
        
        definitionType = TypeFactory.generateOneType(
            theOneTypedefParm.getFieldType(),
            theThriftServicesParserParm);
    }

    public String getName() {
        return name;
    }
    
    public byte getTType()
    {
        return definitionType.getTType();
    }

    @Override
    public Object generateDefaultValue(ConstValue theConstValueParm) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setValue(Object valueParm) {
        // TODO Auto-generated method stub
        
    }
}
