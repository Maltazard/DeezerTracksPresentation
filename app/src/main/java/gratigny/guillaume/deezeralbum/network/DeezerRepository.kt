package gratigny.guillaume.deezeralbum.network

import gratigny.guillaume.deezeralbum.models.PageResult
import gratigny.guillaume.deezeralbum.models.TrackList

class DeezerRepository(private val api: DeezerApiService) {

    /**
     * Call the api call for the albumList
     *
     * @param index the index of the page
     * @return a PageResult
     */
    suspend fun getAlbumsList(index: Int?): PageResult = api.getAlbumPageAsync(index)

    /**
     * Call the api call for the TrackList
     *
     * @param id the id of the album for the trackList
     * @return a TrackList
     */
    suspend fun getAlbumTrackList(id: Int): TrackList = api.getTrackListAsync(id)

}