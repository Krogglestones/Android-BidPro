package com.example.bidpro

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_pilot.*
import kotlinx.android.synthetic.main.content_pilot.*

class PilotActivity : AppCompatActivity() {

    private val pilotLayoutManager by lazy { GridLayoutManager(this, 2) }
    private val pilotRecyclerAdapter by lazy {PilotRecyclerAdapter(this, DataManager.pilots)}
    private val pilotRecyclerAdapter2 by lazy {PilotRecyclerAdapter(this, DataManager.pilots2)}
    private val pilotRecyclerAdapter3 by lazy {PilotRecyclerAdapter(this, DataManager.pilots3)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilot)
        setSupportActionBar(toolbar)

        var airlineNumber = intent.getIntExtra("airline", 1)


        if (airlineNumber == 1) {
            showAmericanPilots()
        } else if (airlineNumber == 2) {
            showAlaskanPilots()
        } else if (airlineNumber == 3) {
            showFrontierPilots()
        }

    }

    private fun showAmericanPilots() {
        list_pilots.layoutManager = pilotLayoutManager
        list_pilots.adapter = pilotRecyclerAdapter
        setTitle("American Pilots")
    }

    private fun showAlaskanPilots() {
        list_pilots.layoutManager = pilotLayoutManager
        list_pilots.adapter = pilotRecyclerAdapter2
        setTitle("Alaskan Pilots")
    }

    private fun showFrontierPilots() {
        list_pilots.layoutManager = pilotLayoutManager
        list_pilots.adapter = pilotRecyclerAdapter3
        setTitle("Frontier Pilots")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_bidtypes -> {
                finish()
                true
            }
            R.id.action_pilots -> {

                showPilots()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showPilots() {
        Toast.makeText(applicationContext, "You're Already Here!!!", Toast.LENGTH_LONG).show()
    }

}
