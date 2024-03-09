package VWO_TC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Dublicate_Char {

    public static void main(String[] args) {
        String str ="Reapeatedttttd";


        char[] chc =str.toCharArray();
        System.out.println(chc);

        Map<Character,Integer> map = new HashMap<>();

        for(char c : chc){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);


            }
            else{
                map.put(c,1);
            }

        }
        System.out.println(map);

        Set<Map.Entry<Character,Integer>> entry = map.entrySet();
        System.out.println(entry);

        for(Map.Entry<Character,Integer> ent : entry){
            if(ent.getValue() > 1){
                System.out.println(ent.getKey()+" : "+ent.getValue());
            }
        }

        int[] array ={324,67,9,4,2,0,1,45};
        int temp;

        int size = array.length;
        for(int i=0;i<size-1;i++){
            for(int j =0;j<size-1;j++){
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;

                }
            }


        }
        System.out.println(Arrays.toString(array));



    }
}
