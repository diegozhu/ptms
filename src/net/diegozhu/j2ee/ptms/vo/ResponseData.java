package net.diegozhu.j2ee.ptms.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import net.diegozhu.j2ee.ptms.utils.StatusMessage;

@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseData<T> {

    @XmlElement(name = "status", required = true)
    private int status;

    @XmlElement(name = "data", nillable = false)
    private T data;

    @XmlElement(name = "error", nillable = false)
    private String error;

    public ResponseData() {
        this.status = StatusMessage.SUCCESS_CODE;
    }

    public ResponseData(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
