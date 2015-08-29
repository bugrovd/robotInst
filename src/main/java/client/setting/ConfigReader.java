package client.setting;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by home on 26.08.2015.
 */
public class ConfigReader {
    private Document doc;//наш XML

    public ConfigReader() {
        File input = new File("setting/setting.xml");//имя файла настроек
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = (Document) db.parse(input);
            doc.getDocumentElement().normalize();
            System.out.println("Главный элемент:" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("account");
            for (int i=0;i<nodeList.getLength();i++) {
                Node node = nodeList.item(i);
                System.out.println(node.getNodeName());
                if (node.getNodeType()== Node.ELEMENT_NODE) {
                    Element e = (Element) node;
                    System.out.println(e.getElementsByTagName("authorization_code").item(0).getTextContent());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parse (Document doc) {

    }
}
