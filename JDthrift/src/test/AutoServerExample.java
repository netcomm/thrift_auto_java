package test;

import org.apache.athrift.AutoProcessorGenerator;
import org.apache.athrift.AutoThriftGenerator;
import org.apache.athrift.service.ThriftServicesParser;
import org.apache.thrift.TBaseProcessor;
import org.apache.thrift.TException;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class AutoServerExample {
	public static void main(String[] args)
	{
		try {
		    // 第一步: 用户自己编写的业务代码
		    AutoTestHandler handler = new AutoTestHandler();
		    
		    // 第二步: 生成对应thrift配置文件解析引擎，并生成自动TProcessor实例
		    AutoThriftGenerator tmpAutoThriftGenerator = new AutoThriftGenerator();
		    ThriftServicesParser tmpThriftServicesParser =
		        tmpAutoThriftGenerator.generateAutoThrift("D:/资料/thrift", "firstTest.thrift");
		    AutoProcessorGenerator tmpAutoProcessorGenerator = new AutoProcessorGenerator();
		    TBaseProcessor tmpProcessor = tmpAutoProcessorGenerator.generate("UserStorage", handler, tmpThriftServicesParser);
			
		    // 第三步: 启动服务
		    TServerTransport serverTransport = new TServerSocket(9090);
	        TServer server = new TSimpleServer(new Args(serverTransport).processor(tmpProcessor));
	        System.out.println("Starting the simple server...");
	        server.serve();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
