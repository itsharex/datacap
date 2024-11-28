package io.edurt.datacap.test.qiniu

import io.edurt.datacap.fs.FsRequest
import io.edurt.datacap.fs.qiniu.IOUtils
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger
import java.io.FileInputStream

class IOUtilsTest
{
    private val log: Logger = getLogger(this::class.java)
    private val request = FsRequest()
    private val fileName = "QiniuFsPluginTest.kt"

    @Before
    fun before()
    {
        request.access = System.getProperty("qiniu.access")
        request.secret = System.getProperty("qiniu.secret")
        request.bucket = System.getProperty("qiniu.bucket")
        request.fileName = fileName
        request.endpoint = System.getProperty("qiniu.endpoint")
    }

    @Test
    fun step1_copy()
    {
        FileInputStream("src/test/kotlin/io/edurt/datacap/test/qiniu/QiniuFsPluginTest.kt").use { stream ->
            val response = IOUtils.copy(request, stream, fileName)
            assertNotNull(response)

            log.info("Copy response [ {} ]", response)
        }
    }

    @Test
    fun step2_reader()
    {
        assertNotNull(IOUtils.reader(request))
    }

    @Test
    fun step3_delete()
    {
        assertTrue(IOUtils.delete(request))
    }
}
