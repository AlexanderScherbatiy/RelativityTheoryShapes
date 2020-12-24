package relativity.math

fun worldLineFromVelocity(
    position: RelativityVector = ZeroRelativityVector,
    velocity: SpaceVector = ZeroSpaceVector,
    time: Double = 1.0,
): WorldLine {
    val end = position + RelativityVector(time, time * velocity.x)
    return WorldLine(start = position, end = end)
}

fun worldLineFromLength(
    length: Double,
    position: RelativityVector = ZeroRelativityVector,
    velocity: SpaceVector = ZeroSpaceVector,
): WorldLine {
    val end = position + RelativityVector(length / velocity.x, length)
    return WorldLine(start = position, end = end)
}

data class WorldLine(val start: RelativityVector, val end: RelativityVector) {

    private val v = end - start

    /**
     * start1 + s1 * v1 = start2 + s2 * v2
     * start1 - start2 = - s1 * v1  + s2 * v2
     * ds = -s1 * v1  + s2 * v2
     */
    infix fun intersect(other: WorldLine): RelativityVector {

        val ds = this.start - other.start
        val b1 = ds.t
        val b2 = ds.x
        val a11 = -this.v.t
        val a21 = -this.v.x
        val a12 = other.v.t
        val a22 = other.v.x

        val det = determinant(a11, a12, a21, a22)
        val det1 = determinant(b1, a12, b2, a22)
        val s1 = det1 / det

        return this.start + s1 * this.v
    }

    private fun determinant(a11: Double, a12: Double, a21: Double, a22: Double): Double = a11 * a22 - a12 * a21
}
