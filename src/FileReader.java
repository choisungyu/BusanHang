import java.io.*;

public class FileReader {

    public static void file1() {
        File file = new File("C:\\Users\\7\\Desktop\\java과외\\주인공설명.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));

            String line ="";
            while ((line = bufferedReader.readLine())!= null){
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static char file2() {
        File file = new File("C:\\Users\\7\\Desktop\\java과외\\게임설명.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));

            String line ="";
            while ((line = bufferedReader.readLine())!= null){
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
