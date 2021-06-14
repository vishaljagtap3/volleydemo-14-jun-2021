package `in`.bitcode.volleydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var reqQueue = Volley.newRequestQueue(this)

        //3
        var jsonArrayReq = JsonArrayRequest(
            Request.Method.GET,
            "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=1500&type=restaurant&keyword=cruise&key=AIzaSyAYh5QhQeFn2TMH4Ru_o1Zfb6voBs6i9rk",
            null,
            JSONArrayResponseListener(),
            JSONErrorListener()
        )
        reqQueue.add(jsonArrayReq)


        //2
        /*var inputJSONObject = JSONObject()
        inputJSONObject.put("name", "Vishal")
        inputJSONObject.put("contact_no", 9881900903)

        var jsonObjReq = JsonObjectRequest(
            Request.Method.GET,
            "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=1500&type=restaurant&keyword=cruise&key=AIzaSyAYh5QhQeFn2TMH4Ru_o1Zfb6voBs6i9rk",
            inputJSONObject,
            JSONResponseListener(),
            JSONErrorListener()
        )
        reqQueue.add(jsonObjReq)*/

        //1
        /*var simpleReq = StringRequest(
            Request.Method.GET,
            "https://bitcode.in",
            SimpleResponseListener(),
            SimpleErrorListener()
        )

        reqQueue.add(simpleReq)*/
    }

    class JSONArrayResponseListener : Response.Listener<JSONArray> {
        override fun onResponse(response: JSONArray?) {
            Log.e("tag", response.toString())
        }
    }

    class JSONErrorListener : Response.ErrorListener {
        override fun onErrorResponse(error: VolleyError?) {
            if(error != null) {
                Log.e("tag", error.message.toString())
            }
        }
    }

    //2
    /*class JSONResponseListener : Response.Listener<JSONObject> {
        override fun onResponse(response: JSONObject?) {
            Log.e("tag", response.toString())
        }
    }

    class JSONErrorListener : Response.ErrorListener {
        override fun onErrorResponse(error: VolleyError?) {
            if(error != null) {
                Log.e("tag", error.message.toString())
            }
        }
    }*/

    //1
    /*class SimpleResponseListener : Response.Listener<String> {
        override fun onResponse(response: String?) {
            Log.w("tag", response.toString())
        }
    }

    class SimpleErrorListener : Response.ErrorListener {
        override fun onErrorResponse(error: VolleyError?) {
            if(error != null) {
                Log.w("tag", error.message.toString())
            }
        }
    }*/
}