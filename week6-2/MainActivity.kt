package kr.co.yeaeun.myapplication

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var num = IntArray(5)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDeal.setOnClickListener{
            for (i in 0..(num.size-1)){
                // 중첩이나 정렬을 하도록 따로 구현할수도
                num[i] = Random.nextInt(52)
                Log.d("Random","$i")
            }

            card1.setImageDrawable(findDrawable(num[0]))
            card2.setImageDrawable(findDrawable(num[1]))
            card3.setImageDrawable(findDrawable(num[2]))
            card4.setImageDrawable(findDrawable(num[3]))
            card5.setImageDrawable(findDrawable(num[4]))
        }
    }

    fun findDrawable(i: Int): Drawable?{
        Log.d("input","$i")

        val shape:Int = i/13
        val number:Int = i%13

        val strShape = intToShape(shape)
        val strNumber = intToNumber(number)
        val name = "c_${strNumber}_of_${strShape}"

        Log.d("Namestr","$name")

        // name을 가지고 drawable 파일 꺼내기기
        val id = resources.getIdentifier(name, "drawable", packageName)
        val d = ResourcesCompat.getDrawable(resources,id,null)

        return d
    }
    fun intToShape(s:Int): String?{
        return when(s){
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> null
        }
    }

    fun intToNumber(n: Int): String?{
        return when(n){
            0 -> "ace"
            in 1..9 -> (n+1).toString()
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> null
        }
    }
}

