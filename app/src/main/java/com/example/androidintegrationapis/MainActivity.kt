package com.example.androidintegrationapis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidintegrationapis.api.MyRetrofit
import com.example.androidintegrationapis.model.Product
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        product_list.layoutManager = LinearLayoutManager(this)
        getData()
    }

    private fun getData() {
        val call: Call<List<Product>> =
            MyRetrofit.instance?.productApi()?.getProductApi() as Call<List<Product>>
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                val adapter = ProductAdapter(
                    this@MainActivity,
                    response.body()?.toList() ?: listOf()
                )
                product_list.adapter = adapter
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t?.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}