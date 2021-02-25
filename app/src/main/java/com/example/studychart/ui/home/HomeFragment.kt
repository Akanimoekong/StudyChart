package com.example.studychart.ui.home

import android.app.LauncherActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studychart.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var binding: HomeFragment

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        var recyclerView: RecyclerView = root.findViewById(R.id.home_recyclerview)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            recyclerView = RecyclerView()
        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        home_recyclerview.setHasFixedSize(true)
        home_recyclerview.layoutManager = LinearLayoutManager(context  , LinearLayoutManager.VERTICAL, false)
    }
}

