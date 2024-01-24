package Task2.entity;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
@XmlRootElement(name = "visual_param")
public class VisualParam {
    private String stemColor;
    private String leafColor;
    private String avgSize;

    public String getStemColor() {
        return stemColor;
    }

    @XmlElement(name="stem_color")
    public void setStemColor(String stemColor) {
        this.stemColor = stemColor;
    }

    public String getLeafColor() {
        return leafColor;
    }

    @XmlElement(name="leaf_color")
    public void setLeafColor(String leafColor) {
        this.leafColor = leafColor;
    }

    public String getAvgSize() {
        return avgSize;
    }

    @XmlElement(name="avg_size")
    public void setAvgSize(String avgSize) {
        this.avgSize = avgSize;
    }
}
