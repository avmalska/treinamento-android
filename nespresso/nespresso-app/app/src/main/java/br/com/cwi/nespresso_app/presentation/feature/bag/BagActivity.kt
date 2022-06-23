package br.com.cwi.nespresso_app.presentation.feature.bag

import android.os.Bundle
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import br.com.cwi.nespresso_app.databinding.ActivityBagBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BagActivity : BaseBottomNavigation() {

    private lateinit var binding : ActivityBagBinding

    override val currentTab: Int = R.id.bag_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBagBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

}