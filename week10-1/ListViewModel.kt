package kr.co.yeaeun.mysonglist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// 화면 회전시에도 데이터 유지
// application context를 상속받는 다면 ViewModel이 아닌 android ViewModel에서 상속받자
class ListViewModel:ViewModel {
    val list = MutableLiveData<ArrayList<String>>()
    private var songs = ArrayList<String>()

    // 상단바 Code -> Generater에서 선택 가능
    constructor() : super() {
        list.value = songs
    }

    fun add(song: String){
        songs.add(song)
        list.value = songs
    }

    //    fun getSong(i: Int):  Stirng{
//        return songs[i]
//    } 아래 축약형과 동일
    fun getSong(i: Int) = songs[i]
}
