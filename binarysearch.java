import java.util.*;
public class binarysearch{

    public static boolean binarysearchfun(int arr[],int key){

     int len= arr.length;
     int low=0;
     int high=len;
     while(low<high){
       int mid=(high+low)/2;
       if(arr[mid]==key){
    
        System.out.println("index is "+mid);
            return true;
       }
       if(key<mid){
        high=mid-1;
       }
       if(key>mid){
        low=mid+1;
       }

       
         }
         
         return false;

    }

public static void main(String args[]){

int arr[]={1,2,3,5,6,7,8,9};
System.out.println(binarysearchfun(arr,8));


}


}