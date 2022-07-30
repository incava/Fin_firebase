package com.incava.fin_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.incava.fin_firebase.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding
lateinit var navController: NavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*getSupportFragmentManager().beginTransaction()
            .add(R.id.Frame_chat, ChatFragment())
            .commit();*/
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.frag_chat) as NavHostFragment
    }
}

