object HelloWorld {
    val randomClass = new scala.util.Random
    
    // Crete all data in one var
    def setRandomData(x: Int, y: Int): Array[Array[Int]] = {
       var data = Array.ofDim[Int](x, y)
       
       return data
   }
   
   // Use for setRandomData
   def setRow(x: Int, y: Int): Array[Int] = {
       var data = Array.ofDim[Int](2)
       data(0) = x
       data(1) = y
       return data
   }
   
   // Generation random Int
   def getRandomInt(start: Int, end: Int): Int = {
       return start + randomClass.nextInt( (end - start) + 1 )
   }
   
   // Generation Array with random Int
   def getRandomRow(cols: Int): Array[Int] = {
       var data = Array.ofDim[Int](cols)
       data(0) = getRandomInt(0, 1)
       data(1) = getRandomInt(1,5)
       return data
   }
   
   // Generation data on air
   def test1(rows: Int, cols: Int) {
      val calcGoals = collection.mutable.Map[Int, Int]()
      val calcFilms = collection.mutable.Map[Int, collection.mutable.Map[Int, Int]]()
      
      for {
        i <- 0 until rows
      } { 
          var temp = getRandomRow(cols)
          if (!calcGoals.keySet.exists(_ == temp(1))) {
              calcGoals(temp(1)) = 0
          }
          calcGoals(temp(1)) += 1
          
          
          if (!calcFilms.keySet.exists(_ == temp(0))) {
              calcFilms(temp(0)) = collection.mutable.Map[Int, Int]()
          }
          if (!calcFilms(temp(0)).keySet.exists(_ == temp(1))) {
              calcFilms(temp(0))(temp(1)) = 0
          }
          calcFilms(temp(0))(temp(1)) += 1
      }
      
      
      for ((k,v) <- calcGoals) {
          printf("Goal: %s, Count: %s\n", k, v)
      }
      printf("\n\nFilms:\n\n")
      
      for ((filmID,mapGoals) <- calcFilms) {
          printf("Film ID: %s\n", filmID)
          
          for ((k,v) <- mapGoals) {
              printf("Goal: %s, Count: %s\n", k, v)
          }
      }
   }
   
   // Generation all data, then processing
   def test2(rows: Int, cols: Int) {
       
   }
   
   def main(args: Array[String]): Boolean = {
       var rows = 10
       var cols = 2
       
       var result = false
       try {
           test1(rows, cols)
           //test2(rows, cols)
           result = true
       } catch {
           case _: Throwable => println("Got some Error")
       }
       return result
   }
}