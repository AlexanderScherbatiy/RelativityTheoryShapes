package relativity.math

val ZeroRelativityVector = RelativityVector()

operator fun Double.times(vector: RelativityVector): RelativityVector = vector * this

data class RelativityVector(val t: Double = 0.0, val x: Double = 0.0, val y: Double = 0.0, val z: Double = 0.0) {

    operator fun plus(other: RelativityVector): RelativityVector = RelativityVector(
        this.t + other.t, this.x + other.x, this.y + other.y, this.z + other.z
    )

    operator fun minus(other: RelativityVector): RelativityVector = RelativityVector(
        this.t - other.t, this.x - other.x, this.y - other.y, this.z - other.z
    )

    operator fun times(value: Double): RelativityVector = RelativityVector(
        value * this.t, value * this.x, value * this.y, value * this.z
    )

    operator fun times(other: RelativityVector): Double =
        this.t * other.t - this.x * other.x - this.y * other.y - this.z * other.z
}