package kr.co.yeaeun.mysonglist

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

//    private val array = arrayOf("에스파 savage", "에스파 black mamba",
//        "에스파 savage", "에스파 black mamba",
//        "에스파 savage", "에스파 black mamba",
//        "에스파 savage", "에스파 black mamba",
//        "에스파 savage", "에스파 black mamba",
//        "에스파 savage", "에스파 black mamba",
//        "에스파 savage", "에스파 black mamba",
//        "에스파 savage", "에스파 black mamba",
//        "에스파 savage", "에스파 black mamba",
//        "에스파 savage", "에스파 black mamba",
//        "에스파 savage", "에스파 black mamba",
//        "에스파 savage", "에스파 black mamba",
//        "에스파 savage", "에스파 black mamba",
//        "에스파 savage", "에스파 black mamba")
    private lateinit var adapter:ArrayAdapter<String>

    private lateinit var model: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // viewModelProviders.of(this).get()와 동일
        // 교수님과 버전이 상이하여 구글링으로 수정한 코드
        model = ViewModelProvider(this).get(ListViewModel::class.java)

        val listObserver = Observer<ArrayList<String>>{
            // 데이터가 달라지면 자동으로 리스트를 바꿔라
            adapter.notifyDataSetChanged()
        }
        model.list.observe(this, listObserver)

        adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,
            model.list.value as List<String>)

        listView.adapter = adapter


        listView.setOnItemClickListener { _, _, position, _ ->
            val uri = Uri.parse("http://www.youtube.com/results?search_query="
                +"노래방 ${model.getSong(position)}")
            val intent = Intent(Intent.ACTION_VIEW,uri) // 암시적 intent
            startActivity(intent)
        }

        fab.setOnClickListener { view ->
            // OnCreate에서 만들어지는 것이 아니기 때문에 inflater를 사용하여 따로 만들어주어야 함
            val customLayout  = layoutInflater.inflate(R.layout.dialog_input, null)
            AlertDialog.Builder(this).setView(customLayout)
                .setPositiveButton("추가"){ _,_ ->
                    // inputEditText는 EditText를 상속받은 것이기 때문에 타입에 저렇게 써줘도 됨
                    val edit = customLayout.findViewById<EditText>(R.id.edit)
                    if(edit.text.toString().length > 0){
                        model.add(edit.text.toString())
                    }
                }
                .create().show()
        }
    }
}
