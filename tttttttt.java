/**
 * @(#)tttttttt.java
 *
 * tttttttt Applet application
 *
 * @author
 * @version 1.00 2010/5/30
 */

import java.awt.*;
import java.applet.*;
import javax.swing.JPanel;
import java.lang.Math.*;
import java.text.DecimalFormat;
import java.util.Scanner;


public class tttttttt extends Applet {

	    private salih bolge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton kubik1;
    private javax.swing.JButton kubik2;
    private javax.swing.JButton quad1;
    private javax.swing.JButton quad2;
    private javax.swing.JTextField yaziGirisi;
    private java.awt.TextArea yazici;
    public int Number_of_Points=0;
    public int points[][]=new int [1000][3];//Koordinatlarý tutan matris
    public int i,j,k;
    double B[][]=new double[1000][1000];
    double sifirla[][]=new double[1000][1000];
    int satirsayisi=0;
    int sutunsayisi=0;
    int p,h,g;
    final double EPSILON = 1e-15;
    public double cozum_cub[]=new double [1000];//Koordinatlarý tutan matris
    public double cozum_cub_real[]=new double [1000];
    public double cozum_quad[]=new double [1000];//Koordinatlarý tutan matris
    public String stringim="";
     DecimalFormat uc = new DecimalFormat("0   ");
     public String ilkalinan="";
     public int uzunluk;
     public int virgulsayisi;
     public String parcabir="";
     public int l;
     public String hop="";
     public int y;
     String stringci="";

    Scanner tara1 = new Scanner (ilkalinan);
    Scanner tara2 = new Scanner (parcabir);


	public void init() {

 setSize(900,450);
        bolge = new salih();
        yazici = new java.awt.TextArea();
        yaziGirisi = new javax.swing.JTextField();
        kubik1 = new javax.swing.JButton();
        kubik2 = new javax.swing.JButton();
        quad1 = new javax.swing.JButton();
        quad2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        bolge.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bolge.setBackground(Color.WHITE);
        bolge.setPreferredSize(new java.awt.Dimension(200, 100));
        bolge.setRequestFocusEnabled(false);
               bolge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bolgeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bolgeLayout = new javax.swing.GroupLayout(bolge);
        bolge.setLayout(bolgeLayout);
        bolgeLayout.setHorizontalGroup(
            bolgeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );
        bolgeLayout.setVerticalGroup(
            bolgeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );

        yazici.setEditable(false);

        kubik1.setText("Draw Cubic Splines");
                kubik1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kubik1MouseClicked(evt);
            }
        });

        kubik2.setText("Draw Cubic Splines");
                kubik2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kubik2MouseClicked(evt);
            }
        });

        quad1.setText("Draw Quadratic Splines");
                quad1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quad1MouseClicked(evt);
            }
        });

        quad2.setText("Draw Quadratic Splines");
                quad2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quad2MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Equations");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(yaziGirisi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(yazici, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(kubik1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quad1))
                            .addComponent(jLabel1))
                        .addGap(209, 209, 209))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bolge, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kubik2)
                            .addComponent(quad2))
                        .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yaziGirisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kubik1)
                    .addComponent(quad1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yazici, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kubik2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quad2))
                    .addComponent(bolge, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
	}

	/*Mouse olaylarý burda*/
    private void bolgeMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        //bolge mouse clicked
        if(kubik1.isEnabled()||kubik2.isEnabled()||quad1.isEnabled()||quad2.isEnabled()){

        //.println(Integer.toString(-250+evt.getX()));
        //.println(Integer.toString(125-evt.getY()));
        Number_of_Points++;
        points[Number_of_Points][1]=-250+evt.getX();
        points[Number_of_Points][2]=125-evt.getY();
        for(i=1;i<=Number_of_Points;i++){

for(y=1;y<Number_of_Points;y++){

if(points[y][1]>points[y+1][1]){

int[] temp = points[y]; points[y] = points[y+1]; points[y+1] = temp;
}
}

}
        bolge.points_number=Number_of_Points;
        bolge.A=points;

        bolge.repaint();

        }

    }
    private void kubik2MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        kubik1.setEnabled(false);
        kubik2.setEnabled(false);
        quad1.setEnabled(false);
        int s=1;
        yazici.setText(yazici.getText()+"\nCubic Equations\n"+"************************\n");
for(i=2;i<Number_of_Points;i++){
k=i-2;
B[s][k*4+1]=Math.pow(points[i][1], 3);//üzeri 3
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)Math.pow(points[i][1], 3))+")"+" a"+Integer.toString(k+1);
//yazici.setText(yazici.getText()+stringim);
B[s][k*4+2]=Math.pow(points[i][1], 2);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 2))+")"+" b"+Integer.toString(k+1);
B[s][k*4+3]=Math.pow(points[i][1], 1);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 1))+")"+" c"+Integer.toString(k+1);
B[s][k*4+4]=Math.pow(points[i][1], 0);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 0))+")"+" d"+Integer.toString(k+1);
B[s][4*(Number_of_Points-1)+1]=points[i][2];//eþit olmasý gereken deðer
stringci+=" ="+Integer.toString(points[i][2]);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";


s++;//katsayý matrisi satýr atladýk

B[s][k*4+5]=Math.pow(points[i][1], 3);//üzeri 3
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)Math.pow(points[i][1], 3))+")"+" a"+Integer.toString(k+2);
B[s][k*4+6]=Math.pow(points[i][1], 2);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 2))+")"+" b"+Integer.toString(k+2);
B[s][k*4+7]=Math.pow(points[i][1], 1);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 1))+")"+" c"+Integer.toString(k+2);
B[s][k*4+8]=Math.pow(points[i][1], 0);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 0))+")"+" d"+Integer.toString(k+2);

B[s][4*(Number_of_Points-1)+1]=points[i][2];//eþit olmasý gereken deðer
stringci+=" ="+Integer.toString(points[i][2]);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";

s++;//katsayý matrisi satýr atladýk

B[s][k*4+1]=3*Math.pow(points[i][1],2);//Birinci türev muhabbeti üzeri 2
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)(3*Math.pow(points[i][1],2)))+")"+" a"+Integer.toString(k+1);
B[s][k*4+2]=2*Math.pow(points[i][1],1);//Birinci türev muhabbeti üzeri 1
stringci+=" + "+"("+Integer.toString((int)(2*Math.pow(points[i][1],1)))+")"+" b"+Integer.toString(k+1);
B[s][k*4+3]=1*Math.pow(points[i][1],0);//Birinci türev muhabbeti üzeri 0
stringci+=" + "+"("+Integer.toString((int)(1*Math.pow(points[i][1],0)))+")"+" c"+Integer.toString(k+1);
B[s][k*4+4]=0;//Birinci türev muhabbeti 0







