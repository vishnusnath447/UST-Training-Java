package org.example.org.entity;

public class Address {
    private int no;
    private String streetName;
    private String city;
    private String state;
    long pinCode;

    public Address(int no, String streetName, String city, String state, long pinCode) {
        this.no = no;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPinCode() {
        return pinCode;
    }

    public void setPinCode(long pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "no=" + no +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}
