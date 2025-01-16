```scala
class MyClass[T](val value: T) {
  def printValue(): Unit = {
    println(value)
  }
}

object MainObject extends App {
  val myInt = new MyClass(5)
  myInt.printValue() // This works fine

  val myString = new MyClass("Hello")
  myString.printValue() // This also works fine

  val myList = new MyClass(List(1, 2, 3))
  myList.printValue()
}
```