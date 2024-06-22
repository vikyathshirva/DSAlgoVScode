package Graphs;

import java.util.*;

public class DisjointSet {

    public List<Integer> rank = new ArrayList<>();
    public List<Integer> parent= new ArrayList<>();
    public List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
       for(int i=0;i<=n;i++) {
        rank.add(0);
        parent.add(i);
        size.add(1);
       } 
    }

    public int ultParent (int node) {
        if(node == parent.get(node)) {
            return node;
        }
        int ulPar = ultParent(parent.get(node));
        parent.set(node,ulPar);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ul_u = parent.get(u);
        int ul_v = parent.get(v);
        if(ul_u == ul_v) {
            return;
        }

        if(rank.get(ul_u) < rank.get(ul_v)) {
            parent.set(ul_u, ul_v);
        } else if(rank.get(ul_u) > rank.get(ul_v)) {
            parent.set(ul_v, ul_u);
        } else {
            parent.set(ul_u, ul_v);
            int rank_v = rank.get(ul_v);
            rank.set(ul_v, rank_v+1);
        }
    }

    public void unionBySize(int u, int v){
        int ul_u = parent.get(u);
        int ul_v = parent.get(v);
        if(ul_u == ul_v) {
            return;
        }

        if(size.get(ul_u) < size.get(ul_v)) {
            parent.set(ul_u, ul_v);
            int size_v = size.get(ul_v);
            int size_u = size.get(ul_u);
            size.set(ul_v, size_u+size_v);
        } else {
            parent.set(ul_v, ul_u);
            int size_v = size.get(ul_v);
            int size_u = size.get(ul_u);
            size.set(ul_u, size_u+size_v);
        }



    }

    public static void main(String[] args) {
        DisjointSet ds= new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        if(ds.ultParent(3) == ds.ultParent(7)) {
            System.out.println("same");
        } else {
            System.out.println("not same");
        }
        ds.unionByRank(3, 7);

        if(ds.ultParent(3) == ds.ultParent(7)) {
            System.out.println("same");
        } else {
            System.out.println("not same");
        }
    }
















    



} 