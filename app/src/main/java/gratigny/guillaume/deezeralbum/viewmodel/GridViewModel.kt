package gratigny.guillaume.deezeralbum.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gratigny.guillaume.deezeralbum.models.DeezerData
import gratigny.guillaume.deezeralbum.models.PageResult
import gratigny.guillaume.deezeralbum.network.DeezerRepository
import gratigny.guillaume.deezeralbum.network.ResultWrapper
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
            albumLiveData.value = addInAlbumList(
                albumLiveData,
                apiService.getAlbumsList(index)
            ) //todo Delete la add in list
        }
    }

    private fun addInAlbumList(data: MutableLiveData<PageResult>, album: PageResult): PageResult? {
        return if (data.value != null) {
            val oldData: MutableList<DeezerData> = data.value!!.data as MutableList
            val list = album.data as MutableList
            oldData.addAll(list)
            album.data = oldData
            album
        } else {
            album
        }

        //todo faire un fct pour add les data ajouté dans lancien live data
    }










    fun getIndex(str: String): Int {
        return str.split("index=").last().toInt()
    }

}