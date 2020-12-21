package relativity.javafx

import javafx.scene.Group
import javafx.scene.shape.Line
import javafx.scene.shape.Shape
import relativity.math.Identity
import relativity.math.RelativityTransform
import relativity.shape.RelativityShape
import relativity.shape.Segment


fun RelativityShape.toJavaFX(transform: RelativityTransform = Identity): Group {

    val shapes = segments.map { it.toJavaFX(transform) }
    return Group(shapes)
}

fun Segment.toJavaFX(transform: RelativityTransform): Shape {
    val s = transform * start
    val e = transform * end
    val x1 = s.x
    val y1 = s.t
    val x2 = e.x
    val y2 = e.t
    val line = Line(x1, y1, x2, y2)
    line.stroke = color
    return line
}