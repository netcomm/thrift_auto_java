package org.apache.athrift;

import org.apache.athrift.service.ThriftService;
import org.apache.athrift.service.ThriftServiceItem;
import org.apache.athrift.service.ThriftServicesParser;
import org.apache.athrift.service.type.BaseType;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

/**
 * 自动Client类
 * 该类是调用远程服务的入口,最重要的方法是sendRequest,该方法把请求实际发给远程服务
 * @author netcomm
 *
 */
public class AutoClient extends org.apache.thrift.TServiceClient{
    private ThriftService theThriftService;
    
    public AutoClient(TProtocol prot, String serviceNameParm,
            ThriftServicesParser theThriftServicesParserParm) {
        super(prot);
        ThriftService tmpThriftService = (ThriftService)theThriftServicesParserParm
            .getTheServiceHMap().get(serviceNameParm);
        theThriftService = tmpThriftService;
    }

    /**
     * 调用远程服务方法
     * @param methodNameParm: 方法名,对应thrift配置文件中的方法定义(注意大小写的敏感)
     * @param argsParm: 调用参数
     * @return
     * @throws TException: thrift自身处理中的异常
     * @throws CommonException: 相应远程方法的自定义异常,具体使用参考CommonException的注释
     */
    public Object sendRequest(String methodNameParm, CommonArgs argsParm)
        throws TException, CommonException
    {
        ThriftServiceItem tmpThriftServiceItem =
            theThriftService.getFuncItem(methodNameParm);
        argsParm.setThriftServiceItem(tmpThriftServiceItem);
        sendBase(methodNameParm, argsParm);
        
        CommonResult tmpResult = new CommonResult(tmpThriftServiceItem);
        receiveBase(tmpResult, methodNameParm);
        
        if (tmpResult.isSetSuccess()) {
          return tmpResult.getRetValue();
        }
        else if (tmpResult.getRetException() != null) {
            Object[] tmpRetExceptionObjs = tmpResult.getRetException();
            String tmpRetExceptionName = (String)tmpRetExceptionObjs[0];
            CommonStruct tmpCommonStruct =
                (CommonStruct)tmpRetExceptionObjs[1];
            throw new CommonException(tmpRetExceptionName,
                tmpCommonStruct);
        }
        
        throw new org.apache.thrift.TApplicationException(
            org.apache.thrift.TApplicationException.MISSING_RESULT, methodNameParm+" failed: unknown result");
    }
}
