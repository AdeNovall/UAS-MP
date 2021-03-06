package com.Android.UAS_AdeNoval

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.Android.Adapter.NoteAdapter
import com.Android.Api.ApiRetrofit
import com.Android.Model.NoteModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class daftar_sekolah2 : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var lisNote: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_sekolah2)

        setupList()
    }


    private fun setupList(){
        lisNote = findViewById(R.id.list_catatan)
        noteAdapter = NoteAdapter(arrayListOf())
        lisNote.adapter = noteAdapter
    }

    override fun onStart() {
        super.onStart()
        getNote()
    }


    private fun getNote(){
        api.data().enqueue(object : Callback<NoteModel> {
            override fun onResponse(call: Call<NoteModel>, response: Response<NoteModel>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.catatan
                    noteAdapter.setData( listData )
//                    listData.forEach {
//                        Log.e("daftar_hadir","nama ${it.nama}")
//                    }
                }
            }

            override fun onFailure(call: Call<NoteModel>, t: Throwable) {
                Log.e("daftar_hadir",t.toString())
            }

        })
    }
}