B[s][k*4+5]=(-3)*Math.pow(points[i][1],2);//Birinci türev muhabbeti
stringci+=" + "+"("+Integer.toString((int)(-3*Math.pow(points[i][1],2)))+")"+" a"+Integer.toString(k+2);
B[s][k*4+6]=(-2)*Math.pow(points[i][1],1);//Birinci türev muhabbeti
stringci+=" + "+"("+Integer.toString((int)(-2*Math.pow(points[i][1],1)))+")"+" b"+Integer.toString(k+2);
B[s][k*4+7]=(-1)*Math.pow(points[i][1],0);//Birinci türev muhabbeti
stringci+=" + "+"("+Integer.toString((int)(-1*Math.pow(points[i][1],0)))+")"+" c"+Integer.toString(k+2);
B[s][k*4+8]=0;//Birinci türev muhabbeti
B[s][4*(Number_of_Points-1)+1]=0;//son sutun
stringci+=" ="+Integer.toString(0);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";

s++;//katsayý matrisi satýr atladýk

B[s][k*4+1]=6*points[i][1];//ikinci türev
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)(6*Math.pow(points[i][1],1)))+")"+" a"+Integer.toString(k+1);
B[s][k*4+2]=2;
stringci+=" + "+"("+Integer.toString((int)(2*Math.pow(points[i][1],0)))+")"+" b"+Integer.toString(k+1);
B[s][k*4+5]=(-6)*points[i][1];//ikinci türev
stringci+=" + "+"("+Integer.toString((int)(-6*Math.pow(points[i][1],1)))+")"+" b"+Integer.toString(k+2);
B[s][k*4+6]=-2;//ikinci türev
stringci+=" + "+"("+Integer.toString((int)(-2*Math.pow(points[i][1],0)))+")"+" b"+Integer.toString(k+2);
B[s][4*(Number_of_Points-1)+1]=0;
stringci+=" ="+Integer.toString(0);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";

s++;//katsayý matrisi satýr atladýk


}//Döngü sonu
// 4n-4 TAne denklem koyduk
// 4n-4 TAne denklem koyduk
// 4n-4 TAne denklem koyduk
// 4n-4 TAne denklem koyduk
// 4n-4 TAne denklem koyduk



//þimdi 4 denklemde sýra

//Bu, ilk nokta saðlamalý
B[s][1]=Math.pow(points[1][1],3);
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)Math.pow(points[1][1], 3))+")"+" a"+Integer.toString(k+1);
B[s][2]=Math.pow(points[1][1],2);
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[1][1], 2))+")"+" b"+Integer.toString(k+1);
B[s][3]=Math.pow(points[1][1],1);
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 1))+")"+" c"+Integer.toString(k+1);
B[s][4]=Math.pow(points[1][1],0);
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 0))+")"+" b"+Integer.toString(k+1);
B[s][4*(Number_of_Points-1)+1]=points[1][2];
stringci+=" ="+Integer.toString(points[1][2]);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";

s++;

//Bu, son nokta saðlamalý
B[s][(Number_of_Points-2)*4+1]=Math.pow(points[Number_of_Points][1],3);
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)Math.pow(points[Number_of_Points][1], 3))+")"+" a"+Integer.toString(Number_of_Points-1);
B[s][(Number_of_Points-2)*4+2]=Math.pow(points[Number_of_Points][1],2);
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[Number_of_Points][1], 2))+")"+" b"+Integer.toString(Number_of_Points-1);
B[s][(Number_of_Points-2)*4+3]=Math.pow(points[Number_of_Points][1],1);
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[Number_of_Points][1], 1))+")"+" c"+Integer.toString(Number_of_Points-1);
B[s][(Number_of_Points-2)*4+4]=Math.pow(points[Number_of_Points][1],0);
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[Number_of_Points][1], 0))+")"+" d"+Integer.toString(Number_of_Points-1);
B[s][4*(Number_of_Points-1)+1]=points[Number_of_Points][2];
stringci+=" ="+Integer.toString(points[Number_of_Points][2]);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";
s++;

//ilk noktada ikinci türev sýfýr

B[s][1]=6*points[1][1];
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)(6*Math.pow(points[1][1], 1)))+")"+" a"+Integer.toString(k+1);
B[s][2]=2;
stringci+=" + "+"("+Integer.toString((int)(2*Math.pow(points[1][1], 0)))+")"+" b"+Integer.toString(k+1);
B[s][4*(Number_of_Points-1)+1]=0;
stringci+=" ="+Integer.toString(0);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";

s++;

//son noktada ikinci türev sýfýr
B[s][(Number_of_Points-2)*4+1]=6*points[Number_of_Points][1];
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)(6*Math.pow(points[Number_of_Points][1], 1)))+")"+" a"+Integer.toString(Number_of_Points-1);
B[s][(Number_of_Points-2)*4+2]=2;
stringci+=" + "+"("+Integer.toString((int)(2*Math.pow(points[Number_of_Points][1], 0)))+")"+" b"+Integer.toString(Number_of_Points-1);
B[s][4*(Number_of_Points-1)+1]=0;
stringci+=" ="+Integer.toString(0);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";


//4N TANE DENKLEM ÇIKARDIK
//4N TANE DENKLEM ÇIKARDIK
//4N TANE DENKLEM ÇIKARDIK
//4N TANE DENKLEM ÇIKARDIK
//4N TANE DENKLEM ÇIKARDIK
//:) :)
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////----------------------------BÄ°RÄ°NCÄ°        DÃ–NGÃœ -----------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------


