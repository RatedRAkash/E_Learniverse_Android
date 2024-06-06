package com.example.e_learniverse_android.kotlin_code.basic_kotlin_code

class Akash : Parent() {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var akash: String = "Sergio Ramos"
            println("Welcome Back to Real Madrid $Ramos ${add(2, 2)}")

            //"var" vs "val"
            //"var" --> this variable can be Re-Assigned
            //"val" --> this variable can NOT be Re-Assigned

            var a: Int = 100
            a = 200
            println(a)

            val b: Int = 200
        }

        fun add(a: Int, b: Int): Int {
            return a + b
        }

    }
}