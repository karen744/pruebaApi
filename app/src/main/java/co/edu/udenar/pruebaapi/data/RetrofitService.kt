package co.edu.udenar.pruebaapi.data

import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    @GET("discover/movie/{type}?sort_by=popularity.desc")
    suspend fun ListPopularMovies (
        @Query("api_key") apiKey:String,
        @Query("language") language:String
    ): RemoteResult

    object RetrofitServiceFactory {
        fun makeRetrofitService(): RetrofitService{
            return Retrofit.Builder().baseUrl("http://api.themoviedb.org/3/").build().create(RetrofitService::class.java)

        }
    }



}