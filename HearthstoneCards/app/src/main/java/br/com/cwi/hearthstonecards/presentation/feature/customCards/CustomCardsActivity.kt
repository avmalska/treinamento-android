package br.com.cwi.hearthstonecards.presentation.feature.customCards

import android.content.Intent
import android.os.Bundle
import br.com.cwi.hearthstonecards.R
import br.com.cwi.hearthstonecards.databinding.ActivityCustomCardsBinding
import br.com.cwi.hearthstonecards.presentation.base.BaseBottomNavigation
import br.com.cwi.hearthstonecards.presentation.feature.createCustomCard.CreateCustomCardActivity
import br.com.cwi.hearthstonecards.presentation.feature.listedCustomCards.ListedCustomCardActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class CustomCardsActivity : BaseBottomNavigation() {

    private lateinit var binding : ActivityCustomCardsBinding

    override val currentTab: Int = R.id.customcards_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomCardsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpButtonActions()
    }

    private fun setUpButtonActions() {
        binding.btnTakePicture.setOnClickListener {
            val intent = Intent(this, CreateCustomCardActivity::class.java)
            startActivity(intent)
        }
        binding.btnViewCustomCards.setOnClickListener {
            val intent = Intent(this, ListedCustomCardActivity::class.java)
            startActivity(intent)
        }
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

}