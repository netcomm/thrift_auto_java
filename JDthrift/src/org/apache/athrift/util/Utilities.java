package org.apache.athrift.util;

import java.io.File;
import java.io.StringReader;
import java.util.Vector;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;


public class Utilities {
    public static String[] strSplit(String strSource, String delimiter) {
        int intPos = 0;
        String str = null;
        Vector vector = new Vector(5);
        String[] strRet = (String[]) null;

        if (strSource == null)
            return new String[0];
        if (delimiter == null)
            return null;
        if (strSource.equals("")) {
            return new String[0];
        }
        intPos = strSource.indexOf(delimiter);
        String strTemp = "";
        while (intPos != -1) {
            if (intPos != 0) {
                if (strSource.substring(intPos - 1, intPos).equals("\\")) {
                    strTemp = strTemp + strSource.substring(0, intPos - 1) + delimiter;
                    strSource = strSource.substring(intPos + 1);
                    intPos = strSource.indexOf(delimiter);
                    continue;
                }
            }

            str = strTemp + strSource.substring(0, intPos);
            strSource = strSource.substring(intPos + delimiter.length());
            vector.addElement(str);
            strTemp = "";
            intPos = strSource.indexOf(delimiter);
        }
        vector.addElement(strSource);

        strRet = new String[vector.size()];
        System.arraycopy(vector.toArray(), 0, strRet, 0, vector.size());
        return strRet;
    }


    public static Element generateXMLElemFromStr(String xmlDetailStrParm) {
        Element returnElem = null;

        if (!xmlDetailStrParm.equals("")) {
            StringBuffer tmpSBuffer = new StringBuffer(xmlDetailStrParm);

            SAXBuilder builder = new SAXBuilder();
            try {
                Document read_doc = builder.build(new StringReader(tmpSBuffer.toString()));
                returnElem = read_doc.getRootElement();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return returnElem;
    }


    public static String replaceSpecStr(String strParm) {
        String retStr = strParm.replaceAll("'", "1#..#1");
        retStr = replaceSpecStrChar(retStr);
        return retStr;
    }


    public static String replaceSpecStrChar(String strParm) {
        StringBuffer retStrBuf = new StringBuffer();
        char[] tmpChars = strParm.toCharArray();
        for (int i = 0; i < tmpChars.length; i++) {
            if (tmpChars[i] == '\\') {
                if (i + 1 < tmpChars.length) {
                    if (tmpChars[i + 1] == '"') {
                        retStrBuf.append("2#..#2");
                        i++;
                    }
                    else {
                        retStrBuf.append(tmpChars[i]);
                    }
                }
            }
            else {
                retStrBuf.append(tmpChars[i]);
            }
        }

        return retStrBuf.toString();
    }


    public static File findFile(File directoryParm, String name) {
        File retFile = null;
        File[] files = directoryParm.listFiles();
        for (int i = 0; i < files.length; i++) {
            File subFile = files[i];
            if (subFile.isFile() && subFile.getName().equals(name)) {
                retFile = subFile;
                break;
            }
            else if (subFile.isDirectory()) {
                retFile = findFile(subFile, name);
                if (retFile != null)
                {
                    break;
                }
            }
        }
        
        return retFile;
    }
}
