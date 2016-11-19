package cl.telematica.android.certamen3_p2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by franciscocabezas on 11/18/16.
 */

public class Show implements Parcelable {

    private String showTitle;

    public Show() {

    }

    protected Show(Parcel in) {
        showTitle = in.readString();
    }

    public static final Creator<Show> CREATOR = new Creator<Show>() {
        @Override
        public Show createFromParcel(Parcel in) {
            return new Show(in);
        }

        @Override
        public Show[] newArray(int size) {
            return new Show[size];
        }
    };

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(showTitle);
    }
}
