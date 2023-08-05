/*
Leetcode. 402 Remove K Digits

Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num. 

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
*/



public class RemoveKDigits
{
  public String removeKDigits(String num, int k)
  {
    int len = num.length();
    Stack<Character> stack = new Stack<>();
    StringBuilder res = new StringBuilder();
    
    if(len == k)
    {
      return "0";
    }

    for(int i=0; i<len; i ++)
    {
      //when prev digit is greater than curr digit, discard the previous one
      while(k>0 &&!stack.isEmpty() && stack.peek()> num.charAt(i))
      {
        stack.pop();
        k--;          
      }
      stack.push(num.charAt(i));
    }

    // corner case like "1111"
    while(k>0)
    {
      stack.pop();
      k--;
    }

    //construct the number from the stack
    while(!stack.isEmpty())
    {
      res.append(stack.pop());
    }

    res.reverse();

    //remove all the 0 at the head
    while(res.length()>1 && res.charAt(0)=='0')
    {
      res.deleteCharAt(0);
    }

    return res.toString();
  }
}


























