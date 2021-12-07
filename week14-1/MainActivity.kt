package kr.co.yeaeun.myapplication

import android.graphics.*
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity(){

    private lateinit var viewModel: GameViewModel

    var level: Long = 0
        get() = viewModel.level

    var seed: Int = 0
        get() = viewModel.seed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        // DB 초기화, Main Thread는 DB에 접근할 수 없다 => 새 스레드 생성
        connect()

        btnLevelUp.setOnClickListener {
            viewModel.levelUp()

            setMoney()
            setLevelUp()
        }
        btnSaveGame.setOnClickListener { // 저장 기능X newGame으로 데이터를 삭제하는 역할함
            //save()
            newGame()
        }
    }

    override fun onStop() { // 앱이 종료되었더라도 데이터 유지
        super.onStop()

        save()
    }

    fun connect() {
        Thread(Runnable{
            viewModel.connect()

            setMoney()
            setLevelUp()
            gameView.invalidate()
        }).start()
    }

    fun save() {
        val task = object : AsyncTask<Unit, Unit, Unit>(){ // ViewModel에 있는 것 부르기
            override fun doInBackground(vararg p0: Unit?){ // save 불러주고 해당 스레드가 끝나면  onPostExecute 실행시킴
                viewModel.save()
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)

                Toast.makeText(getApplication(),
                "Game Saved", Toast.LENGTH_SHORT).show()
            }
        }
        task.execute(Unit)
    }

    fun newGame(){
        val task = object : AsyncTask<Unit, Unit, Unit>(){
            override fun doInBackground(vararg p0: Unit?){ // save 불러주고 해당 스레드가 끝나면  onPostExecute 실행시킴
                viewModel.newGame()
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)

                setMoney()
                setLevelUp()
                gameView.invalidate()

                Toast.makeText(getApplication(),
                    "Game Delete", Toast.LENGTH_SHORT).show()
            }
        }
        task.execute(Unit)
    }

    fun setMoney(){
        val f = DecimalFormat("$###,###")
        textView.text = f.format(viewModel.money)
    }

    fun setLevelUp() {
        val cost = viewModel.levelUpCost(viewModel.level)
        val f = DecimalFormat("$###,###")
        val next = f.format(cost)
        btnLevelUp.text = "[현재 레벨: ${viewModel.level}] 레벨 업 ($next 필요)"
    }

    fun addMoney(){
        viewModel.addMoney()

        setMoney()
    }
}
