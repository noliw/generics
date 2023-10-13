// helpus give the compiler some hints about what kind of objects we are dealing with
// this helps the compiler figure out some errors
// generics are only a compile time feature
// T is a generic type

fun main() {
    val foot = FootballPLayer("Messi")
    val foot2 = FootballPLayer("Ronaldo")

    val base = BaseballPlayer("base1")
    val base2 = BaseballPlayer("base2")

    val footTeam = Team<FootballPLayer>("Foot All Stars", mutableListOf(foot))
    val baseTeam = Team<BaseballPlayer>("Baseball All Stars", mutableListOf(base))

    footTeam.addPlayers(foot2)

}
// T stands for typer parameter
class Team<T>(val name: String, val players: MutableList<T>){
    fun addPlayers(player: T){
        if (players.contains(player)) {
            println("PLayer: ${(player as Player).name} is already in the ${this.name} team")
        } else {
            players.add(player)
            println("PLayer: ${(player as Player).name} was added in the ${this.name} team")
        }
    }
}

open class Player(val name: String)

class FootballPLayer(name: String) : Player(name)

class BaseballPlayer(name: String) : Player(name)