package br.com.cwi.nespresso_app.presentation.feature.favorites

import android.os.Bundle
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import br.com.cwi.nespresso_app.databinding.ActivityFavoritesBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class FavoritesActivity : BaseBottomNavigation() {

    private lateinit var binding : ActivityFavoritesBinding

    override val currentTab: Int = R.id.favorites_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

}