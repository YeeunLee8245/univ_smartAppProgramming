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

        //button.setOnClickListener({v: View -> run{textView.text = "눌렀습니다2"}})
        // 코틀린에서는 interface를 구현한 것 하나만 넘겨준다고 했을 시, 괄호를 빼도 된다.
        button.setOnClickListener{
            textView.text = "눌렀습니다2"
            textView.textSize = 50.toFloat()
        }
    }


}
