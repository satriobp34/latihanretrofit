package retrofit.satrio.com.latihanretrofit.data

import retrofit.satrio.com.latihanretrofit.data.Model.DataLiga
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search_all_leagues.php")
    fun getDataLiga (@Query("c") liga: String,
                     @Query("s") sport: String)
    :Call<DataLiga>
}