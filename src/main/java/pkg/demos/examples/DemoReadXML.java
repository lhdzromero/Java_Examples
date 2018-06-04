package pkg.demos.examples;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;


public class DemoReadXML {

    private static SAXParserFactory       saxFactory;
    private static SAXParser              saxParser;
    private static DefaultHandler         handler;

    private static DocumentBuilderFactory dbFactory;
    private static DocumentBuilder        dBuilder;
    private static Document               doc;


    public static void ReadXMLSAX(String sPath) {
        try {

            System.out.println("");
            System.out.println("Read XML SAX: ");
            saxFactory = SAXParserFactory.newInstance();
            saxParser = saxFactory.newSAXParser();

            handler = new DefaultHandler() {

                boolean bfname  = false;
                boolean blname  = false;
                boolean bnname  = false;
                boolean bsalary = false;


                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start Element: " + qName);

                    if (qName.equalsIgnoreCase("FIRSTNAME"))
                        bfname = true;

                    if (qName.equalsIgnoreCase("LASTNAME"))
                        blname = true;

                    if (qName.equalsIgnoreCase("NICKNAME"))
                        bnname = true;

                    if (qName.equalsIgnoreCase("SALARY"))
                        bsalary = true;
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element: " + qName);
                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    String sTempo = new String(ch, start, length);

                    if (bfname) {
                        System.out.println("First Name: " + sTempo);
                        bfname = false;
                    }

                    if (blname) {
                        System.out.println("Last Name: " + sTempo);
                        blname = false;
                    }

                    if (bnname) {
                        System.out.println("Nick Name: " + sTempo);
                        bnname = false;
                    }

                    if (bsalary) {
                        System.out.println("Salary: " + sTempo);
                        bsalary = false;
                    }

                }

            };

            saxParser.parse(sPath, handler);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("");
        }
    }


    /*
     * https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
     */
    public static void ReadXMLDOM(String spath) {
        try {
            File fXML = new File(spath);
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXML);

            doc.getDocumentElement().normalize();

            System.out.println("Dom Example...");
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("staff");

            System.out.println("------------------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element: " + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element)nNode;

                    System.out.println("Staff id: " + eElement.getAttribute("id"));
                    System.out.println("First Name: " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name: " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Nick Name: " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Salary: " + eElement.getElementsByTagName("salary").item(0).getTextContent());
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void ReadXMLLoop(String spath) {
        try {
            File file = new File(spath);
            dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = dBuilder.parse(file);

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            if (doc.hasChildNodes()) {
                printNote(doc.getChildNodes());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printNote(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node tempNode = nodeList.item(i);

            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("\nNode Name = " + tempNode.getNodeName() + " [OPEN]");
                System.out.println("Node Value = " + tempNode.getTextContent());

                if (tempNode.hasAttributes()) {
                    NamedNodeMap nodeMap = tempNode.getAttributes();
                    for (int j = 0; j < nodeMap.getLength(); j++) {
                        Node node = nodeMap.item(j);
                        System.out.println("Attr Name:  " + node.getNodeName() + " Attr Value: " + node.getNodeValue());
                    }
                }

                if (tempNode.hasChildNodes())
                    printNote(tempNode.getChildNodes());

                System.out.println("Node Name: " + tempNode.getNodeName() + " [CLOSE]");

            }

        }

    }
}
