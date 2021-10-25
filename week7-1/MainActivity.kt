package kr.co.yeaeun.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("Lifecycle", "onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle", "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle", "onRestart()")
    }

    // Code-Override Methods
    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "onDestroy")
    }
}
