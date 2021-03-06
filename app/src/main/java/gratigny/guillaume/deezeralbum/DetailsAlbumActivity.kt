package gratigny.guillaume.deezeralbum

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import gratigny.guillaume.deezeralbum.databinding.ActivityDetailsAlbumBinding
import gratigny.guillaume.deezeralbum.models.DeezerData
import gratigny.guillaume.deezeralbum.models.TrackList
import gratigny.guillaume.deezeralbum.view.TrackListAdapter
import gratigny.guillaume.deezeralbum.viewmodel.DetailsAlbumViewModel
import kotlinx.android.synthetic.main.activity_details_album.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsAlbumActivity : AppCompatActivity() {

    private lateinit var trackListRecyclerView: RecyclerView
    private lateinit var trackViewAdapter: TrackListAdapter
    private lateinit var errorText: TextView

    private lateinit var bi: ActivityDetailsAlbumBinding
    private val viewModel: DetailsAlbumViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_details_album)
        bi.data = viewModel
        trackListRecyclerView = findViewById(R.id.tracklist_recycler)
        errorText = findViewById(R.id.error_text)

        val obj: DeezerData = intent?.extras?.getParcelable("object")!!
        viewModel.setData(obj)

        viewModel.trackList.observe(this, trackListObserver)
        viewModel.isError.observe(this, noDataObserver)
        setView(obj)
    }

    /**
     * Create an observer for the LiveData of the trackList and set the recyclerView & adapter
     */
    private var trackListObserver: Observer<TrackList> =
        Observer { listOfTrack ->
            trackViewAdapter = TrackListAdapter(this, listOfTrack.data)
            trackListRecyclerView.layoutManager = LinearLayoutManager(this)
            trackListRecyclerView.adapter = trackViewAdapter
        }

    /**
     * Observer for displaying a message in case of missing trackList
     */
    private var noDataObserver: Observer<Boolean> =
        Observer { noData ->
            if (noData == true) {
                trackListRecyclerView.visibility = View.GONE
                error_text.visibility = View.VISIBLE
            }
        }

    /**
     * Set the cover image
     *
     * @param obj the album data
     */
    private fun setView(obj: DeezerData) {
        Glide.with(this)
            .asDrawable()
            .load(obj.cover_xl)
            .placeholder(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.placeholder_cover
                )
            ).into(back_image)
    }

}
