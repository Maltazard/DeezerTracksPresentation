package gratigny.guillaume.deezeralbum.models

data class PageResult(
    val checksum: String,
    val data: List<Data>,
    val next: String,
    val total: Int
)