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
import com.p.weatherapi.databinding.FragmentDaysBinding
import com.p.weatherapi.databinding.FragmentMainBinding


class DaysFragment : Fragment(),WeatherAdapter.Listener {

    private lateinit var binding: FragmentDaysBinding
    private lateinit var adapter: WeatherAdapter
    private val model:MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun init()= with(binding){
        adapter = WeatherAdapter(this@DaysFragment)
        rcView.layoutManager = LinearLayoutManager(activity)
        rcView.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        model.liveDataList.observe(viewLifecycleOwner){
            adapter.submitList(it.subList(1,it.size))
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = DaysFragment()
    }

    override fun onClick(item: WeatherModel) {

        model.liveDataCurrent.value = item

    }
}