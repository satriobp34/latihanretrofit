package retrofit.satrio.com.latihanretrofit

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import retrofit.satrio.com.latihanretrofit.data.ApiServiceImpl
import retrofit.satrio.com.latihanretrofit.data.Model.DataLiga
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("start","Starting")
        recyclerView.layoutManager = LinearLayoutManager(this)
        getData()
    }

    private fun getData(){
        ApiServiceImpl.create()
                .getDataLiga("England", "Soccer")
                .enqueue(object :Callback<DataLiga>{
                    //Ketika gagal respons server
                    override fun onFailure(call: Call<DataLiga>, t: Throwable) {
                       progressBar.visibility = View.GONE
                        Log.e("APAYANGSALAH", t.localizedMessage)
                        }

                    //ketika berhasil
                    override fun onResponse(call: Call<DataLiga>, response: Response<DataLiga>) {
                        progressBar.visibility = View.GONE
                        if (response.isSuccessful){
                            Log.d("isi",response.message().toString())
                            val adapter = LigaRecyclerAdapter(response.body()?.countrys!!)
                            recyclerView.adapter = adapter
                        }

                    }

                })

    }
}