package kr.co.yeaeun.myapplication

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(CardView(this))
    }

    // code > generate > secondary constructor
    public class CardView: View {

        private var num = IntArray(5)

        private val p = Paint()
        private val back = Paint()

        private var sizex = 0
        private var sizey = 0

        private var yy: Float = 0F

        private val bmpWidth: Int
        private val bmpHeight: Int
        private val bmpBack = BitmapFactory.decodeResource(resources, R.drawable.c_ace_of_spades)

        constructor(context: Context?) : this(context, null)
        constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
        constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
                : super(context, attrs, defStyleAttr) {
            p.setARGB(255, 255, 255, 255) // 하얀색
            p.textSize = 50F
            back.setARGB(255, 0, 128, 0) // 초록색

            bmpWidth = bmpBack.width
            bmpHeight = bmpBack.height

            dealCards()
        }

        override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
            super.onSizeChanged(w, h, oldw, oldh)

            sizex = (width / 5f).toInt() - 4
            sizey = (bmpHeight * sizex / bmpWidth).toInt() // 비율 맞춰줌

            yy = height / 2F - sizey / 2F
        }

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            drawBackground(canvas)

            drawText(canvas, "Good Luck!")

            for (i in 0 until 5)
                drawBitmap(canvas, i)

        }

        fun drawBackground(canvas: Canvas) {
            canvas.drawRect(0F, 0F, width.toFloat(), height.toFloat(), back)
        }

        fun drawText(canvas: Canvas, text: String) {
            val cx = width / 2f - p.measureText(text) / 2
            canvas.drawText(text, cx, p.textSize + 20F, p)
        }

        fun drawBitmap(canvas: Canvas, x: Int) {
            // (100,100) 위치에 반경 50인 원 출력
            //canvas.drawCircle(100F, 100F, 50F, p)
//            canvas.drawRect(100F,100F,100F + bmpBack.width, 100F+ bmpBack.height, p)
//            canvas.drawBitmap(bmpBack, 100F,100F, p)

            val bmp = findBitmap(num[x])
            // bmp 사이즈 축소
            val scaledBmp = Bitmap.createScaledBitmap(bmp, sizex, sizey, false)

            canvas.drawRoundRect(
                ((sizex + 4) * x).toFloat() + 4F, yy,
                ((sizex + 4) * x).toFloat() + 4F + sizex.toFloat(), yy + sizey, 10F, 10F, p
            )
            canvas.drawBitmap(scaledBmp, ((sizex + 4) * x).toFloat() + 4F, yy, p)
        }

        fun dealCards() {
            for (i in 0 until 5)
                num[i] = (0 until 52).random()
        }

        fun findBitmap(i: Int): Bitmap {
            Log.d("input", "$i")

            val shape: Int = i / 13
            val number: Int = i % 13

            val strShape = intToShape(shape)
            val strNumber = intToNumber(number)
            val name = "c_${strNumber}_of_${strShape}"

            Log.d("Namestr", "$name")

            // name을 가지고 drawable 파일 꺼내기기
            val id = resources.getIdentifier(name, "drawable", context.packageName)
            val b = BitmapFactory.decodeResource(resources, id)

            return b
        }

        fun intToShape(s: Int): String? {
            return when (s) {
                0 -> "spades"
                1 -> "diamonds"
                2 -> "hearts"
                3 -> "clubs"
                else -> null
            }
        }

        fun intToNumber(n: Int): String? {
            return when (n) {
                0 -> "ace"
                in 1..9 -> (n + 1).toString()
                10 -> "jack"
                11 -> "queen"
                12 -> "king"
                else -> null
            }
        }

        // 터치시에 작동동
        override fun onTouchEvent(event: MotionEvent): Boolean {
            // 터치를 했을 시
            if (event.action == MotionEvent.ACTION_DOWN){
                dealCards()
                invalidate()
            }

            return true
        }
    }

}
