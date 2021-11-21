package kr.co.yeaeun.mysonglist


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
// dependency로 volley 추가해주었기 때문에 사용 가능
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(this)

        val url = "https://bwoh.tistory.com"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                //textView.text = response
//                webView.settings.defaultTextEncodingName = "UTF-8"
//                webView.loadData(response, "text/html;charset=UTF-8", null)

                val ogTitle = "\"og:title\""
                val ogDesc = "\"og:description\""
                val ogImage = "\"og:image\""

                val resultTitle = findContent(response,ogTitle,0)
                val resultDesc = findContent(response,ogDesc,0)
                val resultImage = findContent(response,ogImage,0)
                // +를 다음단에 쓰면 에러남
                val text = "${resultTitle}\n${resultDesc}"
//                textView.text = text
//                webView.loadUrl(resultImage)

                val html = """
                    <html>
                        <body>
                            <h1>$resultTitle</h1>
                            <p>$resultDesc</p>
                            <img src="$resultImage"/>
                        </body>
                    </html>
                """.trimIndent()

                webView.settings.defaultTextEncodingName = "UTF-8"
                webView.loadData(html, "text/html;charset=UTF-8", null)

//                textView.text = findContent(response,ogTitle,0)
//                textView.text = findContent(response,ogDesc,0)

            },
            Response.ErrorListener {
                textView.text = "Error: $it"
            }
        )
        queue.add(stringRequest)
    }
    fun findContent(target: String, meta: String, startIndex:Int): String{
        val content = "content=\""
        val close = "\" >"

        var start = target.indexOf(meta)
        start = target.indexOf(content, start)
        val end = target.indexOf(close, start)

        // content(content=") 다음부터 출력 시작
        return target.substring(start + content.length..end - 1)
    }

}
