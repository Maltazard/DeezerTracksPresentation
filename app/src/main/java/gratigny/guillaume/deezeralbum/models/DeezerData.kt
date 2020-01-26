package gratigny.guillaume.deezeralbum.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DeezerData(
    val alternative: Alternative?,
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
    val time_add: Int,
    val title: String,
    val tracklist: String,
    val type: String
)