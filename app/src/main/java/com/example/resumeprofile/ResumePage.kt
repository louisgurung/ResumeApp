package com.example.resumeprofile

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_resume_page.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class ResumePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume_page)


        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = prefs.edit()
        editor.putString("resumeContentFromResumePage", resumeContent.getText().toString()) //InputString: from the EditText
        editor.commit()


//        val intent = Intent(this, MainActivity::class.java)
//        intent.putExtra("resumeContentSentFromResumePage", resumeContent.getText().toString());
//        startActivity(intent);
    }
}