satirsayisi=s;
sutunsayisi=s+1;
        for (int p = 1; p <= satirsayisi; p++) {


            int max = p;


////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////--------------------------P. SUTUNDAKÄ° EN BÃœYÃœK SATIRI BULDUK ----------------------------
////------------------------------------------------------------------------------------------

            for (int i = p + 1; i <= satirsayisi; i++) {
                if (Math.abs(B[i][p]) > Math.abs(B[max][p])) {
                    max = i;//EN BÃœYÃœK DEÄ?ERLÄ° SATIR NUMARASI
                }
            }
            if(Math.abs(B[max][p]) <= EPSILON){

                B[max][p]=0.00;
               continue;
            }
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------

         ////-----------SATIRLARIN YERLERÄ°NÄ° DEÄ?Ä°Å?TÄ°RDÄ°K--------------------------------------
            double[] temp = B[p]; B[p] = B[max]; B[max] = temp;


if(p!=(satirsayisi-1)){
stringim="";
for(h=1;h<=satirsayisi;h++){

	for(g=1;g<=sutunsayisi;g++){
//twoPlaces.format(val)
		//stringim=stringim+uc.format(B[h][g])+" ";
		}

	//stringim=stringim+"\n";
	}

	//yazici.setText(yazici.getText()+"\n::::::::::::::::::::::::::::::::\n"+stringim);
        }





 ////--------------:):):):):)---:)BURAYA KADAR SORUN YOK---------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------



            // singular or nearly singular  MATRÄ°S SINGULAR MI DÄ°YE KONTROL EDÄ°YORUZ

////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
            // pivot within A and b

            for (int i = p + 1; i <= satirsayisi; i++) {

                double bolucu = B[i][p] / B[p][p];


////-----------BURASI SON SUTUNU DEÄ?Ä°Å?TÄ°RÄ°YOR------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------BURASI NORMAL MATRÄ°SÄ° DEÄ?Ä°Å?TÄ°RÄ°YOR--------------------------------------------------

                for (int j = p; j <= sutunsayisi; j++) {
                    B[i][j] -= bolucu * B[p][j];
                }

            }
if(p!=(satirsayisi)){
stringim="";
for(h=1;h<=satirsayisi;h++){

	for(g=1;g<=sutunsayisi;g++){
//twoPlaces.format(val)
		stringim=stringim+uc.format(B[h][g])+" ";
		}

	stringim=stringim+"\n";
	}

	//yazici.setText(yazici.getText()+"\n::::::::::::::::::::::::::::::::\n"+stringim);
        }

        }

////-------------------SATIR VE SUTNLARDA Ã‡IKARMA Ä°Å?LEMÄ° YAPIYORUZ------------------------------------------

////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------





        for (int i = satirsayisi; i > 0; i--) {
        	//.println("girdim çözümdeyim")  ;               //SON SATIRDAN BAÅ?LAYARAK
            double sum = 0.0;
            for (int j = i + 1; j <= satirsayisi; j++) {//BÄ°RÄ°NCÄ° DE GÄ°RMÄ°YOR:
                sum += B[i][j] * cozum_cub[j];
            }
            if(B[i][i]==0){


    if((B[i][sutunsayisi] - sum)==0){


        yaziGirisi.setText("It is a redundant set of Equations");
    }

    else{

        yaziGirisi.setText("It is a inconsistent set of Equations");
    }

break;
}
            cozum_cub[i] = (B[i][sutunsayisi] - sum) / B[i][i];//BÄ°R DE YAPTIÄ?I Ä°Å?LEM
        }







	for(i=1;i<=satirsayisi;i++){
//.println("\n"+Double.toString(cozum_cub[i])+"**************");



	}

	bolge.C=cozum_cub;
	bolge.number_of_cubic=Number_of_Points;
	bolge.repaint();
	B=sifirla;




///////////Gauss
///////////Gauss
///////////Gauss




    }
    private void kubik1MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
                    ilkalinan=yaziGirisi.getText();
//.println(ilkalinan);
            yaziGirisi.setEditable(false);
            quad1.setEnabled(false);
            quad2.setEnabled(false);
            kubik2.setEnabled(false);



uzunluk=ilkalinan.length();
Scanner tara3 = new Scanner (ilkalinan);


            for(i=0;i<uzunluk;i++){


                if(ilkalinan.charAt(i)==';'){
                    virgulsayisi++;

                }
            }
satirsayisi=virgulsayisi+1;
sutunsayisi=2;
tara3.useDelimiter(";");


k=1;
l=1;


for(i=1;i<=satirsayisi;i++){

    parcabir=tara3.next();
    Scanner tara5=new Scanner(parcabir);
    for(j=1;j<=sutunsayisi;j++){

        hop=tara5.next();
        points[k][l]=(int)Double.parseDouble(hop);
        if(l==sutunsayisi){

            k++;
            l=1;
        }
        else{

            l++;
        }
   //------------------------------------------------------------------------------
   //------------------------------------------------------------------------------
   //-----------DÄ°ZÄ°YE ATTIM-------------------------------------------------
   //------------------------------------------------------------------------------



    }
}
        // TODO add your handling code here:
        kubik1.setEnabled(false);
        quad1.setEnabled(false);
        int s=1;
        Number_of_Points=satirsayisi;
        for(i=1;i<=Number_of_Points;i++){

for(y=1;y<Number_of_Points;y++){

if(points[y][1]>points[y+1][1]){

int[] temp = points[y]; points[y] = points[y+1]; points[y+1] = temp;
}
}

}
for(i=2;i<Number_of_Points;i++){
k=i-2;
B[s][k*4+1]=Math.pow(points[i][1], 3);//üzeri 3
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)Math.pow(points[i][1], 3))+")"+" a"+Integer.toString(k+1);
//yazici.setText(yazici.getText()+stringim);
B[s][k*4+2]=Math.pow(points[i][1], 2);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 2))+")"+" b"+Integer.toString(k+1);
B[s][k*4+3]=Math.pow(points[i][1], 1);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 1))+")"+" c"+Integer.toString(k+1);
B[s][k*4+4]=Math.pow(points[i][1], 0);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 0))+")"+" d"+Integer.toString(k+1);
B[s][4*(Number_of_Points-1)+1]=points[i][2];//eþit olmasý gereken deðer
stringci+=" ="+Integer.toString(points[i][2]);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";


s++;//katsayý matrisi satýr atladýk

B[s][k*4+5]=Math.pow(points[i][1], 3);//üzeri 3
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)Math.pow(points[i][1], 3))+")"+" a"+Integer.toString(k+2);
B[s][k*4+6]=Math.pow(points[i][1], 2);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 2))+")"+" b"+Integer.toString(k+2);
B[s][k*4+7]=Math.pow(points[i][1], 1);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 1))+")"+" c"+Integer.toString(k+2);
B[s][k*4+8]=Math.pow(points[i][1], 0);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 0))+")"+" d"+Integer.toString(k+2);

B[s][4*(Number_of_Points-1)+1]=points[i][2];//eþit olmasý gereken deðer
stringci+=" ="+Integer.toString(points[i][2]);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";

s++;//katsayý matrisi satýr atladýk

