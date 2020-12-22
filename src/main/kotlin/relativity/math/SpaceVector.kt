package relativity.math

val ZeroSpaceVector = SpaceVector()


operator fun Double.times(vector: SpaceVector): SpaceVector = vector * this

data class SpaceVector(val x: Double = 0.0, val y: Double = 0.0, val z: Double = 0.0) {

    operator fun plus(other: SpaceVector): SpaceVector = SpaceVector(
        this.x + other.x, this.y + other.y, this.z + other.z
    )

    operator fun times(value: Double): SpaceVector = SpaceVector(
        value * this.x, value * this.y, value * this.z
    )

    operator fun times(other: SpaceVector): Double =
        this.x * other.x + this.y * other.y + this.z * other.z

    fun sqr(): Double = this * this

    fun length(): Double = Math.sqrt(sqr())
}