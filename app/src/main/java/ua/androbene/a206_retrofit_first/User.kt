package ua.androbene.a206_retrofit_first

data class User(
    val name: String,
    val email: String,
    val phone: String,
    val address: Address
)

data class Address(
    val street: String,
    val suite: String,
)