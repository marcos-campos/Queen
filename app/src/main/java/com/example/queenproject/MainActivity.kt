package com.example.queenproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.queenproject.ui.main.MainFragment
import java.lang.reflect.Array.newInstance

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}