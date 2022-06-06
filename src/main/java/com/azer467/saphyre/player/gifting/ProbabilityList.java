//package com.azer467.saphyre.player.gifting;
//
//import com.azer467.saphyre.util.interfaces.IGiftBase;
//
//import java.util.*;
//
//public class ProbabilityList {
//    ArrayList<IGiftBase> giftList;
//    double sumProb;
//    Random rand = new Random();
//
//    ProbabilityList(ArrayList<IGiftBase> giftList) {
//        this.giftList = giftList;
//        giftList.forEach(gift -> sumProb += gift.getProbability());
//    }
//
//    public ProbabilityList addToList(IGiftBase element) {
//        giftList.add(element);
//        sumProb += element.getProbability();
//        return this;
//    }
//
//    public IGiftBase sample(){
//        double prob = rand.nextDouble() * sumProb;
//        int i;
//        for(i=0; prob>0; i++){
//            prob -= giftList.get(i).getProbability();
//        }
//        return giftList.get(i - 1);
//    }
//}