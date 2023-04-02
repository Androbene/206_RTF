package ua.androbene.a206_retrofit_first.annotations

import ua.androbene.a206_retrofit_first.base.lol

fun usage() {
    val employee = CustomAnnotatedEmployee(1, "Androbene")
    employee.logEmployeeDetails()
    lol("My Company Name: " + employee.company.name)
    lol("My Company City: " + employee.company.city)
}