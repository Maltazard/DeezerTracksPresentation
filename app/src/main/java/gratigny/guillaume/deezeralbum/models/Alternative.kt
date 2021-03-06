package gratigny.guillaume.deezeralbum.models

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Alternative(
    val artist: Artist,
    val available: Boolean,
    val cover: String,
    val cover_big: String,
    val cover_medium: String,
    val cover_small: String,
    val cover_xl: String,
    val explicit_lyrics: Boolean,
    val id: Int,
    val link: String,
    val nb_tracks: Int,
    val record_type: String,
    val release_date: String,
    val title: String,
    val tracklist: String,
    val type: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable<Artist>(Artist::class.java.classLoader),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(artist, 0)
        parcel.writeByte(if (available) 1 else 0)
        parcel.writeString(cover)
        parcel.writeString(cover_big)
        parcel.writeString(cover_medium)
        parcel.writeString(cover_small)
        parcel.writeString(cover_xl)
        parcel.writeByte(if (explicit_lyrics) 1 else 0)
        parcel.writeInt(id)
        parcel.writeString(link)
        parcel.writeInt(nb_tracks)
        parcel.writeString(record_type)
        parcel.writeString(release_date)
        parcel.writeString(title)
        parcel.writeString(tracklist)
        parcel.writeString(type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Alternative> {
        override fun createFromParcel(parcel: Parcel): Alternative {
            return Alternative(parcel)
        }

        override fun newArray(size: Int): Array<Alternative?> {
            return arrayOfNulls(size)
        }
    }
}