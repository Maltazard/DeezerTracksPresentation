package gratigny.guillaume.deezeralbum

import androidx.multidex.MultiDexApplication
import gratigny.guillaume.deezeralbum.network.DeezerNetworkModule
import gratigny.guillaume.deezeralbum.network.DeezerRepository
import gratigny.guillaume.deezeralbum.viewmodel.DetailsAlbumViewModel
import gratigny.guillaume.deezeralbum.viewmodel.GridViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : MultiDexApplication() {

    private var listModules = module {
        single { DeezerNetworkModule().getDeezerApiService() }
        single { DeezerRepository(get()) }
        viewModel { GridViewModel(get()) }
        viewModel { DetailsAlbumViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listModules)
        }
    }

}