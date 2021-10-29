package com.zebo.tasqla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.zebo.tasqla.extension.toast
import com.zebo.tasqla.ui.JoinManagerActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.employee_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId){
        R.id.action_completed -> {
            toast("Completed")
            true
        }
        R.id.action_approved -> {
            toast("Approved")
            true
        }
        R.id.action_not_completed -> {
            toast("Not completed")
            true
        }
        R.id.action_join_manager -> {
            toast("Join a manager")
            Intent(this@MainActivity, JoinManagerActivity::class.java).apply {
                startActivity(this)
            }
            true
        }
        else -> true
    }

}