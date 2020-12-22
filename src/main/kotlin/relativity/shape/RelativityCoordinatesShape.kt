package relativity.shape

import javafx.scene.paint.Color
import relativity.math.*

class RelativityCoordinatesShape(
    val size: Double,
    val position: RelativityVector = ZeroRelativityVector,
    val velocity: SpaceVector = ZeroSpaceVector,
    val color: Color = Color.BLACK,
    val grid: Boolean = false,
    val lightCone: Boolean = false,
    override val shapes: List<RelativityShape> = listOf()
) :
    RelativityShape() {

    override val segments: List<Segment>
        get() {

            var segments = mutableListOf<Segment>()
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

            segments.add(t)
            segments.add(x)

            val N = 8;
            val d = 2 * size / N
            val s = size - d

            if (grid) {
                for (i in 1 until N) {
                    val dd = -size + i * d
                    segments.add(
                        Segment(
                            start = RelativityVector(t = -s, x = dd),
                            end = RelativityVector(t = s, x = dd),
                            color = color,
                            dashed = true
                        )
                    )
                    segments.add(
                        Segment(
                            start = RelativityVector(t = dd, x = -s),
                            end = RelativityVector(t = dd, x = s),
                            color = color,
                            dashed = true
                        )
                    )
                }
            }

            if (lightCone) {
                val l1 = Segment(
                    start = RelativityVector(t = -s, x = -s),
                    end = RelativityVector(t = s, x = s),
                    color = Color.ORANGE
                )
                val l2 = Segment(
                    start = RelativityVector(t = -s, x = s),
                    end = RelativityVector(t = s, x = -s),
                    color = Color.ORANGE
                )
                segments.add(l1)
                segments.add(l2)
            }

            return segments
        }

    override val transforms: List<RelativityTransform>
        get() = listOf(Translate(position), VelocityTransform(velocity))
}
