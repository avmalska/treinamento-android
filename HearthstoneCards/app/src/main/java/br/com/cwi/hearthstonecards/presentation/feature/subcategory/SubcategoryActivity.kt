package br.com.cwi.hearthstonecards.presentation.feature.subcategory

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import br.com.cwi.hearthstonecards.R
import br.com.cwi.hearthstonecards.databinding.ActivityCardSubcategoryBinding
import br.com.cwi.hearthstonecards.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class SubcategoryActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityCardSubcategoryBinding

    override val currentTab: Int = R.id.home_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardSubcategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpAdapter()
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

/*    private fun setUpViewModel() {

    }*/

    private fun setUpAdapter() {
        binding.rvSubcategories.apply {
            val categoryname = intent.getStringExtra("categoryname")
            adapter = intent.getStringArrayListExtra("subcategorys")
                ?.let { SubcategoryAdapter(context = context, it, categoryname!!) }
            layoutManager = GridLayoutManager(context, 2)
        }
    }
}