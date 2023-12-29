package com.message.messageapp.activities

import android.Manifest.permission.*
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.message.messageapp.R

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var mContext: Context
    private var splash_Screen_Time = 2000
    private val request_Code = 124

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        mContext = this

        checkMultiplePermissions()
        getSoftwareVersion()
    }

    private fun checkMultiplePermissions() {
        val permissionsNeeded: MutableList<String> = ArrayList()
        val permissionsList: MutableList<String> = ArrayList()
        if (!addPermission(permissionsList, READ_CONTACTS)) {
            permissionsNeeded.add("Read Storage")
        }

        if (!addPermission(permissionsList, CALL_PHONE)) {
            permissionsNeeded.add("Write Storage")
        }

        if (!addPermission(permissionsList, SEND_SMS)) {
            permissionsNeeded.add("Manage Storage")
        }

        if (!addPermission(permissionsList, WRITE_CONTACTS)) {
            permissionsNeeded.add("Camera")
        }

        if (permissionsList.size > 0) {
            requestPermissions(
                permissionsList.toTypedArray<String>(), request_Code
            )
            return
        } else {
            getGotoNextPage()
        }
    }

    private fun addPermission(permissionsList: MutableList<String>, permission: String): Boolean {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission)
            // Check for Rationale Option
            if (!shouldShowRequestPermissionRationale(permission)) return false
        }
        return true
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            request_Code -> {
                val perms: MutableMap<String, Int> = HashMap()
                perms[READ_CONTACTS] = PackageManager.PERMISSION_GRANTED
                perms[CALL_PHONE] = PackageManager.PERMISSION_GRANTED
                perms[SEND_SMS] = PackageManager.PERMISSION_GRANTED
                perms[WRITE_CONTACTS] = PackageManager.PERMISSION_GRANTED

                var i = 0
                while (i < permissions.size) {
                    perms[permissions[i]] = grantResults[i]
                    i++
                }

                if (perms[READ_CONTACTS] == PackageManager.PERMISSION_GRANTED
                    && perms[CALL_PHONE] == PackageManager.PERMISSION_GRANTED
                    && perms[SEND_SMS] == PackageManager.PERMISSION_GRANTED
                    && perms[WRITE_CONTACTS] == PackageManager.PERMISSION_GRANTED
                ) {
                    getGotoNextPage()
                    return
                } else {
                    getGotoNextPage()
                }
            }

            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    private fun getGotoNextPage() {
        Handler().postDelayed({
            try {
                startActivity(
                    Intent(
                        mContext, ContactListActivity::class.java
                    ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                )
                this@SplashScreenActivity.finish()
            } catch (e: Exception) {
                e.stackTrace
            }
        }, splash_Screen_Time.toLong())
    }

    private fun getSoftwareVersion() {
        try {
            val pInfo = mContext.packageManager.getPackageInfo(mContext.packageName, 0)
            val version = pInfo.versionName
            println("Software Version :- $version")
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
    }
}