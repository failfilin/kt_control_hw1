fun main() {
    val timeUserOut = 3600
    val userStatus = agoToNext(timeUserOut)
    println(userStatus)
}

fun agoToNext(timeUserOut: Int): String {
    return when {
        timeUserOut > 60 && timeUserOut <= (60 * 60) -> "был(а) ${timeUserOut / 60} ${minutEnder(timeUserOut)} назад"
        timeUserOut > (60 * 60) && timeUserOut <= (24 * 60 * 60) -> "был(а) ${timeUserOut / (60 * 60)} ${hourEnder(timeUserOut)} назад"
        timeUserOut > (24 * 60 * 60) && timeUserOut <= (2 * 24 * 60 * 60) -> "был(а) вчера"
        timeUserOut > (2 * 24 * 60 * 60) && timeUserOut <= (3 * 24 * 60 * 60) -> "был(а) позавчера"
        timeUserOut > (3 * 24 * 60 * 60) -> "был(а) давно"
        else -> "был(а) только что"
    }
}

fun minutEnder(timeUserOut: Int): String {
    val inMinut = timeUserOut / 60
    return when {
        inMinut != 11 && inMinut % 10 == 1 -> "минуту"
        inMinut >= 20 && inMinut % 10 in arrayOf(2, 3, 4) || inMinut < 10 && inMinut % 10 in arrayOf(2, 3, 4) -> "минуты"
        else -> "минут"
    }
}

fun hourEnder(timeUserOut: Int): String{
    val inHour = timeUserOut/3600
    return when {
        inHour != 11 && inHour % 10 ==1 -> "час"
        inHour >= 20 && inHour % 10 in arrayOf(2, 3, 4) || inHour < 10 && inHour % 10 in arrayOf(2, 3, 4) -> "часа"
        else -> "часов"
    }
}