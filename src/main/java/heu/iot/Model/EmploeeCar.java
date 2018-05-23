package heu.iot.Model;

public class EmploeeCar {
    private Integer id;

    private String emName;

    private String emPassword;

    private Integer emPriv;

    private Integer emCartype;

    public String getEmTel() {
        return emTel;
    }

    public void setEmTel(String emTel) {
        this.emTel = emTel;
    }

    private String emTel;

    public String getCaType() {
        return caType;
    }

    public void setCaType(String caType) {
        this.caType = caType;
    }

    private String  caType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmName() {
        return emName;
    }

    public void setEmName(String emName) {
        this.emName = emName == null ? null : emName.trim();
    }

    public String getEmPassword() {
        return emPassword;
    }

    public void setEmPassword(String emPassword) {
        this.emPassword = emPassword == null ? null : emPassword.trim();
    }

    public Integer getEmPriv() {
        return emPriv;
    }

    public void setEmPriv(Integer emPriv) {
        this.emPriv = emPriv;
    }

    public Integer getEmCartype() {
        return emCartype;
    }

    public void setEmCartype(Integer emCartype) {
        this.emCartype = emCartype;
    }
}