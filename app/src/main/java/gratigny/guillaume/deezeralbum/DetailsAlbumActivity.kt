package gratigny.guillaume.deezeralbum

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import gratigny.guillaume.deezeralbum.databinding.ActivityDetailsAlbumBinding
import gratigny.guillaume.deezeralbum.models.DeezerData
import gratigny.guillaume.deezeralbum.viewmodel.DetailsAlbumViewModel
import kotlinx.android.synthetic.main.activity_details_album.*
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

        setView(obj)
    }

    private fun setView(obj: DeezerData) {
        Glide.with(this)
            .asDrawable()
            .load(obj.cover_xl)
            .placeholder(
                ContextCompat.getDrawable(
                    this,
                    R.mipmap.placeholder
                )
            ).into(back_image)
    }

}
