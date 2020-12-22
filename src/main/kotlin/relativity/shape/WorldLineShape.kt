package relativity.shape

import javafx.scene.paint.Color
import relativity.math.*


fun worldLineFromVelocity(
    time: Double,
    position: RelativityVector = ZeroRelativityVector,
    velocity: SpaceVector = ZeroSpaceVector,
    color: Color = Color.BLACK
): WorldLineShape {
    val end = position + RelativityVector(time, time * velocity.x)
    return WorldLineShape(start = position, end = end, color = color)
}

fun worldLineFromLength(
    length: Double,
    position: RelativityVector = ZeroRelativityVector,
    velocity: SpaceVector = ZeroSpaceVector,
    color: Color = Color.BLACK
): WorldLineShape {
    val end = position + RelativityVector(length / velocity.x, length)
    return WorldLineShape(start = position, end = end, color = color)
}

data class WorldLineShape(
    val start: RelativityVector,
    val end: RelativityVector, val color: Color = Color.BLACK
) : RelativityShape {

    override val segments = listOf(
        Segment(
            start = start,
            end = end,
            color = color
        )
    )

    override val transforms = listOf<RelativityTransform>()

    override val shapes = listOf<RelativityShape>()
}
