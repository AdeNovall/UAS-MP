package com.Android.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.Android.Model.NoteModel
import com.Android.UAS_AdeNoval.R

class NoteAdapter (
    val notes: ArrayList<NoteModel.Data>
): RecyclerView.Adapter<NoteAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter, parent, false)
    )

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        val data = notes[position]
        holder.textCatatan.text = data.nama
//        holder.textWaktu.text = data.waktu
    }

    override fun getItemCount() = notes.size

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textCatatan = view.findViewById<TextView>(R.id.text_catatan)
//        val textWaktu = view.findViewById<TextView>(R.id.text_waktu)

    }

    public fun setData(data: List<NoteModel.Data>){
        notes.clear()
        notes.addAll(data)
        notifyDataSetChanged()
    }

}