package kr.co.yeaeun.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun onButton(v: View){
        textView.text = "눌렀습니다"
        textView.textSize = 50.toFloat() // 글자 크기 증가
        // makeText은 static method(Toast 클래스 이름으로 바로 호출할 수 있기 때문에): 객체를 만드는 것까지
        // 따라서 보여지기 위해 show()를 호출해줘야함
        Toast.makeText(this, "눌렸습니다", Toast.LENGTH_SHORT).show()
    }
}
