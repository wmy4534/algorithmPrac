import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stackint = new Stack<Integer>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(bf.readLine() );
        //
        for (int i=0; i < testNum; i++) {
            StringTokenizer s = new StringTokenizer(bf.readLine());
            String str = s.nextToken();

            if ( str.equals("push") ) {
                int num = Integer.parseInt(s.nextToken() );
                stackint.push(num);
            } else if ( stackint.empty() && (str.equals("pop") || str.equals("top")) ){
                    System.out.println(-1);
            } else if ( str.equals("pop"))
                System.out.println(stackint.pop());
            else if ( str.equals("empty") ) {
                if (stackint.empty())
                    System.out.println(1);
                else
                    System.out.println(0);
            } else if ( str.equals("top"))
                System.out.println(stackint.peek());
            else if ( str.equals("size"))
                System.out.println(stackint.size());
        }

    }
}