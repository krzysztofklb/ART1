/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuron;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author LENOVO
 */
public class ConvertImage {
    private int[][] imgBinaryTable;
    public ConvertImage(String path) {
        File file = new File(path);
        try {
            BufferedImage image = ImageIO.read(file);
            imgBinaryTable = convertImgToTable(image);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int[] getImgBinaryTable() {        
        return convert2Dto1D(imgBinaryTable);
    }


    
        private int[][] convertImgToTable(BufferedImage image) {
		int[][] imgBinaryTable = new int[image.getWidth()][image.getHeight()];
		String[][] imgBinaryTableString = new String[image.getWidth()][image.getHeight()];
		int val;
		String valString;
		for (int i = 0; i < image.getWidth(); i++) {
		        for (int j = 0; j < image.getHeight(); j++) {
		            int color = image.getRGB(j, i);

		             val = image.getRGB(j,i) < -2 ? 1:0;
		             
		             imgBinaryTable[j][i] = val;    
		        }
  
		    }
		return imgBinaryTable;
	}
        public static int[] convert2Dto1D(int[][] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            // tiny change 1: proper dimensions
            for (int j = 0; j < arr[i].length; j++) {
                // tiny change 2: actually store the values
                list.add(arr[i][j]);
            }
        }
        int[] vector = new int[list.size()];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = list.get(i);
        }
        return vector;
    }
        

 }
    
    
    
    
    
    
//        static int[] image1 = {1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1};
//        static int[] image2 = {1,0,0,0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,1,0,1,0,0,0,1};
//        static int[] image3 = {1,0,0,0,1,0,1,0,1,0,1,1,1,1,1,0,1,0,1,0,1,0,0,0,1};
//        static int[] image4 = {1,0,0,0,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,0,0,0,1};

//        public static void main(String [] args){
//        System.out.println("rozpoczecie");
//        
//        Network siec1 = new Network();
//        siec1.addToNeuron_list(image1);
//        System.out.println(siec1.toString());
//
//        siec1.returnWinnerNeuron(image1);
//        siec1.returnWinnerNeuron(image2);
//        siec1.returnWinnerNeuron(image3);
//        siec1.returnWinnerNeuron(image4);
//        
//        
//        System.out.println(siec1.toString());
//
//
//        
//        
//        System.out.println("zakonczenie");
//    }
    

