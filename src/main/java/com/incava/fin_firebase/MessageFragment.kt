package com.incava.fin_firebase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigator
import androidx.navigation.fragment.navArgs
import com.incava.fin_firebase.databinding.FragmentChatBinding
import com.incava.fin_firebase.databinding.FragmentMessageBinding
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit


class MessageFragment: Fragment() {

    lateinit var binding: FragmentMessageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = FragmentMessageBinding.inflate(inflater, container, false)
        return view.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentMessageBinding = FragmentMessageBinding.bind(view)
        binding = fragmentMessageBinding
        binding.messageActivityTextViewTopName.text = arguments?.getString("name")

        //Toast.makeText(activity,ChatName,Toast.LENGTH_SHORT).show()
    }

}

