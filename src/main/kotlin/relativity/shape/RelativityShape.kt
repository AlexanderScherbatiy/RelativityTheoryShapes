package relativity.shape

import relativity.math.RelativityTransform

abstract class RelativityShape {

    abstract val segments: List<Segment>
    abstract val transforms: List<RelativityTransform>
    abstract val shapes: List<RelativityShape>
}