package kr.co.yeaeun.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.yeaeun.myapplication.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        // static method
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // root: constraint layout

        binding.button.setOnClickListener{
            val n = Random.nextInt(1,46)
            binding.text1.text = "$n"
            binding.text2.text = "${Random.nextInt(1,46)}"
        }
    }
}

