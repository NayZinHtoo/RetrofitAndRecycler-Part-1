package com.nzh.retrofitandrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nzh.retrofitandrecyclerview.adapter.RegionAdapter
import com.nzh.retrofitandrecyclerview.model.Region
import com.nzh.retrofitandrecyclerview.network.APIClient
import com.nzh.retrofitandrecyclerview.network.APIService
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var apiService: APIService = APIClient.client.create((APIService::class.java))
    var regionList:List<Region>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var regionRecycler: RecyclerView =findViewById(R.id.region_recycler)
        regionRecycler.layoutManager= LinearLayoutManager(this)

        val call=apiService.getRegion()
        call.enqueue(object :retrofit2.Callback<List<Region>>{
            override fun onFailure(call: Call<List<Region>>, t: Throwable) {
            }
            override fun onResponse(call: Call<List<Region>>, response: Response<List<Region>>) {
                regionList=response.body()

                var regionAdapter=RegionAdapter(regionList as ArrayList<Region>)
                regionRecycler.adapter=regionAdapter

            }
        })
    }
}
