package gratigny.guillaume.deezeralbum.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TrackArtist(
    val id: Int,
    val name: String,
    val tracklist: String,
    val type: String
)