package org.apache.athrift.service.type;

import org.apache.athrift.compiler.Struct;
import org.apache.athrift.service.ThriftServicesParser;
import org.apache.athrift.service.type.struct.ThriftStruct;

public class ExceptionType extends ThriftStruct{

    public ExceptionType(Struct theExceptionTypeParm,
            ThriftServicesParser theThriftServicesParserParm) throws Exception {
        super(theExceptionTypeParm, theThriftServicesParserParm);
    }
}
