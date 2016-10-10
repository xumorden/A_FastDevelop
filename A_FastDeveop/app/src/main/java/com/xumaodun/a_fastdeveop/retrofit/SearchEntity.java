package com.xumaodun.a_fastdeveop.retrofit;

/**
 * Created by xumaodun on 16/6/13.
 */
public class SearchEntity {

    /**
     * ack : true
     * label : please sign in
     * version : 1.0
     * copyright : @2014 上海思蓄力教育科技有限公司
     * timestamp : 1465820411491
     * code : 1004
     * totalItems : 0
     */

    private boolean ack;
    private String label;
    private String version;
    private String copyright;
    private long timestamp;
    private int code;
    private int totalItems;

    public boolean isAck() {
        return ack;
    }

    public void setAck(boolean ack) {
        this.ack = ack;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    public String toString() {
        return "SearchEntity{" +
                "ack=" + ack +
                ", label='" + label + '\'' +
                ", version='" + version + '\'' +
                ", copyright='" + copyright + '\'' +
                ", timestamp=" + timestamp +
                ", code=" + code +
                ", totalItems=" + totalItems +
                '}';
    }
}
