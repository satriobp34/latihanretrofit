package retrofit.satrio.com.latihanretrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_liga.*
import retrofit.satrio.com.latihanretrofit.data.Model.Country

class DetailLigaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_liga)

        var data: Country? = null
        if (intent.hasExtra("data")){
                data = intent.getParcelableExtra("data")
    }

        Glide.with(this).load(data?.strFanart1).into(imageviewBanner)
        textviewLiga.text = data?.strLeague
        textviewDeskripsi.text = data?.strDescriptionEN
    }


}
