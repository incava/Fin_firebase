package com.incava.fin_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.incava.fin_firebase.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSupportFragmentManager().beginTransaction()
            .add(R.id.Frame_chat, ChatFragment())
            .commit();

        fun replaceFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction().replace(R.id.Frame_chat, fragment).commit()
        }
    }
}


