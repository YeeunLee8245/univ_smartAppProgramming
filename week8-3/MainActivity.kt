package kr.co.yeaeun.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.yeaeun.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var view: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        // ActivityMainBinding => 파스칼 케이스
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        // 명시적 인텐트
        view.btnExplicitIntent.setOnClickListener {
            val intent = Intent(this, imageActivity2::class.java)
            startActivity(intent)
        }

        // 암시적 인텐트트
       view.btnImplicitIntent.setOnClickListener {
//            val  uri = Uri.parse("http://www.google.com")
            val  uri = Uri.parse("http://www.youtube.com/results?search_query="
                    + view.editText.text.toString())
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }


    }

}
