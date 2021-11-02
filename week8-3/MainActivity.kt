package kr.co.yeaeun.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{

    companion object{
        const val keyName = "name"
        const val requestGundam = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // SecondActivity에서 백버튼을 누르면 이쪽으로 다시 돌아옴(강의를 통해 눈으로 확인 해보기)
        setContentView(R.layout.activity_main)


//        btnGundam.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra(keyName, "RX-78-2")
//            intent.putExtra("test", 300)
//            startActivity(intent)
//        }
//
//        btnZaku.setOnClickListener {
//
//        }

        // 현재 클래스에서(onClick 메소드) 처리하라라
       btnGundam.setOnClickListener(this)
        btnZaku.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, SecondActivity::class.java)
        when (v?.id){
            btnGundam.id -> intent.putExtra(keyName, "RX-78-2")
            btnZaku.id -> intent.putExtra(keyName, "MS-06S")
            null -> return
        }

        //startActivity(intent)
        startActivityForResult(intent, requestGundam)
    }

    // Seconde Activity의 result 데이터가 이 메소드의 data 인자로 넘어옴
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK){
            when(requestCode){
                requestGundam -> {
                    textView.text = data?.getStringExtra(SecondActivity.result)
                }
            }
        }
    }

}
