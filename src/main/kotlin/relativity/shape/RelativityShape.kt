package relativity.shape

import relativity.math.RelativityTransform

interface RelativityShape {

    val segments: List<Segment>
    val transforms: List<RelativityTransform>
    val shapes: List<RelativityShape>
}