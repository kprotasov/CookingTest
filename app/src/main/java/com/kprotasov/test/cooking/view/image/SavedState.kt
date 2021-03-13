package com.kprotasov.test.cooking.view.image

import android.os.Parcel
import android.os.Parcelable
import android.view.View

class SavedState : View.BaseSavedState {

    companion object CREATOR : Parcelable.Creator<SavedState> {
        override fun createFromParcel(parcel: Parcel): SavedState {
            return SavedState(parcel)
        }

        override fun newArray(size: Int): Array<SavedState?> {
            return arrayOfNulls(size)
        }
    }

    var currentImage: Int = 1
    var totalImageCount: Int = 1

    internal constructor(superState: Parcelable?) : super(superState)

    private constructor(parcel: Parcel) : super(parcel) {
        currentImage = parcel.readInt()
        totalImageCount = parcel.readInt()
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeInt(currentImage)
        out.writeInt(totalImageCount)
    }

    override fun describeContents(): Int {
        return 0
    }

}