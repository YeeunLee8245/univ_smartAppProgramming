package kr.co.yeaeun.myapplication

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class SongViewModel(application: Application) : AndroidViewModel(application) {
    companion object{
        const val QUEUE_TAG = "SongVolleyRequest"
    }

    // kotlin의 data class는 c++의 struct다.
    data class Song(var id: Int, var title: String, var singer: String)
    // 바인딩을 통해 데이터가 바뀌면 화면도 수정됨
    val list = MutableLiveData<ArrayList<Song>>()
    private val song = ArrayList<Song>()

    private var queue: RequestQueue

    init {
        list.value = song // 변수를 초기화하면서 삽입
        queue = Volley.newRequestQueue(application) // requestQueue 생성
    }

    fun getSong(i: Int) = song[i]
    fun getSize() = song.size
    override fun onCleared() {
        super.onCleared()
        queue.cancelAll(QUEUE_TAG)  // 큐에 있는 모든 요청 취소
    }

    fun requestSong() {
        val url = "https://expresssongdb-ebrbw.run.goorm.io"
        // json Array 받아오기
        val request = JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            // 성공했을 때
            {
//                Toast.makeText(getApplication(), it.toString(), Toast.LENGTH_LONG).show()
                song.clear()
                parseJson(it) // it <= JSONArray
                list.value = song
            },
            // 에러가 발생했을 때
            {
                Toast.makeText(getApplication(), it.toString(), Toast.LENGTH_LONG).show()
            })
        request.tag = QUEUE_TAG
        queue.add(request) // 리퀘스트 요청 객체 넣어주기
    }

    private fun parseJson(items: JSONArray){
        // 한 튜플씩 처리
        for (i in 0 until items.length()){
            val item: JSONObject = items[i] as JSONObject
            val id = item.getInt("id")
            val title = item.getString("title")
            val singer = item.getString("singer")

            song.add(Song(id, title, singer))
        }
    }
}
