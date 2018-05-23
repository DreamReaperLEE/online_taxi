package heu.iot.Model;

public class OrderClient {
    private Integer id;

    private String clName;

    private String coName;

    private Integer orCid;

    private Integer orEid;

    private String orTime;

    private String orStart;

    private String orEnd;

    private String orSgps;

    private String orEgps;

    private Float orPrice;

    private Integer orState;

    private Integer orCheck;

    private String cltel;

    public String getCltel() {
        return cltel;
    }

    public void setCltel(String cltel) {
        this.cltel = cltel;
    }

    public String getClName() {
        return clName;
    }

    public void setClName(String clName) {
        this.clName = clName;
    }

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrCid() {
        return orCid;
    }

    public void setOrCid(Integer orCid) {
        this.orCid = orCid;
    }

    public Integer getOrEid() {
        return orEid;
    }

    public void setOrEid(Integer orEid) {
        this.orEid = orEid;
    }

    public String getOrTime() {
        return orTime;
    }

    public void setOrTime(String orTime) {
        this.orTime = orTime == null ? null : orTime.trim();
    }

    public String getOrStart() {
        return orStart;
    }

    public void setOrStart(String orStart) {
        this.orStart = orStart == null ? null : orStart.trim();
    }

    public String getOrEnd() {
        return orEnd;
    }

    public void setOrEnd(String orEnd) {
        this.orEnd = orEnd == null ? null : orEnd.trim();
    }

    public String getOrSgps() {
        return orSgps;
    }

    public void setOrSgps(String orSgps) {
        this.orSgps = orSgps == null ? null : orSgps.trim();
    }

    public String getOrEgps() {
        return orEgps;
    }

    public void setOrEgps(String orEgps) {
        this.orEgps = orEgps == null ? null : orEgps.trim();
    }

    public Float getOrPrice() {
        return orPrice;
    }

    public void setOrPrice(Float orPrice) {
        this.orPrice = orPrice;
    }

    public Integer getOrState() {
        return orState;
    }

    public void setOrState(Integer orState) {
        this.orState = orState;
    }

    public Integer getOrCheck() {
        return orCheck;
    }

    public void setOrCheck(Integer orCheck) {
        this.orCheck = orCheck;
    }
}