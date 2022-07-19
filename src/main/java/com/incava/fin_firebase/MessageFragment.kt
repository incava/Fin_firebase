package com.incava.fin_firebase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.incava.fin_firebase.databinding.FragmentMessageBinding


class MessageFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = FragmentMessageBinding.inflate(inflater, container, false)
        return view.root
    }


}