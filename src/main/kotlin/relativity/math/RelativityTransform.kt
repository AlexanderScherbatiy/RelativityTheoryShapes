package relativity.math

interface RelativityTransform {
    operator fun times(vector: RelativityVector): RelativityVector
}

object Identity : RelativityTransform {
    override fun times(vector: RelativityVector) = vector
}

data class Translate(val translate: RelativityVector) : RelativityTransform {
    override fun times(vector: RelativityVector): RelativityVector = translate + vector
}