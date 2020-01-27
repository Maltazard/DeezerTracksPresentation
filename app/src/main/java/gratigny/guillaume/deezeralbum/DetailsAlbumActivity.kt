package gratigny.guillaume.deezeralbum

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import gratigny.guillaume.deezeralbum.models.DeezerData


class DetailsAlbumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_album)

        val obj: DeezerData = intent?.extras?.getParcelable("object")!!
        println(obj.title)
    }
}