B[s][k*4+1]=3*Math.pow(points[i][1],2);//Birinci türev muhabbeti üzeri 2
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)(3*Math.pow(points[i][1],2)))+")"+" a"+Integer.toString(k+1);
B[s][k*4+2]=2*Math.pow(points[i][1],1);//Birinci türev muhabbeti üzeri 1
stringci+=" + "+"("+Integer.toString((int)(2*Math.pow(points[i][1],1)))+")"+" b"+Integer.toString(k+1);
B[s][k*4+3]=1*Math.pow(points[i][1],0);//Birinci türev muhabbeti üzeri 0
stringci+=" + "+"("+Integer.toString((int)(1*Math.pow(points[i][1],0)))+")"+" c"+Integer.toString(k+1);
B[s][k*4+4]=0;//Birinci türev muhabbeti 0







B[s][k*4+5]=(-3)*Math.pow(points[i][1],2);//Birinci türev muhabbeti
stringci+=" + "+"("+Integer.toString((int)(-3*Math.pow(points[i][1],2)))+")"+" a"+Integer.toString(k+2);
B[s][k*4+6]=(-2)*Math.pow(points[i][1],1);//Birinci türev muhabbeti
stringci+=" + "+"("+Integer.toString((int)(-2*Math.pow(points[i][1],1)))+")"+" b"+Integer.toString(k+2);
B[s][k*4+7]=(-1)*Math.pow(points[i][1],0);//Birinci türev muhabbeti
stringci+=" + "+"("+Integer.toString((int)(-1*Math.pow(points[i][1],0)))+")"+" c"+Integer.toString(k+2);
B[s][k*4+8]=0;//Birinci türev muhabbeti
B[s][4*(Number_of_Points-1)+1]=0;//son sutun
stringci+=" ="+Integer.toString(0);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";

s++;//katsayý matrisi satýr atladýk

B[s][k*4+1]=6*points[i][1];//ikinci türev
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)(6*Math.pow(points[i][1],1)))+")"+" a"+Integer.toString(k+1);
B[s][k*4+2]=2;
stringci+=" + "+"("+Integer.toString((int)(2*Math.pow(points[i][1],0)))+")"+" b"+Integer.toString(k+1);
B[s][k*4+5]=(-6)*points[i][1];//ikinci türev
stringci+=" + "+"("+Integer.toString((int)(-6*Math.pow(points[i][1],1)))+")"+" b"+Integer.toString(k+2);
B[s][k*4+6]=-2;//ikinci türev
stringci+=" + "+"("+Integer.toString((int)(-2*Math.pow(points[i][1],0)))+")"+" b"+Integer.toString(k+2);
B[s][4*(Number_of_Points-1)+1]=0;
stringci+=" ="+Integer.toString(0);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";

s++;//katsayý matrisi satýr atladýk


}//Döngü sonu
// 4n-4 TAne denklem koyduk
// 4n-4 TAne denklem koyduk
// 4n-4 TAne denklem koyduk
// 4n-4 TAne denklem koyduk
// 4n-4 TAne denklem koyduk



//þimdi 4 denklemde sýra

//Bu, ilk nokta saðlamalý
B[s][1]=Math.pow(points[1][1],3);
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)Math.pow(points[1][1], 3))+")"+" a"+Integer.toString(k+1);
B[s][2]=Math.pow(points[1][1],2);
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[1][1], 2))+")"+" b"+Integer.toString(k+1);
B[s][3]=Math.pow(points[1][1],1);
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 1))+")"+" c"+Integer.toString(k+1);
B[s][4]=Math.pow(points[1][1],0);
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 0))+")"+" b"+Integer.toString(k+1);
B[s][4*(Number_of_Points-1)+1]=points[1][2];
stringci+=" ="+Integer.toString(points[1][2]);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";

s++;

//Bu, son nokta saðlamalý
B[s][(Number_of_Points-2)*4+1]=Math.pow(points[Number_of_Points][1],3);
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)Math.pow(points[Number_of_Points][1], 3))+")"+" a"+Integer.toString(Number_of_Points-1);
B[s][(Number_of_Points-2)*4+2]=Math.pow(points[Number_of_Points][1],2);
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[Number_of_Points][1], 2))+")"+" b"+Integer.toString(Number_of_Points-1);
B[s][(Number_of_Points-2)*4+3]=Math.pow(points[Number_of_Points][1],1);
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[Number_of_Points][1], 1))+")"+" c"+Integer.toString(Number_of_Points-1);
B[s][(Number_of_Points-2)*4+4]=Math.pow(points[Number_of_Points][1],0);
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[Number_of_Points][1], 0))+")"+" d"+Integer.toString(Number_of_Points-1);
B[s][4*(Number_of_Points-1)+1]=points[Number_of_Points][2];
stringci+=" ="+Integer.toString(points[Number_of_Points][2]);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";
s++;

//ilk noktada ikinci türev sýfýr

B[s][1]=6*points[1][1];
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)(6*Math.pow(points[1][1], 1)))+")"+" a"+Integer.toString(k+1);
B[s][2]=2;
stringci+=" + "+"("+Integer.toString((int)(2*Math.pow(points[1][1], 0)))+")"+" b"+Integer.toString(k+1);
B[s][4*(Number_of_Points-1)+1]=0;
stringci+=" ="+Integer.toString(0);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";

s++;

//son noktada ikinci türev sýfýr
B[s][(Number_of_Points-2)*4+1]=6*points[Number_of_Points][1];
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)(6*Math.pow(points[Number_of_Points][1], 1)))+")"+" a"+Integer.toString(Number_of_Points-1);
B[s][(Number_of_Points-2)*4+2]=2;
stringci+=" + "+"("+Integer.toString((int)(2*Math.pow(points[Number_of_Points][1], 0)))+")"+" b"+Integer.toString(Number_of_Points-1);
B[s][4*(Number_of_Points-1)+1]=0;
stringci+=" ="+Integer.toString(0);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";


//4N TANE DENKLEM ÇIKARDIK
//4N TANE DENKLEM ÇIKARDIK
//4N TANE DENKLEM ÇIKARDIK
//4N TANE DENKLEM ÇIKARDIK
//4N TANE DENKLEM ÇIKARDIK
//:) :)
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////----------------------------BÄ°RÄ°NCÄ°        DÃ–NGÃœ -----------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------


