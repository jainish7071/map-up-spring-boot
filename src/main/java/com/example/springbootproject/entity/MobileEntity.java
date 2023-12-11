package com.example.springbootproject.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="mobiles")
public class MobileEntity {
    @Id
    @GeneratedValue
    @JoinColumn (name = "mobileId")
    private int id;
    private String name;

    private String detailsList;
    private float effectivePrice;
    private float price;
    private float discount;
    private String deliveryType;
    private String mobileImage;

    public MobileEntity(int id, String name, String detailsList,float effectivePrice, float price, float discount, String deliveryType, String mobileImage) {
        this.id = id;
        this.name = name;
        this.effectivePrice = effectivePrice;
        this.price = price;
        this.discount = discount;
        this.detailsList = detailsList;
        this.deliveryType = deliveryType;
        this.mobileImage = mobileImage;
    }
    public MobileEntity(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDetailsList() {
        return detailsList;
    }

    public void setDetailsList(String detailsList) {
        this.detailsList = detailsList;
    }

    public void setName(String name) {
        this.name = name;
    }


    public float getEffectivePrice() {
        return effectivePrice;
    }

    public void setEffectivePrice(float effectivePrice) {
        this.effectivePrice = effectivePrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getMobileImage() {
        return mobileImage;
    }

    public void setMobileImage(String mobileImage) {
        this.mobileImage = mobileImage;
    }

    @Override
    public String toString(){
        return "name : " + this.name+
                "\ndetailsList : " + this.detailsList.toString()+
                "\nprice : " + this.price+
                "\ndeliveryType : " + this.deliveryType+
                "\neffectivePrice : " + this.effectivePrice;
    }
}
