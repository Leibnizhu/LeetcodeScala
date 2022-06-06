package codewars.kyu3

import java.lang.reflect.Field
import java.util.Random
import java.util.concurrent.atomic.AtomicLong

/**
  * 2022-06-06
  * {@see <a href='https://www.codewars.com/kata/54bd79a7956834e767001357/train/scala'/> }
  */
object Psychic {
  //    java.lang.Math.RandomNumberGeneratorHolder.randomNumberGenerator
  val holderClass: Class[_] = Class.forName("java.lang.Math$RandomNumberGeneratorHolder")
  val generatorField: Field = holderClass.getDeclaredField("randomNumberGenerator")
  generatorField.setAccessible(true)
  val generator: AnyRef = generatorField.get(null)
  val seedField: Field = generator.getClass.getDeclaredField("seed")
  seedField.setAccessible(true)
  val seed:AtomicLong = seedField.get(generator).asInstanceOf[AtomicLong]
  val random = new Random()
  seedField.set(random, new AtomicLong(seed.get())) //要新的AtomicLong,否则和原来的一起用两边修改

  def guess(): Double = {
    random.nextDouble()
  }
}
