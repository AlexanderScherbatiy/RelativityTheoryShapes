package relativity.math

import kotlin.math.sqrt

interface RelativityTransform {
    operator fun times(vector: RelativityVector): RelativityVector
}

object Identity : RelativityTransform {
    override fun times(vector: RelativityVector) = vector
}

data class Translate(val translate: RelativityVector) : RelativityTransform {
    override fun times(vector: RelativityVector): RelativityVector = translate + vector
}

/**
 * t' = (t+vx) / sqrt(1-v^2)
 * x' = (x+vt) / sqrt(1-v^2)
 */
data class VelocityTransform(val velocity: SpaceVector) : RelativityTransform {

    override fun times(vector: RelativityVector): RelativityVector {

        val t = vector.t
        val x = vector.x
        val v = velocity.x
        val s = sqrt(1.0 - velocity.sqr())

        val tt = (t + v * x) / s
        val xx = (x + v * t) / s

        return RelativityVector(t = tt, x = xx)
    }
}