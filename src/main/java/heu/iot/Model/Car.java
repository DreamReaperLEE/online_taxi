package heu.iot.Model;

public class Car {
    private Integer id;

    private String caType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaType() {
        return caType;
    }

    public void setCaType(String caType) {
        this.caType = caType == null ? null : caType.trim();
    }
}