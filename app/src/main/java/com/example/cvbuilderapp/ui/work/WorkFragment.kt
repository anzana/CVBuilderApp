package com.example.cvbuilderapp.ui.work

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cvbuilderapp.R
import com.example.cvbuilderapp.data.Work

class WorkFragment : Fragment(R.layout.fragment_work) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val workRecyclerView: RecyclerView = view.findViewById(R.id.work_recycler_view)
        val adapter = WorkAdapter(Work.getWorkList())
        workRecyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = WorkFragment()
    }
}