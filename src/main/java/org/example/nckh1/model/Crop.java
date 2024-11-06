package org.example.nckh1.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "crops")
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cropId;

    private String name;
    private String description;
    private BigDecimal optimalTemp;
    private BigDecimal optimalHumidity;
    private BigDecimal optimalWindSpeed;
    private String wateringSchedule;

    public Long getCropId() {
        return cropId;
    }

    public void setCropId(Long cropId) {
        this.cropId = cropId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getOptimalTemp() {
        return optimalTemp;
    }

    public void setOptimalTemp(BigDecimal optimalTemp) {
        this.optimalTemp = optimalTemp;
    }

    public BigDecimal getOptimalHumidity() {
        return optimalHumidity;
    }

    public void setOptimalHumidity(BigDecimal optimalHumidity) {
        this.optimalHumidity = optimalHumidity;
    }

    public BigDecimal getOptimalWindSpeed() {
        return optimalWindSpeed;
    }

    public void setOptimalWindSpeed(BigDecimal optimalWindSpeed) {
        this.optimalWindSpeed = optimalWindSpeed;
    }

    public String getWateringSchedule() {
        return wateringSchedule;
    }

    public void setWateringSchedule(String wateringSchedule) {
        this.wateringSchedule = wateringSchedule;
    }
}
