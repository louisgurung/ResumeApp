package com.example.resumeprofile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.preference.PreferenceManager
import android.content.SharedPreferences
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val emailButtonTemp = findViewById<Button>(R.id.sendEmailButton);

        emailButtonTemp.setOnClickListener {

            var recipient = editAddress.text.toString().trim();

            val prefs = PreferenceManager.getDefaultSharedPreferences(this)
            val message =  prefs.getString("resumeContentFromResumePage", "no id")



            sendEmail(recipient, message)
        }

        val resumeButton = findViewById<Button>(R.id.resumeButton);
        resumeButton.setOnClickListener(View.OnClickListener() {
                val openNextActivity = Intent(this, ResumePage::class.java);
                startActivity(openNextActivity);
        });


        //sending email


    }


    private fun sendEmail(recipient: String, message: String?) {

        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mail to:")
        mIntent.type = "text/plain"

        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, "My Resume: ")
        mIntent.putExtra(Intent.EXTRA_TEXT, message)

        try {
            startActivity(Intent.createChooser(mIntent, "Choose email client"))
        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }


}
