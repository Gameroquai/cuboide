/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuboide;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import utils78.ES;

/**
 *
 * @author Usuario
 */
public class Cuboide extends JFrame{
    
    static int i, j, k, tope, buscar;
    static int cuboide[][][];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Escriba primera dimension: ");
        i = sc.nextInt();
        System.out.println("Escriba segunda dimension: ");
        j = sc.nextInt();
        System.out.println("Escriba tercera dimension: ");
        k = sc.nextInt();
        System.out.println("Tope de numero aleatorio: ");
        tope = sc.nextInt();
        cuboide = crearCubo(i, j, k, tope);
        //System.out.println(Arrays.deepToString(cuboide));
        System.out.println("Numero que desea buscar: ");
        buscar = sc.nextInt();
        buscarCoor(buscar);
        cantidadRep();*/
        Cuboide ventana = new Cuboide();
        ventana.setSize(900, 600);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        ventana.setTitle("Cuboide");
        ventana.setVisible(true);
    }//Main---------------------------------------------------------------------

    public Cuboide() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                cerrar();
            }
        });
        
        //ELEMENTOS-------------------------------------------------------------
        JLabel labelDim, labelX, labelY, labelZ, labelTope, labelCreado, labelCoord, labelRep;
        JTextField textoX, textoY, textoZ, textoTope, textoCoord;
        JButton buttonMontar, buttonCoord, buttonRep, buttonLimpiar, buttonCerrar;
        JTextArea solucion;
        //PANEL OESTE-----------------------------------------------------------
        JPanel oeste = new JPanel();
        oeste.setLayout(new BoxLayout(oeste, BoxLayout.Y_AXIS));
        labelDim = new JLabel("Dimensiones");
        //box
        labelTope = new JLabel("Nº tope");
        textoTope = new JTextField(10);
        buttonMontar = new JButton("Generar");
        
        oeste.add(labelDim);
        oeste.add(labelTope);
        oeste.add(textoTope);
        oeste.add(buttonMontar);
        //PANEL ESTE------------------------------------------------------------
        JPanel este = new JPanel();
        
        //PANEL SUR-------------------------------------------------------------
        JPanel sur = new JPanel();
        
        
        
        
        
        add(oeste, BorderLayout.WEST);
        add(este, BorderLayout.EAST);
        add(sur, BorderLayout.SOUTH);
        
    }
    
    static int [][][] crearCubo(int i, int j, int k, int tope){
        int [][][] cuboide = new int [i][j][k];
        
        for (int l = 0; l < i; l++) {
            for (int m = 0; m < j; m++) {
                for (int n = 0; n < k; n++) {
                    cuboide[l][m][n]= (int) (Math.random()*((tope - 0)+1)+0);
                }
            }
        }
        return cuboide;
    }
    
    static void buscarCoor(int buscar){
        for (int l = 0; l < i; l++) {
            for (int m = 0; m < j; m++) {
                for (int n = 0; n < k; n++) {
                    if(cuboide[l][m][n]==buscar){
                        System.out.println("Coordenadas: "+l+" "+m+" "+n);
                    }
                }
            }
        }
    }
    
    static void cantidadRep() {
        for (int x = 0; x <= tope; x++) {
            System.out.print(x + ": ");
            for (int y = 0; y < cuboide.length-1; y++) {
                int cont = 0;
                for (int l = 0; l < i; l++) {
                    for (int m = 0; m < j; m++) {
                        for (int n = 0; n < k; n++) {
                            if (cuboide[l][m][n] == x) {
                                cont++;
                            }
                        }
                    }
                }
                if (cont!=0){
                    System.out.println(cont);
                }
                
            }
        }
    }
    
    static void cerrar(){
        String [] botones = {"Sí", "No"};
                int respuesta = JOptionPane.showOptionDialog(null, "Desea Salir?", "Ventana de salida", 
                        JOptionPane.WARNING_MESSAGE, 0, null, botones, botones[1]);
                if (respuesta == 0){
                    System.exit(0);
                }
    }
}
