package relativity.shape

import relativity.math.RelativityVector

class RelativityCoordinatesShape(val size: Double) : RelativityShape() {

    override val segments: List<Segment>
        get() {

            val t = Segment(
                start = RelativityVector(t = -size),
                end = RelativityVector(t = size)
            );

            val x = Segment(
                start = RelativityVector(x = -size),
                end = RelativityVector(x = size)
            );

            return listOf(t, x)
        }
}