package ua.androbene.a206_retrofit_first.annotations

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class MyCompany(
    val name: String = "LTD",
    val city: String = "Kiev"
)