package Task2.entity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "grow_tips")
public class GrowTips {
    private float temp;
    private boolean lighting;
    private float watering;

    public float getTemp() {
        return temp;
    }

    @XmlElement(name="temp")
    public void setTemp(float temp) {
        this.temp = temp;
    }

    public boolean isLighting() {
        return lighting;
    }

    @XmlElement(name="lighting")
    public void setLighting(boolean lighting) {
        this.lighting = lighting;
    }

    public float getWatering() {
        return watering;
    }

    @XmlElement(name="watering")
    public void setWatering(float watering) {
        this.watering = watering;
    }


}
