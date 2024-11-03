
// Given an array of integers nums and an integer target, return indices of the two numbers such
// that they add up to target.

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //Recorrer array numero a numero y sumar con el siguiente de la lista
        //Obtener iterador de la lista 
        //Crear array[2] que almacene indices de la lista
        int [] res = new int[2];
        for (int i = 0; i < res.length; i++) {
            for(int j=i+1; j<res.length; j++){
                int sum=0;
                if(j<res.length){
                    sum = nums[i] + nums[j];
                    if(sum == target){
                        res[0] = i;
                        res[1]=j;
                        break;
                    }
                }
            }
        }
        return res;
    }

}