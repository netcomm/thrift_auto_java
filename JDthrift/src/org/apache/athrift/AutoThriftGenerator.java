package org.apache.athrift;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.athrift.compiler.ThriftDescriptor;
import org.apache.athrift.compiler.parser.ThriftParser;
import org.apache.athrift.service.ThriftServicesParser;
import org.apache.athrift.util.Utilities;

public class AutoThriftGenerator {
    public AutoThriftGenerator()
    {
        
    }
    
    public ThriftServicesParser generateAutoThrift(String directoryParm, String fileNameParm)
    {
        ThriftServicesParser retThriftServicesParser = new ThriftServicesParser();
        doGenerate(directoryParm, fileNameParm, retThriftServicesParser);
        return retThriftServicesParser;
    }
    
    private void doGenerate(String directoryParm, String fileNameParm,
            ThriftServicesParser retThriftServicesParserParm)
    {
        System.out.println("thrift配置文件: "+fileNameParm);
        try
        {
            File tmpDirectory = new File(directoryParm);
            File tmpThriftFile = Utilities.findFile(tmpDirectory, fileNameParm);
            ThriftParser parser = new ThriftParser(new FileInputStream(
                tmpThriftFile));
            ThriftDescriptor tmpThriftDescriptor = parser.generateThriftDescriptor();
            
            String tmpThriftName = fileNameParm;
            int tmpPosi = tmpThriftName.lastIndexOf(".thrift");
            if (tmpPosi != -1)
            {
                tmpThriftName = tmpThriftName.substring(0, tmpPosi).trim();
            }
            tmpThriftDescriptor.setThriftName(tmpThriftName);
            
            ArrayList<String> tmpIncludeFileList = tmpThriftDescriptor.getIncludeList();
            for (int i = 0; i < tmpIncludeFileList.size(); i++)
            {
                String tmpIncludeFileName = tmpIncludeFileList.get(i).replaceAll("\"", "");
                doGenerate(directoryParm, tmpIncludeFileName, retThriftServicesParserParm);
            }
            
            retThriftServicesParserParm.generateServices(tmpThriftDescriptor);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
