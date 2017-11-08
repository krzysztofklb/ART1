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
public class Network{
    
    float p = 0.8f;
    int current_image[];


    int neuronID;
    
    float simila;
    
    ArrayList<Neuron> neuron_list = new ArrayList<>();
    public void addToNeuron_list(int[] image) {
        this.neuron_list.add(new Neuron(image.length));        
    }
    
    public float getsim(Neuron n){
        float x = n.getSimilarity();
        return x;
    }
    public Neuron returnWinnerNeuron(int[] current_image){
        for (Neuron neuron_list1 : neuron_list) {
            neuron_list1.calc_match(current_image);     
        }

        
        for (int i = 0; i < neuron_list.size(); i++) {
            Neuron neuro_n = this.neuron_list.get(0);
            for (int j = 0; j < neuron_list.size(); j++) {
                System.out.println(" Aktualny " + j + "=" + neuron_list.get(j));
                if(neuron_list.get(j).getMatch() > neuro_n.getMatch()){
                    neuro_n = neuron_list.get(j);
                }
                
                
            }
            
            if (neuro_n.getMatch() == 0f){
                Neuron new_neuron= new Neuron(current_image.length);
                
                new_neuron.adaptat(current_image);
                this.neuron_list.add(new_neuron);
                System.out.println("dodano neuron");
                neuronID = neuron_list.indexOf(new_neuron);
                return new_neuron;
            }
            
            neuro_n.calc_similarity(current_image);
            simila = getsim(neuro_n);
            if(neuro_n.getSimilarity() > this.p){
                neuro_n.adaptat(current_image);
                System.out.println("zakcetowano neuron");
                neuronID = neuron_list.indexOf(neuro_n);
                return neuro_n;
            }else{
                neuro_n.setMatch(0f);
            }
        }
        Neuron new_neuron= new Neuron(current_image.length);
            new_neuron.adaptat(current_image);
            this.neuron_list.add(new_neuron);
            System.out.println("dodano neuron");
            neuronID = neuron_list.indexOf(new_neuron);
            return new_neuron;
    }
    
    @Override
    public String toString() {
        return "Network{" + "neuron_list=" + neuron_list + '}';
    }
    public ArrayList<Neuron> getNeuron_list() {
        return neuron_list;
    }

    public void setP(float p) {
        this.p = p;
    }

    public float getP() {
        return p;
    }
    public float getSimila() {
        return simila;
    }
        public int getNeuronID() {
        return neuronID;
    }
}
