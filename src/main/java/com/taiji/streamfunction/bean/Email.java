package com.taiji.streamfunction.bean;

public class Email {

    private String address;


    public Email(String address) {
        this.address = address;
    }

    public Email() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Email{" +
                "address='" + address + '\'' +
                '}';
    }
}
