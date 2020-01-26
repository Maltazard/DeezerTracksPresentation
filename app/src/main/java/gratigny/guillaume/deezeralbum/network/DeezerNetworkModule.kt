package gratigny.guillaume.deezeralbum.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DeezerNetworkModule {

    fun getDeezerApiService(): DeezerApiService{

        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.deezer.com/2.0/user/2529/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create(DeezerApiService::class.java)
    }
}