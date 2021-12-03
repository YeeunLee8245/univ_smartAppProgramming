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
            setHasFixedSize(true)   // RecyclerView는 고정된 사이즈를 가진다(아이템이 추가되거나 삭제되지 않음)
            itemAnimator = DefaultItemAnimator() // 중요X(아이템 추가, 삭제, 이동 시 기본적으로 동작하는 애니메이션)
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
            return ViewHolder(view) // view 셋팅한 ViewHolder 생성
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
