fun main() {
    val arr = """ @@@   @@@ 
@   @ @   @
@    @    @
@         @
 @       @ 
  @     @  
   @   @   
    @ @    
     @     
    """.split("\n")

    val n = readln().toInt()
    val ans = StringBuilder()
    for (i in arr.indices) {
        for (j in 1..n) {
            ans.append(arr[i]).append(' ')
        }
        ans.append('\n')
    }

    print(ans)
}