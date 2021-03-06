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
        getData(null)
    }

    /**
     * Get the data (PageResult) from the server
     *
     * @param index the index in cas of a second page is called
     */
    private fun getData(index: Int?) {
        viewModelScope.launch {
            albumLiveData.value = apiService.getAlbumsList(index)
        }
    }

}