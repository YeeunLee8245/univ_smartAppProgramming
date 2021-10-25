package kr.co.yeaeun.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

//class MainActivity : AppCompatActivity(), View.OnClickListener {
class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Handler를 사용한 onClick 동작
        val h: MyHandler = MyHandler()
        button.setOnClickListener(h)

        // onClick 동작
        //button.setOnClickListener(this)
    }

    inner class MyHandler: View.OnClickListener{
        override fun onClick(p0: View?) {
            textView.text = "또 다시 눌렀습니다"
            textView.textSize = 50.toFloat()
        }

    }

//    override fun onClick(p0: View?) {
//        TODO("Not yet implemented")
//        textView.text = "또 눌렀습니다"
//        textView.textSize = 50.toFloat() // 글자 크기 증가
//    }

}
