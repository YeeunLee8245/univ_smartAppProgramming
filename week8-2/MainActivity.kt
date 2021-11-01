package kr.co.yeaeun.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHome.setOnClickListener {
            val uri = Uri.parse("http://bwoh.tistory.com") // uri 밑에 있는 url 사용
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        btnMap.setOnClickListener {
            val uri = Uri.parse("geo:0,0?q=부산시 동래구 연안로 74") // uri 밑에 있는 url 사용
            //val uri = Uri.parse("geo:36.145014, 128.393047?z=17") // 좌표 지정 가능
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        btnTel.setOnClickListener {
//            val uri = Uri.parse("tel:01034318245") // uri 밑에 있는 url 사용
            val uri = Uri.parse("sms:01034318245")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            //startActivity(intent)

            if(intent.resolveActivity(packageManager) != null)
                startActivity(intent)
        }

        btnSecond.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }



    }

}
