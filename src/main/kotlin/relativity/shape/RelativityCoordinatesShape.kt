package relativity.shape

import javafx.scene.paint.Color
import relativity.math.RelativityTransform
import relativity.math.RelativityVector
import relativity.math.Translate
import relativity.math.ZeroRelativityVector

class RelativityCoordinatesShape(
    val size: Double,
    val position: RelativityVector = ZeroRelativityVector,
    val color: Color = Color.BLACK,
    override val shapes: List<RelativityShape> = listOf()
) :
    RelativityShape() {

    override val segments: List<Segment>
        get() {

            val t = Segment(
                start = RelativityVector(t = -size),
                end = RelativityVector(t = size),
                color = color
            );

            val x = Segment(
                start = RelativityVector(x = -size),
                end = RelativityVector(x = size),
                color = color
            );

            return listOf(t, x)
        }

    override val transforms: List<RelativityTransform>
        get() = listOf(Translate(position))
}
