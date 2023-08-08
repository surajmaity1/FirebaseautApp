package com.surajmaity1.firebaseautapp.realtime_database

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.surajmaity1.firebaseautapp.activities.SignUp
import com.surajmaity1.firebaseautapp.models.User
import com.surajmaity1.firebaseautapp.utils.Constants

class FireBaseRDB {

    private val mFireStore = FirebaseFirestore.getInstance()

    fun registerUser(activity : SignUp, user: User){
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .set(user, SetOptions.merge())
            .addOnSuccessListener {
                FirebaseAuth.getInstance().signOut()
            }.addOnFailureListener { exception ->
                Log.e(activity.javaClass.simpleName,"Error while getting loggedIn user details", exception)
            }
    }

    fun getCurrentUserId():String{
        val currentUser = FirebaseAuth.getInstance().currentUser

        var currentUserId = ""

        if (currentUser != null){
            currentUserId = currentUser.uid
        }

        return currentUserId
    }

}