satirsayisi=s;
sutunsayisi=s+1;
        for (int p = 1; p <= satirsayisi; p++) {


            int max = p;


////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////--------------------------P. SUTUNDAKÄ° EN BÃœYÃœK SATIRI BULDUK ----------------------------
////------------------------------------------------------------------------------------------

            for (int i = p + 1; i <= satirsayisi; i++) {
                if (Math.abs(B[i][p]) > Math.abs(B[max][p])) {
                    max = i;//EN BÃœYÃœK DEÄ?ERLÄ° SATIR NUMARASI
                }
            }
            if(Math.abs(B[max][p]) <= EPSILON){

                B[max][p]=0.00;
               continue;
            }
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------

         ////-----------SATIRLARIN YERLERÄ°NÄ° DEÄ?Ä°Å?TÄ°RDÄ°K--------------------------------------
            double[] temp = B[p]; B[p] = B[max]; B[max] = temp;


if(p!=(satirsayisi-1)){
stringim="";
for(h=1;h<=satirsayisi;h++){

	for(g=1;g<=sutunsayisi;g++){
//twoPlaces.format(val)
		stringim=stringim+uc.format(B[h][g])+" ";
		}

	stringim=stringim+"\n";
	}

	//yazici.setText(yazici.getText()+"\n::::::::::::::::::::::::::::::::\n"+stringim);
        }





 ////--------------:):):):):)---:)BURAYA KADAR SORUN YOK---------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------



            // singular or nearly singular  MATRÄ°S SINGULAR MI DÄ°YE KONTROL EDÄ°YORUZ

////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
            // pivot within A and b

            for (int i = p + 1; i <= satirsayisi; i++) {

                double bolucu = B[i][p] / B[p][p];


////-----------BURASI SON SUTUNU DEÄ?Ä°Å?TÄ°RÄ°YOR------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------BURASI NORMAL MATRÄ°SÄ° DEÄ?Ä°Å?TÄ°RÄ°YOR--------------------------------------------------

                for (int j = p; j <= sutunsayisi; j++) {
                    B[i][j] -= bolucu * B[p][j];
                }

            }
if(p!=(satirsayisi)){
stringim="";
for(h=1;h<=satirsayisi;h++){

	for(g=1;g<=sutunsayisi;g++){
//twoPlaces.format(val)
		stringim=stringim+uc.format(B[h][g])+" ";
		}

	stringim=stringim+"\n";
	}

	//yazici.setText(yazici.getText()+"\n::::::::::::::::::::::::::::::::\n"+stringim);
        }

        }

////-------------------SATIR VE SUTNLARDA Ã‡IKARMA Ä°Å?LEMÄ° YAPIYORUZ------------------------------------------

////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------





        for (int i = satirsayisi; i > 0; i--) {
        	//.println("girdim çözümdeyim")  ;               //SON SATIRDAN BAÅ?LAYARAK
            double sum = 0.0;
            for (int j = i + 1; j <= satirsayisi; j++) {//BÄ°RÄ°NCÄ° DE GÄ°RMÄ°YOR:
                sum += B[i][j] * cozum_cub[j];
            }
            if(B[i][i]==0){


    if((B[i][sutunsayisi] - sum)==0){


        yaziGirisi.setText("It is a redundant set of Equations");
    }

    else{

        yaziGirisi.setText("It is a inconsistent set of Equations");
    }

break;
}
            cozum_cub[i] = (B[i][sutunsayisi] - sum) / B[i][i];//BÄ°R DE YAPTIÄ?I Ä°Å?LEM
        }







	for(i=1;i<=satirsayisi;i++){
//.println("\n"+Double.toString(cozum_cub[i])+"**************");



	}
    bolge.A=points;
    bolge.points_number=Number_of_Points;
	bolge.C=cozum_cub;
	bolge.number_of_cubic=Number_of_Points;
	bolge.repaint();

    }/*Kubik 1 sonu*/
    private void quad2MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
  // TODO add your handling code here:
  quad2.setEnabled(false);
        kubik1.setEnabled(false);
        quad1.setEnabled(false);
        int s=1;
        yazici.setText(yazici.getText()+"\nQuadratic Equations\n"+"************************\n");
for(i=2;i<Number_of_Points;i++){
k=i-2;
B[s][k*3+1]=Math.pow(points[i][1], 2);//üzeri 3

stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)Math.pow(points[i][1], 2))+")"+" a"+Integer.toString(k+1);
B[s][k*3+2]=Math.pow(points[i][1], 1);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 1))+")"+" b"+Integer.toString(k+1);
B[s][k*3+3]=Math.pow(points[i][1], 0);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 0))+")"+" c"+Integer.toString(k+1);

B[s][3*(Number_of_Points-1)+1]=points[i][2];//eþit olmasý gereken deðer
stringci+=" ="+Integer.toString(points[i][2]);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";


s++;//katsayý matrisi satýr atladýk

B[s][k*3+4]=Math.pow(points[i][1], 2);//üzeri 3
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)Math.pow(points[i][1], 2))+")"+" a"+Integer.toString(k+2);
B[s][k*3+5]=Math.pow(points[i][1], 1);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 1))+")"+" b"+Integer.toString(k+2);
B[s][k*3+6]=Math.pow(points[i][1], 0);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 0))+")"+" c"+Integer.toString(k+2);

B[s][3*(Number_of_Points-1)+1]=points[i][2];//eþit olmasý gereken deðer
stringci+=" ="+Integer.toString(points[i][2]);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";


s++;//katsayý matrisi satýr atladýk

B[s][k*3+1]=2*Math.pow(points[i][1],1);//Birinci türev muhabbeti üzeri 2
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)(2*Math.pow(points[i][1], 1)))+")"+" a"+Integer.toString(k+1);
B[s][k*3+2]=Math.pow(points[i][1],0);//Birinci türev muhabbeti üzeri 1
stringci+=" + "+"("+Integer.toString((int)(Math.pow(points[i][1], 0)))+")"+" b"+Integer.toString(k+1);




B[s][k*3+4]=(-2)*Math.pow(points[i][1],1);//Birinci türev muhabbeti
stringci+=" + "+"("+Integer.toString((int)(-2*Math.pow(points[i][1], 1)))+")"+" a"+Integer.toString(k+2);
B[s][k*3+5]=(-1)*Math.pow(points[i][1],0);//Birinci türev muhabbeti
stringci+=" + "+"("+Integer.toString((int)(-1*Math.pow(points[i][1], 0)))+")"+" b"+Integer.toString(k+2);

B[s][3*(Number_of_Points-1)+1]=0;//son sutun
stringci+=" ="+Integer.toString(0);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";
s++;//katsayý matrisi satýr atladýk




}//Döngü sonu
// 4n-4 TAne denklem koyduk
// 4n-4 TAne denklem koyduk
// 4n-4 TAne denklem koyduk
// 4n-4 TAne denklem koyduk
// 4n-4 TAne denklem koyduk



//þimdi 4 denklemde sýra

