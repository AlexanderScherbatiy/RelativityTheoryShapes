package relativity.math

import org.junit.Test
import kotlin.test.assertEquals

class RelativityTransformTest {

    @Test
    fun testIdentity() {
        assertEquals(
            RelativityVector(1.0, 2.0, 3.0, 4.0),
            Identity * RelativityVector(1.0, 2.0, 3.0, 4.0)
        )
    }

    @Test
    fun testTranslate() {
        assertEquals(
            RelativityVector(6.0, 8.0, 10.0, 12.0),
            Translate(RelativityVector(1.0, 2.0, 3.0, 4.0)) * RelativityVector(5.0, 6.0, 7.0, 8.0)
        )
    }
}