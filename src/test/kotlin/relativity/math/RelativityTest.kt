package relativity.math

import kotlin.test.Test
import kotlin.test.assertEquals

class RelativityTest {

    @Test
    fun testVelocitySum() {
        assertEquals(1.0, velocitySum(0.5, 1.0))
        assertEquals(1.0, velocitySum(1.0, 0.8))
        assertEquals(1.0 / 1.25, velocitySum(0.5, 0.5))
    }
}