//Bu, ilk nokta saðlamalý
B[s][1]=Math.pow(points[1][1],2);
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)(Math.pow(points[1][1], 2)))+")"+" a"+Integer.toString(1);
B[s][2]=Math.pow(points[1][1],1);
stringci+=" + "+"("+Integer.toString((int)(Math.pow(points[1][1], 1)))+")"+" b"+Integer.toString(1);
B[s][3]=Math.pow(points[1][1],0);
stringci+=" + "+"("+Integer.toString((int)(Math.pow(points[1][1], 0)))+")"+" c"+Integer.toString(1);

B[s][3*(Number_of_Points-1)+1]=points[1][2];
stringci+=" ="+Integer.toString(points[1][2]);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";
s++;

//Bu, son nokta saðlamalý
B[s][(Number_of_Points-2)*3+1]=Math.pow(points[Number_of_Points][1],2);
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)(Math.pow(points[Number_of_Points][1], 2)))+")"+" a"+Integer.toString(Number_of_Points-1);
B[s][(Number_of_Points-2)*3+2]=Math.pow(points[Number_of_Points][1],1);
stringci+=" + "+"("+Integer.toString((int)(Math.pow(points[Number_of_Points][1], 1)))+")"+" b"+Integer.toString(Number_of_Points-1);
B[s][(Number_of_Points-2)*3+3]=Math.pow(points[Number_of_Points][1],0);
stringci+=" + "+"("+Integer.toString((int)(Math.pow(points[Number_of_Points][1], 0)))+")"+" c"+Integer.toString(Number_of_Points-1);

B[s][3*(Number_of_Points-1)+1]=points[Number_of_Points][2];
stringci+=" ="+Integer.toString(points[Number_of_Points][2]);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";
s++;

stringci+=Integer.toString(s)+".) "+"a1=0";
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";



//4N TANE DENKLEM ÇIKARDIK
//4N TANE DENKLEM ÇIKARDIK
//4N TANE DENKLEM ÇIKARDIK
//4N TANE DENKLEM ÇIKARDIK
//4N TANE DENKLEM ÇIKARDIK
//:) :)
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////----------------------------BÄ°RÄ°NCÄ°        DÃ–NGÃœ -----------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------


satirsayisi=s;
sutunsayisi=s+1;
        for (int p = 1; p <= satirsayisi; p++) {


            int max = p;


////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////--------------------------P. SUTUNDAKÄ° EN BÃœYÃœK SATIRI BULDUK ----------------------------
////------------------------------------------------------------------------------------------

            for (int i = p + 1; i <= satirsayisi; i++) {
                if (Math.abs(B[i][p]) > Math.abs(B[max][p])) {
                    max = i;//EN BÃœYÃœK DEÄ?ERLÄ° SATIR NUMARASI
                }
            }
            if(Math.abs(B[max][p]) <= EPSILON){

                B[max][p]=0.00;
               continue;
            }
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------

         ////-----------SATIRLARIN YERLERÄ°NÄ° DEÄ?Ä°Å?TÄ°RDÄ°K--------------------------------------
            double[] temp = B[p]; B[p] = B[max]; B[max] = temp;


if(p!=(satirsayisi-1)){
stringim="";
for(h=1;h<=satirsayisi;h++){

	for(g=1;g<=sutunsayisi;g++){
//twoPlaces.format(val)
		stringim=stringim+uc.format(B[h][g])+" ";
		}

	stringim=stringim+"\n";
	}

	//yazici.setText(yazici.getText()+"\n::::::::::::::::::::::::::::::::\n"+stringim);
        }





 ////--------------:):):):):)---:)BURAYA KADAR SORUN YOK---------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------



            // singular or nearly singular  MATRÄ°S SINGULAR MI DÄ°YE KONTROL EDÄ°YORUZ

////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
            // pivot within A and b

            for (int i = p + 1; i <= satirsayisi; i++) {

                double bolucu = B[i][p] / B[p][p];


////-----------BURASI SON SUTUNU DEÄ?Ä°Å?TÄ°RÄ°YOR------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------BURASI NORMAL MATRÄ°SÄ° DEÄ?Ä°Å?TÄ°RÄ°YOR--------------------------------------------------

                for (int j = p; j <= sutunsayisi; j++) {
                    B[i][j] -= bolucu * B[p][j];
                }

            }
if(p!=(satirsayisi)){
stringim="";
for(h=1;h<=satirsayisi;h++){

	for(g=1;g<=sutunsayisi;g++){
//twoPlaces.format(val)
		stringim=stringim+uc.format(B[h][g])+" ";
		}

	stringim=stringim+"\n";
	}

	//yazici.setText(yazici.getText()+"\n::::::::::::::::::::::::::::::::\n"+stringim);
        }

        }

////-------------------SATIR VE SUTNLARDA Ã‡IKARMA Ä°Å?LEMÄ° YAPIYORUZ------------------------------------------

////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------




cozum_quad[satirsayisi]=0;
        for (int i = satirsayisi-1; i > 0; i--) {
        	//.println("girdim çözümdeyim")  ;               //SON SATIRDAN BAÅ?LAYARAK
            double sum = 0.0;
            for (int j = i + 1; j <= satirsayisi; j++) {//BÄ°RÄ°NCÄ° DE GÄ°RMÄ°YOR:
                sum += B[i][j] * cozum_quad[j];
            }
            if(B[i][i]==0){


    if((B[i][sutunsayisi] - sum)==0){


        yaziGirisi.setText("It is a redundant set of Equations");
    }

    else{

        yaziGirisi.setText("It is a inconsistent set of Equations");
    }

break;
}
            cozum_quad[i] = (B[i][sutunsayisi] - sum) / B[i][i];//BÄ°R DE YAPTIÄ?I Ä°Å?LEM
        }







	for(i=1;i<=satirsayisi;i++){
//.println("\n"+Double.toString(cozum_quad[i])+"**************");



	}
    bolge.A=points;
	bolge.Q=cozum_quad;
	bolge.number_of_quad=Number_of_Points;
	bolge.repaint();
	B=sifirla;
	//.println(Integer.toString(Number_of_Points)+"......................");



///////////Gauss
///////////Gauss
///////////Gauss




    }
    private void quad1MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
                // TODO add your handling code here:
                    ilkalinan=yaziGirisi.getText();
//.println(ilkalinan);
            yaziGirisi.setEditable(false);
            kubik1.setEnabled(false);


uzunluk=ilkalinan.length();
Scanner tara3 = new Scanner (ilkalinan);


            for(i=0;i<uzunluk;i++){


                if(ilkalinan.charAt(i)==';'){
                    virgulsayisi++;

                }
            }
satirsayisi=virgulsayisi+1;
sutunsayisi=2;
tara3.useDelimiter(";");
Number_of_Points=satirsayisi;


k=1;
l=1;


