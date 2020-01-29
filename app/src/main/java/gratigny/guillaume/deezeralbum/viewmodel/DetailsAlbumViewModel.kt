package gratigny.guillaume.deezeralbum.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gratigny.guillaume.deezeralbum.models.DeezerData
import gratigny.guillaume.deezeralbum.network.DeezerRepository

class DetailsAlbumViewModel(private val apiService: DeezerRepository) : ViewModel() {

    var albumData: MutableLiveData<DeezerData> = MutableLiveData()

    fun setData(selectedAlbum: DeezerData) {
        //todo si binding ne marche pas ici, changer les données ici
        albumData.value = selectedAlbum

    }
}