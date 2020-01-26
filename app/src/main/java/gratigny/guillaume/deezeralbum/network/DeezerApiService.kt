package gratigny.guillaume.deezeralbum.network

import gratigny.guillaume.deezeralbum.models.PageResult
import retrofit2.http.GET
import retrofit2.http.Query

interface DeezerApiService {

    @GET("albums")
    suspend fun getAlbumPageAsync(@Query("index") index: Int?): PageResult

}