import java.io.*;

public class Results {
    public static void main(String[] args) {
        printProblem55Result();
        printProblem81Result();
        printProblem89Result();
    }
    private static void printProblem55Result(){
        System.out.println(Problem55.countLychrel());
    }
    private static void printProblem81Result(){
        byte[] bytes = bufferedStreamRead("./p081_matrix.txt");
        if(bytes != null) {
            String[] strs = new String(bytes).split("\n");
            int[][] matrix = new int[80][80];
            for(int i = 0; i < strs.length; i ++) {
                String[] strs1 = strs[i].split(",");
                for(int j = 0; j < strs1.length; j ++) {
                    matrix[i][j] = Integer.parseInt(strs1[j]);
                }
            }
            System.out.println(Problem81.minPathSum(matrix));
        }
    }
    private static void printProblem89Result(){
        byte[] bytes1 = bufferedStreamRead("./p089_roman.txt");
        if(bytes1 != null) {
            String[] strings = new String(bytes1).split("\n");
            System.out.println(Problem89.count(strings));
        }
    }
    private static byte[] bufferedStreamRead(String path){
        File file = new File(path);
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len;
            byte[] buf = new byte[1024];
            while ((len = bis.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }
            baos.close();
            bis.close();
            fis.close();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
