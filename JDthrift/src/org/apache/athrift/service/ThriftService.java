package org.apache.athrift.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.athrift.compiler.Function;
import org.apache.athrift.compiler.Service;

public class ThriftService {
    private String name;
    private ThriftService extendService;
    private HashMap<String, ThriftServiceItem> theFuncNameHMap = new HashMap<String, ThriftServiceItem>();
    
    public ThriftService(Service theServiceParm,
            ThriftServicesParser theThriftServicesParserParm) throws Exception
    {
        name = theServiceParm.getName();
        
        String tmpExtendService = theServiceParm.getExtendService();
        if (tmpExtendService != null)
        {
            ThriftService tmpExtThriftService = (ThriftService)theThriftServicesParserParm.getTheServiceHMap()
                    .get(tmpExtendService);
            if (tmpExtThriftService == null)
            {
                tmpExtThriftService =
                    (ThriftService)ServiceCatalog.getInstance()
                        .getServiceHMap_WithFilePrefix().get(tmpExtendService);
            }
            
            if (tmpExtThriftService == null)
            {
                throw new Exception("没找到对应的extends服务");
            }
            else
            {
                extendService = tmpExtThriftService;
            }
        }
        
        ArrayList<Function> tmpList = theServiceParm.getFunctionList();
        for (int i = 0; i < tmpList.size(); i++)
        {
            Function tmpOneFunction = tmpList.get(i);
            ThriftServiceItem tmpNewItem = new ThriftServiceItem(tmpOneFunction,
                theThriftServicesParserParm);
            theFuncNameHMap.put(tmpNewItem.getName(), tmpNewItem);
        }
    }
    
    public String getName() {
        return name;
    }
    
    public ThriftServiceItem getFuncItem(String funcNameParm)
    {
        ThriftServiceItem retItem = null;
        retItem = theFuncNameHMap.get(funcNameParm);
        
        if (retItem == null)
        {
            if (extendService != null)
            {
                retItem = extendService.getFuncItem(funcNameParm);
            }
        }
        
        return retItem;
    }
}
