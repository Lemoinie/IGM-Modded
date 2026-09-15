package it.paranoidsquirrels.idleguildmaster

import it.paranoidsquirrels.idleguildmaster.storage.FileManager
import org.junit.Assert.assertEquals
import org.junit.Test
import java.nio.charset.StandardCharsets

/**
 * Regression test for the save-loading encoding bug.
 *
 * The game writes/reads saves as UTF-8 without BOM. A save exported by an external
 * tool as UTF-16 (LE or BE) with a BOM, or a UTF-8 file carrying a BOM, used to be
 * read as garbled UTF-8, making Gson fail and the game fall back to a fresh save
 * ("lost all data"). [FileManager.decodeSaveText] must accept all three encodings.
 */
class FileManagerEncodingTest {

    private val sampleJson = "{\"money\": 5000, \"gems\": 150}"

    private fun utf16Encoded(bigEndian: Boolean): ByteArray {
        val bom = if (bigEndian) byteArrayOf(0xFE.toByte(), 0xFF.toByte())
        else byteArrayOf(0xFF.toByte(), 0xFE.toByte())
        val charset = if (bigEndian) StandardCharsets.UTF_16BE else StandardCharsets.UTF_16LE
        return bom + sampleJson.toByteArray(charset)
    }

    @Test
    fun plainUtf8WithoutBomIsDecodedAsIs() {
        assertEquals(sampleJson, FileManager.decodeSaveText(sampleJson.toByteArray(StandardCharsets.UTF_8)))
    }

    @Test
    fun utf8WithBomIsStripped() {
        val bom = byteArrayOf(0xEF.toByte(), 0xBB.toByte(), 0xBF.toByte())
        val bytes = bom + sampleJson.toByteArray(StandardCharsets.UTF_8)
        assertEquals(sampleJson, FileManager.decodeSaveText(bytes))
    }

    @Test
    fun utf16LittleEndianWithBomIsDecoded() {
        assertEquals(sampleJson, FileManager.decodeSaveText(utf16Encoded(bigEndian = false)))
    }

    @Test
    fun utf16BigEndianWithBomIsDecoded() {
        assertEquals(sampleJson, FileManager.decodeSaveText(utf16Encoded(bigEndian = true)))
    }

    @Test
    fun emptyInputYieldsEmptyString() {
        assertEquals("", FileManager.decodeSaveText(ByteArray(0)))
    }
}