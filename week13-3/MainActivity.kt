package kr.co.yeaeun.myapplication

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kr.co.yeaeun.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var viewModel: ListViewModel
    //private lateinit var view: GraphicView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        //view = GraphicView(this)
        //setContentView(view)
    }

    fun addPosition(x: Float, y: Float){
        viewModel.add(x,y)
    }

    fun getPositionList() : ArrayList<PointF> {
        return viewModel.list
    }
}
