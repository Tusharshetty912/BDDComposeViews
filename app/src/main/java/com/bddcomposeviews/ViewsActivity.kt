package com.bddcomposeviews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bddcomposeviews.databinding.ActivityViewsBinding

class ViewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityViewsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setLogin()
    }

    private fun setLogin(){
        binding.loginBtn.setOnClickListener {
            val email = binding.emailText.text.toString()
            val password = binding.passwordText.text.toString()
            if(isValidCredential(email, password)){
                changeStatus("Success")
            }else{
                changeStatus("Failed")
            }
        }
    }

    private fun changeStatus(status: String){
        binding.status.text = status
    }
    private fun isValidCredential(email: String, password: String): Boolean{
        return email == "example123@gmail.com" && password == "1234567"
    }
}