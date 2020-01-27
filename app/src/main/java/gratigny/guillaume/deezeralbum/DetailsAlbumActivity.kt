package gratigny.guillaume.deezeralbum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import gratigny.guillaume.deezeralbum.models.DeezerData

class DetailsAlbumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_album)
        val obj = intent?.extras?.getParcelable<DeezerData>("object")
        println("BITE")
        if (obj != null) {
            println(obj.title)
        }
    }
}
