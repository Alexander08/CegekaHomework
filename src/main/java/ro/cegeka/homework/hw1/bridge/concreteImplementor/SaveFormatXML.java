package ro.cegeka.homework.hw1.bridge.concreteImplementor;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.cegeka.homework.hw1.bridge.implementor.SaveFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Date;

/**
 * Created by John Smith on 14.04.2016.
 */
public class SaveFormatXML implements SaveFormat {

    public void printObject(String name, String form, Double price, Double weight, Date expireDate) {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("CandyBag");
            doc.appendChild(rootElement);

            Element candy = doc.createElement("candy");
            rootElement.appendChild(candy);

            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            candy.setAttributeNode(attr);

            Element candyName = doc.createElement("name");
            candyName.appendChild(doc.createTextNode(name));
            candy.appendChild(candyName);

            Element candyForm = doc.createElement("form");
            candyForm.appendChild(doc.createTextNode(form));
            candy.appendChild(candyForm);

            Element candyPrice = doc.createElement("price");
            candyPrice.appendChild(doc.createTextNode(price.toString()));
            candy.appendChild(candyPrice);

            Element candyWeight = doc.createElement("weight");
            candyWeight.appendChild(doc.createTextNode(weight.toString()));
            candy.appendChild(candyWeight);

            Element candyExpireDate = doc.createElement("expireDate");
            candyExpireDate.appendChild(doc.createTextNode(expireDate.toString()));
            candy.appendChild(candyExpireDate);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("candy.xml"));

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
