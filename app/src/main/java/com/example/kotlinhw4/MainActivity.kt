package com.example.kotlinhw4

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridview = findViewById<gridView>(R.id.gridView)

        val item = ArrayList<Item>()
        val array = resources.obtainTypedArray(R.array.resourceList)
        val item = arrayOf("哭哭","發抖","再見","生氣","昏倒","竊笑","很棒","你好","驚嚇","大笑")
        array.recycle()
        spinner.adapter = MyAdapter(R.layout.adapter_horizontal, item)
        gridview.numColumns = 3
        gridview.adapter = Myadapter(R.layout.adapter_vertical, item)
        listView.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayListOf("訊息1","訊息2","訊息3","訊息4","訊息5","訊息6"))

        val list_item = arrayListOf("訊息1","訊息2","訊息3","訊息4","訊息5","訊息6")
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list_item)
        val listView = findViewById<Spinner>(R.id.listView)

        listView.adapter = adapter
        listView.setOnClickListener {
            parent, view, position, id ->
            Toast(this,"你選的是"+list_item[position],
            Toast.LENGTH_SHORT).show()
        }

        listView.adapter = MyAdapter()

        data class Item(
            val photo: Int,
            val name: String
        )

    }

    class gridView : View() {
        val item = ArrayList<Item>()
        val array = resources.obtainTypedArray(R.array.resourceList)
        val item = arrayOf("哭哭","發抖","再見","生氣","昏倒","竊笑","很棒","你好","驚嚇","大笑")
        array.recycle()
    }
}
class MyAdapter : BaseAdapter(){
    override fun getCount() = 0
    override fun getItem(position: Int) = null
    override fun getItemId(position: Int) = 0L
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View?{
        return convertView
    }
}
class Myadapter constructor(private val layout:Int,private val data:ArrayList<ClipData.Item>):BaseAdapter() {
    override fun getCount() = data.size
    override fun getItem(position: Int) = data[position]
    override fun getItemId(position: Int) = 0L
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = View.inflate(parent?.context, layout, null)
        view.imageView.setImageresource(data[position].photo)
        view.name.text = data[position].name

        return view
    }
}