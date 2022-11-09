fun main() {

    val regularCustomer = true
    val customer = false
    val amount = 100500

    try {
        val price = resulPriceForMusic(amount, regularCustomer)
        println(price)
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun resulPriceForMusic(amount: Int, isRegularCustomer: Boolean): Int {
    val discount = 5
    val discountForRegularCustomer = 1
    val result = when {
        amount in 0..1000 -> amount
        amount in 1001..10000 -> amount - 100
        amount in 10001..Int.MAX_VALUE ->
            if (isRegularCustomer)
                ((amount * (1 - (discount.toDouble() / 100))) * (1 - (discountForRegularCustomer.toDouble() / 100))).toInt()
            else (amount * (1 - discount.toDouble())).toInt()

        else -> throw Exception("Invalid amount")
    }
    return result
}