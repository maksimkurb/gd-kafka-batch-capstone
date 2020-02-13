package ru.cubly.pet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class HddReportId implements Serializable {
    private String serialNumber;
    private String model;
    private Date date;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HddReportId)) return false;
        HddReportId that = (HddReportId) o;
        return Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(model, that.model) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, model, date);
    }

    @Override
    public String toString() {
        return "HddReportId{" +
                "serialNumber='" + serialNumber + '\'' +
                ", model='" + model + '\'' +
                ", date=" + date +
                '}';
    }
}
