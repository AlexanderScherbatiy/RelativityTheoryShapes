package relativity.shape

import javafx.scene.paint.Color
import relativity.math.RelativityVector

data class Segment(val start: RelativityVector, val end: RelativityVector, val color: Color = Color.BLACK)
