package com.budi.paixu;

/**
 * @program: javabasic
 * @description:
 * @author:zhaoyongquan
 * @create:2020-08-20-20-39
 **/
public class MaoPao {
    public static void main(String[] args) {
        int[] arr={34,24,2,56,4,68,98,23};
        for (int x=0;x<arr.length-1;x++){
            for(int y=0;y<arr.length-x-1;y++){
                if(arr[y]<arr[y+1]){
                    int temp=arr[y];
                    arr[y]=arr[y+1];
                    arr[y+1]=temp;
                }
            }
        }
        print(arr);

    }
    public static void  print(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+",");
        }
    }
    public static void zheban(){
        //需求是把5加进去的顺序的角标
        int a=5;
        int[] arr={2,4,6,7,8};
        int min=0,max=arr.length-1,mid=(min+max)/2;
        if(a>arr[mid]){
            min=mid+1;
        }else{
            max=mid-1;
        }
    }
}
