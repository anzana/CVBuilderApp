package com.example.cvbuilderapp.data

class Education (
    val institutionName: String,
    val program: String,
    val logo: String
){
    companion object {
        fun getEducationList() : MutableList<Education> {
            return mutableListOf(
                Education(
                    "Maharishi International University",
                    "Master's in Computer Science(Compro)",
                    "https://maharishischool.org/wp-content/uploads/MaharishiSchoolTreeLogo-8cc541-green.jpg",
                    ),
                Education(
                    "Gandaki College of Engineering and Science",
                    "Bachelor in Software Engineering",
                    "https://gces.edu.np/wp-content/uploads/2019/07/gces_logo.png",
                )
            )
        }
    }
}