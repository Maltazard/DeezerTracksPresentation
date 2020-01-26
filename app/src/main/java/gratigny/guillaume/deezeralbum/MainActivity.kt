package gratigny.guillaume.deezeralbum

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gratigny.guillaume.deezeralbum.models.PageResult
import gratigny.guillaume.deezeralbum.view.MainRecyclerViewAdapater
import gratigny.guillaume.deezeralbum.viewmodel.GridViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewAdapter: MainRecyclerViewAdapater
    private val viewModel: GridViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycle_view)

        viewModel.albumLiveData.observe(this, dataUpdateObserver)
    }

    private var dataUpdateObserver: Observer<PageResult> =
        Observer { deezerData ->
            recyclerViewAdapter = MainRecyclerViewAdapater(this, deezerData.data)
            recyclerView.layoutManager = GridLayoutManager(this, 2)
            recyclerView.adapter = recyclerViewAdapter
        }

}
