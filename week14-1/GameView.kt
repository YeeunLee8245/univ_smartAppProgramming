package kr.co.yeaeun.myapplication

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.random.Random

class GameView: View {
    private val activity = context as MainActivity
    private val p = Paint()
    private var bmp = BitmapFactory.decodeResource(resources, R.drawable.blue)

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr){
        bmp = Bitmap.createScaledBitmap(bmp, 100,100,false)
    }

    // 인자의 타입이 널허용이면 함수 안에서 정의할 때도 ? 붙여주기
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // seed 값 고정
        val r = Random(activity.seed)

        for (i in 0 until activity.level){
            val x = r.nextInt(width).toFloat()
            val y = r.nextInt(height).toFloat()
            canvas.drawBitmap(bmp, x, y, p)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action){
            MotionEvent.ACTION_DOWN -> {
                activity.addMoney()
                invalidate()
            }
        }
        return true
    }
}