package com.luck;

import java.util.Random;


public class Big_LE_Tou {
	  private int n[]=new int[5];  
	  private int m[]=new int[2];
	  private Random r=new Random();  
	       
	    public int[] doubleBal(){  
	          
	        int i=0;  
	        while(i<n.length){  
	            n[i]=r.nextInt(35)+1;  
	            if(compared(n,i,n[i])){  
	                i++;  
	            }  
	        }  
	        return n;  
	    }  
	      
	    public int[] double_Bal(){
	    	int i=0;
	    	while(i<m.length){
	    		m[i]=r.nextInt(12)+1;
	    		if(compared1(m, i, m[i])){
	    			i++;
	    		}
	    	}
	    	return m;
	    }
	    public boolean compared(int n[],int index,int d){  
	        boolean flag=true;  
	        for(int i=0;i<index;i++){  
	            if(n[i]==d){  
	                flag=false;  
	            }  
	        }  
	        return flag;  
	    }  
	    public boolean compared1(int m[],int index,int d){
	    	boolean flag=true;
	    	for(int i=0;i<index;i++)
	    	{
	    		if(m[i]==d)
	    		{
	    			flag=false;
	    		}
	    	}
	    	return flag;
	    }
	      
	    public void sortArray(int n[]){  
	        for(int i=0;i<n.length;i++){  
	            int temp;  
	            for(int j=0;j<n.length-i-1;j++){  
	                if(n[j]>n[j+1]){  
	                    temp=n[j];  
	                    n[j]=n[j+1];  
	                    n[j+1]=temp;  
	                }  
	            }  
	        }  
	    }  
	      
	    public void sortArray1(int m[]){  
	        for(int i=0;i<m.length;i++){  
	            int temp;  
	            for(int j=0;j<m.length-i-1;j++){  
	                if(m[j]>m[j+1]){  
	                    temp=m[j];  
	                    m[j]=m[j+1];  
	                    m[j+1]=temp;  
	                }  
	            }  
	        }  
	    }  
	      
	    public void printNums(int n){  
	        for(int k=0;k<n;k++){  
	            int [] n1=doubleBal();  
	            int [] m1=double_Bal();
	            sortArray(n1);  
	            sortArray1(m1);
	            System.out.print("红球：");  
	            for(int i=0;i<5;i++){  
	                System.out.print("\t"+add0(n1[i]));  
	            }  
	            System.out.print("\t\t蓝球:");
	            for(int i=0;i<2;i++)
	            {
	            System.out.print("\t"+add0(m1[i])+"");  
	            }
	            System.out.println("\n");
	        }  
	        
	    }  
	      
	    public String add0(int n){  
	        String str="";  
	        if(n<10){  
	            str="0"+n;  
	        }else{  
	            str=n+"";  
	        }  
	        return str;  
	    }  
	      
	    public static void main(String args[]){  
	    	Big_LE_Tou db=new Big_LE_Tou();  
	        db.printNums(10);  
	    }  
}
