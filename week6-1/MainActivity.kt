package kr.co.yeaeun.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Thread.sleep
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val images = arrayOf(R.drawable.image1,
    R.drawable.image2, R.drawable.image3)
    var n = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setOnClickListener {
            // resource ID를 가지고 Drawable 타입의 객체를 얻음
            val d = ResourcesCompat.getDrawable(resources,images[n], null)
            n = (++n) % images.size
//            if (d != null)
//            // imageView에 setting
//                imageView.setImageDrawable(d)
            d?.let { imageView.setImageDrawable(d) } // d가 null이 아니라면 블록 안을 실행해라
        }
    }

}

