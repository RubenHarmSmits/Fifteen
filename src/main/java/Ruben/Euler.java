package Ruben;

import java.util.ArrayList;

public class Euler {

    ArrayList<Long> pennummers = new ArrayList<Long>();

    public static void main(String args[]){
        Euler euler = new Euler();
        euler.coin();

    }

    public void coin(){
        int x = getSeperations(5);
        System.out.println(x);
    }

    public int getSeperations(int x){
        int seperations =0;
        for(int i=0;i<=x;i++){
            for(int q=0;q<=x;q++){
                for(int w=0;w<=x;w++){
                    for(int r=0;r<=x;r++){
                        for(int t=0;t<=x;t++){
                            if(i+q+w+r+t==x){
                                if(i>=q&q>=w&w>=r&r>=t){
                                    seperations++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return seperations;
    }

    public int recursive(int x, int seperations){
        if(x>0){
            x--;
            return recursive(x,seperations);
        }
        return seperations;
    }




}
