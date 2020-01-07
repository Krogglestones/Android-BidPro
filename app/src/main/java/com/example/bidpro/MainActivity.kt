package com.example.bidpro

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private val flightLayoutManager by lazy { LinearLayoutManager(this) }
    private val flightRecyclerAdapter by lazy { FlightRecyclerAdapter(this, DataManager.flights) }
    private val flightRecyclerAdapter2 by lazy { FlightRecyclerAdapter(this, DataManager.flights2) }
    private val flightRecyclerAdapter3 by lazy { FlightRecyclerAdapter(this, DataManager.flights3) }

    var chosenAirline = 1

    private val ViewModel by lazy { ViewModelProviders.of(this)[MainActivityViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        ///////////////////////////////////////////////////////////////////////


//        listItems.layoutManager = flightLayoutManager
//        listItems.adapter = flightRecyclerAdapter
//        setTitle("American")

        handleDisplaySelection(ViewModel.navDrawerDisplaySelection)


        ///////////////////////////////////////////////////////////////////////
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    private fun showAmerican() {
        listItems.layoutManager = flightLayoutManager
        listItems.adapter = flightRecyclerAdapter
        setTitle("American")
        chosenAirline = 1
    }

    private fun showAlaskan() {
        listItems.layoutManager = flightLayoutManager
        listItems.adapter = flightRecyclerAdapter2
        setTitle("Alaskan")
        chosenAirline = 2
    }

    private fun showFrontier() {
        listItems.layoutManager = flightLayoutManager
        listItems.adapter = flightRecyclerAdapter3
        setTitle("Frontier")
        chosenAirline = 3
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
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
                Toast.makeText(applicationContext, "You're Already Here!!!", Toast.LENGTH_LONG).show()
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
        val intent = Intent(this, PilotActivity::class.java)
        intent.putExtra("airline", chosenAirline)
        startActivity(intent)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_american,
            R.id.nav_alaskan,
            R.id.nav_frontier -> {
                handleDisplaySelection(item.itemId)
                ViewModel.navDrawerDisplaySelection = item.itemId
            }
        }


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun handleDisplaySelection(itemId: Int) {
        when (itemId) {
            R.id.nav_american -> {
                showAmerican()
            }
            R.id.nav_alaskan -> {
                showAlaskan()
            }
            R.id.nav_frontier -> {
                showFrontier()
            }
        }
    }
}
