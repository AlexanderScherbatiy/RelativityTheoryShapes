package sample

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.stage.Stage

class Main : Application() {

    override fun start(primaryStage: Stage) {

        primaryStage.title = "Hello world Application"
        primaryStage.width = 300.0
        primaryStage.height = 200.0

        val helloWorldLabel = Label("Hello world!");
        val primaryScene = Scene(helloWorldLabel);
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
