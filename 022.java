public class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> results = new ArrayList<>();
    if(n == 0) {
      return results;
    }
    genParen(0, 0, 0, "", n, results); 
    return results;
  }
  
  private void genParen(int leftParens, int rightParens, int level, String parens, int n, List<String> results) {
    if(level == 2*n) {
      results.add(parens);
      return; 
    }
    if(rightParens >= leftParens) {
      genParen(leftParens+1, rightParens, level+1, parens+"(", n, results); 
    } else if(leftParens >= n) {
      genParen(leftParens, rightParens+1, level+1, parens+")", n, results);
    } else {
      genParen(leftParens+1, rightParens, level+1, parens+"(", n, results);
      genParen(leftParens, rightParens+1, level+1, parens+")", n, results);
    } 
  } 
}
