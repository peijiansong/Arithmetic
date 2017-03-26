/**
 * Created by 90年的古董先生 on 2017/3/26.
 */
import java.util.*;
public class aa
{
    public static void main(String args[]){
        int sum=0;
        int i=1;
        int j=1;
        for(i=1;i<=20;i++)
        {
            int n=1;
            for(j=1;j<=i;j++)
                n*=j;
            sum+=n;
        }
        System.out.printf("1!+2!+...+20!=");
        System.out.println(sum);
    }
}

