package com.automation.jQuery.utility.dataRelated;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.error;

public class XMLReaderUtil {

    public Document getData(String filePath) {
        File inputFile = new File(System.getProperty("user.dir") + filePath);
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read(inputFile);
        } catch (DocumentException e) {
            e.printStackTrace();
            error("Error occured while reading data from xml with path " + filePath);

        }
        return document;
    }
}