for(i=1;i<=satirsayisi;i++){

    parcabir=tara3.next();
    Scanner tara5=new Scanner(parcabir);
    for(j=1;j<=sutunsayisi;j++){

        hop=tara5.next();
        points[k][l]=Integer.parseInt(hop);
        if(l==sutunsayisi){

            k++;
            l=1;
        }
        else{

            l++;
        }
   //------------------------------------------------------------------------------
   //------------------------------------------------------------------------------
   //-----------DÄ°ZÄ°YE ATTIM-------------------------------------------------
   //------------------------------------------------------------------------------



    }
}
        // TODO add your handling code here:

        quad1.setEnabled(false);
        int s=1;
        for(i=1;i<=Number_of_Points;i++){

for(y=1;y<Number_of_Points;y++){

if(points[y][1]>points[y+1][1]){

int[] temp = points[y]; points[y] = points[y+1]; points[y+1] = temp;
}
}

}
for(i=2;i<Number_of_Points;i++){
k=i-2;
B[s][k*3+1]=Math.pow(points[i][1], 2);//üzeri 3
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)Math.pow(points[i][1], 2))+")"+" a"+Integer.toString(k+1);
B[s][k*3+2]=Math.pow(points[i][1], 1);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 1))+")"+" b"+Integer.toString(k+1);
B[s][k*3+3]=Math.pow(points[i][1], 0);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 0))+")"+" c"+Integer.toString(k+1);

B[s][3*(Number_of_Points-1)+1]=points[i][2];//eþit olmasý gereken deðer
stringci+=" ="+Integer.toString(points[i][2]);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";


s++;//katsayý matrisi satýr atladýk

B[s][k*3+4]=Math.pow(points[i][1], 2);//üzeri 3
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)Math.pow(points[i][1], 2))+")"+" a"+Integer.toString(k+2);
B[s][k*3+5]=Math.pow(points[i][1], 1);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 1))+")"+" b"+Integer.toString(k+2);
B[s][k*3+6]=Math.pow(points[i][1], 0);//üzeri 3
stringci+=" + "+"("+Integer.toString((int)Math.pow(points[i][1], 0))+")"+" c"+Integer.toString(k+2);

B[s][3*(Number_of_Points-1)+1]=points[i][2];//eþit olmasý gereken deðer
stringci+=" ="+Integer.toString(points[i][2]);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";


s++;//katsayý matrisi satýr atladýk

B[s][k*3+1]=2*Math.pow(points[i][1],1);//Birinci türev muhabbeti üzeri 2
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)(2*Math.pow(points[i][1], 1)))+")"+" a"+Integer.toString(k+1);
B[s][k*3+2]=Math.pow(points[i][1],0);//Birinci türev muhabbeti üzeri 1
stringci+=" + "+"("+Integer.toString((int)(Math.pow(points[i][1], 0)))+")"+" b"+Integer.toString(k+1);




B[s][k*3+4]=(-2)*Math.pow(points[i][1],1);//Birinci türev muhabbeti
stringci+=" + "+"("+Integer.toString((int)(-2*Math.pow(points[i][1], 1)))+")"+" a"+Integer.toString(k+2);
B[s][k*3+5]=(-1)*Math.pow(points[i][1],0);//Birinci türev muhabbeti
stringci+=" + "+"("+Integer.toString((int)(-1*Math.pow(points[i][1], 0)))+")"+" b"+Integer.toString(k+2);

B[s][3*(Number_of_Points-1)+1]=0;//son sutun
stringci+=" ="+Integer.toString(0);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";
s++;//katsayý matrisi satýr atladýk




}//Döngü sonu
// 4n-4 TAne denklem koyduk
// 4n-4 TAne denklem koyduk
// 4n-4 TAne denklem koyduk
// 4n-4 TAne denklem koyduk
// 4n-4 TAne denklem koyduk



//þimdi 4 denklemde sýra

//Bu, ilk nokta saðlamalý
B[s][1]=Math.pow(points[1][1],2);
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)(Math.pow(points[1][1], 2)))+")"+" a"+Integer.toString(1);
B[s][2]=Math.pow(points[1][1],1);
stringci+=" + "+"("+Integer.toString((int)(Math.pow(points[1][1], 1)))+")"+" b"+Integer.toString(1);
B[s][3]=Math.pow(points[1][1],0);
stringci+=" + "+"("+Integer.toString((int)(Math.pow(points[1][1], 0)))+")"+" c"+Integer.toString(1);

B[s][3*(Number_of_Points-1)+1]=points[1][2];
stringci+=" ="+Integer.toString(points[1][2]);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";
s++;

//Bu, son nokta saðlamalý
B[s][(Number_of_Points-2)*3+1]=Math.pow(points[Number_of_Points][1],2);
stringci+=Integer.toString(s)+".) "+"("+Integer.toString((int)(Math.pow(points[Number_of_Points][1], 2)))+")"+" a"+Integer.toString(Number_of_Points-1);
B[s][(Number_of_Points-2)*3+2]=Math.pow(points[Number_of_Points][1],1);
stringci+=" + "+"("+Integer.toString((int)(Math.pow(points[Number_of_Points][1], 1)))+")"+" b"+Integer.toString(Number_of_Points-1);
B[s][(Number_of_Points-2)*3+3]=Math.pow(points[Number_of_Points][1],0);
stringci+=" + "+"("+Integer.toString((int)(Math.pow(points[Number_of_Points][1], 0)))+")"+" c"+Integer.toString(Number_of_Points-1);

B[s][3*(Number_of_Points-1)+1]=points[Number_of_Points][2];
stringci+=" ="+Integer.toString(points[Number_of_Points][2]);
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";
s++;

stringci+=Integer.toString(s)+".) "+"a1=0";
stringci+="\n";
yazici.setText(yazici.getText()+stringci);
stringci="";



//4N TANE DENKLEM ÇIKARDIK
//4N TANE DENKLEM ÇIKARDIK
//4N TANE DENKLEM ÇIKARDIK
//4N TANE DENKLEM ÇIKARDIK
//4N TANE DENKLEM ÇIKARDIK
//:) :)
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////----------------------------BÄ°RÄ°NCÄ°        DÃ–NGÃœ -----------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------


