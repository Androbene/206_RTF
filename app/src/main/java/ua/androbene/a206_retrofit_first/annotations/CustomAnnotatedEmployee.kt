package ua.androbene.a206_retrofit_first.annotations

import ua.androbene.a206_retrofit_first.base.lol

@MyCompany
class CustomAnnotatedEmployee(private val id: Int, private val name: String) {

    fun logEmployeeDetails() {
        lol("Employee Id: $id")
        lol("Employee Name: $name")
    }

    val company: MyCompany
        get() = this.javaClass.getAnnotation(MyCompany::class.java)
                as Annotation
                as MyCompany


}