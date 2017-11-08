/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuron;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Neuron {
    
    ArrayList<Float> v = new ArrayList<Float>();
    ArrayList<Float> w = new ArrayList<Float>();


    Float match, similarity;

    @Override
    public String toString() {
        return "Neuron{" + "match=" + match + '}';
    }


    
    public Neuron(float pixelcount){
        for(int i=0; i < pixelcount;i++){
            this.w.add(1.0f/(1.0f+pixelcount));
            this.v.add(1f);    
        }
//        System.out.println(this.w.get(1));
    }
    
    public void calc_match(int[] current_image){
        this.match =0f;
        for (int i=0; i < current_image.length ;i++) {
            this.match += current_image[i] * this.w.get(i);
        }
        
        System.out.println("match:" + this.match);
    }
    
    public void calc_similarity(int[] current_image){
        this.similarity =0f;
        float similarity_bottom = 0;
        for (int i=0; i < current_image.length ;i++) { 
            this.similarity += current_image[i] * this.v.get(i);
            similarity_bottom += current_image[i];
        }
        this.similarity /= similarity_bottom;
        System.out.println("similarity:"+similarity);
    }
    
    public void adaptat(int[] current_image){
        float suma_dol = 0.5f;
        
        for (int i = 0; i < this.v.size(); i++) {
            suma_dol += this.v.get(i) * current_image[i];
        }
        
        for (int i = 0; i < this.v.size(); i++) {
            this.v.set(i, this.v.get(i) * current_image[i]);
            this.w.set(i, this.v.get(i) / suma_dol);
        }
    }

    public void setMatch(Float match) {
        this.match = match;
    }
    
    public ArrayList<Float> getW() {
        return w;
    }
    
    public Float getMatch() {
        return match;
    }

    public Float getSimilarity() {
        return similarity;
    }
    
}