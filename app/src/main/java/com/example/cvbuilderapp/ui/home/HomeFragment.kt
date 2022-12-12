package com.example.cvbuilderapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.cvbuilderapp.Constants
import com.example.cvbuilderapp.Constants.EMAIL
import com.example.cvbuilderapp.Constants.USERNAME
import com.example.cvbuilderapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var userNameTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
    }

    private fun initViews(view: View) {
        val floatingAddButton = view.findViewById<FloatingActionButton>(R.id.floating_add_button)
        userNameTextView = view.findViewById(R.id.user_name_text_view)

        floatingAddButton.setOnClickListener {
            Snackbar.make(view, "Add Additional fields on home page", Snackbar.LENGTH_LONG).show()
        }

    }

    private fun initUserData() {
        val sharedPref = requireActivity().getSharedPreferences(Constants.SHARED_PREF_NAME, 0)
        val userName = sharedPref.getString(USERNAME, "")
        val userEmail = sharedPref.getString(EMAIL, "")

        userNameTextView.text = userName

    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}