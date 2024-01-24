package Task2;

import Task2.Enums.Multiplying;
import Task2.Enums.Soil;
import Task2.entity.Flower;
import Task2.entity.GrowTips;
import Task2.entity.VisualParam;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class XReader {

    XPathFactory factory;
    XPath path;

    public XReader() throws XPathExpressionException, FileNotFoundException {
//         this.factory = XPathFactory.newInstance();
//         this.path = factory.newXPath();

    }

    public void readFlower(String pathFile) throws XPathExpressionException, FileNotFoundException {
        //XPathExpression expression = path.compile("flower");
        //File xml = new File(pathFile);

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;

        try{
            builder = builderFactory.newDocumentBuilder();
            doc = builder.parse(FileLinks.rose);
        }catch (Exception e){
            e.printStackTrace();
        }

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xPath = xpathFactory.newXPath();

        Flower flower = new Flower();

        //InputSource source = new InputSource(new FileInputStream(xml));
        flower.setName(getFlowerName(doc,xPath));
        flower.setSoil(getSoilType(doc,xPath));
        flower.setOrigin(getFlowerOrigin(doc,xPath));
        flower.setMultiplying(getFlowerMiltiplying(doc,xPath));
        flower.setVisualParam(getFlowerVisParam(doc,xPath));
        flower.setGrowTips(getFlowerGrowTips(doc,xPath));

        System.out.println(flower);




        //Object result = expression.evaluate(source, XPathConstants.NODESET);

//        NodeList list = (NodeList) result;
//
//        for (int i =0;i<list.getLength();i++){
//            list.item(1).getFirstChild().getTextContent();
//        }



    }

    public GrowTips getFlowerGrowTips(Document doc, XPath xPath)throws XPathExpressionException{
       GrowTips growTips = new GrowTips();
        XPathExpression expression = xPath.compile("flower/grow_tips");
        NodeList nodeList = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);
        int x =0;

        String[] values = nodeList.item(0).getTextContent().split("\n");

        for (int i =0; i< values.length; i++){
            if (x==3){break;}
            String value = values[i].replaceAll(" ", "");
            if (value.equals("")){
                continue;
            }else {

                switch (x){
                    case 0 :
                        growTips.setTemp(Float.parseFloat(value));
                        x++;
                        break;

                    case 1 :
                        growTips.setLighting(Boolean.parseBoolean(value));
                        x++;
                        break;
                    case 2 :
                        growTips.setWatering(Float.parseFloat(value));
                        x++;
                        break;
                }
            }


        }

       return growTips;
    }
    public VisualParam getFlowerVisParam(Document doc, XPath xPath) throws XPathExpressionException {

        VisualParam vP = new VisualParam();
        XPathExpression expression = xPath.compile("flower/visual_param");
        NodeList nodeList = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);

        int x =0;

        String[] values = nodeList.item(0).getTextContent().split("\n");

        for (int i =0; i< values.length; i++){
            if (x==3){break;}
            String value = values[i].replaceAll(" ", "");
            if (value.equals("")){
                continue;
            }else {

                switch (x){
                    case 0 :
                    vP.setStemColor(value);
                    x++;
                    break;

                    case 1 :
                    vP.setLeafColor(value);
                    x++;
                    break;
                    case 2 :
                    vP.setAvgSize(value);
                    x++;
                    break;
                }
            }


        }

        return vP;

    }

    public Multiplying getFlowerMiltiplying(Document doc, XPath xPath) throws XPathExpressionException {
        Multiplying multiplying = null;
        XPathExpression expression = xPath.compile("flower/multiplying");
        String enumValue = (String) expression.evaluate(doc, XPathConstants.STRING);
        multiplying = Multiplying.valueOf(enumValue.toUpperCase());
        return multiplying;
    }

    public String getFlowerOrigin(Document doc, XPath xPath) throws XPathExpressionException{

        String origin = "";
        XPathExpression expression = xPath.compile("flower/origin");
        origin = (String) expression.evaluate(doc, XPathConstants.STRING);

        return origin;


    }

    public String getFlowerName(Document doc, XPath xPath) throws XPathExpressionException {
        String name = "";
        XPathExpression expression = xPath.compile("flower/name");
        name = (String) expression.evaluate(doc, XPathConstants.STRING);
        return name;
    }

    public Soil getSoilType(Document doc, XPath xPath) throws XPathExpressionException {
       Soil s = null;
        XPathExpression expression = xPath.compile("flower/soil");
        String enumValue = (String) expression.evaluate(doc, XPathConstants.STRING);
        enumValue = enumValue.replaceFirst("-","_");
        s = Soil.valueOf(enumValue.toUpperCase());
       return s;
    }

}
