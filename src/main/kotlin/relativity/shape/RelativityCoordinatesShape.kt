package relativity.shape

import javafx.scene.paint.Color
import relativity.math.RelativityVector

class RelativityCoordinatesShape(val size: Double) : RelativityShape() {

    override val segments: List<Segment>
        get() {

            val t = Segment(
                start = RelativityVector(t = -size),
                end = RelativityVector(t = size),
                color = Color.BLUE
            );

            val x = Segment(
                start = RelativityVector(x = -size),
                end = RelativityVector(x = size),
                color = Color.BLACK
            );

            return listOf(t, x)
        }
}