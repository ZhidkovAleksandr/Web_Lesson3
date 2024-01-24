package Task2;

import javax.xml.xpath.XPathExpressionException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws XPathExpressionException, FileNotFoundException {
        XReader xReader = new XReader();
        xReader.readFlower(FileLinks.rose);
    }
}