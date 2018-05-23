package heu.iot.Server;

import java.io.Serializable;

public class KeepAliveNode implements Serializable {
    private static final long serialVersionUID = 8333474091717582052L;
    private String type;//
    private Object object;
    private String result;

    public KeepAliveNode(String type, Object object, String result) {
        this.type = type;
        this.object = object;
        this.result = result;
    }

    public KeepAliveNode() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
