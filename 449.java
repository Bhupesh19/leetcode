public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }
    String lstr = serialize(root.left);
    String rstr = serialize(root.right);
    if (lstr.equals("") && rstr.equals("")) {
      return Integer.toString(root.val);
    }
    return root.val + "(" + lstr + "|" + rstr + ")";
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.equals("")) {
      return null;
    }
    if (data.indexOf('(') == -1 && data.indexOf(')') == -1 && data.indexOf('|') == -1) {
      return new TreeNode(Integer.parseInt(data));
    }
    int lstart = data.indexOf('(');
    int rend = data.lastIndexOf(')');
    String value = data.substring(0, lstart);
    TreeNode root = new TreeNode(Integer.parseInt(value));
    int counts = 0;
    int rstart = lstart;
    for (int i = lstart; i <= rend; i++) {
      if (data.charAt(i) == '(') {
        counts++;   
      }
      if (data.charAt(i) == '|' && counts == 1) {
        rstart = i;
        break;
      }
      if (data.charAt(i) == ')') {
        counts--;
      }
    }
    root.left = deserialize(data.substring(lstart + 1, rstart));
    root.right = deserialize(data.substring(rstart + 1, rend));
    return root;
  }
}

