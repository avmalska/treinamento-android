package br.com.cwi.nespresso_app.presentation.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityCoffeeBinding
import br.com.cwi.nespresso_app.databinding.ViewErrorBinding
import br.com.cwi.nespresso_app.presentation.extension.visibleOrGone
import br.com.cwi.nespresso_app.presentation.feature.bag.BagActivity
import br.com.cwi.nespresso_app.presentation.feature.favorites.FavoritesActivity
import br.com.cwi.nespresso_app.presentation.feature.products.ProductsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.security.acl.Owner

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
                R.id.products_menu -> {
                    val intent = Intent(this, ProductsActivity::class.java)
                    startActivity(intent)
                }
                R.id.favorites_menu -> {
                    val intent = Intent(this, FavoritesActivity::class.java)
                    startActivity(intent)
                }
                R.id.bag_menu -> {
                    val intent = Intent(this, BagActivity::class.java)
                    startActivity(intent)
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun selectCurrentTab() {
        getBottomNavigation().selectedItemId = currentTab
    }
}