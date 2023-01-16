package com.example.loginscreen1

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.loginscreen1.databinding.ActivitySignupBinding


class SignupActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etusername =binding.usernamesignup
        val etpassword = binding.passwordsignup
        var sex : Boolean
        var remember  :Boolean

        binding.sexGroup.setOnCheckedChangeListener { group, checkedId ->
            val checkedRadioButton = group.findViewById(checkedId) as RadioButton
            sex = checkedRadioButton.text == "Female"
        }

        binding.rememberCheckbox.setOnCheckedChangeListener { buttonView, isChecked ->
            remember = isChecked
        }

        binding.signupBtn.setOnClickListener{
            var result = true
            if (etusername.text.toString().length < 9){
                etusername.error = "Require more than 9 characters"
                result = false
            }
            if(etpassword.text.toString().length < 6){
                etpassword.error =  "Require more than 6 characters"
                result = false
            }

            // Login on server

            // return token


            if(result){
                startActivity(Intent(this, ResultActivity::class.java))
            }
        }
    }
}
