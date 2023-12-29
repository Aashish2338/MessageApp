package com.message.messageapp.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.gsm.SmsManager
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.message.messageapp.R
import com.message.messageapp.models.NumberResponse
import com.message.messageapp.models.NumberSaveResponse
import com.message.messageapp.utilities.ApiClients
import com.message.messageapp.utilities.ApiInterface
import com.message.messageapp.utilities.UserSession
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class CreateMessageActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mContext: Context
    private lateinit var userSession: UserSession
    private var strName: String = ""
    private var strMobileNumber: String = ""
    private var strMessage: String = ""
    private lateinit var mobileNumber_Tv: TextView
    private lateinit var writeMsg_Et: EditText
    private lateinit var sendMsgBtn: AppCompatButton
    private var separator: String = "; "
    private var allNumbers: String = ""
    private var numbers: Array<String> = arrayOf()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_message)
        try {
            mContext = this
            userSession = UserSession(mContext)
            getLayoutUiIdFind()

            strName = userSession.getName().toString()
            strMobileNumber = userSession.getMobileNumber().toString()
            strMessage = userSession.getMessage().toString()
            println("Selected number :- $strMobileNumber")
            val jsonArrayString = strMobileNumber
            val parsedList = parseJsonArray(jsonArrayString)
            println("Data list :- $parsedList")

            var idNumber = userSession.getMessage().toString()

//            mobileNumber_Tv.text = b
            sendMsgBtn.setOnClickListener(this)

            getSavedNumbers(idNumber)
        } catch (exp: Exception) {
            exp.stackTrace
        }
    }

    private fun getSavedNumbers(idNumber: String) {
        val apiService: ApiInterface =
            ApiClients.getClient()?.create<ApiInterface>(ApiInterface::class.java)!!
        val call: Call<NumberResponse?> = apiService.getSaveNumberData(idNumber)
        call.enqueue(object : Callback<NumberResponse?> {
            override fun onResponse(
                call: Call<NumberResponse?>, response: Response<NumberResponse?>
            ) {
                if (response.isSuccessful) {
                    println("All numbers Data :- ${response.body()?.numbers}")
                    for (item in response.body()?.numbers!!) {
                        val a = item.replace("[", "")
                        val b = a.replace("]", "")
                        val c = b.replace("\"", "")
                        mobileNumber_Tv.text = c
                    }
//                    val a = response.body()?.numbers.toString().replace("[[", "")
//                    val b = a.replace("]]", "")
//                    val c = b.replace("\"", "")
//                    mobileNumber_Tv.text = c
                } else {
                    println("All numbers Data :- ${response.body()?.numbers}")
                }
            }

            override fun onFailure(call: Call<NumberResponse?>, t: Throwable) {
                println("All numbers data response :- ${t.message}")
            }
        })
    }

    private fun parseJsonArray(jsonArrayString: String): List<String> {
        val jsonArray = JSONArray(jsonArrayString)
        val resultList = mutableListOf<String>()

        for (i in 0 until jsonArray.length()) {
            val stringValue = jsonArray.getString(i)
            resultList.add(stringValue)
        }

        return resultList
    }

    private fun getLayoutUiIdFind() {
        try {
            mobileNumber_Tv = findViewById<TextView>(R.id.mobileNumber_Tv) as TextView
            writeMsg_Et = findViewById<EditText>(R.id.writeMsg_Et) as EditText
            sendMsgBtn = findViewById<AppCompatButton>(R.id.sendMsgBtn) as AppCompatButton

        } catch (exp: Exception) {
            exp.message
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.sendMsgBtn -> {
                try {
                    strMessage = writeMsg_Et.text.trim().toString()
                    if (strMobileNumber == "") {
                        Toast.makeText(
                            mContext,
                            "Please select your number for message firstly and then send sms...",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (strMessage == "") {
                        Toast.makeText(
                            mContext,
                            "Please type your message firstly and then send sms...",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val jsonArrayString = strMobileNumber
                        val parsedList = parseJsonArray(jsonArrayString)
                        val smsManager: SmsManager = SmsManager.getDefault()
                        for (number in parsedList) {
                            smsManager.sendTextMessage(number, null, strMessage, null, null)
                        }
                        Toast.makeText(
                            mContext,
                            "Your message has been send successfully on your selected number.",
                            Toast.LENGTH_SHORT
                        ).show()
                        startActivity(
                            Intent(
                                mContext, ContactListActivity::class.java
                            ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                        )
                    }
                } catch (exp: Exception) {
                    exp.stackTrace
                }
            }
        }
    }
}