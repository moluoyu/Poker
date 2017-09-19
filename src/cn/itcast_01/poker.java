package cn.itcast_01;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * PokerDemo
 * 		创建一个hashMap
 *  	创建一个ArrayList 
 *		创建花色和电色数组
 *  	从0开始往HashMap存储编号，并且存储对应的牌
 *    	同时往Arraylist里面存储编号
 *		洗牌（洗的是编号）
 *		发牌（洗的是编号）			
 *		看牌（遍历TreeSet获取编号，到HashMap中找到对应的牌）
 *
 *
 *
 *
 *
 */	
public class poker  {

//	static HashMap<Integer,String> hm = new HashMap<Integer,String>();
	
    public static void main(String [] args)
    {
    	//创建一个hashMap
   		HashMap<Integer,String> hm = new HashMap<Integer,String>();
    	//创建一个ArrayList
   		ArrayList<Integer> array = new ArrayList<Integer>();
    
        String[] colors ={"♠","♥","♣","♦"};
        String[] numbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
      
        //从0开始往HashMap存储编号，并且存储对应的牌
        int index = 0;
        for(String number: numbers)
        {
        	for(String color: colors)
        	{
        		String poker = color.concat(number);
        	
        		hm.put(index,poker);
        		array.add(index);
        		index++;
        	}
        	
        }
        //装入大小王
        hm.put(index, "littleking");
		array.add(index);
		index++;
        hm.put(index, "king");
		array.add(index);
		
		//洗牌（洗的是编号）
        Collections.shuffle(array);
        
        
        System.out.println(hm.size());
        //发牌    发的是编号，为了保证编号是排序的,创建TreeSet对象
   
        TreeSet<Integer> luoyu1 = new TreeSet<Integer>();
        
        TreeSet<Integer> luoyu2 = new TreeSet<Integer>();
        
        TreeSet<Integer> luoyu3 = new TreeSet<Integer>();
        
        TreeSet<Integer> dipai = new TreeSet<Integer>();

    
       

       for(int x = 0; x < array.size(); x++)
       {
    	   if(x>= array.size()-3)
    	   {
    		   dipai.add(array.get(x));
    	   }
    	   else if (x % 3 == 0) 
    	   {
    		   luoyu1.add(array.get(x));
			
		   }
    	   else if (x % 3 == 1)
    	   {
    		   luoyu2.add(array.get(x));

    	   }
    	   else if (x % 3 == 2)
    	   {
    		   luoyu3.add(array.get(x));

   		   }	
    	   
       }
       
       //
       LookPoker("luoyu1", luoyu1,hm);
       
       LookPoker("luoyu2", luoyu2,hm);
       
       LookPoker("luoyu3", luoyu3,hm);

       LookPoker("dipai", dipai,hm); 
       
    }

    
    public static void LookPoker(String name,TreeSet<Integer> treeSet,HashMap<Integer,String> hm)
    {
    	
    	System.out.println(name +"的牌是：");
      	for(Integer str : treeSet)
      	
      	{    	
      		System.out.print(hm.get(str)+"  ");
      
       	}
  		System.out.println();  	
    }
}
