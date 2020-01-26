package gratigny.guillaume.deezeralbum.network

import gratigny.guillaume.deezeralbum.models.PageResult

class DeezerRepository(private val api: DeezerApiService) {

    suspend fun getAlbumsList(index: Int?): PageResult = api.getAlbumPageAsync(index)
}