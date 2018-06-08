package leetcode.primary.others

object IsValidBrackets {
  def isValid(s: String): Boolean = {
    val stack = new java.util.Stack[Char]()
    for (c <- s.toCharArray) {
      if (c == '(' || c == '[' || c == '{') { //左括号入栈
        stack.push(c)
      } else {
        if(stack.empty()) //没有对应的左括号,也是错误格式
          return false
        val prevChar = stack.pop()
        //出栈,对比当前括号,是否能匹配上
        if ((prevChar == '(' && c != ')') ||
          (prevChar == '[' && c != ']') ||
          (prevChar == '{' && c != '}'))
          return false
      }
    }
    stack.empty() //栈内若有剩余,也是错误格式
  }
}
