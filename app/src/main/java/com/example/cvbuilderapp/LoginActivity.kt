package com.example.cvbuilderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Carriers.PASSWORD
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.cvbuilderapp.Constants.EMAIL
import com.example.cvbuilderapp.Constants.IS_LOGGED_IN
import com.example.cvbuilderapp.Constants.SHARED_PREF_NAME
import com.example.cvbuilderapp.Constants.USERNAME

class LoginActivity : AppCompatActivity(), OnClickListener {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPref = getSharedPreferences(SHARED_PREF_NAME,0)
        if (sharedPref.getBoolean(IS_LOGGED_IN, false)) {
            openMainActivity()
        }else {
            initSharedPreference()
        }

        etEmail = findViewById(R.id.email_edit_text)
        etPassword = findViewById(R.id.password_edit_text)
        btnLogin = findViewById(R.id.login_button)

        btnLogin.setOnClickListener(this)
    }

    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun initSharedPreference() {
        val sharedPref = getSharedPreferences(SHARED_PREF_NAME, 0)
        val editor = sharedPref.edit()
        editor.putString(EMAIL, "ansharma@miu.edu")
        editor.putString(PASSWORD, "maharishi")
        editor.putString(USERNAME, "Anjana Sharma")
        editor.putBoolean(IS_LOGGED_IN, false)
        editor.apply()
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.login_button -> {
                if (validateFields()) {
                    if (checkAuthorization()) {

                        //set login as true
                        val sharedPref = getSharedPreferences(SHARED_PREF_NAME, 0)
                        val editor = sharedPref.edit()
                        editor.putBoolean(IS_LOGGED_IN, true)
                        editor.apply()

                        openMainActivity()

                    }else {
                        Toast.makeText(this,"Email or Password not match!", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun checkAuthorization(): Boolean {
        val sharedPref = getSharedPreferences(SHARED_PREF_NAME,0)
        val email = sharedPref.getString(EMAIL,"")
        val password = sharedPref.getString(PASSWORD,"")
        Log.v("LoginActivity", "$email : $password")
        if (etEmail.text.toString().trim() != email || etPassword.text.toString().trim() != password) {
            return false
        }
        return true
    }

    private fun validateFields(): Boolean {
        if (etEmail.text.isEmpty()) {
            etEmail.error = "Email can not be empty"
            etEmail.requestFocus()
            return false
        } else if (etPassword.text.isEmpty()) {
            etPassword.error = "Password can not be empty"
            etPassword.requestFocus()
            return false;
        }

        return true
    }
}