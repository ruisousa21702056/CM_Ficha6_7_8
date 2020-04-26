package com.example.acalculator

import androidx.lifecycle.ViewModel
import org.apache.commons.codec.digest.DigestUtils

class SignUpViewModel : ViewModel() {

    private val signUpLogic = SignUpLogic()

    fun getUsers(): List<User> {
        return signUpLogic.getUsers()
    }

    fun signUp(name: String, email: String, password: String, confirmPassword: String): Boolean{
        if(!name.equals("") && !email.equals("") && !email.equals("") && password.equals(confirmPassword) ){
            var user_aux = User(name, email, DigestUtils.sha256Hex(password))
            signUpLogic.addUser(user_aux)
            return true
        }
        return false
    }
}