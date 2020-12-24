package relativity.shape

import javafx.scene.paint.Color
import relativity.math.*

data class WorldLineShape(
    val worldLine: WorldLine,
    val color: Color = Color.BLACK,
    val lineWidth: Double = 1.0
) : RelativityShape {

    override val segments = listOf(
        Segment(
            start = worldLine.start,
            end = worldLine.end,
            color = color,
            lineWidth = lineWidth
        )
    )

    override val transforms = listOf<RelativityTransform>()

    override val shapes = listOf<RelativityShape>()
}
