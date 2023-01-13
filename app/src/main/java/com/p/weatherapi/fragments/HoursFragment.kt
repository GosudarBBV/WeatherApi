package com.p.weatherapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.p.weatherapi.MainViewModel
import com.p.weatherapi.R
import com.p.weatherapi.adapters.WeatherAdapter
import com.p.weatherapi.adapters.WeatherModel
import com.p.weatherapi.databinding.FragmentHoursBinding
import com.p.weatherapi.databinding.FragmentMainBinding
import com.p.weatherapi.databinding.ListItemBinding
import org.json.JSONArray
import org.json.JSONObject

class HoursFragment : Fragment() {

    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter
    private val model:MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHoursBinding.inflate(inflater,container,false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
        model.liveDataCurrent.observe(viewLifecycleOwner){
            adapter.submitList(getHoursList(it))
        }
    }

    private fun getHoursList(wItem:WeatherModel):List<WeatherModel>{

        val hoursArray = JSONArray(wItem.hours)
        val list = ArrayList<WeatherModel>()

        for (i in 0 until hoursArray.length()){
            val item = WeatherModel(
                wItem.city,
                (hoursArray[i] as JSONObject).getString("time"),
                (hoursArray[i] as JSONObject).getJSONObject("condition").getString("text"),
                (hoursArray[i] as JSONObject).getString("temp_c"),
                "",
                "",
                (hoursArray[i] as JSONObject).getJSONObject("condition").getString("icon"),
                ""
            )
            list.add(item)
        }

        return list
    }

    private fun initRcView() = with(binding){
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter(null)
        rcView.adapter = adapter
        val list = listOf(
            WeatherModel("","12:00","Sunny","25^C",
            "","","",""),
            WeatherModel("","13:00","Sunny","25^C",
            "","","",""),
            WeatherModel("","13:00","Sunny","25^C",
            "","","",""),

        )
        adapter.submitList(list)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HoursFragment()
    }
}