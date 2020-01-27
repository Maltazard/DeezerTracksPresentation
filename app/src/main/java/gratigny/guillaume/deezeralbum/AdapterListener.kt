package gratigny.guillaume.deezeralbum

import gratigny.guillaume.deezeralbum.models.DeezerData

interface AdapterListener {

    fun onAlbumClicked(data: DeezerData)
}