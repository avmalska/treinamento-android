package br.com.cwi.hearthstonecards.presentation.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import br.com.cwi.hearthstonecards.R
import br.com.cwi.hearthstonecards.presentation.feature.categories.CategoriesActivity
import br.com.cwi.hearthstonecards.presentation.feature.customCards.CustomCardsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class BaseBottomNavigation : AppCompatActivity() {

    abstract val currentTab: Int

    abstract fun getBottomNavigation(): BottomNavigationView

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }

    override fun onResume() {
        super.onResume()
        setUpBottomNavigationActions()
        selectCurrentTab()
    }

    private fun setUpBottomNavigationActions() {

        getBottomNavigation().setOnItemSelectedListener {
            if (it.itemId != this.currentTab) when (it.itemId) {
                R.id.home_menu -> {
                    val intent = Intent(this, CategoriesActivity::class.java)
                    startActivity(intent)
                }
                R.id.customcards_menu -> {
                    val intent = Intent(this, CustomCardsActivity::class.java)
                    startActivity(intent)
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun selectCurrentTab() {
        getBottomNavigation().selectedItemId = currentTab
    }

}