package com.example.logindanregistrasi

import android.os.Parcel
import android.os.Parcelable

class ItemData(
    val gambar: Int,
    val nama: String,
    val harga: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(gambar)
        parcel.writeString(nama)
        parcel.writeString(harga)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ItemData> {
        override fun createFromParcel(parcel: Parcel): ItemData = ItemData(parcel)
        override fun newArray(size: Int): Array<ItemData?> = arrayOfNulls(size)
    }
}
