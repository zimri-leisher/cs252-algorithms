package misc

fun main() {
    val counties = mutableListOf(
        Triple(-29, 82, 28338),
        Triple(8, 84, 798908),
        Triple(-57, 85, 19580),
        Triple(-71, 87, 2297),
        Triple(-11, 88, 27348),
        Triple(-40, 88, 21363),
        Triple(-27, 88, 2179),
        Triple(4, 89, 231692),
        Triple(-58, 89, 4177),
        Triple(-62, 89, 2648),
        Triple(-50, 90, 12195),
        Triple(-35, 90, 2860),
        Triple(-67, 90, 474),
        Triple(-51, 91, 2232),
        Triple(-54, 92, 7324),
        Triple(-41, 96, 28358),
        Triple(-79, 98, 942),
    )

    val currentBiden = 588252
    val currenTrump = 580605

    var newBiden = 0
    var newTrump = 0

    for ((skew, percent, votes) in counties) {
        var forTrumpSkew = 49.5 - skew / 2
        var forBidenSkew = 49.5 + skew / 2

        val totalVotes = (votes / (percent / 100.0)).toInt()
        val remainingVotes = totalVotes - votes
        val remainingVotesForBiden = remainingVotes * (forBidenSkew / 100.0)
        val remainingVotesForTrump = remainingVotes * (forTrumpSkew / 100.0)

        newBiden += remainingVotesForBiden.toInt()
        newTrump += remainingVotesForTrump.toInt()
    }

    val total = currentBiden + newBiden + currenTrump + newTrump

    println("projected percent: biden-${(currentBiden + newBiden).toDouble() / total}, trump-${(currenTrump + newTrump).toDouble() / total}")
    println("there are $newBiden biden votes remaining, and $newTrump trump votes remaining")
    // this is some quick code i threw together to guess the results of arizona 2020 election
    // it predicted biden +.9, in reality it was biden +.3
}