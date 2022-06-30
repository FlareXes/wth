package com.fireflaredb.bds;

import javafx.beans.property.SimpleStringProperty;

public class ClusterTableView {

    private SimpleStringProperty sno;
    private SimpleStringProperty doner;
    private SimpleStringProperty contact;
    private SimpleStringProperty bloodGroup;
    private SimpleStringProperty age;
    private SimpleStringProperty email;
    private SimpleStringProperty address;


    public ClusterTableView(String sno, String doner, String contact, String bloodGroup, String age, String email, String address) {
        this.sno = new SimpleStringProperty(sno);
        this.doner = new SimpleStringProperty(doner);
        this.contact = new SimpleStringProperty(contact);
        this.bloodGroup = new SimpleStringProperty(bloodGroup);
        this.age = new SimpleStringProperty(age);
        this.email = new SimpleStringProperty(email);
        this.address = new SimpleStringProperty(address);
    }

    public String getSno() {
        return sno.get();
    }

    public SimpleStringProperty snoProperty() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno.set(String.valueOf(sno));
    }

    public String getDoner() {
        return doner.get();
    }

    public SimpleStringProperty donerProperty() {
        return doner;
    }

    public void setDoner(String doner) {
        this.doner.set(doner);
    }

    public String getContact() {
        return contact.get();
    }

    public SimpleStringProperty contactProperty() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact.set(contact);
    }

    public String getBloodGroup() {
        return bloodGroup.get();
    }

    public SimpleStringProperty bloodGroupProperty() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup.set(bloodGroup);
    }

    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(String.valueOf(age));
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }
}