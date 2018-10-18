import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import javax.swing.Timer;
import java.net.*;

public class Moms_Class_Stuff{
   public static JFrame mainwind = new JFrame("home");
   public static JPanel mainPan = new JPanel();
   public static JFrame Enterstuds = new JFrame("enter studens");
   public static JPanel ESPan = new JPanel();
   public static JFrame PickStuds = new JFrame("pick students");
   public static JPanel PSPan = new JPanel();
   public static JFrame f = new JFrame("Animation");
   public static void main(String[] args){
      mainwind.setSize(450, 250);
      mainwind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainwind.add(mainPan);
      
      Enterstuds.setSize(450,750);
      Enterstuds.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      Enterstuds.add(ESPan);
      
      PickStuds.setSize(450,750);
      PickStuds.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      PickStuds.add(PSPan);
      
      mainPan.setLayout(null);
      JLabel infoA = new JLabel("Class Name");
      infoA.setBounds(10,20,80,25);
      mainPan.add(infoA);
      
      JTextField classs = new JTextField();
      classs.setBounds(100,20,165,25);
      mainPan.add(classs);
      
      JButton enter = new JButton("add students");
      enter.setBounds(10,60,160,70);
      enter.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         pollEnter((classs.getText() + ".txt"));
      }
      });
      mainPan.add(enter);
      
      JButton pull = new JButton("choose students");
      pull.setBounds(180,60,160,70);
      pull.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         pollPull(classs.getText() + ".txt");
      }
      });
      mainPan.add(pull);
      
      mainPan.setVisible(true);
      mainwind.setVisible(true);

    //  pollEnter();
     // ArrayList pull = pullNameFromFile(classs);
    //  String end = pollPull();
    //  System.out.println(end);
   }
   
   public static void pollEnter(String classs){
      ESPan.removeAll();
      ESPan.revalidate();
      ESPan.repaint();
      ESPan.setLayout(null);
      
      JLabel infnamm = new JLabel("Student Name");
      infnamm.setBounds(10,20,80,25);
      ESPan.add(infnamm);
      
      JTextField name = new JTextField();
      name.setBounds(100,20,165,25);
      ESPan.add(name);
      
      JLabel Class = new JLabel(dostuff(classs));
      Class.setBounds(10,30,230,500);
      ESPan.add(Class);
      
      JButton add = new JButton("add");
      add.setBounds(300,20,90,50);
      add.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         addtofile(classs,name.getText());
         String temp = dostuff(classs);
         Class.setText(temp);
      }
      });
      ESPan.add(add);
      
      JButton rev = new JButton("remove");
      rev.setBounds(300,80,90,50);
      rev.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         removefromfile(classs,name.getText());
         String temp = dostuff(classs);
         Class.setText(temp);
      }
      });
      ESPan.add(rev);
      
      
      ESPan.setVisible(true);
      Enterstuds.setVisible(true);
   
   }
    public static String dostuff(String classs){
        String w = "<HTML>";
         try{
         Scanner wordReadr = new Scanner(new File(classs));
         while ( wordReadr.hasNextLine()) {
          w += (wordReadr.nextLine() + "");
          w+= "<br>";
         }
         w+="</HTML>";
         System.out.println("doing stuff");
         wordReadr.close();
          }
         
         catch (Exception e){
         w = "";
         System.out.println("error in function dostuff");
         }
        return w;
     }
   public static Timer t;
   public static void pollPull(String classs){
      PSPan.removeAll();
      PSPan.revalidate();
      PSPan.repaint();
      PSPan.setLayout(null);
      
      JLabel infA = new JLabel("I need");
      infA.setBounds(10,20,80,25);
      PSPan.add(infA);
      
      JSpinner numof = new JSpinner();
      numof.setBounds(50,20,35,25);
      numof.setValue(1);
      PSPan.add(numof);
      
      JLabel infB = new JLabel("groups of");
      infB.setBounds(90,20,80,25);
      PSPan.add(infB);
      
      JSpinner grpsize = new JSpinner();
      grpsize.setBounds(150,20,35,25);
      grpsize.setValue(1);
      PSPan.add(grpsize);
      
      Object howmany =grpsize.getValue();
      System.out.println(howmany);
      
      JLabel Class = new JLabel(dostuff(classs));
      Class.setBounds(10,30,400,600);
      PSPan.add(Class);
      
      JButton Start = new JButton("<HTML><body style= \"font-size:125%\";> GO!!!</body></HTML>");
      Start.setBounds(250,20,100,100);
      Start.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         try {
        numof.commitEdit();
        } catch ( java.text.ParseException e ) {  }
        int value = (int) numof.getValue();
        try {
        grpsize.commitEdit();
        } catch ( java.text.ParseException e ) {  }
        int val = (int) grpsize.getValue();
         Timer t = new Timer(2000, new ActionListener(){
                 int count = 0;
                 String ress = "";
                 int trak = 0;
         ArrayList pull = pullNameFromFile(classs);
         int[] INTpulled = new int[pull.size()];
            @Override
            public void actionPerformed(ActionEvent e){
            if(count < value){try{
               int gif = (int)Math.round(Math.random() * 4);
               System.out.println(gif);
               String ur = "";
               switch(gif){
                  case 0: ur = "dice1.gif"; break;
                  case 1: ur = "spinner.gif"; break;
                  case 2: ur = "dice2.gif"; break;
                  case 3: ur = "spinner1.gif"; break;
                  case 4: ur = "dice3.gif"; break;
               }
                URL url = getClass().getResource(ur);
                Icon icon;
                icon = new ImageIcon(url);
                JLabel giff = new JLabel(icon);
                System.out.println(icon);
                f.getContentPane().add(giff);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                Timer delay = new Timer(1700, new ActionListener(){ 
                @Override 
                public void actionPerformed(ActionEvent e) {
                System.out.println("disposing");
                f.getContentPane().remove(giff);
                f.dispose();
                
                ress += choose(pull,INTpulled,value,val,Class,trak);
                                Class.setText("<HTML>  <p style= \"font-size:125%; color: #ff0000\">" + ress + "</p> <HTML>");
                trak += val;
                  }
                  });
                  delay.setRepeats(false);
                delay.start(); 
                }
                catch(Exception err){
                System.out.println("error: " + err);
                }
                }
                count ++;
            }
        });
        t.start();
       }
      });
      PSPan.add(Start);
            
      PSPan.setVisible(true);
      PickStuds.setVisible(true);
   }
   public static String choose(ArrayList pull,int[] INTpulled, int howmany, int grpsize, JLabel Class,int trak){
         String res = "";
          //ArrayList pull = pullNameFromFile(classs);
         //int[] INTpulled = new int[pull.size()];
         System.out.println(Arrays.toString(INTpulled));
         while((howmany * grpsize) > pull.size()){
            if(grpsize > pull.size()){
            grpsize -= 1;
            }
            else{
            howmany -= 1;
            }
            }
               int grpsizee = grpsize;
               int howmanyy = howmany;
               String ress = "";
               int trakk = trak;
           //    for (int r = 0; r < howmany; r++){
               for (int a = 0; a < grpsize; a++){
               int toPull= 0;
               boolean pulled = false;
               do{//checks if number has been drawn allready
                  pulled = false;
                  int max = pull.size();
                  if((max > 1)){
                  max -= 1;
                  }
                  if(((howmanyy*grpsizee)-trak == 1) && (howmanyy !=1) && (grpsizee != 1)){
                     for(int c = 0; c < INTpulled.length; c++){
                     boolean drawn = false;
                        for(int d = 0; d <INTpulled.length;d++){
                        if(c == INTpulled[d]){
                        drawn = true;
                        }
                        }
                        if(!drawn){
                        toPull = c;
                        }
                     }
                  }
                  else{
                  toPull  = ((int)(Math.round((max) * Math.random())));
                  for(int b = 0; b < INTpulled.length; b++){
                     if (toPull == INTpulled[b]){
                        pulled = true;
                     }
                  }
                  }
                  System.out.println(toPull);
                 }while((pulled));
               INTpulled[trak] = toPull;

               if(a == 0){
                  res += ("[ " + pull.get(toPull));
               }
               else{
                  res += (", " + pull.get(toPull));
               }
               trak++;
               Class.setText(res);
            }
                        res += " ]";
            Class.setText(res);
            //}
         return res;
   }
   
   public static void addtofile(String filename, String name){
      try{
         File classs = new File(filename);
         PrintWriter out = new PrintWriter(new FileWriter(classs, true));
         out.println(name);
         out.close();
      }
      catch(Exception e){
         System.out.println("error in function addtofile");
      }
   }
   public static void removefromfile(String filename, String name){
      try{
         File Class = new File(filename);
         int end = filename.indexOf(".");
         String classer = (filename.substring(0,end) + "TEMP.txt");
         File tempClass = new File(classer);
         BufferedReader reader = new BufferedReader(new FileReader(Class));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempClass));

         String currentLine;

         while((currentLine = reader.readLine()) != null) {
         // trim newline when comparing with lineToRemove
         String trimmedLine = currentLine.trim();
          if(trimmedLine.equals(name)) continue;
         writer.write(currentLine + System.getProperty("line.separator"));
         }
         writer.close(); 
         reader.close(); 
         boolean deleted = Class.delete();
         boolean successful = tempClass.renameTo(Class);
         System.out.println("worked: " + (successful && deleted)); 
      }
      catch(Exception e){
       System.out.println("error in function removefromfile");
      }
   }
   public static ArrayList pullNameFromFile(String filename){
      ArrayList names = new ArrayList();
      int i =0;
      try{
      Scanner reader = new Scanner(new File(filename));
         while(reader.hasNextLine()){
         names.add(i,reader.nextLine());
         i++;
         }
         reader.close();
      }
      catch(Exception e){
      System.out.println("error in function pullNameFromFile");
      }
      return names;
   }
}