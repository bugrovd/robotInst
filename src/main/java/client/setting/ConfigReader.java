package client.setting;

import instagram.application.Client;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by home on 26.08.2015.
 */
public class ConfigReader {
    private Document doc;//наш XML
    private final String PATH = "setting/setting.xml";

    public ConfigReader() {
        File input = new File(PATH);//имя файла настроек
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = (Document) db.parse(input);
            //doc.getDocumentElement().normalize();
/*            System.out.println("Главный элемент:" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("account");

                }    for (int i=0;i<nodeList.getLength();i++) {
                Node node = nodeList.item(i);
                System.out.println(node.getNodeName());
                if (node.getNodeType()== Node.ELEMENT_NODE) {
                    Element e = (Element) node;
System.out.println(e.getElementsByTagName("authorization_code").item(0).getTextContent());
            }*/
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Client> getClients () throws TransformerException {
        ArrayList<Client> list = new ArrayList<Client>();
        NodeList nodeList = doc.getElementsByTagName("client");
        for (int i=0;i<nodeList.getLength();i++) {
            Node node = nodeList.item(i);
            //System.out.println(node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) node;
                Client client = new Client(e.getElementsByTagName("client_name").item(0).getTextContent(),
                        e.getElementsByTagName("client_id").item(0).getTextContent(),
                        e.getElementsByTagName("client_secret").item(0).getTextContent());
                //e.getElementsByTagName("client_secret").item(0).setTextContent("1233333333333");
                //saveReader();
                list.add(client);
            }
        }
        return list;
    }
    public ArrayList<Account> getAccounts () {
        ArrayList<Account> list = new ArrayList<Account>();
        NodeList nodeList = doc.getElementsByTagName("account");
        for (int i=0;i<nodeList.getLength();i++) {
            Node node = nodeList.item(i);
            //System.out.println(node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) node;
                Account account = new Account(e.getElementsByTagName("access_token").item(0).getTextContent(),
                        e.getElementsByTagName("user_id").item(0).getTextContent(),
                        e.getElementsByTagName("user_name").item(0).getTextContent(),
                        e.getElementsByTagName("full_name").item(0).getTextContent());
                list.add(account);
            }
        }
        return list;
    }
    public void addAccount (Account a) throws TransformerException {
        Node accounts = doc.getElementsByTagName("accounts").item(0);
        Element account = doc.createElement("account");
        accounts.appendChild(account);

        Element accessToken = doc.createElement("access_token");
        accessToken.appendChild(doc.createTextNode(a.getAccessToken()));
        account.appendChild(accessToken);

        Element userId = doc.createElement("user_id");
        userId.appendChild(doc.createTextNode(a.getUserId()));
        account.appendChild(userId);

        Element userName = doc.createElement("user_name");
        userName.appendChild(doc.createTextNode(a.getUserName()));
        account.appendChild(userName);

        Element fullName = doc.createElement("full_name");
        fullName.appendChild(doc.createTextNode(a.getFullName()));
        account.appendChild(fullName);

        saveReader();
    }
    public void saveReader () throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(PATH));
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
