package sample

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.paint.Color
import javafx.scene.transform.Affine
import javafx.stage.Stage
import relativity.javafx.toJavaFX
import relativity.math.*
import relativity.shape.RelativityCoordinatesShape
import relativity.shape.WorldLineShape

class Main : Application() {

    override fun start(primaryStage: Stage) {

        primaryStage.title = "Hello world Application"
        val width = 1200.0
        val height = 1000.0
        val size = 500.0

        primaryStage.width = width
        primaryStage.height = height

        val v = 0.15
        val u = 0.75
        val length = 300.0

        val tachyon1 = worldLineFromLength(length = length, velocity = SpaceVector(u))
        val position = RelativityVector(100.0, 150.0)
        val observer = worldLineFromVelocity(position, SpaceVector(v))

        val intersect1 = tachyon1 intersect observer

        val w = velocitySum(v, -u)
        val tachyoun2 = worldLineFromVelocity(intersect1, SpaceVector(w))

        val intersect2 = tachyoun2 intersect WorldLine(ZeroRelativityVector, RelativityVector(t = 1.0, x = 0.0))

        val coordinates = RelativityCoordinatesShape(
            size,
            position = position,
            color = Color.BLUE,
            lightCone = true,
            grid = true,
            velocity = SpaceVector(x = v)
        )
        val baseCoordinates = RelativityCoordinatesShape(
            size,
            color = Color.BLACK,
            grid = true,
            lightCone = true,
            shapes = listOf(
                coordinates,
                WorldLineShape(WorldLine(ZeroRelativityVector, intersect1), Color.GREEN, 2.0),
                WorldLineShape(WorldLine(intersect1, intersect2), Color.GREEN, 2.0),
            )
        )
        val group = baseCoordinates.toJavaFX()

        val transform = Affine(1.0, 0.0, width / 2, 0.0, -1.0, height / 2)
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
