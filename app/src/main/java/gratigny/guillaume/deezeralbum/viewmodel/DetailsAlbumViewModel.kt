package gratigny.guillaume.deezeralbum.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gratigny.guillaume.deezeralbum.extension.dateFormat
import gratigny.guillaume.deezeralbum.models.DeezerData
import gratigny.guillaume.deezeralbum.models.TrackList
import gratigny.guillaume.deezeralbum.network.DeezerRepository
import kotlinx.coroutines.launch

class DetailsAlbumViewModel(private val apiService: DeezerRepository) : ViewModel() {

    var albumData: MutableLiveData<DeezerData> = MutableLiveData()
    var trackList: MutableLiveData<TrackList> = MutableLiveData()
    var isError: MutableLiveData<Boolean> = MutableLiveData(false)

    /**
     * Set data in a object before calling getAlbumTrackList for having the details of a tracklist
     * @param selectedAlbum an album
     */
    fun setData(selectedAlbum: DeezerData) {
        selectedAlbum.release_date = selectedAlbum.release_date.dateFormat()
        albumData.value = selectedAlbum
        getAlbumTrackList()
    }

    /**
     * Check if the trackList is available and if it is request the details
     */
    private fun getAlbumTrackList() {
        var id: Int? = null
        if (albumData.value != null) {
            val data: DeezerData = albumData.value!!
            if (data.available && data.nb_tracks != 0) {
                id = data.id
            } else if (!data.available && data.alternative != null && data.nb_tracks != 0) {
                id = data.alternative.id
            }
        }

        if (id != null) {
            viewModelScope.launch {
                trackList.postValue(apiService.getAlbumTrackList(id))
            }
        } else {
            isError.value = true
        }
    }
}