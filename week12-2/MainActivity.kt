package kr.co.yeaeun.mysonglist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
// dependency로 volley 추가해주었기 때문에 사용 가능
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var volley: VolleySingleton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // companion object
        volley = VolleySingleton.getInstance(this)

        btnConnect.setOnClickListener{
            // networkImageView 사용
            imageView.setImageUrl("https://www.kumoh.ac.kr/_res/ko/img/common/logo@2x.png",
                volley.imageLoader)
        }
    }

}
