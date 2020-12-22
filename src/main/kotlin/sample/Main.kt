package sample

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.paint.Color
import javafx.scene.transform.Affine
import javafx.scene.transform.Transform
import javafx.stage.Stage
import relativity.javafx.toJavaFX
import relativity.math.RelativityVector
import relativity.math.SpaceVector
import relativity.shape.RelativityCoordinatesShape

class Main : Application() {

    override fun start(primaryStage: Stage) {

        primaryStage.title = "Hello world Application"
        val w = 1000.0
        val h = 800.0
        val size = 400.0

        primaryStage.width = w
        primaryStage.height = h

        val coordinates2 = RelativityCoordinatesShape(
            size,
            position = RelativityVector(100.0, 150.0),
            color = Color.BLUE,
            lightCone = true,
            grid = true,
            velocity = SpaceVector(x = 0.20)
        )
        val coordinates1 = RelativityCoordinatesShape(
            size,
            color = Color.BLACK,
            grid = true,
            lightCone = true,
            shapes = listOf(coordinates2)
        )
        val group = coordinates1.toJavaFX()

        val transform = Affine(1.0, 0.0, w / 2, 0.0, -1.0, h / 2)
        group.transforms.addAll(transform)

        val primaryScene = Scene(group);
        primaryStage.scene = primaryScene;
        primaryStage.show();
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Main::class.java)
        }
    }
}
