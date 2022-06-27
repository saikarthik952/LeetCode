package leetcode.seven;

public class SubTreeOfAnotherTree {
    public static void main(String[] args) {
        System.out.println(serialize(null).contains(serialize(null)));
    }


    public static String serialize(final PopulateRightPointer.Node node) {
        final StringBuilder stringBuilder = new StringBuilder();
        buildString(stringBuilder, node);
        return stringBuilder.toString();
    }



    private static void buildString(StringBuilder stringBuilder, PopulateRightPointer.Node node) {
        if (node == null) {
            stringBuilder.append(",#");
            return;
        }
        stringBuilder.append("," + node.val);
        buildString(stringBuilder, node.left);
        buildString(stringBuilder, node.right);

    }
    /*
    public boolean isSubtree(TreeNode s, TreeNode t) {
  // s
  StringBuilder sb = new StringBuilder();
  preorder(s, sb);
  String seqS = sb.toString();
  // t
  sb = new StringBuilder();
  preorder(t, sb);
  String seqT = sb.toString();

  return seqS.indexOf(seqT) >= 0;
}

private void preorder(TreeNode t, StringBuilder sb) {
  if (t == null) {
    sb.append("null");
    return;
  }
  sb.append("#" + t.val);
  preorder(t.left, sb);
  preorder(t.right, sb);
}
     */
}
