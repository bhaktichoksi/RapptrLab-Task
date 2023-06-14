package com.datechnologies.androidtest.chat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.datechnologies.androidtest.Api
import com.datechnologies.androidtest.MainActivity
import com.datechnologies.androidtest.api.ChatData
import com.datechnologies.androidtest.api.ChatLogMessageModel
import com.datechnologies.androidtest.databinding.ActivityChatBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Screen that displays a list of chats from a chat log.
 */
class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding
    private lateinit var chatAdapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "Chat"
        }

        getChatData()
        // TODO: Make the UI look like it does in the mock-up. Allow for horizontal screen rotation.

        // TODO: Retrieve the chat data from http://dev.rapptrlabs.com/Tests/scripts/chat_log.php
        // TODO: Parse this chat data from JSON into ChatLogMessageModel and display it.
    }

    private fun getChatData() {
        val tempList: MutableList<ChatLogMessageModel> = ArrayList()

        val rootURL = "https://dev.rapptrlabs.com/Tests/scripts/"
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(rootURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        fun getApiService(): Api {
            return getRetrofitInstance().create(Api::class.java)
        }

        val apis = getApiService()
        val call = apis.getDataFromURL()

        call?.enqueue(object : Callback<ChatData> {
            override fun onResponse(call: Call<ChatData>, response: Response<ChatData>) {
                if (response.isSuccessful) {

                    val chatResponse = response.body()?.data!!
                    for (i in chatResponse.indices) {
                        var chatList = chatResponse[i]

                        tempList.add(ChatLogMessageModel(chatList.user_id, chatList.avatar_url, chatList.name, chatList.message))
                        chatAdapter = ChatAdapter(tempList)
                    }
                }
                binding.recyclerView.adapter = chatAdapter
                binding.recyclerView.setHasFixedSize(true)
                binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext,
                    LinearLayoutManager.VERTICAL,
                    false)
            }

            override fun onFailure(call: Call<ChatData>, t: Throwable) {
                println("failure")
            }
        })
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, ChatActivity::class.java)
            context.startActivity(starter)
        }
    }
}