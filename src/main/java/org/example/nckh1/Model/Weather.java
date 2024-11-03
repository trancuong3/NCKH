
package org.example.nckh1.Model;

public class Weather {
    private String temperature;
    private String humidity;
    private String condition;
    private String wind;


    public Weather() {}

    public Weather(String temperature, String humidity, String condition, String wind) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.condition = condition;
        this.wind = wind;
    }


    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }
}
