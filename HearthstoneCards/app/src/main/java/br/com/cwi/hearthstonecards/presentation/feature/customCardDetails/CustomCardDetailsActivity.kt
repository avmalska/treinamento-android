package br.com.cwi.hearthstonecards.presentation.feature.customCardDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.cwi.hearthstonecards.databinding.ActivityCustomCardDetailBinding
import com.bumptech.glide.Glide

class CustomCardDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomCardDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomCardDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUpPage()
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setUpPage() {
        binding.tvCustomCardNameDetail.text = intent.getStringExtra("customCardName")
        val customCardImg = intent.getByteArrayExtra("customCardImage")
        Glide.with(this).load(customCardImg).into(binding.ivCustomCardImage)
    }
}