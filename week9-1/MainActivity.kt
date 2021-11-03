package kr.co.yeaeun.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    val mArray = arrayOf("정류진", "신해범", "기우희", "진치우" ,"성재경", "권세혁", "신예나",
        "정류진", "신해범", "기우희", "진치우" ,"성재경", "권세혁", "신예나",
        "정류진", "신해범", "기우희", "진치우" ,"성재경", "권세혁", "신예나")

    companion object{
        const val keyName = "name"
        const val requestGundam = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mArray)
            listView.setOnItemClickListener { _, _, i, _ ->
                //Toast.makeText(this, "눌렀습니다", Toast.LENGTH_SHORT).show()
                //Toast.makeText(this, "${mArray[i]}", Toast.LENGTH_SHORT).show() <이건 안됨? 함 해보기
                Toast.makeText(this, mArray[i], Toast.LENGTH_SHORT).show()

                //val uri = Uri.parse("http://www.google.com/search?q=${mArray[i]}")
                val uri = Uri.parse("http://www.youtube.com/results?search_query=cc${mArray[i]}")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            } // interface funtion

    }

}
