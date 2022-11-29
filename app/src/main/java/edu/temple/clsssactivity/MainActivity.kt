package edu.temple.clsssactivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    // this function is to inflate the menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        // inflate the created menu and display at the app bar
        menuInflater.inflate(R.menu.main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    // this function is to set the item function ( what to do when it selected)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_take_picture ->
                Toast.makeText(
                    this,
                    "You have selected the take picture option.",
                    Toast.LENGTH_SHORT
                ).show()
            R.id.action_help ->
                startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.temple.edu")))
            // action when user selects delete picture action
            // with a dialog for user to confirm before delete
            R.id.action_delete_picture -> {
                AlertDialog.Builder(this)
                    .setTitle(R.string.delete_dialog_title)
                    .setMessage(R.string.delete_dialog_message)
                    // _,_ represent two arguments, first _ is the Yes
                    .setPositiveButton(R.string.positive_dialog_button) { _, _ -> Toast.makeText(this, "Picture deleted", Toast.LENGTH_SHORT).show() }
                    .setNegativeButton(R.string.negative_dialog_button) { dialog, _ -> dialog.cancel() }
                    .setCancelable(false)
                    // have to use .create to create the alertDialog
                    .create()
                    .show()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}