package w1d1.assignments;

import java.util.Arrays;
import java.util.Random;

public class ComparingAlgo {
    public static int algorithm1(int[] arr){

        int[] evenArray = new int[arr.length];
        int len=0;
        int maxDistance =0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                evenArray[len]=arr[i];
                len++;
            }
        }

        evenArray = Arrays.copyOf(evenArray, len);

        for(int i=0;i<evenArray.length;i++){
            for(int j=0;j< evenArray.length;j++){
                if(evenArray[j]-evenArray[i]>maxDistance){
                    maxDistance=evenArray[j]-evenArray[i];
                }
            }
        }
        return maxDistance;
    }

    public static int algorithm2(int[] arr){
        int maxDistance=0;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i]%2==0 && arr[j]%2==0 && arr[j]-arr[i]>maxDistance){
                    maxDistance=arr[j]-arr[i];
                }
            }
        }
        return maxDistance;
    }

    public static int algorithm3(int[] arr){
        int min=arr[0];
        int max=arr[0];

        for(int i=0;i<arr.length;i++){

            if(min%2!=0){
                if(arr[i]%2==0){
                    min=arr[i];
                    max=arr[i];
                }
            }
           if(arr[i]%2==0){
               if(arr[i]<=min){
                   min=arr[i];
               }else if(arr[i]>=max){
                   max=arr[i];
               }
           }
        }
        return max-min;
    }


    public static int algorithm4(int[] arr){
        int min = Arrays.stream(arr).filter(e->e%2==0).min().getAsInt();
        int max = Arrays.stream(arr).filter(e->e%2==0).max().getAsInt();
        return max-min;
    }


    public static void main(String[] args) {
        Random rd = new Random(); // creating Random object
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(1,100000); // storing random integers in an array
        }

        long start1 = System.nanoTime();
        int distance1 = algorithm1(arr);
        long end1 = System.nanoTime();
        System.out.println("Algorithm1 performance time: "+(end1-start1)+", maxDistance: "+distance1);

        long start2 = System.nanoTime();
        int distance2 = algorithm2(arr);
        long end2 = System.nanoTime();
        System.out.println("Algorithm2 performance time: "+(end2-start2)+", maxDistance: "+distance2);

        long start3 = System.nanoTime();
        int distance3 = algorithm3(arr);
        long end3 = System.nanoTime();
        System.out.println("Algorithm3 performance time: "+(end3-start3)+", maxDistance: "+distance3);

        long start4 = System.nanoTime();
        long distance4 = algorithm4(arr);
        long end4 = System.nanoTime();
        System.out.println("Algorithm3 performance time: "+(end4-start4)+", maxDistance: "+distance4);
    }
}