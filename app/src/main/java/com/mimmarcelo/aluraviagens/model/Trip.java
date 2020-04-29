package com.mimmarcelo.aluraviagens.model;

import android.content.Context;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Trip implements Serializable {
    private final String local;
    private final String image;
    private final int days;
    private final BigDecimal price;

    public Trip(String local, String image, int days, BigDecimal price) {
        this.local = local;
        this.image = image;
        this.days = days;
        this.price = price;
    }

    public String getLocal() {
        return local;
    }

    public String getImage() {
        return image;
    }

    public int getDays() {
        return days;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getImageResource(Context context) {
        return context.getResources().getIdentifier(image, "drawable", context.getPackageName());
    }

    public String getDaysResource() {
        String days = " days";
        if (this.days == 1) {
            days = " day";
        }
        return this.days + days;
    }

    public String getPriceResource(){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));
        return numberFormat.format(price).replace("R$", "R$ ");
    }
}
