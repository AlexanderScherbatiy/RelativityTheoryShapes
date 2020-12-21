package relativity.math

data class RelativityVector(val t: Double = 0.0, val x: Double = 0.0, val y: Double = 0.0, val z: Double = 0.0) {

    operator fun times(other: RelativityVector): Double {
        return this.t * other.t - this.x * other.x - this.y * other.y - this.z * other.z;
    }
}