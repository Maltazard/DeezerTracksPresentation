package gratigny.guillaume.deezeralbum.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TrackList(
    val data: List<TrackData>,
    val total: Int
)