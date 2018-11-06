package kr.co.ezenac.jun0397.flower.beans;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018-03-19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store implements Parcelable{
    private int id;
    private String name;
    private String gu;
    private String dong;
    private double lat;
    private double lon;
    //    private String img_src;
//    private String  call;
//    private String address;

    protected Store(Parcel in) {
        readFormParcel(in);
    }

    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel in) {
            return new Store(in);
        }
        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(gu);
        parcel.writeString(dong);
        parcel.writeDouble(lat);
        parcel.writeDouble(lon);
//        parcel.writeString(img_src);
//        parcel.writeString(call);
//        parcel.writeString(address);
    }
    public void readFormParcel(Parcel in){
        id = in.readInt();
        name = in.readString();
        gu = in.readString();
        dong = in.readString();
        lat = in.readDouble();
        lon = in.readDouble();
//        img_src = in.readString();
//        call = in.readString();
//        address = in.readString();
    }
}
