package com.suaratech.pilpres.jagakpu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import com.github.mikephil.charting.formatter.PercentFormatter
import android.R.attr.data
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bungkus.shop.bungkus.ApiClient
import com.bungkus.shop.bungkus.ApiInterface
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import com.suaratech.pilpres.jagakpu.R.id.piechart
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.R.attr.data
import android.graphics.Color


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getData()



    }


    private fun getData(){
        val apiInterface = ApiClient().client.create(ApiInterface::class.java)
        val call = apiInterface.getApiKpu()

        call.enqueue(object : Callback<com.suaratech.pilpres.jagakpu.data.Response> {
            override fun onResponse(call: Call<com.suaratech.pilpres.jagakpu.data.Response>, response: Response<com.suaratech.pilpres.jagakpu.data.Response>) {
                if(response.isSuccessful){
                    try {
                        val a = response.body()
                        val NoOfEmp = ArrayList<Entry>()
                        NoOfEmp.add(Entry(a.results?.jokowi?.percent!!.toFloat(), 0))
                        NoOfEmp.add(Entry(a.results?.prabowo?.percent!!.toFloat(), 1))
                        val dataSet = PieDataSet(NoOfEmp, "Sumber Real Count KPU")
                        val year = ArrayList<String>()
                        year.add("Jokowi-Amin")
                        year.add("Prabowo-sandi")
                        val data = PieData(year,dataSet)
                        data.setValueFormatter(PercentFormatter())
                        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS)
                        piechart.setDescription(a.results?.progress.toString() + "versi :"+a.results.version)
                        piechart.setDrawHoleEnabled(true)
                        piechart.setTransparentCircleRadius(30f);
                        piechart.setHoleRadius(30f)
                        data.setValueTextSize(13f)
                        data.setValueTextColor(Color.DKGRAY);
                        piechart.animateXY(5000, 5000)
                        piechart.data = data
                    }

                    catch (e: Exception) {
                        Log.e("retro",e.toString())
                        Toast.makeText(applicationContext, "server tidak merespon", Toast.LENGTH_LONG).show()
                    }
                }
                piechart.visibility = View.VISIBLE
                progressBar.visibility = View.GONE

            }

            override fun onFailure(call: Call<com.suaratech.pilpres.jagakpu.data.Response>, t: Throwable) {
                Log.e("error ret", t.toString())
            }
        })
    }
}
