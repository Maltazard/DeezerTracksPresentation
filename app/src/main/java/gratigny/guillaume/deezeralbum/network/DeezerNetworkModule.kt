package gratigny.guillaume.deezeralbum.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DeezerNetworkModule {

    /**
     * Create an instance of retrofit
     *
     * @return the API service
     */
    fun getDeezerApiService(): DeezerApiService {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.deezer.com/2.0/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create(DeezerApiService::class.java)
    }
}