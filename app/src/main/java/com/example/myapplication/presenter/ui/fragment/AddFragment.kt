package com.example.myapplication.presenter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_home, container, false)
        val home = view.findViewById<TextView>(R.id.tv_home)
        val name = view.findViewById<EditText>(R.id.et_name)
        val click = view.findViewById<Button>(R.id.bn_click)
        click.setOnClickListener {
            home.text = name.text
        }
        return view
    }
}