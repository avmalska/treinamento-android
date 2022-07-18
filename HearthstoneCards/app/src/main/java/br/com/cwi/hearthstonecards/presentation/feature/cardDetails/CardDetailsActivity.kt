package br.com.cwi.hearthstonecards.presentation.feature.cardDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.cwi.hearthstonecards.databinding.ActivityCardDetailsBinding
import com.bumptech.glide.Glide

class CardDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCardDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardDetailsBinding.inflate(layoutInflater)
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
        binding.tvCardNameDetail.text = intent.getStringExtra("cardName")
        binding.tvCardFlavour.text = intent.getStringExtra("cardFlavour")
        val cardImg = intent.getStringExtra("cardImg") ?: "https://www.shareicon.net/download/2015/09/21/104677_back_450x671.png"
        Glide.with(this).load(cardImg).into(binding.ivCardImage)
    }

}