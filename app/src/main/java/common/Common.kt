package common

import com.decagon.android.sq007.pokemonApi.Ability
import com.decagon.android.sq007.pokemonApi.Move
import com.decagon.android.sq007.pokemonApi.Stat

object Common {

    var abilities: List<Ability>? = null
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var move: List<Move>? = null
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var stats: List<Stat>? = null
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var imagePosition: String? = null
        get() {
            return field
        }
        set(value) {
            field = value
        }

    val BASE_KEY = "position"
}
