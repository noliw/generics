// helpus give the compiler some hints about what kind of objects we are dealing with
// this helps the compiler figure out some errors
// generics are only a compile time feature
// T is a generic type
// upper bounds allow use to restrict what kind of type is passed to our generic type
fun main() {
    val foot = FootballPLayer("Messi")
    val foot2 = FootballPLayer("Ronaldo")

    val base = BaseballPlayer("base1")
    val base2 = BaseballPlayer("base2")

    val footTeam = Team<FootballPLayer>("Foot All Stars", mutableListOf(foot))
    footTeam.addPlayers(foot2)

    val baseTeam = Team("Baseball All Stars", mutableListOf(base))
    baseTeam.addPlayers(base2)

    val gamesTeam = Team<GamesPlayer>("g team", mutableListOf())

    val footTeam2 = Team<Player>(
        "F team",
        mutableListOf<FootballPLayer>(FootballPLayer("Neymar"), FootballPLayer("Lewandowski"))
    )

    var gamesTeam1 = Team<CounterStrikePlayer> (
        "Games team",
        mutableListOf<GamesPlayer>(GamesPlayer("p1"), GamesPlayer("p2"))
    )


}
// T stands for type parameter
// <T: Player> restricts so only players are able
// covariance out, I am going to accept the class and subclasses
// countervariance when we want ot accept superclass
class Team<T: Player>(val name: String, val players: MutableList<in T>){
    fun addPlayers(player: T){
        if (players.contains(player)) {
            println("${player.name} is already in the ${this.name} team")
        } else {
            players.add(player)
            println("${player.name} was added in the ${this.name} team")
        }
    }
}

open class Player(val name: String)

class FootballPLayer(name: String) : Player(name)

class BaseballPlayer(name: String) : Player(name)

open class GamesPlayer(name: String) : Player(name)

class CounterStrikePlayer(name: String) : GamesPlayer(name)

