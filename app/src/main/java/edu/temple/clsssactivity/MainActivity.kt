package edu.temple.clsssactivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    // this function is to inflate the menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        // inflate the created menu and display at the app bar
        menuInflater.inflate(R.menu.main,menu)

        return super.onCreateOptionsMenu(menu)
    }

    // this function is to set the item function ( what to do when it selected)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_take_picture ->
                Toast.makeText(this,"You have selected the take picture option.",Toast.LENGTH_SHORT).show()
            R.id.action_help ->
                startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.temple.edu")))
        }

        return super.onOptionsItemSelected(item)
    }
}