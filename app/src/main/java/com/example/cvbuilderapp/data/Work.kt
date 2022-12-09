package com.example.cvbuilderapp.data

data class Work (
    val organizationName: String,
    val startDate: String,
    val endDate: String,
    val location: String,
    val logo: String,
    val roles: String
) {
    companion object {
        fun getWorkList() : MutableList<Work> {
            return mutableListOf(
                Work (
                    "Imark Digital Private Limited",
                    "January 2020",
                    "September 2021",
                    "Pokhara, Nepal",
                    "https://www.imarkdigital.com/public/assets/img/imark-logo.png",
                    "Worked as Sotware Engineer for Healthcare Management System"
                        ),
                Work (
                    "Creospan",
                    "September 2022",
                    "Present",
                    "Schaumburg, IL",
                    "https://creospan.com/wp-content/uploads/2022/09/creospan_logo_88.png",
                    "Working as a Full Stack Engineer"
                )
            )
        }
    }
}