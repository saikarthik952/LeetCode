package leetcode.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * public int kEmptySlots(int[] flowers, int k) {
 *     TreeSet<Integer> active = new TreeSet();
 *     int day = 0;
 *     for (int flower: flowers) {
 *         day++;
 *         active.add(flower);
 *         Integer lower = active.lower(flower)
 *         Integer higher = active.higher(flower);
 *         if (lower != null && flower - lower - 1 == k ||
 *                 higher != null && higher - flower - 1 == k)
 *             return day;
 *     }
 *     return -1;
 * }
 */
public class Dir {
    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        String input1 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        List<File> fileList = new ArrayList<>();
        /**
         * parse or interpret the string as a graph and find the deepest child and bactrack to root will give the length of it
         *
         */
        final String[] split = input1.split("\n");
        String root = split[0];
        File prevRoot = new File(root, 0, null);
        for (String s : split) {
            final String[] split2 = s.split("\t");
            if (split2.length == 0) {
                File newRoot = new File(root, 0, prevRoot);
                fileList.add(newRoot);
                prevRoot = newRoot;
                break;
            }
            int depth = 0;
            for (String x : split2) {
                // System.out.println("X Value is:" + x);
                if (x.equals(""))
                    depth++;
                if (!x.equals("")) {
                    root = x;
                    break;
                }
            }
            File newRoot = new File(root, depth, prevRoot);
            fileList.add(newRoot);
            if (prevRoot != null && prevRoot.getDepthFromRoot() < depth)
                prevRoot = newRoot;
        }
         File file = fileList
                .stream()
                .max(Comparator.comparingInt(File::getDepthFromRoot))
                .stream().findFirst().orElse(null);

        if (file == null) {
            System.out.println("0");
            System.exit(0);
        }
        final List<String> strings = new ArrayList<>();
        while (file != null) {
            strings.add(file.getFileName());
            file = file.getRoot();
        }
        Collections.reverse(strings);
        System.out.println(strings);
        final StringBuilder stringBuilder = new StringBuilder();
        int x = 1;
         strings
                .forEach(s -> {
                  stringBuilder.append(s);
                    stringBuilder.append("\n");
                    for (int i = 0; i < x; i++) {
                        stringBuilder.append("\t");
                    }

                });
    System.out.println(stringBuilder.toString());
    System.out.println(stringBuilder.toString().length());

    }

    static class File {
        String fileName;
        int depthFromRoot;
        File root;

        public File() {
        }

        public File(String fileName, int depthFromRoot, File root) {
            this.fileName = fileName;
            this.depthFromRoot = depthFromRoot;
            this.root = root;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public int getDepthFromRoot() {
            return depthFromRoot;
        }

        public void setDepthFromRoot(int depthFromRoot) {
            this.depthFromRoot = depthFromRoot;
        }

        public File getRoot() {
            return root;
        }

        public void setRoot(File root) {
            this.root = root;
        }

        @Override
        public String toString() {
            return "File{" +
                    "fileName='" + fileName + '\'' +
                    ", depthFromRoot=" + depthFromRoot +
                    ", root=" + root +
                    '}';
        }
    }
}

