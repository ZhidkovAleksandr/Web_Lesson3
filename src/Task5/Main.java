package Task5;

import Task2.FileLinks;
import Task2.entity.Flower;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class Main {
    public static void main(String[] args) {
        Flower flower = new Flower();

        try {
            File file = new File(FileLinks.rose);
            JAXBContext jaxbContext = JAXBContext.newInstance(Flower.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            flower = (Flower) unmarshaller.unmarshal(file);
            System.out.println(flower);
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }

}
