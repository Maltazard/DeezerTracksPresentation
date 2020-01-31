package gratigny.guillaume.deezeralbum

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
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
    private lateinit var recyclerViewAdapter: MainRecyclerViewAdapter
    private val viewModel: GridViewModel by viewModel()
    var flagDecoration = false

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

            if (!flagDecoration) {
                recyclerView.addItemDecoration(MarginItemDecoration(resources.getDimension(R.dimen.padding_default).toInt()))
                flagDecoration = true
            }

            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {//todo delete if not resolve
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                        if (deezerData != null) { //todo delete if not resolve
                            if (deezerData.next != null) {
                                Log.e("TRIGGER", "TRIGGER")
                                viewModel.getData(viewModel.getIndex(deezerData.next))
                            }
                        }
                    }
                }

            })//todo delete if not resolve

        }

    override fun onAlbumClicked(data: DeezerData) {
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
