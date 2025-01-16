```scala
class MyClass[T](val value: T) {
  def printValue(): Unit = {
    println(value) // The issue may be with this line. The compiler might not know how to print complex types like lists.
  }
}

object MainObject extends App {
  val myInt = new MyClass(5)
  myInt.printValue() // This works fine

  val myString = new MyClass("Hello")
  myString.printValue() // This also works fine

  val myList = new MyClass(List(1, 2, 3))
  myList.printValue() //This may print the List's default representation rather than something more human-readable.
}

//Solution
class MyClassCorrected[T](val value: T) {
  def printValue(): Unit = {
    println(value match {
      case list: List[_] => list.mkString(", ") // Handle lists by explicitly formatting their string representation
      case other => other.toString // Handle other types using their default toString method
    })
  }
}

object MainObjectCorrected extends App {
  val myIntCorrected = new MyClassCorrected(5)
  myIntCorrected.printValue()

  val myStringCorrected = new MyClassCorrected("Hello")
  myStringCorrected.printValue()

  val myListCorrected = new MyClassCorrected(List(1, 2, 3))
  myListCorrected.printValue()
}
```