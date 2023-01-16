package com.example.loginscreen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.loginscreen1.databinding.ActivityLoginBinding

class loginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usernameet = binding.username //Generic
        val passwordet = binding.password

        usernameet.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })


        binding.loginBtn.setOnClickListener{
            var status = if (usernameet.text.toString().equals("giahuy")
                && passwordet.text.toString().equals("123456789"))
                "Login successfully"  else "Login unsuccessfully"

            Toast.makeText(this, status, Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ResultActivity::class.java))
        }
    }
}
