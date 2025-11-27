/*
We are given a bar of chocolate composed of m×n square pieces. One should break the chocolate into single squares. Each break of a part of the chocolate is charged a cost expressed by a positive integer. This cost does not depend on the size of the part that is being broken but only depends on the line the break goes along. Let us denote the costs of breaking along consecutive vertical lines with x₁, x₂, …, xₘ₋₁ and along horizontal lines with y₁, y₂, …, yₙ₋₁.
Compute the minimal cost of breaking the whole chocolate into single squares.

import java.util.*;
public class ChocolaProblem {
    public static void main(String args[]){
        int n=4,m=6;
        
        Integer []costVer={2,1,3,1,4};
        Integer []costHor={4,1,2};
        
        int h=0,v=0;
        int hp=0,vp=0;
        
        while(h<costHor.length && v<costVer.length){
            if(costVer[v]<=costHor[h]){

            }
        }
    }
}*/