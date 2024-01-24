package Task2.entity;

import Task2.Enums.Multiplying;
import Task2.Enums.Soil;
import Task2.Enums.Multiplying ;
import Task2.Enums.Soil;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "flower")
public class Flower {
    private String name;
    private Soil soil;
    private String origin;
    private VisualParam visualParam;
    private GrowTips growTips;
    private Multiplying multiplying;

    public String getName() {
        return name;
    }

    public Flower() {
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public Soil getSoil() {
        return soil;
    }

    @XmlElement(name = "soil")
    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    @XmlElement(name = "origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public VisualParam getVisualParam() {
        return visualParam;
    }

    @XmlElement(name = "visual_param")
    public void setVisualParam(VisualParam visualParam) {
        this.visualParam = visualParam;
    }

    public GrowTips getGrowTips() {
        return growTips;
    }

    @XmlElement(name = "grow_tips")
    public void setGrowTips(GrowTips growTips) {
        this.growTips = growTips;
    }

    public Multiplying getMultiplying() {
        return multiplying;
    }

    @XmlElement(name = "multiplying")
    public void setMultiplying(Multiplying multiplying) {
        this.multiplying = multiplying;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "Name='" + name + '\'' +
                ", Soil= " + soil.getTitle() +
                ", Origin='" + origin + '\'' +
                ", Visual Parameters:"  +
                " leaf color: " +
                visualParam.getLeafColor() +
                " steam color: " +
                visualParam.getStemColor() +
                " average size: " +
                visualParam.getAvgSize() +
                ", Growing tips: " +
                " temperature: " + growTips.getTemp() +
                " lighting: " + growTips.isLighting() +
                " watering: " + growTips.getWatering() +
                ", Multiplying= " + multiplying.getTitle() +
                '}';
    }
}
