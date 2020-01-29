package gratigny.guillaume.deezeralbum.network

import gratigny.guillaume.deezeralbum.models.PageResult
import gratigny.guillaume.deezeralbum.models.TrackList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DeezerApiService {

    @GET("user/2529/albums")
    suspend fun getAlbumPageAsync(@Query("index") index: Int?): PageResult

    @GET("album/{id}/tracks")
    suspend fun getTrackListAsync(@Path("id") albumId: Int): TrackList
}