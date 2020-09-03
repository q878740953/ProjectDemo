package com.ssm.domain;

import com.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品信息
 */
public class Product implements Serializable {
    private int id; // 主键
    private String productNum; // 编号，唯一
    private String productName; // 名字
    private String cityName; // 出发城市
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date DepartureTime; // 出发时间
    private String DepartureTimeStr;
    private Double productPrice; // 产品价格
    private String productDesc; // 产品描述
    private int productStatus; // 产品状态 0关闭 1开启
    private String productStatusStr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(Date departureTime) {
        DepartureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if (DepartureTime!=null){
            DepartureTimeStr = DateUtils.dateFormat(DepartureTime);
        }
        return DepartureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        DepartureTimeStr = departureTimeStr;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (productStatus == 0){
            productStatusStr = "关闭";
        }
        if (productStatus == 1){
            productStatusStr = "开启";
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", DepartureTime=" + DepartureTime +
                ", DepartureTimeStr='" + DepartureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr=" + productStatusStr +
                '}';
    }
}
