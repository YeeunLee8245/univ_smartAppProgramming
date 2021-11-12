package kr.co.yeaeun.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object{
        const val result = "result"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        editText.text = intent.getShortExtra("name") // 타입 맞지 X
        editText.setText(intent.getStringExtra(MainActivity.keyName)) // setText를 이용해면 casting 되어서 들어감

        when(intent.getStringExtra(MainActivity.keyName)){
            "RX-78-2" -> imageView.setImageResource(R.drawable.image1)
            "MS-06S" -> imageView.setImageResource(R.drawable.image3)
        }

        btnApply.setOnClickListener{
            val result = Intent()
            result.putExtra(SecondActivity.result, editText.text.toString()) // lambda expression이기 때문에 resultX, 클래스를 지정해줘야함.
            setResult(RESULT_OK,result)
            finish()
        }
    }
}