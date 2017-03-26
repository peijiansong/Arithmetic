/**
 * Created by 90年的古董先生 on 2017/3/26.
 */
import java.awt.*;
import java.util.*;
public class Arithmetic {
    int right;
    int wrong;

    public void Frame(){                                      //框架结构
        System.out.println("同学你接下来将要面对10道小学三年级的奥数计算题，请仔细作答！");
        int cc=0;                                       //用于接收分子分母最大公约数的cc
        for(int i=1;i<=10;i++)
        {
            String result_right="";
            int denominator_x=(int)(Math.random()*100);   //产生1-100的数作为第一个分数的分母
            int numerator_x=(int)(Math.random()*denominator_x);     //产生比分母小的数作为第一个分数的分子
            int denominator_y=(int)(Math.random()*100);   //产生1-100的数作为第二个分数的分母
            int numerator_y=(int)(Math.random()*denominator_y);     //产生比分母小的数作为第二个分数的分子
            int x=(int)(Math.random()*100);             //第一个整数x
            int y=(int)(Math.random()*100);             //第二个整数y
            int n=(int)(Math.random()*12)+1;
            switch (n){                                 //1-4为整数间的运算，5-8为整数与分数的运算，9-12为分数间的运算
                case 1:
                    System.out.println(i+".  "+x+" ＋ "+y+" = ");
                    result_right=""+(x+y);
                    Judge(result_right);
                    break;
                case 2:
                    System.out.println(i+".  "+x+" — "+y+" = ");
                    result_right=""+(x-y);
                    Judge(result_right);
                    break;
                case 3:
                    System.out.println(i+".  "+x+" × "+y+" = ");
                    result_right=""+(x*y);
                    Judge(result_right);
                    break;
                case 4:
                    System.out.println(i+".  "+x+" ÷ "+y+" = ");
                    cc=GCD(x,y);
                    result_right=""+((x/cc)/(y/cc));
                    Judge(result_right);
                    break;
                case 5:
                    System.out.println(i+".  "+x+" ＋ "+numerator_x+"/"+denominator_x+" = ");
                    cc=GCD(x*denominator_x+numerator_x,denominator_x);
                    result_right=""+(x*denominator_x+numerator_x)/cc+"/"+(denominator_x)/cc;
                    Judge(result_right);
                    break;
                case 6:
                    System.out.println(i+".  "+x+" — "+numerator_x+"/"+denominator_x+" = ");
                    cc=GCD(x*denominator_x-numerator_x,denominator_x);
                    result_right=""+(x*denominator_x-numerator_x)/cc+"/"+(denominator_x)/cc;
                    Judge(result_right);
                    break;
                case 7:
                    System.out.println(i+".  "+x+" × "+numerator_x+"/"+denominator_x+" = ");
                    cc=GCD(x*numerator_x,denominator_x);
                    result_right=""+(x*numerator_x)/cc+"/"+(denominator_x)/cc;
                    Judge(result_right);
                    break;
                case 8:
                    System.out.println(i+".  "+x+" ÷ "+numerator_x+"/"+denominator_x+" = ");
                    cc=GCD(x*denominator_x,numerator_x);
                    result_right=""+(x*denominator_x)/cc+"/"+(numerator_x)/cc;
                    Judge(result_right);
                    break;
                case 9:
                    System.out.println(i+".  "+numerator_x+"/"+denominator_x+" ＋ "+numerator_y+"/"+denominator_y+" = ");
                    cc=GCD(numerator_x*denominator_y+numerator_y*denominator_x,denominator_x*denominator_y);
                    if(DenominatorIsOne((numerator_x * denominator_y + numerator_y * denominator_x) / cc,(denominator_x * denominator_y) / cc)){     //判断分母是否为1的情况
                        result_right=""+(numerator_x*denominator_y+numerator_y*denominator_x)/cc;
                        Judge(result_right);
                        break;
                    }
                    else {
                        result_right = "" + (numerator_x * denominator_y + numerator_y * denominator_x) / cc + "/" + (denominator_x * denominator_y) / cc;
                        Judge(result_right);
                        break;
                    }
                case 10:
                    System.out.println(i+".  "+numerator_x+"/"+denominator_x+" — "+numerator_y+"/"+denominator_y+" = ");
                    if(numerator_x==numerator_y&&denominator_x==denominator_y) {        //判断两个分数是否相同导致相减为0
                        result_right="0";
                        break;
                    }
                    else {
                        cc = GCD(numerator_x * denominator_y - numerator_y * denominator_x, denominator_x * denominator_y);
                        result_right = "" + (numerator_x * denominator_y - numerator_y * denominator_x) / cc + "/" + (denominator_x * denominator_y) / cc;
                        Judge(result_right);
                        break;
                    }
                case 11:
                    System.out.println(i+".  "+numerator_x+"/"+denominator_x+" × "+numerator_y+"/"+denominator_y+" = ");
                    cc=GCD(numerator_x*numerator_y,denominator_x*denominator_y);
                    if(DenominatorIsOne( (numerator_x * numerator_y) / cc, (denominator_x * denominator_y) / cc)) {     //判断分母是否为1的情况
                        result_right=""+(numerator_x*numerator_y)/cc;
                        Judge(result_right);
                        break;
                    }
                    else {
                        result_right = "" + (numerator_x * numerator_y) / cc + "/" + (denominator_x * denominator_y) / cc;
                        Judge(result_right);
                        break;
                    }
                case 12:
                    System.out.println(i+".  "+numerator_x+"/"+denominator_x+" ÷ "+numerator_y+"/"+denominator_y+" = ");
                    cc=GCD(numerator_x*denominator_y,denominator_x*numerator_y);
                    if(DenominatorIsOne((numerator_x * denominator_y) / cc,(denominator_x * numerator_y) / cc)) {     //判断分母是否为1的情况
                        result_right=""+(numerator_x*denominator_y)/cc;
                        Judge(result_right);
                        break;
                    }
                    else {
                        result_right = "" + (numerator_x * denominator_y) / cc + "/" + (denominator_x * numerator_y) / cc;
                        Judge(result_right);
                        break;
                    }
            }

        }
        System.out.println("正确率："+(right)*10+"%");
    }
    public void Judge(String result_right){             //判断输入的结果是否正确
            String result_student = "";
            Scanner result = new Scanner(System.in);
            result_student = result.next();
            if (result_right.equals(result_student)) {
                right++;
                System.out.println("正确！");
            }
            else {
                wrong++;
                System.out.println("错误！");
            }
    }
    public int GCD(int aa,int bb){                              //求分子分母化简的最大公约数
        int c=0;
        if(bb>aa)
        {
            c=aa;
            aa=bb;
            bb=c;
        }
        int temp=0;
        while(true)
        {
            temp=aa%bb;
            if(temp==0)
            {
                break;
            }
            else
            {
                aa=bb;
                bb=temp;
            }
        }
        return bb;

    }
    public Boolean DenominatorIsOne(int aa,int bb){
        if(bb==1)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Arithmetic a=new Arithmetic();
        a.Frame();
    }
}
