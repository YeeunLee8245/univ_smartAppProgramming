package kr.co.yeaeun.catlist

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
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

        listView.adapter = CatAdapter_Base(this)

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

    inner class CatAdapter_Base(context: Context) : BaseAdapter(){
            // inflation을 해주는 것을 inflater라고 한다.
            // 인자로 받아온 context를 inflation함
            private var mInflater = LayoutInflater.from(context)
        override fun getCount(): Int {
            return mArray.size
        }

        override fun getItem(position: Int): Any {
            return mArray[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view: View
            val tv:TextView
            val viewHolder: CatViewHolder

            // convertView: 리스트 스크롤 시에 나타나고 사라지는 요소들을 보관하는 view(재활용을 위해: recyclerView도 같은 기능)
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
                viewHolder = view.tag as CatViewHolder
            }

            //tv.text = getItem(position).model
            viewHolder.txName.text = mArray[position].name
            viewHolder.txModel.text =  mArray[position].model
            return view
        }

        }
}
