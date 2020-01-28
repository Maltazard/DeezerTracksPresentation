package gratigny.guillaume.deezeralbum

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import gratigny.guillaume.deezeralbum.databinding.ActivityDetailsAlbumBinding
import gratigny.guillaume.deezeralbum.models.DeezerData
import gratigny.guillaume.deezeralbum.viewmodel.DetailsAlbumViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class DetailsAlbumActivity : AppCompatActivity() {

    private lateinit var bi: ActivityDetailsAlbumBinding
    private val viewModel: DetailsAlbumViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_details_album)
        bi.data = viewModel

        val obj: DeezerData = intent?.extras?.getParcelable("object")!!
        viewModel.setData(obj)

    }
}
