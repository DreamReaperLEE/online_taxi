package heu.iot.Model;

public class Company {
    private Integer id;

    private String coName;

    private String coAdminname;

    private String coAdmintel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName == null ? null : coName.trim();
    }

    public String getCoAdminname() {
        return coAdminname;
    }

    public void setCoAdminname(String coAdminname) {
        this.coAdminname = coAdminname == null ? null : coAdminname.trim();
    }

    public String getCoAdmintel() {
        return coAdmintel;
    }

    public void setCoAdmintel(String coAdmintel) {
        this.coAdmintel = coAdmintel == null ? null : coAdmintel.trim();
    }
}