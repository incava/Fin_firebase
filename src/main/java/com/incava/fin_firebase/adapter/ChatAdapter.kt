package com.incava.fin_firebase.adapter
/*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import com.incava.fin_firebase.Model.ChatModel
import com.incava.fin_firebase.Model.Personinfo
import com.incava.fin_firebase.databinding.ItemHomeBinding

class ChatAdapter : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>(){

    private lateinit var database: FirebaseDatabase
    private var Chatinfo =  mutableListOf<ChatModel>()

    init{
        //val database = Firebase.database
    }
    interface OnItemClickListener{
        fun onItemClick(v: View, data: Personinfo, pos : Int)
    }
    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }


    fun UpdateUseritem(info : ChatModel) {
        Chatinfo.add(info)
    }

    inner class ChatViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(ChatItem: ChatModel) {

            //binding.tvName.setText(Comment.comments)
            //binding.tvEmail.setText(ChatItem.email)
            binding.root.setOnClickListener {
                val pos = adapterPosition
                if(pos!= RecyclerView.NO_POSITION)
                {
                    itemView.setOnClickListener {
                        //listener?.onItemClick(itemView,ChatItem,pos)
                    }
                }

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ChatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        /*if (itemClick != null) {
             holder?.itemView?.setOnClickListener { v ->
                 //2.아이템 클릭시 onClick 함수 실행됨
                 itemClick!!.onClick(v, position)
             }
         }*/
        holder.bind(Chatinfo[position])
        //holder.bind(personinfo[position])
    }

    override fun getItemCount(): Int {
        return Chatinfo.size
    }
}
}
*/
