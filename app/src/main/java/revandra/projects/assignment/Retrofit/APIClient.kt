package revandra.projects.assignment.Retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    fun getInstance(baseUrl:String): APIInterface {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient
                .Builder()
                .build()
            )
            .build()
            .create(APIInterface::class.java)
    }

    private const val BASE_URL = "https://smartfarm.iislab.id/"
    val apiService:APIInterface by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient
                    .Builder()
                    .build()
            )
            .build()
            .create(APIInterface::class.java)
    }
}