package com.xhb.j2objc.myapplication.module;

import java.io.Serializable;
import java.util.List;

// error when implements Parcelable interface?
public class JsonPerson implements Serializable {
    private int id;
    private String name;
    private String email;
    private List<PhoneNumber> phoneNumbers;
    private static final long serialVersionUID = 1L;

    public JsonPerson() {
    }

    public static class PhoneNumber implements Serializable {
        private static final long serialVersionUID = 1L;

        private String number;
        private PhoneType phoneType;

        public PhoneNumber(String number) {
            this.number = number;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public PhoneType getPhoneType() {
            return phoneType;
        }

        public void setPhoneType(PhoneType phoneType) {
            this.phoneType = phoneType;
        }

        @Override
        public String toString() {
            return "PhoneNumber{" +
                    "number='" + number + '\'' +
                    ", phoneType=" + phoneType +
                    '}';
        }
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

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public enum PhoneType implements Serializable {
        MOBILE,
        HOME,
        WORK
    }

    @Override
    public String toString() {
        return "JsonPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
