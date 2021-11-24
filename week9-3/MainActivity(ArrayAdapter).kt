package kr.co.yeaeun.catlist

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    data class Cat(var name:String, var model: String)

    var mArray = ArrayList<Cat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mArray.add(Cat("정류진","이병"))
        mArray.add(Cat("신해범","준장"))
        mArray.add(Cat("기우희","소령"))
        mArray.add(Cat("성재경","소위"))
        mArray.add(Cat("정류진","이병"))
        mArray.add(Cat("신해범","준장"))
        mArray.add(Cat("기우희","소령"))
        mArray.add(Cat("성재경","소위"))
        mArray.add(Cat("정류진","이병"))
        mArray.add(Cat("신해범","준장"))
        mArray.add(Cat("기우희","소령"))
        mArray.add(Cat("성재경","소위"))
        mArray.add(Cat("정류진","이병"))
        mArray.add(Cat("신해범","준장"))
        mArray.add(Cat("기우희","소령"))
        mArray.add(Cat("성재경","소위"))
        mArray.add(Cat("정류진","이병"))
        mArray.add(Cat("신해범","준장"))
        mArray.add(Cat("기우희","소령"))
        mArray.add(Cat("성재경","소위"))
        mArray.add(Cat("정류진","이병"))
        mArray.add(Cat("신해범","준장"))
        mArray.add(Cat("기우희","소령"))
        mArray.add(Cat("성재경","소위"))

        //listView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mArray)

        listView.adapter = CatAdapter(this,android.R.layout.simple_list_item_1,mArray)

        listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, mArray[position].model, Toast.LENGTH_SHORT).show()

            //val uri = Uri.parse("http://www.google.com/search?q=${mArray[i]}")
            val uri = Uri.parse("http://www.youtube.com/results?search_query=cc${mArray[position]}")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        } // interface funtion
    }

    private class CatViewHolder{
        lateinit var txName: TextView
        lateinit var txModel: TextView
    }

    inner class CatAdapter(context: Context, resource: Int, objects: MutableList<Cat>):
        ArrayAdapter<Cat>(context, resource, objects){
            // inflation을 해주는 것을 inflater라고 한다.
            // 인자로 받아온 context를 inflation함
            private var mInflater = LayoutInflater.from(context)

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view: View
            val tv:TextView
            val viewHolder: CatViewHolder

            // convertView: 리스트 스크롤 시에 나타나고 사라지는 요소들을 보관하는 view(재활용을 위해)
            if(convertView == null) {
                // android.R.layout.simple_list_item_2 => 2줄 텍스트 리스트
                view = mInflater.inflate(
                    android.R.layout.simple_list_item_2,
                    parent, false
                )
                //tv = view.findViewById(android.R.id.text1)
                viewHolder = CatViewHolder()
                viewHolder.txName = view.findViewById(android.R.id.text1)
                viewHolder.txModel = view.findViewById(android.R.id.text2)

                view.tag = viewHolder
            }
            else{
                view = convertView
                //tv = view.findViewById(android.R.id.text1)
                // => 87라인과 95라인 중복 => 최적화 필요 => ViewHolder
                // 다시 셋팅
                viewHolder = view.tag as CatViewHolder
            }

            //tv.text = getItem(position).model
            // position: 리스트에서 보일 아이템의 위치 정보
            // Adapter의 함수 getItem(position)으로 해당 위치의 view를 가져올 수 있다.
            viewHolder.txName.text = getItem(position)?.name
            viewHolder.txModel.text = getItem(position)?.model
            return view
        }

        }
}
