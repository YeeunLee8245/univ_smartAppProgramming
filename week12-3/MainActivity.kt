package kr.co.yeaeun.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.co.yeaeun.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var model: SongViewModel

    private lateinit var view: ActivityMainBinding

    private val mAdapter = SongAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        model = ViewModelProvider(this).get(SongViewModel::class.java)

        view.list.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator() // 중요X
            adapter = mAdapter

        }
        model.list.observe(this,
            Observer<ArrayList<SongViewModel.Song>> {
                mAdapter.notifyDataSetChanged() // 변경된 것을 recycler에 알려줘서 recycler를 다시 그리게 함
            })
        model.requestSong()
    }

    // 이거 안 보고 쓸 줄 알아야한다고 언급
    inner class SongAdapter: RecyclerView.Adapter<SongAdapter.ViewHolder>(){
        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val txTitle: TextView = itemView.findViewById(android.R.id.text1)
            val txSinger: TextView = itemView.findViewById(android.R.id.text2)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            // 텀플젝에서는 레이아웃도 내가 직접 정의
            val view = layoutInflater.inflate(android.R.layout.simple_list_item_2, parent, false)
            return ViewHolder(view) // ViewHolder에 view 셋팅
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.txTitle.text = model.getSong(position).title
            holder.txSinger.text = model.getSong(position).singer
        }

        override fun getItemCount(): Int {
            return model.getSize()
        }
    }
}
