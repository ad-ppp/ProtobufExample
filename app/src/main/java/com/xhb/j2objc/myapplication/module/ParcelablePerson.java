package com.xhb.j2objc.myapplication.module;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class ParcelablePerson implements Parcelable {
    private int id;
    private String name;
    private String email;
    private List<JsonPerson.PhoneNumber> phoneNumbers;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.email);
        dest.writeList(this.phoneNumbers);
    }

    public ParcelablePerson() {
    }

    private ParcelablePerson(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.email = in.readString();
        this.phoneNumbers = new ArrayList<>();
        in.readList(this.phoneNumbers, JsonPerson.PhoneNumber.class.getClassLoader());
    }

    public static final Creator<ParcelablePerson> CREATOR = new Creator<ParcelablePerson>() {
        @Override
        public ParcelablePerson createFromParcel(Parcel source) {
            return new ParcelablePerson(source);
        }

        @Override
        public ParcelablePerson[] newArray(int size) {
            return new ParcelablePerson[size];
        }
    };

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

    public List<JsonPerson.PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<JsonPerson.PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "ParcelablePerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
