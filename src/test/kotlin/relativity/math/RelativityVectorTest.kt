package relativity.math

import org.junit.Assert
import org.junit.Test

class RelativityVectorTest {

    private val delta = 0.001;

    @Test
    fun testScalarProduct() {

        Assert.assertEquals(0.0, RelativityVector(t = 0.0) * RelativityVector(t = 3.0), delta)
        Assert.assertEquals(0.0, RelativityVector(t = 3.0) * RelativityVector(x = 3.0), delta)
        Assert.assertEquals(6.0, RelativityVector(t = 2.0) * RelativityVector(t = 3.0), delta)
        Assert.assertEquals(-6.0, RelativityVector(x = 2.0) * RelativityVector(x = 3.0), delta)
        Assert.assertEquals(5.0, RelativityVector(t = 4.0, x = 3.0) * RelativityVector(t = 2.0, x = 1.0), delta)
    }
}