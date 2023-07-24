package com.example.hiltwithcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var apiService: ApiService

    lateinit var textView: TextView
    lateinit var fetchBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView= findViewById(R.id.test)
        fetchBtn= findViewById(R.id.btn)

        fetchBtn.setOnClickListener({
            fetchData()
        })
    }

    private fun fetchData() {
        textView.text = "Loading..."

        // Launch a coroutine in the IO dispatcher using lifecycleScope
        lifecycleScope.launch {
            try {
                // Make the API call using Retrofit and suspend function
                val response = apiService.fetchData()
                // Update UI on the Main dispatcher
                textView.text = "Data: ${response[0].archiveUrl}"
            } catch (e: Exception) {
                // Handle API call error
                textView.text = "Error: ${e.message}"
                Log.d("dfghj", "fetchData: "+e.message)
            }
        }
    }
}