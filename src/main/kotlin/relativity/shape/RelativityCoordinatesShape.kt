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
    val grid: Boolean = false,
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

            var gridLines = mutableListOf<Segment>()
            if (grid) {
                val N = 8;
                val d = 2 * size / N
                val s = size - d
                for (i in 1 until N) {
                    val dd = -size + i * d
                    gridLines.add(
                        Segment(
                            start = RelativityVector(t = -s, x = dd),
                            end = RelativityVector(t = s, x = dd),
                            color = color,
                            dashed = true
                        )
                    )
                    gridLines.add(
                        Segment(
                            start = RelativityVector(t = dd, x = -s),
                            end = RelativityVector(t = dd, x = s),
                            color = color,
                            dashed = true
                        )
                    )
                }
            }

            return listOf(t, x) + gridLines
        }

    override val transforms: List<RelativityTransform>
        get() = listOf(Translate(position))
}
