package gratigny.guillaume.deezeralbum.network

import gratigny.guillaume.deezeralbum.models.PageResult
import gratigny.guillaume.deezeralbum.models.TrackList

class DeezerRepository(private val api: DeezerApiService) {

    suspend fun getAlbumsList(index: Int?): PageResult = api.getAlbumPageAsync(index)

    suspend fun getAlbumTrackList(id : Int): TrackList = api.getTrackListAsync(id)
}