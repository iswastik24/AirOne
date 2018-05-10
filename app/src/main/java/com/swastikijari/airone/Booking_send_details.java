package com.swastikijari.airone;

import android.widget.EditText;

import java.lang.ref.SoftReference;

import javax.sql.StatementEvent;

/**
 * Created by swastik ijari on 17-04-2018.
 */

public class Booking_send_details {
    public String source;
    public String dest;
    public String doj;
    public String bord_pt;
    public String drop_pt;
    public String email_user;
    public String phon_no;
    public String user_name;
    public String age;
    public String booking_id;
    public String seats_name;
    public String busnumber;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getBord_pt() {
        return bord_pt;
    }

    public void setBord_pt(String bord_pt) {
        this.bord_pt = bord_pt;
    }

    public String getDrop_pt() {
        return drop_pt;
    }

    public void setDrop_pt(String drop_pt) {
        this.drop_pt = drop_pt;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getPhon_no() {
        return phon_no;
    }

    public void setPhon_no(String phon_no) {
        this.phon_no = phon_no;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }

    public String getSeats_name() {
        return seats_name;
    }

    public void setSeats_name(String seats_name) {
        this.seats_name = seats_name;
    }

    public String getBusnumber() {
        return busnumber;
    }

    public void setBusnumber(String busnumber) {
        this.busnumber = busnumber;
    }

    public Booking_send_details(String source, String dest, String doj, String bord_pt, String drop_pt, String email_user,
                                String phon_no, String user_name, String age1, String booking_id, String seats_name, String busnumber) {
        this.source = source;
        this.dest = dest;
        this.doj = doj;
        this.bord_pt = bord_pt;
        this.drop_pt = drop_pt;
        this.email_user = email_user;
        this.phon_no = phon_no;
        this.user_name = user_name;
        this.age = age1;
        this.booking_id = booking_id;
        this.seats_name = seats_name;
        this.busnumber=busnumber;

    }
}
