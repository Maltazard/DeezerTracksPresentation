package gratigny.guillaume.deezeralbum.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gratigny.guillaume.deezeralbum.models.PageResult
import gratigny.guillaume.deezeralbum.network.DeezerRepository
import kotlinx.coroutines.launch

class GridViewModel(private val apiService: DeezerRepository) : ViewModel() {

    var albumLiveData: MutableLiveData<PageResult> = MutableLiveData()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            albumLiveData.value = apiService.getAlbumsList(null)
        }
    }

}