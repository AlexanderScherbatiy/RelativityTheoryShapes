package relativity.math

data class SpaceVector(val x: Double = 0.0, val y: Double = 0.0, val z: Double = 0.0) {
    operator fun plus(other: SpaceVector): SpaceVector = SpaceVector(
        this.x + other.x, this.y + other.y, this.z + other.z
    )


    operator fun times(other: SpaceVector): Double =
        this.x * other.x + this.y * other.y + this.z * other.z
}