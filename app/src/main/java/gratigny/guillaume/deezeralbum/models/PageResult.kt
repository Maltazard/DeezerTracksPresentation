package gratigny.guillaume.deezeralbum.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PageResult(
    val checksum: String?,
    var data: List<DeezerData>,
    val prev: String?,
    val next: String?,
    val total: Int
)