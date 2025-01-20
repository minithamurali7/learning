package com.example.myapplication.presenter.ui.model

import android.os.Parcel
import android.os.Parcelable

data class UserParcelable(val name:String,val age:Int) : Parcelable {
    constructor(parcel: Parcel):this(parcel.readString()!!,parcel.readInt())

    override fun describeContents(): Int {
     return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeInt(age)
    }

    companion object CREATOR : Parcelable.Creator<UserParcelable> {
        override fun createFromParcel(parcel: Parcel): UserParcelable {
            return UserParcelable(parcel)
        }

        override fun newArray(size: Int): Array<UserParcelable?> {
            return arrayOfNulls(size)
        }
    }
}