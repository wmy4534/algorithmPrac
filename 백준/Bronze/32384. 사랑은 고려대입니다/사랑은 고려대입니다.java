import java.util.*;
import java.io.*;

public class Main {
	
	final static String sentence = "LoveisKoreaUniversity";
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	for (int i = 0; i < N; i++) {
    		sb.append(sentence).append(" ");
    	}
    	System.out.print(sb);
    	sc.close();
    }
}