package org.apache.athrift;

import java.util.ArrayList;

/**
 * 通用结构类
 * 该类对应thrift配置文件中的struct,所有结构体都用CommonStruct表示
 * @author user
 *
 */
public class CommonStruct {
    private ArrayList<Object[]> values = new ArrayList();
    
    public CommonStruct()
    {
        
    }
    
    /**
     * 添加一个元素
     * @param nameParm: 元素名称
     * @param valueParm: 元素值(任意类型,如int/double/string/list/hashmap/commonStruct等)
     * 
     * 具体使用:
     * 某thrift配置文件片段如下
     * struct UserProfile {
        1: i32 uid,
        2: required string name,
        3: string blurb,
        4: userPosi theuserPosi,
        5: optional TweetType tweetType = TweetType.TWEET
       }
                  则它对应一个CommonStruct实例,具体代码示例如下:
       CommonStruct retCommonStruct = new CommonStruct();
       retCommonStruct.addOneValue("uid", 100);
       retCommonStruct.addOneValue("name", "new world");
       retCommonStruct.addOneValue("blurb", "test");
                    
       CommonStruct tmpPosi = new CommonStruct();
       tmpPosi.addOneValue("posi", "testPosi");
       retCommonStruct.addOneValue("theuserPosi", tmpPosi);
     */
    public void addOneValue(String nameParm, Object valueParm)
    {
        Object[] tmpNewValue = new Object[2];
        tmpNewValue[0] = nameParm;
        tmpNewValue[1] = valueParm;
        values.add(tmpNewValue);
    }
    
    public Object getOneValue(String nameParm)
    {
        for (Object[] tmpOneValues: values)
        {
            if (nameParm.equals(tmpOneValues[0]))
            {
                return tmpOneValues[1];
            }
        }
        
        return null;
    }
    
    public ArrayList<Object[]> getValues() {
        return values;
    }
    
    public String toString()
    {
        StringBuffer retStrBuf = new StringBuffer();
        
        for (Object tmpOneValue: values)
        {
            retStrBuf.append(tmpOneValue+":");
        }
        
        return retStrBuf.toString();
    }
}
