package Task2.Enums;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


@XmlRootElement(name = "soil")
@XmlEnum(String.class)
public enum Soil {

    @XmlEnumValue("podzolic")
    PODZOLIC("podzolic"),
    @XmlEnumValue("ground")
    GROUND("ground"),
    @XmlEnumValue("sod-podzolic")
    SOD_PODZOLIC("sod-podzolic");


    private String title;

    Soil(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
