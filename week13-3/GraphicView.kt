package kr.co.yeaeun.myapplication

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.widget.ConstraintSet

class GraphicView: View {

    private val p = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL_AND_STROKE
        strokeCap = Paint.Cap.ROUND
        strokeWidth = 10F
    }

    private val activity = context as MainActivity
    private var bmp = BitmapFactory.decodeResource(resources, R.drawable.blue)

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr) {
        bmp = Bitmap.createScaledBitmap(bmp, 100, 100, false)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //canvas.drawLine(10F, 10F, 100F, 100F, p)
        val list = activity.getPositionList()

//        var oldP: PointF? = null
//        for (i in 0 until list.size){
//            //canvas.drawCircle(list[i].x, list[i].y, 30F, p)
//            oldP?.run{ // oldP가 null이 아닐 때 동작
//                canvas.drawLine(this.x, this.y, list[i].x, list[i].y, p) // this => oldP
//            }
//            oldP = list[i]
//        }

        for(i in 0 until list.size)
            canvas.drawBitmap(bmp, list[i].x, list[i].y, p)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action){
            MotionEvent.ACTION_DOWN,
            MotionEvent.ACTION_MOVE -> {
                activity.addPosition(event.x,event.y)
                invalidate() // 중요!!!!!!! 이것을 해야지 onDraw가 다시 불릴 수 있다.
            }
        }
        return true
    }
}