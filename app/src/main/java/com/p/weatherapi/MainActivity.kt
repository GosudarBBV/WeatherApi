package com.p.weatherapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.p.weatherapi.databinding.ActivityMainBinding
import com.p.weatherapi.fragments.HoursFragment
import com.p.weatherapi.fragments.MainFragment

const val API_KEY = "fadc4f7458814ebb993134532222412"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeHolder,MainFragment.newInstance())
            .commit()
    }

//    private fun getResult(name:String) {
//        val url = "http://api.weatherapi.com/v1/current.json?" +
//                "key=$API_KEY&q=Name&aqi=no"
//
//        val queue = Volley.newRequestQueue(this)
//        val stringRequest = StringRequest(Request.Method.GET,
//            url,
//            {
//                    respons->
//                val obj = JSONObject(respons)
//                val temp = obj.getJSONObject("current")
//
//
//                Log.d("MyLog","Volley error:  $respons")
//            },
//            {
//                Log.d("MyLog","Volley error:  $it")
//            }
//        )
//        queue.add(stringRequest)
//    }

}