package org.apache.athrift;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.athrift.service.ThriftService;
import org.apache.athrift.service.ThriftServiceItem;
import org.apache.athrift.service.ThriftServicesParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AutoProcessorGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutoProcessorGenerator.class.getName());
    private Object theHandler;
    private ThriftServicesParser theThriftServicesParser;
    private HashMap<String, org.apache.thrift.ProcessFunction> theFuncHMap =
        new HashMap<String, org.apache.thrift.ProcessFunction>();

    public AutoProcessorGenerator() {
        
    }
    
    public AutoProcessor generate(String serviceNameParm, Object theHandlerParm,
            ThriftServicesParser theThriftServicesParserParm)
    {
        ThriftService tmpThriftService = (ThriftService)theThriftServicesParserParm
            .getTheServiceHMap().get(serviceNameParm);
        getProcessMap(theFuncHMap, theHandlerParm, tmpThriftService);
        //Wrapper wrapper = Wrapper.getWrapper(theHandlerParm.getClass());
        AutoProcessor retAutoProcessor = new AutoProcessor(theHandlerParm, theFuncHMap);
        return retAutoProcessor;
    }
    
    private void getProcessMap(
            Map<String, org.apache.thrift.ProcessFunction> processMap,
            Object theHandlerParm, ThriftService theThriftServiceParm) {
        Method[] methods = theHandlerParm.getClass().getMethods();
        for( Method m : methods )
        {
            if( m.getDeclaringClass() == Object.class ) //ignore Object's method.
            {
                continue;
            }
            
            String tmpMethodName = m.getName();
            ThriftServiceItem tmpServiceItem = theThriftServiceParm.getFuncItem(tmpMethodName);
            processMap.put(tmpMethodName, new AutoProcessFunction(tmpMethodName, tmpServiceItem));
        }
    }
    
    protected class AutoProcessor extends org.apache.thrift.TBaseProcessor implements org.apache.thrift.TProcessor {
        protected AutoProcessor(Object iface, Map processFunctionMap) {
            super(iface, processFunctionMap);
            // TODO Auto-generated constructor stub
        }
    }
}
