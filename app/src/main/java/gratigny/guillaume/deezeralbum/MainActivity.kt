package gratigny.guillaume.deezeralbum

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gratigny.guillaume.deezeralbum.models.DeezerData
import gratigny.guillaume.deezeralbum.models.PageResult
import gratigny.guillaume.deezeralbum.view.MainRecyclerViewAdapter
import gratigny.guillaume.deezeralbum.view.MarginItemDecoration
import gratigny.guillaume.deezeralbum.viewmodel.GridViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), AdapterListener {

    private lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewAdapter: MainRecyclerViewAdapter
    private val viewModel: GridViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycle_view)

        viewModel.albumLiveData.observe(this, dataUpdateObserver)
    }

    private var dataUpdateObserver: Observer<PageResult> =
        Observer { deezerData ->
            recyclerViewAdapter = MainRecyclerViewAdapter(this, deezerData.data, this)
            recyclerView.layoutManager = GridLayoutManager(this, 3)
            recyclerView.adapter = recyclerViewAdapter
            recyclerView.addItemDecoration(MarginItemDecoration(resources.getDimension(R.dimen.padding_default).toInt()))
        }

    override fun onAlbumClicked(data: DeezerData) {
        //todo choose data to pass to the second activity
        launchDetailsActivity(data)
    }

    private fun launchDetailsActivity(data: DeezerData) {
        val intent = Intent(this, DetailsAlbumActivity::class.java).apply {
            //todo first is id for get the correct album, second is TEMPORARY before the use of cache or db
            putExtra("id", data.id)
            putExtra("object", data)
        }
        startActivity(intent)
    }

}
