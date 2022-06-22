package codewars.kyu4

import java.io.{ByteArrayOutputStream, IOException, OutputStream}

/**
  * 2022-06-22
  * {@see <a href='https://www.codewars.com/kata/58a57c6bcebc069d7e0001fe/train/scala'/> }
  */
object BasE91EncodingAndDecoding {
  private val BIT_TO_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%&()*+,./:;<=>?@[]^_`{|}~\"".toCharArray
  private val BASE = BIT_TO_CHAR.length
  private val CHAR_TO_BIT = BIT_TO_CHAR.zipWithIndex.map(t => (t._1, t._2)).toMap
  private val AVERAGE_ENCODING_RATIO = 1.2297f

  /**
    * 读13bit，如果小于等于88，再读1bit放最高位，得到v
    * i0 = v%91, i1 = v/91. 查表得 table[i0], table[i1]
    */
  def encode(data: String): String = {
    val out = new ByteArrayOutputStream
    val base91OutputStream = new Base91OutputStream(out)
    try {
      base91OutputStream.write(data.getBytes)
      base91OutputStream.flush()
    } catch {
      case e: IOException =>
        throw new RuntimeException("Failed to encode", e)
    }
    new String(out.toByteArray)
  }

  def decode(data: String): String = {
    var (dbq, dn, dv) = (0, 0, -1)
    val estimatedSize = Math.round(data.length / AVERAGE_ENCODING_RATIO)
    val output = new ByteArrayOutputStream(estimatedSize)

    for (c <- data.toCharArray) {
      if (dv == -1) dv = CHAR_TO_BIT(c) else {
        dv += CHAR_TO_BIT(c) * BASE
        dbq |= dv << dn
        dn += (if ((dv & 8191) > 88) 13 else 14)
        do {
          output.write(dbq.toByte)
          dbq >>= 8
          dn -= 8
        } while (dn > 7)
        dv = -1
      }
    }
    if (dv != -1) output.write((dbq | dv << dn).toByte)
    new String(output.toByteArray)
  }

  class Base91OutputStream(val out: OutputStream) {
    private var ebq = 0
    private var en = 0

    @throws[IOException]
    def write(b: Int): Unit = {
      ebq |= (b & 255) << en
      en += 8
      if (en > 13) {
        var ev = ebq & 8191
        if (ev > 88) {
          ebq >>= 13
          en -= 13
        }
        else {
          ev = ebq & 16383
          ebq >>= 14
          en -= 14
        }
        out.write(BIT_TO_CHAR(ev % BASE))
        out.write(BIT_TO_CHAR(ev / BASE))
      }
    }

    @throws[IOException]
    def write(b: Array[Byte]): Unit = write(b, 0, b.length)

    @throws[IOException]
    def write(data: Array[Byte], offset: Int, length: Int): Unit = {
      for (i <- offset until length) {
        write(data(i))
      }
    }

    @throws[IOException]
    def flush(): Unit = {
      if (en > 0) {
        out.write(BIT_TO_CHAR(ebq % BASE))
        if (en > 7 || ebq > 90) out.write(BIT_TO_CHAR(ebq / BASE))
      }
      out.flush()
    }
  }
}
