package com.incava.fin_firebase.Model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.incava.fin_firebase.databinding.ItemHomeBinding

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    private var personinfo =  mutableListOf<Personinfo>()

    fun setListData(data:MutableList<Personinfo>){
        personinfo = data
    }



    interface OnItemClickListener{
        fun onItemClick(v:View, data: Personinfo, pos : Int)
    }


    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }


    fun UpdateUseritem(info : Personinfo) {
       personinfo.add(info)
    }

    inner class PersonViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(PersonItem:Personinfo) {

            binding.tvName.setText(PersonItem.name)
            binding.tvEmail.setText(PersonItem.email)
            binding.root.setOnClickListener {
                val pos = adapterPosition
                if(pos!= RecyclerView.NO_POSITION)
                {
                    itemView.setOnClickListener {
                        listener?.onItemClick(itemView,PersonItem,pos)
                        Toast.makeText(binding.root.context,PersonItem.toString(),Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
       /*if (itemClick != null) {
            holder?.itemView?.setOnClickListener { v ->
                //2.아이템 클릭시 onClick 함수 실행됨
                itemClick!!.onClick(v, position)
            }
        }*/
        holder.bind(personinfo[position])
        //holder.bind(personinfo[position])
    }

    override fun getItemCount(): Int {
        return personinfo.size
    }
}