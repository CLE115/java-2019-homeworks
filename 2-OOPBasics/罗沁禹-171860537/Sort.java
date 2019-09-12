import java.util.*;

class HuLuWa {
    public String rank;
    public String color;

    HuLuWa(String r, String c) {
        rank = new String(r);
        color = new String(c);
    }
    public int getNumberByRank(){
        int res = 0;
        switch(rank){
            case"老大":res = 1;break;
            case"老二":res = 2;break;
            case"老三":res = 3;break;
            case"老四":res = 4;break;
            case"老五":res = 5;break;
            case"老六":res = 6;break;
            case"老七":res = 7;break;
        }
        return res;
    }
    public int getNumberByColor(){
        int res = 0;
        switch(color){
            case"红色":res = 1;break;
            case"橙色":res = 2;break;
            case"黄色":res = 3;break;
            case"绿色":res = 4;break;
            case"青色":res = 5;break;
            case"蓝色":res = 6;break;
            case"紫色":res = 7;break;
        }
        return res;
    }
    public void reportChange(int prev, int now){
        System.out.println(rank + "：" + prev + "->" + now);
    }
}

public class Sort {
    public static void main(String[] args) {
        int n = 7;
        HuLuWa[] list = new HuLuWa[n];
        HuLuWa[] h = new HuLuWa[n];
        h[0]=new HuLuWa("老大","红色");
        h[1]=new HuLuWa("老二","橙色");
        h[2]=new HuLuWa("老三","黄色");
        h[3]=new HuLuWa("老四","绿色");
        h[4]=new HuLuWa("老五","青色");
        h[5]=new HuLuWa("老六","蓝色");
        h[6]=new HuLuWa("老七","紫色");

        //随机站队
        Random rand = new Random();
        boolean[] bool = new boolean[n];
        int num =0;
        //产生0-6的随机数
        for (int i = 0; i<n; i++){
            do{
                //如果产生的数相同继续循环
                num = rand.nextInt(n);
            }while(bool[num]);
            bool[num] =true;
            list[num] = h[i];
        }

        //冒泡排序
        for(int i=0; i<n-1; i++)
        {
            for(int j=0; j<n-i-1; j++)
            {
                if(list[j].getNumberByRank()>list[j+1].getNumberByRank())
                {
                    list[j].reportChange(j+1,j+2);
                    list[j+1].reportChange(j+2,j+1);
                    HuLuWa tmp = list[j+1];
                    list[j+1]=list[j];
                    list[j]=tmp;
                }
            }
        }
        //报数
        for(int i=0; i<n; i++){
            System.out.println(list[i].rank);
        }

        //再次随机站队
        for(int i=0; i<n; i++){
            bool[i] = false;
        }
        for (int i = 0; i<n; i++){
            do{
                //如果产生的数相同继续循环
                num = rand.nextInt(n);
            }while(bool[num]);
            bool[num] =true;
            list[num] = h[i];
        }
        //二分排序
        for(int i=1; i<n; i++){
            HuLuWa tmp = list[i];  //要插入的第i个元素
            int low = 0;
            int high = i - 1; //插入目标元素的前 i-1 个元素
            int mid = -1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (list[mid].getNumberByColor() > tmp.getNumberByColor()) {
                    high = mid - 1;
                } else { // 元素相同时，也插入在后面的位置
                    low = mid + 1;
                }
            }
            // 目标位置 之后的元素 整体移动一位
            for(int j = i - 1; j >= low; j--) {
                list[j].reportChange(j+1,j+2);
                list[j + 1] = list[j];
            }
            if(i!=low)
                tmp.reportChange(i+1,low+1);
            list[low] = tmp;
        }

        //报数
        for(int i=0; i<n; i++){
            System.out.println(list[i].color);
        }
    }
}