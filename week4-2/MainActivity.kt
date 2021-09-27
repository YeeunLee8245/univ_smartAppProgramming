package kr.co.yeaeun.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        my_button.setOnClickListener{
            //val price = 3_000_000
            //count++
            //my_text.text = "" + count
            //my_text.text = count.toString()
            //my_text.text = 40.toString()
            my_text.text = "${++count}"
            //my_text.text = "$price"
        }

        my_button_sub.setOnClickListener {
            if (--count < 0)
                count = 0
            my_text.text = "${count}"
        }

        my_button_reset.setOnClickListener {
            count = 0
            my_text.text = "${count}"
        }

        my_button_set.setOnClickListener {
            count = my_edit.text.toString().toIntOrNull() ?: count
            my_text.text = "${count}"
        }
    }

//    fun onButton(v: View){
//        my_text.text = "눌렸습니다2"
//    }
}
