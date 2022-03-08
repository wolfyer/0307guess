package com.vangood.guess4

interface Report {
    fun print()
}
class FinanceReport : Report {
    override fun print() {
        println("Finance!")
    }

}

fun main() {
    val financeReport = FinanceReport()
    financeReport.print()

    //anonymous
    object : Report {
        override fun print() {
            println("Health!")
        }
    }.print()
}