package com.example.listdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PersonAdapter (val personsList: List<Person>, val activity: MainActivity): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>(){
    class PersonViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvName = itemView.findViewById<TextView>(R.id.textName)
        val tvSName = itemView.findViewById<TextView>(R.id.textSecondName)
        val tvAge = itemView.findViewById<TextView>(R.id.textAge)
        val ivPhoto = itemView.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_layout,parent,false)
        val viewHolder = PersonViewHolder(itemView)
        viewHolder.itemView.setOnLongClickListener {
            val position = viewHolder.adapterPosition
            activity.deletePerson(position)
            return@setOnLongClickListener true
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val currentPerson = personsList[position]
        holder.tvName.text = currentPerson.name
        holder.tvSName.text = currentPerson.secondName
        holder.tvAge.text = "${currentPerson.age}years"

        if(currentPerson.photo !=null){
            holder.ivPhoto.setImageBitmap(currentPerson.photo)
        }else{
            holder.ivPhoto.setImageResource(currentPerson.photoId)
        }
    }

    override fun getItemCount(): Int {
        return personsList.size
    }
}