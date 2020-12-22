package relativity.math

import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals

class SpaceVectorTest {

    private val delta = 0.001;

    @Test
    fun testPlus() {
        assertEquals(
            SpaceVector(8.0, 10.0, 12.0),
            SpaceVector(2.0, 3.0, 4.0) + SpaceVector(6.0, 7.0, 8.0)
        )
    }

    @Test
    fun testScalarProduct() {

        Assert.assertEquals(0.0, SpaceVector(x = 0.0) * SpaceVector(x = 3.0), delta)
        Assert.assertEquals(0.0, SpaceVector(x = 3.0) * SpaceVector(y = 3.0), delta)
        Assert.assertEquals(6.0, SpaceVector(x = 2.0) * SpaceVector(x = 3.0), delta)
        Assert.assertEquals(6.0, SpaceVector(y = 2.0) * SpaceVector(y = 3.0), delta)
        Assert.assertEquals(11.0, SpaceVector(x = 4.0, y = 3.0) * SpaceVector(x = 2.0, y = 1.0), delta)
    }

    @Test
    fun testSqr() {

        Assert.assertEquals(0.0, SpaceVector(x = 0.0).sqr(), delta)
        Assert.assertEquals(1.0, SpaceVector(x = 1.0).sqr(), delta)
        Assert.assertEquals(5.0, SpaceVector(x = 1.0, y = 2.0).sqr(), delta)
        Assert.assertEquals(25.0, SpaceVector(x = -3.0, y = -4.0).sqr(), delta)
    }

    @Test
    fun testLength() {

        Assert.assertEquals(0.0, SpaceVector(x = 0.0).length(), delta)
        Assert.assertEquals(1.0, SpaceVector(x = 1.0).length(), delta)
        Assert.assertEquals(5.0, SpaceVector(x = -3.0, y = 4.0).length(), delta)
        Assert.assertEquals(5.0, SpaceVector(x = 3.0, y = -4.0).length(), delta)
    }
}