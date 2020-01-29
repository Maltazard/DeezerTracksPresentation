package gratigny.guillaume.deezeralbum.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gratigny.guillaume.deezeralbum.models.DeezerData
import gratigny.guillaume.deezeralbum.models.PageResult
import gratigny.guillaume.deezeralbum.network.DeezerRepository
import kotlinx.coroutines.launch

class GridViewModel(private val apiService: DeezerRepository) : ViewModel() {

    var albumLiveData: MutableLiveData<PageResult> = MutableLiveData()
    lateinit var albumAll: PageResult
    lateinit var albumList: MutableList<DeezerData>

    init {
        getData(null)
    }

    fun getData(index: Int?) {
        viewModelScope.launch {
            albumLiveData.value = apiService.getAlbumsList(index) //todo mettre ici la fct
        }
    }

/*    private fun addInAlbumLsit(album: PageResult) {
        //todo faire un fct pour add les data ajouté dans lancien live data
        albumAll.data.add(album.data)
        albumLiveData.value = albumAll
    }*/

    fun getIndex(str: String): Int {
        return str.split("index=").last().toInt()
    }

}