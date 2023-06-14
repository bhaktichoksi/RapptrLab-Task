package com.datechnologies.androidtest.chat

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.datechnologies.androidtest.R
import com.datechnologies.androidtest.api.ChatLogMessageModel
import com.datechnologies.androidtest.chat.ChatAdapter.ChatViewHolder
import com.squareup.picasso.Picasso
import java.util.*


/**
 * A recycler view adapter used to display chat log messages in [ChatActivity].
 *
 */
class ChatAdapter(private var messages: List<ChatLogMessageModel> = mutableListOf()) : RecyclerView.Adapter<ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ChatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(messages[position])
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    class ChatViewHolder(view: View) : ViewHolder(view) {
        var avatarImageView: ImageView
        var messageTextView: TextView
        var userTextView: TextView

        init {
            avatarImageView = view.findViewById<View>(R.id.avatarImageView) as ImageView
            messageTextView = view.findViewById<View>(R.id.messageTextView) as TextView
            userTextView = view.findViewById<View>(R.id.userTextView) as TextView
        }

        fun bind(message: ChatLogMessageModel) {
            messageTextView.text = message.message
            userTextView.text = message.name
            Picasso.get().load(message.avatar_url).into(avatarImageView)
        }
    }
}