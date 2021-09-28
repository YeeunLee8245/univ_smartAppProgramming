package kr.co.yeaeun.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd.setOnClickListener{
            textCount.text = "${++count}"
        }

        btnSub.setOnClickListener{
            textCount.text = "${--count}"
        }

        btnReset.setOnClickListener{
            count = 0
            textCount.text = "${count}"
        }
    }

}