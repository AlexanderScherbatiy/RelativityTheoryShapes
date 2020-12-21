package relativity.math

val ZeroRelativityVector = RelativityVector()

data class RelativityVector(val t: Double = 0.0, val x: Double = 0.0, val y: Double = 0.0, val z: Double = 0.0) {

    operator fun plus(other: RelativityVector): RelativityVector = RelativityVector(
        this.t + other.t, this.x + other.x, this.y + other.y, this.z + other.z
    )


    operator fun times(other: RelativityVector): Double =
        this.t * other.t - this.x * other.x - this.y * other.y - this.z * other.z
}