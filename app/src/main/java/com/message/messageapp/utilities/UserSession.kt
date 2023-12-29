package com.message.messageapp.utilities

import android.content.Context
import android.content.SharedPreferences

class UserSession(mContext: Context) {

    private var pref: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null
    private var _context: Context? = null
    private val PRIVATE_MODE = 0
    private val PREF_NAME = "Greenusys"
    private val KEY_NUMBERS = "numbers"
    private val KEY_MESSAGE = "message"

    init {
        this._context = mContext
        pref = _context!!.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref!!.edit()
    }

    fun setName(name: String?) {
        editor!!.putString("name", name)
        editor!!.commit()
    }

    fun getName(): String? {
        return pref!!.getString("name", "")
    }

    fun setMobileNumber(mobileNumber: String?) {
        editor!!.putString("mobileNumber", mobileNumber)
        editor!!.commit()
    }

    fun getMobileNumber(): String? {
        return pref!!.getString("mobileNumber", "")
    }

    fun setMessage(message: String?) {
        editor!!.putString("message", message)
        editor!!.commit()
    }

    fun getMessage(): String? {
        return pref!!.getString("message", "")
    }

}