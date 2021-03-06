package com.android.timetrackingdashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.timetrackingdashboard.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (supportActionBar != null) {
            supportActionBar!!.hide();
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}