package com.udacity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.udacity.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  =  ActivityDetailBinding.inflate(layoutInflater)
        binding.apply {
            setSupportActionBar(toolbar)
            val fileName = intent.getStringExtra(FILE_NAME)
            val status = intent.getStringExtra(STATUS)
            content.tvFileName.text = fileName
            content.tvStatus.text = status
            content.btnOk.setOnClickListener {
                this@DetailActivity.onBackPressed()
            }
        }
        setContentView(binding.root)
    }

    companion object {
        const val FILE_NAME = "FILE_NAME"
        const val STATUS = "STATUS"
    }
}
