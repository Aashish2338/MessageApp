package com.message.messageapp.activities

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.message.messageapp.*
import com.message.messageapp.adapters.ContactListAdapter
import com.message.messageapp.database.ContactNumberDatabase
import com.message.messageapp.models.ContactsModal
import com.message.messageapp.utilities.UserSession
import kotlinx.coroutines.launch
import java.util.*

class ContactListActivity : AppCompatActivity(), View.OnClickListener,
    ContactListAdapter.OnClickInterface {

    private lateinit var mContext: Context
    private lateinit var userSession: UserSession
    private lateinit var contactListRcView: RecyclerView
    private lateinit var addContact_btn: AppCompatButton
    private lateinit var sendMsg_btn: AppCompatButton
    private lateinit var oopsDataLayout: LinearLayout
    private lateinit var searchName: EditText
    private lateinit var contactListAdapter: ContactListAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var cursor: Cursor
    private var contactId: String = ""
    private var displayName: String = ""
    private var phoneNumber: String = ""

    private val filtered: ArrayList<ContactsModal>? = ArrayList()
    private var data: List<ContactsModal>? = null
    private var dialog: Dialog? = null

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)
        try {
            mContext = this
            userSession = UserSession(mContext)

            getLayoutUiIdFind()
            getContactNumber()
            addTextListener()

            addContact_btn.setOnClickListener(this)
            sendMsg_btn.setOnClickListener(this)

        } catch (exp: Exception) {
            exp.stackTrace
        }
    }

    private fun addTextListener() {
        try {
            searchName.addTextChangedListener(object : TextWatcher {
                @SuppressLint("NotifyDataSetChanged")
                override fun afterTextChanged(msg: Editable) {
                    filter(msg.toString())
                    contactListAdapter.notifyDataSetChanged()
                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int, count: Int, after: Int
                ) {
                }

                override fun onTextChanged(
                    query: CharSequence, start: Int, before: Int, count: Int
                ) {
                }
            })
        } catch (exp: Exception) {
            exp.stackTrace
        }
    }

    @SuppressLint("Range", "Recycle", "NotifyDataSetChanged")
    private fun getContactNumber() {
        try {
            cursor = contentResolver.query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
            )!!

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val hasPhoneNumber =
                        cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
                            .toInt()
                    if (hasPhoneNumber > 0) {
                        contactId =
                            cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                        displayName =
                            cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        val phoneCursor = contentResolver.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            arrayOf(contactId),
                            null
                        )

                        if (phoneCursor!!.moveToNext()) {
                            phoneNumber = phoneCursor.getString(
                                phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                            )

                            println("Name:- $displayName, phone number :- $phoneNumber")
                            if (phoneNumber.length >= 10) {
                                val contactsModal = ContactsModal(displayName, phoneNumber)

                                val contactNumberDatabase by lazy {
                                    ContactNumberDatabase.getDatabase(mContext).repoDao()
                                }
                                lifecycleScope.launch {
                                    contactNumberDatabase.addContactNumber(contactsModal)
                                }
                            } else {
                                println("Invalid mobile number because this is not 10 digit!")
                            }
                        }
                        phoneCursor.close()
                    }
                }
            }

            cursor.close()
            contactListAdapter.notifyDataSetChanged()

        } catch (exp: Exception) {
            exp.stackTrace
        }
    }

    private fun getLayoutUiIdFind() {
        try {
            contactListRcView = findViewById<RecyclerView>(R.id.contactListRcView) as RecyclerView
            addContact_btn = findViewById<AppCompatButton>(R.id.addContact_btn) as AppCompatButton
            sendMsg_btn = findViewById<AppCompatButton>(R.id.sendMsg_btn) as AppCompatButton
            oopsDataLayout = findViewById<LinearLayout>(R.id.oopsDataLayout) as LinearLayout
            searchName = findViewById<EditText>(R.id.searchName) as EditText

        } catch (exp: Exception) {
            exp.stackTrace
        }
    }

    private fun filter(text: String) {
        try {
            filtered?.clear()
            for (item in data!!) {
                if (item.userName.lowercase(Locale.getDefault())
                        .contains(text.lowercase(Locale.getDefault()))
                ) {
                    filtered?.add(item)
                    val gson = Gson()
                    println("Selected size :- ${filtered?.size}")
                    val json: String = gson.toJson(filtered)
                    userSession.setMobileNumber(json)
                }
            }
            if (filtered?.isEmpty()!!) {
                Toast.makeText(mContext, "No Contact Found", Toast.LENGTH_SHORT).show()
            } else {
                contactListAdapter.filterList(filtered)
                val gson = Gson()
                println("Selected size :- ${filtered.size}")
                val json: String = gson.toJson(filtered)
                userSession.setMobileNumber(json)
            }
        } catch (exp: Exception) {
            exp.stackTrace
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.addContact_btn -> {
                addNewContactNumber()
            }

            R.id.sendMsg_btn -> {
                startActivity(
                    Intent(
                        mContext, CreateMessageActivity::class.java
                    ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                )
            }
        }
    }

    private fun addNewContactNumber() {
        try {
            dialog = Dialog(mContext)
            dialog?.setContentView(R.layout.add_contact_number_layout)
            dialog?.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog?.setCanceledOnTouchOutside(false)
            dialog?.window?.attributes?.windowAnimations = R.style.animation

            val nameEt: EditText = dialog?.findViewById(R.id.nameEt) as EditText
            val numberEt: EditText = dialog?.findViewById(R.id.numberEt) as EditText
            val mailEt: EditText = dialog?.findViewById(R.id.mailEt) as EditText
            val saveBtn: AppCompatButton = dialog?.findViewById(R.id.saveBtn) as AppCompatButton

            saveBtn.setOnClickListener {
                val name: String = nameEt.text.trim().toString()
                val phone: String = numberEt.text.trim().toString()
                val email: String = mailEt.text.trim().toString()
                if (name == "") {
                    Toast.makeText(mContext, "Please enter name!", Toast.LENGTH_SHORT).show()
                } else if (phone == "") {
                    Toast.makeText(mContext, "Please enter number!", Toast.LENGTH_SHORT).show()
                } else if (email == "") {
                    Toast.makeText(mContext, "Please enter mail-id!", Toast.LENGTH_SHORT).show()
                } else {
                    addContact(name, email, phone)
                    dialog?.dismiss()
                    dialog?.cancel()
                }
            }
            dialog?.show()
        } catch (exp: Exception) {
            exp.stackTrace
        }
    }

    private fun addContact(name: String, email: String, phone: String) {
        try {
            val contactIntent = Intent(ContactsContract.Intents.Insert.ACTION)
            contactIntent.type = ContactsContract.RawContacts.CONTENT_TYPE
            contactIntent.putExtra(ContactsContract.Intents.Insert.NAME, name)
                .putExtra(ContactsContract.Intents.Insert.PHONE, phone)
                .putExtra(ContactsContract.Intents.Insert.EMAIL, email)
            launchContactActivity.launch(contactIntent)
        } catch (exp: Exception) {
            exp.stackTrace
        }
    }

    private var launchContactActivity = registerForActivityResult<Intent, ActivityResult>(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        try {
            if (result.resultCode == RESULT_OK) {
                Toast.makeText(mContext, "Contact has been added.", Toast.LENGTH_SHORT).show()
                getContactNumber()
            }
        } catch (exp: Exception) {
            exp.stackTrace
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun prepareAllContactNumber(data: List<ContactsModal>) {
        try {
            println("Contact numbers :- " + data.size)
            if (data.isNotEmpty()) {
                sendMsg_btn.visibility = View.GONE
                contactListAdapter = ContactListAdapter(mContext, data, this)
                linearLayoutManager = LinearLayoutManager(mContext)
                contactListRcView.layoutManager = linearLayoutManager
                contactListRcView.adapter = contactListAdapter
                contactListAdapter.notifyDataSetChanged()
            } else {
                oopsDataLayout.visibility = View.VISIBLE
            }
        } catch (exp: Exception) {
            exp.stackTrace
        }
    }

    override fun onClickCreateMessage(position: Int) {
        when (sendMsg_btn.visibility) {
            View.GONE -> {
                sendMsg_btn.visibility = View.VISIBLE
            }

            else -> {
                sendMsg_btn.visibility = View.VISIBLE
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val contactNumberDatabase by lazy {
            ContactNumberDatabase.getDatabase(mContext).repoDao()
        }

        lifecycleScope.launch {
            data = contactNumberDatabase.getAllContactNumber()
            if (data != null) {
                println("Contact list size :- ${data?.size}")
                prepareAllContactNumber(data!!)
            } else {
                println("Contact list size :- N/A")
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        val contactNumberDatabase by lazy {
            ContactNumberDatabase.getDatabase(mContext).repoDao()
        }

        lifecycleScope.launch {
            data = contactNumberDatabase.getAllContactNumber()
            if (data != null) {
                println("Contact list size :- ${data?.size}")
                prepareAllContactNumber(data!!)
            } else {
                println("Contact list size :- N/A")
            }
        }
    }

    override fun onResume() {
        super.onResume()

        val contactNumberDatabase by lazy {
            ContactNumberDatabase.getDatabase(mContext).repoDao()
        }

        lifecycleScope.launch {
            data = contactNumberDatabase.getAllContactNumber()
            if (data != null) {
                println("Contact list size :- ${data?.size}")
                prepareAllContactNumber(data!!)
            } else {
                println("Contact list size :- N/A")
            }
        }
    }
}