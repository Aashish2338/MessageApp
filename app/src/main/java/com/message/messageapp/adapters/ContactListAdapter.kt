package com.message.messageapp.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.message.messageapp.R
import com.message.messageapp.activities.ContactListActivity
import com.message.messageapp.adapters.ContactListAdapter.ContactListViewHolder
import com.message.messageapp.models.ContactsModal
import com.message.messageapp.models.NumberSaveResponse
import com.message.messageapp.utilities.ApiClients
import com.message.messageapp.utilities.ApiInterface
import com.message.messageapp.utilities.UserSession
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class ContactListAdapter(
    mContext: Context,
    private var data: List<ContactsModal>?,
    var onClickInterface: ContactListActivity
) : RecyclerView.Adapter<ContactListViewHolder>() {

    private var userSession: UserSession = UserSession(mContext)
    private var selected: ArrayList<String>? = null
    private var filteredList = ArrayList<ContactsModal>()
    private var selectedItems = SparseBooleanArray()

    init {
        filteredList = ArrayList(data)
    }

    companion object {
        var onClickCheckButton: OnClickInterface? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.contect_item_layout, parent, false)
        return ContactListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactListViewHolder, position: Int) {
        onClickCheckButton = onClickInterface
        val contactsModal: ContactsModal = data?.get(position)!!
        holder.name.text = contactsModal.userName
        holder.number.text = contactsModal.contactNumber
        selected = ArrayList()

        holder.checkNumber.setOnClickListener {
            if (onClickCheckButton != null) {
                if (holder.checkNumber.isChecked) {
                    holder.checkNumber.isChecked = true
                    val gson = Gson()
                    onClickCheckButton?.onClickCreateMessage(position = position)
                    selected?.add(contactsModal.contactNumber)
                    println("Selected size :- $selected")
                    val json: String = gson.toJson(selected)
//                    userSession.setMobileNumber(json)
//                    userSession.setName(contactsModal.userName)
                    var data = apiJsonSign(json).toString()
                    println("data :- $data")
                    saveSelectedNumber(apiJsonSign(json))
                } else {
                    holder.checkNumber.isChecked = false
//                    val gson = Gson()
                    onClickCheckButton?.onClickCreateMessage(position = position)
//                    selected?.remove(contactsModal.contactNumber)
//                    val json: String = gson.toJson(selected)
//                    println("Selected size :- $json")
//                    userSession.setMobileNumber(json)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return data?.size!!
    }

    class ContactListViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val conImage: ImageView = itemView.findViewById<ImageView>(R.id.conImage) as ImageView
        val name: TextView = itemView.findViewById<TextView>(R.id.name) as TextView
        val number: TextView = itemView.findViewById<TextView>(R.id.number) as TextView
        val checkNumber: AppCompatCheckBox =
            itemView.findViewById<AppCompatCheckBox>(R.id.checkNumber) as AppCompatCheckBox
        val showDetails: LinearLayout =
            itemView.findViewById<LinearLayout>(R.id.showDetails) as LinearLayout
    }

    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filterer: ArrayList<ContactsModal>?) {
        data = filterer
        notifyDataSetChanged()
    }

    interface OnClickInterface {
        fun onClickCreateMessage(position: Int)
    }

    private fun saveSelectedNumber(apiJsonSign: JsonObject?) {
        val apiService: ApiInterface =
            ApiClients.getClient()?.create<ApiInterface>(ApiInterface::class.java)!!
        val call: Call<NumberSaveResponse?>? = apiService.numberSaveData(apiJsonSign)
        call!!.enqueue(object : Callback<NumberSaveResponse?> {
            override fun onResponse(
                call: Call<NumberSaveResponse?>, response: Response<NumberSaveResponse?>
            ) {
                if (response.isSuccessful) {
                    var signingResponse = response.body()
                    if (signingResponse?.Id != null) {
                        userSession.setMessage(signingResponse?.Id.toString())
                    }
                }
            }

            override fun onFailure(call: Call<NumberSaveResponse?>, t: Throwable) {
                println("Api error response :- ${t.message}")
            }
        })
    }

    private fun apiJsonSign(jsonArray: String): JsonObject? {
        var gsonMailResult = JsonObject()
        try {
            val paramAbTestResult = JSONObject()
            paramAbTestResult.put("numbers", jsonArray)
            val jsonArrays = JSONArray()
            jsonArrays.put(jsonArray)
            val jsonParser = JsonParser()
            gsonMailResult = jsonParser.parse(paramAbTestResult.toString()) as JsonObject
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return gsonMailResult
    }
}