package com.swastikijari.airone;

import com.google.firebase.database.DatabaseReference;

import java.lang.ref.SoftReference;

/**
 * Created by swastik ijari on 08-04-2018.
 */

public class Custom_Bus_list {
    private String traveller;
    private String dep_time;
    private String arr_time;
    private String  sleeper;
    private double seats;
    private String seats_desc;
    private String rating;
    private String rating_desc;
    private double fare;
    public Custom_Bus_list(){

    }
    public Custom_Bus_list(String traveller, String dep_time, String arr_time, String sleeper,
                           double seats, String seats_desc, String rating, String rating_desc, double fare) {
        this.traveller = traveller;
        this.dep_time = dep_time;
        this.arr_time = arr_time;
        this.sleeper = sleeper;
        this.seats = seats;
        this.seats_desc = seats_desc;
        this.rating = rating;
        this.rating_desc = rating_desc;
        this.fare = fare;
    }
    public String getTraveller() {

        return traveller;
    }

    public void setTraveller(String traveller) {
        this.traveller = traveller;
    }

    public String getDep_time() {
        return dep_time;
    }

    public void setDep_time(String dep_time) {
        this.dep_time = dep_time;
    }

    public String getArr_time() {
        return arr_time;
    }

    public void setArr_time(String arr_time) {
        this.arr_time = arr_time;
    }

    public String getSleeper() {
        return sleeper;
    }

    public void setSleeper(String sleeper) {
        this.sleeper = sleeper;
    }

    public double getSeats() {
        return seats;
    }

    public void setSeats(double seats) {
        this.seats = seats;
    }

    public String getSeats_desc() {
        return seats_desc;
    }

    public void setSeats_desc(String seats_desc) {
        this.seats_desc = seats_desc;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating_desc() {
        return rating_desc;
    }

    public void setRating_desc(String rating_desc) {
        this.rating_desc = rating_desc;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }


}
