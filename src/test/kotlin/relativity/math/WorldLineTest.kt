package relativity.math

import kotlin.test.Test
import kotlin.test.assertEquals

class WorldLineTest {

    private val delta = 0.001

    @Test
    fun testIntersection1() {

        val t = 10.0
        val x = 15.0

        val w1 = WorldLine(
            start = RelativityVector(t = t, x = 0.0),
            end = RelativityVector(t = t, x = 2 * x)
        )

        val w2 = WorldLine(
            start = RelativityVector(t = 0.0, x = x),
            end = RelativityVector(t = 3 * t, x = x)
        )

        assertEquals(RelativityVector(t = t, x = x), w1 intersect w2)
    }

    @Test
    fun testIntersection2() {

        val t = 30.0
        val x = 20.0

        val w1 = WorldLine(
            start = RelativityVector(t = 0.0, x = 0.0),
            end = RelativityVector(t = 2 * t, x = 2 * x)
        )

        val w2 = WorldLine(
            start = RelativityVector(t = 2 * t, x = 0.0),
            end = RelativityVector(t = 0.0, x = 2 * x)
        )

        assertEquals(RelativityVector(t = t, x = x), w1 intersect w2)
    }
}