satirsayisi=s;
sutunsayisi=s+1;
        for (int p = 1; p <= satirsayisi; p++) {


            int max = p;


////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////--------------------------P. SUTUNDAKÄ° EN BÃœYÃœK SATIRI BULDUK ----------------------------
////------------------------------------------------------------------------------------------

            for (int i = p + 1; i <= satirsayisi; i++) {
                if (Math.abs(B[i][p]) > Math.abs(B[max][p])) {
                    max = i;//EN BÃœYÃœK DEÄ?ERLÄ° SATIR NUMARASI
                }
            }
            if(Math.abs(B[max][p]) <= EPSILON){

                B[max][p]=0.00;
               continue;
            }
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------

         ////-----------SATIRLARIN YERLERÄ°NÄ° DEÄ?Ä°Å?TÄ°RDÄ°K--------------------------------------
            double[] temp = B[p]; B[p] = B[max]; B[max] = temp;


if(p!=(satirsayisi-1)){
stringim="";
for(h=1;h<=satirsayisi;h++){

	for(g=1;g<=sutunsayisi;g++){
//twoPlaces.format(val)
		stringim=stringim+uc.format(B[h][g])+" ";
		}

	stringim=stringim+"\n";
	}

	//yazici.setText(yazici.getText()+"\n::::::::::::::::::::::::::::::::\n"+stringim);
        }





 ////--------------:):):):):)---:)BURAYA KADAR SORUN YOK---------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------



            // singular or nearly singular  MATRÄ°S SINGULAR MI DÄ°YE KONTROL EDÄ°YORUZ

////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
            // pivot within A and b

            for (int i = p + 1; i <= satirsayisi; i++) {

                double bolucu = B[i][p] / B[p][p];


////-----------BURASI SON SUTUNU DEÄ?Ä°Å?TÄ°RÄ°YOR------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------BURASI NORMAL MATRÄ°SÄ° DEÄ?Ä°Å?TÄ°RÄ°YOR--------------------------------------------------

                for (int j = p; j <= sutunsayisi; j++) {
                    B[i][j] -= bolucu * B[p][j];
                }

            }
if(p!=(satirsayisi)){
stringim="";
for(h=1;h<=satirsayisi;h++){

	for(g=1;g<=sutunsayisi;g++){
//twoPlaces.format(val)
		stringim=stringim+uc.format(B[h][g])+" ";
		}

	stringim=stringim+"\n";
	}

	//yazici.setText(yazici.getText()+"\n::::::::::::::::::::::::::::::::\n"+stringim);
        }

        }

////-------------------SATIR VE SUTNLARDA Ã‡IKARMA Ä°Å?LEMÄ° YAPIYORUZ------------------------------------------

////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------
////------------------------------------------------------------------------------------------





cozum_quad[satirsayisi]=0;
        for (int i = satirsayisi-1; i > 0; i--) {
        	//.println("girdim çözümdeyim")  ;               //SON SATIRDAN BAÅ?LAYARAK
            double sum = 0.0;
            for (int j = i + 1; j <= satirsayisi; j++) {//BÄ°RÄ°NCÄ° DE GÄ°RMÄ°YOR:
                sum += B[i][j] * cozum_quad[j];
            }
            if(B[i][i]==0){


    if((B[i][sutunsayisi] - sum)==0){


        yaziGirisi.setText("It is a redundant set of Equations");
    }

    else{

        yaziGirisi.setText("It is a inconsistent set of Equations");
    }

break;
}
            cozum_quad[i] = (B[i][sutunsayisi] - sum) / B[i][i];//BÄ°R DE YAPTIÄ?I Ä°Å?LEM
        }







	for(i=1;i<=satirsayisi;i++){
//.println("\n"+Double.toString(cozum_quad[i])+"**************");



	}
	bolge.points_number=Number_of_Points;
    bolge.A=points;
	bolge.Q=cozum_quad;
	bolge.number_of_quad=Number_of_Points;
	bolge.repaint();
	B=sifirla;
	//.println(Integer.toString(Number_of_Points)+"......................");

    }


}

class salih extends JPanel{
public int points_number=0;
public int number_of_cubic=0;
public int number_of_quad=0;
public int x;
public int A[][]=new int [1000][3] ;//Koordinatlarý tutan matris
public double  C[]=new double  [1000];//cubic çözümlerini tutan matrsi
public double  Q[]=new double  [1000];//Koordinatlarý tutan matris

int k,i,y;
public void paint(Graphics g){
	super.paint(g);


    g.setColor(Color.BLUE);
    g.fillRect(10,230,7,7);
    g.drawString("Quadratic",25,238);
	g.setColor(Color.BLACK);
	g.fillRect(10,220,7,7);
	g.drawString("Cubic",25,228);
	g.drawLine(250,0,250,500);
	g.drawLine(0,125,500,125);
	g.drawString("0",252,123);
	g.drawString("250",475,123);
	g.drawString("-250",5,123);
	g.drawString("125",255,15);
	g.drawString("-125",255,245);

/*Týklanan noktalara nokta koyuyor
 *****************************************************************************/
g.setColor(Color.RED);
for(i=1;i<=points_number;i++){
    g.fillOval(A[i][1]+250,-A[i][2]+125,8,8);
	//g.drawString(".["+Integer.toString(A[i][1])+" , "+Integer.toString(A[i][2])+"]",A[i][1]+250,-A[i][2]+125);


	}
/*****************************************************************************
 *Týklanan yerlere nokta koyduk
 **/
/*
 *Kübiði çizdik************************************************************************************************
 **/
g.setColor(Color.BLACK);
 for(i=1;i<number_of_cubic;i++){
//.println("girdim la");
 	for(k=A[i][1];k<A[i+1][1];k++){
 		//Math.pow(A[1][1],3);
 		y=(int)((Math.pow(k,3))*C[(i-1)*4+1]+((int)Math.pow(k,2))*C[(i-1)*4+2]+(Math.pow(k,1))*C[(i-1)*4+3]+(Math.pow(k,0))*C[(i-1)*4+4]);
 		g.drawRect(k+250,-y+125,1,1);
 		//g.drawString("o",k+250,-y+125);// dönüþtürelecek
 		//.println(Integer.toString(y));
 		}


 	}
 	/*
 *Kübiði çizdik************************************************************************************************
 **/

 /*
  *Quadratiði çiziyoruz************************************************************************************
  **/
g.setColor(Color.BLUE);
   for(i=1;i<number_of_quad;i++){

 	for(k=A[i][1];k<A[i+1][1];k++){
 		//Math.pow(A[1][1],3);

 		y=(int)((Math.pow(k,2))*Q[(i-1)*3+1]+(Math.pow(k,1))*Q[(i-1)*3+2]+(Math.pow(k,0))*Q[(i-1)*3+3]);
 		//g.drawString("o",k+250,-y+125);// dönüþtürelecek
 		g.drawRect(k+250,-y+125,1,1);
 		}


 	}
 /*
  *Quadratiði çizdik ***********************************************************************************
  **/

	}

	}

