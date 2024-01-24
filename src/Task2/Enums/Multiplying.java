package Task2.Enums;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlRootElement(name = "multiplying")
@XmlEnum(String.class)
public enum Multiplying {
    @XmlEnumValue("leafs")
    LEAFS("leafs"),
    @XmlEnumValue("leafs")
    CUTTINGS("cuttings"),
    @XmlEnumValue("seeds")
    SEEDS("seeds");

    private String title;

    Multiplying(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
