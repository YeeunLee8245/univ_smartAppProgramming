package kr.co.yeaeun.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //sleep(2000)
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MyApplication)
        setContentView(R.layout.activity_main)

    }

}
