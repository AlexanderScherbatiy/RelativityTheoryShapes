package relativity.javafx

import javafx.scene.Group
import javafx.scene.shape.Line
import javafx.scene.shape.Shape
import relativity.math.RelativityTransform
import relativity.math.RelativityVector
import relativity.shape.RelativityShape
import relativity.shape.Segment


fun RelativityShape.toJavaFX(transforms: List<RelativityTransform> = listOf()): Group {


    val tx = transforms + this.transforms
    val segmentShapes = segments.map { it.toJavaFX(tx) }

    val children = shapes.map { it.toJavaFX(tx) }

    return Group(segmentShapes + children)
}

fun Segment.toJavaFX(transforms: List<RelativityTransform>): Shape {
    val s = start.transform(transforms)
    val e = end.transform(transforms)
    val x1 = s.x
    val y1 = s.t
    val x2 = e.x
    val y2 = e.t
    val line = Line(x1, y1, x2, y2)
    line.stroke = color
    if (dashed) {
        line.strokeDashArray.addAll(2.0, 5.0)
    }
    line.strokeWidth = lineWidth
    return line
}

private fun RelativityVector.transform(transforms: List<RelativityTransform>): RelativityVector {

    var result = this
    for (t in transforms.reversed()) {
        result = t * result
    }

    return result
}