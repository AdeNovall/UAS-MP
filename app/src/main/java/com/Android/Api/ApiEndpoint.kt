package com.Android.Api

import com.Android.Model.NoteModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {@GET("data.php")
fun data() : Call<NoteModel>

}