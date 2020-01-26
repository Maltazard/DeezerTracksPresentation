package gratigny.guillaume.deezeralbum

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gratigny.guillaume.deezeralbum.models.PageResult
import gratigny.guillaume.deezeralbum.view.MainRecyclerViewAdapter
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
            recyclerView.layoutManager = GridLayoutManager(this, 2)
            recyclerView.adapter = recyclerViewAdapter
        }

    override fun onAlbumClicked(id: Int) {
        Log.e("CLICK ", id.toString())
        //todo choose data to pass to the second activity
        launchDetailsActivity()
    }

    private fun launchDetailsActivity() {
        val intent = Intent(this, DetailsAlbumActivity::class.java).apply {
            //todo put data here
        }
        startActivity(intent)
    }

}
