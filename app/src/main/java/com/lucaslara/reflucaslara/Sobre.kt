package com.lucaslara.reflucaslara

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucaslara.reflucaslara.bases.Registros
import com.lucaslara.reflucaslara.databinding.ActivitySobreBinding

class Sobre : AppCompatActivity() {

    private lateinit var linksAdapter: LinksAdapter
    private lateinit var binding: ActivitySobreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySobreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniciarRecyclerView()
        addDataSource()


    }

    private fun addDataSource() {
        val dataSource = Registros.createLinks()
        this.linksAdapter.setDataSet(dataSource)
    }

    private fun iniciarRecyclerView() {
        this.linksAdapter = LinksAdapter()

        binding.recyclerview.layoutManager = LinearLayoutManager(this@Sobre)
        binding.recyclerview.adapter = this.linksAdapter
    }
}