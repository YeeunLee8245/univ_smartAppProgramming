package kr.co.yeaeun.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kr.co.yeaeun.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var view: ActivityMainBinding
    private val songs = arrayOf(
        "기우희", "신해범", "정류진", "성재경", "신유나", "진치우",
        "기우희", "신해범", "정류진", "성재경", "신유나", "진치우",
        "기우희", "신해범", "정류진", "성재경", "신유나", "진치우",
        "기우희", "신해범", "정류진", "성재경", "신유나", "진치우",

        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        view.list.adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,
            songs) // 리스트에 출력하고싶은 array 변수 삽입

        // 메소드 이름 주의! setOnItemClickListener임!!
        view.list.setOnItemClickListener { _, _, i, _ ->
            val uri = Uri.parse("http://youtube.com/results?search_query="
                    +songs[i])
            // 암시적 intent에 띄울 uri
            val youtube = Intent(Intent.ACTION_VIEW,uri)
            startActivity(youtube)
        }
    }
}
