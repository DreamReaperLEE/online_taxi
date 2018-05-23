package heu.iot.Model;

public class Client {
    private Integer id;

    private String clName;

    private String clTel;

    private Integer clCompany;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClName() {
        return clName;
    }

    public void setClName(String clName) {
        this.clName = clName == null ? null : clName.trim();
    }

    public String getClTel() {
        return clTel;
    }

    public void setClTel(String clTel) {
        this.clTel = clTel == null ? null : clTel.trim();
    }

    public Integer getClCompany() {
        return clCompany;
    }

    public void setClCompany(Integer clCompany) {
        this.clCompany = clCompany;
    }
}