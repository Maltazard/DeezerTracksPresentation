package gratigny.guillaume.deezeralbum.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gratigny.guillaume.deezeralbum.models.DeezerData
import gratigny.guillaume.deezeralbum.models.TrackList
import gratigny.guillaume.deezeralbum.network.DeezerRepository
import kotlinx.coroutines.launch

class DetailsAlbumViewModel(private val apiService: DeezerRepository) : ViewModel() {

    var albumData: MutableLiveData<DeezerData> = MutableLiveData()
    var trackList: MutableLiveData<TrackList> = MutableLiveData()

    fun setData(selectedAlbum: DeezerData) {
        //todo si binding ne marche pas ici, changer les données ici
        albumData.value = selectedAlbum
        getAlbumTrackList()
    }

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
        }
    }
}