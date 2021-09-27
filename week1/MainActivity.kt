package kr.co.yeaeun.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        my_button.setOnClickListener{
            my_text.text = "1"
        }
    }

//    fun onButton(v: View){
//        my_text.text = "눌렸습니다2"
//    }
}
