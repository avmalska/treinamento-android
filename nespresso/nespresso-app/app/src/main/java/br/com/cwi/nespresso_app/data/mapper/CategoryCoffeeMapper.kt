package br.com.cwi.nespresso_app.data.mapper

import br.com.cwi.nespresso_app.data.entity.CategoryCoffeeResponse
import br.com.cwi.nespresso_app.domain.entity.Category

class CategoryCoffeeMapper: DomainMapper<CategoryCoffeeResponse, Category> {

    override fun toDomain(from: CategoryCoffeeResponse) = Category(
        category = from.category,
        products = CoffeeMapper().toDomain(from.coffees)
    )

    override fun toDomain(from: List<CategoryCoffeeResponse>) = from.map {
        toDomain(it)
    }

}