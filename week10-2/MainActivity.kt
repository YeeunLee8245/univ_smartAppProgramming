package kr.co.yeaeun.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.co.yeaeun.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var view: ActivityMainBinding

    private lateinit var model: ListViewModel
    private val songAdapter = SongAdapter()

    val mArray = arrayOf("정류진", "신해범", "기우희", "진치우" ,"성재경", "권세혁", "신예나",
        "정류진", "신해범", "기우희", "진치우" ,"성재경", "권세혁", "신예나",
        "정류진", "신해범", "기우희", "진치우" ,"성재경", "권세혁", "신예나")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: 삭제할 것
        //setContentView(R.layout.activity_main)

        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        model = ViewModelProvider(this).get(ListViewModel::class.java)
        model.getList().observe(this, Observer<ArrayList<String>>{
            songAdapter.notifyDataSetChanged()
        })

        model.add("꼬꼬야")

        view.list.apply {
            adapter = songAdapter
            layoutManager = LinearLayoutManager(applicationContext)

        }
    }

    inner class SongAdapter: RecyclerView.Adapter<SongAdapter.ViewHolder>(){
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val txSong: TextView = itemView.findViewById(android.R.id.text1) // simple item 1으로 설정했기 때문
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongAdapter.ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_1,
                parent,
                false)// 부모는 recycler, 따로 붙일 것
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: SongAdapter.ViewHolder, position: Int) {
            holder.txSong.text = model.getSong(position)
        }

        override fun getItemCount() = model.getSize()
    }

}
