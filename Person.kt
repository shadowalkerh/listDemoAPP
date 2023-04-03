package com.example.listdemo

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable

data class Person(
    val name:String,
    val secondName:String,
    val age: Int,
    val photoId: Int,
    val photo:Bitmap? =null
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readParcelable(Bitmap::class.java.classLoader)
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(secondName)
        parcel.writeInt(age)
        parcel.writeInt(photoId)
        parcel.writeParcelable(photo, flags)
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}