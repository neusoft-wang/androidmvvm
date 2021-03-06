package com.github.wtopolski.mvvmsampleapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.github.wtopolski.libmvvm.view.ColorationSeekBar;

/**
 * Created by wojciechtopolski on 05/05/16.
 */
public class ColorForm implements Parcelable {
    private String name;
    private String description;
    private String color;
    private ColorationSeekBar.ColorationType coloration;
    private boolean favorite;

    public ColorForm() {
    }

    public ColorForm(String name, String description, String color, ColorationSeekBar.ColorationType coloration, boolean favorite) {
        this.name = name;
        this.description = description;
        this.color = color;
        this.coloration = coloration;
        this.favorite = favorite;
    }

    protected ColorForm(Parcel in) {
        name = in.readString();
        description = in.readString();
        color = in.readString();
        coloration = ColorationSeekBar.ColorationType.valueOf(in.readString());
        favorite = in.readInt() == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(color);
        dest.writeString(coloration.name());
        dest.writeInt(favorite ? 1 : 0);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ColorForm> CREATOR = new Creator<ColorForm>() {
        @Override
        public ColorForm createFromParcel(Parcel in) {
            return new ColorForm(in);
        }

        @Override
        public ColorForm[] newArray(int size) {
            return new ColorForm[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public ColorationSeekBar.ColorationType getColoration() {
        return coloration;
    }

    public void setColoration(ColorationSeekBar.ColorationType coloration) {
        this.coloration = coloration;
    }

    @Override
    public String toString() {
        return  "" + name + " - " + description + " " + color + " " + coloration;
    }
}
