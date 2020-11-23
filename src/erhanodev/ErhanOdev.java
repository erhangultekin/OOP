/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erhanodev;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class ErhanOdev {

    private static final Student[] studentArray = new Student[200];

    private static final String[][] studentArray2 = new String[200][5];

    private static final String[] patikayol = new String[200];

    private static final double[] ogretimuyesi = new double[5];

    public static void main(String[] args) throws IOException {

        String line;

        BufferedReader br = new BufferedReader(new FileReader("Kurum.txt"));

        line = br.readLine();

        int ogrenciSayi = 0;

        int dosyadanalinanogrenciler = 0;

        while ((line = br.readLine()) != null) {

            String[] txtarray = line.split(",");
            if (txtarray[0].equals("u")) {

                UnderGraduate student1 = new UnderGraduate(Integer.valueOf(txtarray[1]), txtarray[2], txtarray[3], txtarray[4]);
                studentArray[ogrenciSayi] = student1;
                patikayol[ogrenciSayi] = student1.getTrack();
                dosyadanalinanogrenciler++;
                ogrenciSayi++;

            } else if (txtarray[0].equals("g")) {
                Graduate student2 = new Graduate(Integer.valueOf(txtarray[1]), txtarray[2], txtarray[3], txtarray[4], txtarray[5]);
                studentArray[ogrenciSayi] = student2;
                dosyadanalinanogrenciler++;
                ogrenciSayi++;

            } else {
                int a = 0;
                for (String x : txtarray) {
                    studentArray2[ogrenciSayi - 1][a] = x.trim();
                    a++;
                }

            }

        }

        System.out.println("Her bir öğretim eleman için o öğretim elemanına ait ortalama derecelendirme puanı");
        System.out.println(" A  " + " B  " + " C  " + " D  " + " E  ");

        for (int y = 0; y < 5; y++) {
            double toplam = 0;
            double toplamOrtalama = 0;
            for (int x = 0; ogrenciSayi > x; x++) {
                toplam += (Double.valueOf(studentArray2[x][y]));
                toplamOrtalama = toplam / ogrenciSayi;
                ogretimuyesi[y] = toplamOrtalama;
            }
            System.out.print(toplamOrtalama + " ");
        }

        System.out.println(" ");

        NumberFormat formatter = new DecimalFormat("#0.0");
        System.out.println("Her bir öğretim elemanı için sadece lisans öğrencilerini dikkate alarak elde edilen ortalama derecelendirme puanı");
        System.out.println(" A  " + " B  " + " C  " + " D  " + " E  ");

        for (int j = 0; j < 5; j++) {
            double underToplam = 0;
            double underToplamOrtalama = 0;
            int UnderOgrencisayı = 0;
            for (int i = 0; ogrenciSayi > i; i++) {
                if (studentArray[i].getClass().equals(UnderGraduate.class)) {
                    UnderOgrencisayı++;
                    underToplam += (Double.valueOf(studentArray2[i][j]));
                    underToplamOrtalama = underToplam / UnderOgrencisayı;

                }
            }
            System.out.print(formatter.format(underToplamOrtalama) + " ");
        }
        System.out.println(" ");

        System.out.println("Her bir öğretim elemanı için sadece lisansüstü öğrencileri dikkate alarak elde edilen ortalama derecelendirme puanı");
        System.out.println(" A  " + " B  " + " C  " + " D  " + " E  ");

        for (int j = 0; j < 5; j++) {
            double graduateToplam = 0;
            double graduateToplamOrtalama = 0;
            int graduateOgrencisayı = 0;
            for (int i = 0; ogrenciSayi > i; i++) {
                if (studentArray[i].getClass().equals(Graduate.class)) {
                    graduateOgrencisayı++;
                    graduateToplam += (Double.valueOf(studentArray2[i][j]));
                    graduateToplamOrtalama = graduateToplam / graduateOgrencisayı;

                }
            }
            System.out.print(graduateToplamOrtalama + " ");
        }
        System.out.println("");

        System.out.println("Her bir öğretim elemanı için sadece lisans öğrencilerinden izlediği patika yapay zeka olanlar dikkate alınarak elde edilen ortalama derecelendirme puanı");
        System.out.println(" A  " + " B  " + " C  " + " D  " + " E  ");
        for (int j = 0; j < 5; j++) {
            double yapayzekaToplam = 0;
            double yapayzekaToplamOrtalama = 0;
            int yapayzekaOgrencisayı = 0;
            for (int i = 0; ogrenciSayi > i; i++) {
                if (patikayol[i] != null) {
                    if (patikayol[i].equalsIgnoreCase("Yapay Zeka")) {
                        yapayzekaOgrencisayı++;
                        yapayzekaToplam += (Double.valueOf(studentArray2[i][j]));
                        yapayzekaToplamOrtalama = yapayzekaToplam / yapayzekaOgrencisayı;
                    }
                }

            }
            System.out.print(yapayzekaToplamOrtalama + " ");
        }
        System.out.println(" ");

        for (int j = 0; j < 5; j++) {
            System.out.println((j + 1) + ". Öğretmen için derecelendirmenin altında puan vermiş olan lisans öğrencilerinin bilgileri: ");
            System.out.println("****************************************************************************************************");
            System.out.println(" ");
            for (int i = 0; studentArray.length > i; i++) {
                if (studentArray[i] != null && studentArray[i].getClass().equals(UnderGraduate.class)) {
                    if (Integer.valueOf(studentArray2[i][j]) < ogretimuyesi[j]) {
                        System.out.println(studentArray[i].toString());

                    }
                }

            }
        }

        System.out.println(" ");
        for (int j = 0; j < 5; j++) {
            System.out.println((j + 1) + ". Öğretmen için  derecelendirmenin altında puan vermiş olan lisansüstü öğrencilerinin bilgileri : ");
            System.out.println("****************************************************************************************************");
            System.out.println(" ");
            for (int i = 0; studentArray.length > i; i++) {
                if (studentArray[i] != null && studentArray[i].getClass().equals(Graduate.class)) {
                    if (Integer.valueOf(studentArray2[i][j]) < ogretimuyesi[j]) {
                        System.out.println(studentArray[i].toString());

                    }
                }

            }
        }

        while (ogrenciSayi < 200) {

            int[] ToplamPuanlar = new int[5];

            int puan;

            Scanner input = new Scanner(System.in);
            System.out.print("Öğrencinin Lisans ve Lisansüstü olma durumunu u ve g olarak giriniz:");
            String OgrenciBilgileri = input.nextLine();
            System.out.print("Öğrencinin adını giriniz:");
            String Name = input.nextLine();
            System.out.print("Öğrencinin Soyadını giriniz:");
            String Surname = input.nextLine();
            System.out.print("Öğrencinin numarasını giriniz:");
            int studentID = input.nextInt();
            input.nextLine();

            if (OgrenciBilgileri.equals("u")) {
                System.out.print("Öğrencinin izlediği akademik patikayı giriniz:");
                String track = input.nextLine();
                studentArray[ogrenciSayi] = new UnderGraduate(studentID, Name, Surname, track);
                ogrenciSayi++;

            } else if (OgrenciBilgileri.equals("g")) {
                System.out.print("Öğrencinin tez konusunu giriniz:");
                String subject = input.nextLine();
                System.out.print("Öğrencinin öğretim danışmanını giriniz:");
                String advisor = input.nextLine();
                studentArray[ogrenciSayi] = new Graduate(studentID, Name, Surname, subject, advisor);
                ogrenciSayi++;
            }

            int[] benzerlikPuani = new int[ogrenciSayi - 1];

            for (int x = 0; x < 4; x++) {
                System.out.println((x + 1) + " Öğretim elemanı için puanınızı giriniz");
                puan = input.nextInt();
                studentArray2[ogrenciSayi - 1][x] = Integer.toString(puan);
                ToplamPuanlar[x] = puan;

            }

            studentArray2[ogrenciSayi - 1][4] = "0";
            int x;
            for (int j = 0; j < ogrenciSayi - 1; j++) {
                int benzerlikOranı = 0;
                for (int i = 0; i < 4; i++) {
                    x = Integer.parseInt(studentArray2[j][i]) - ToplamPuanlar[i];
                    benzerlikOranı += Math.abs(x);
                    benzerlikPuani[j] = benzerlikOranı;

                }
            }

            int MinDeger = 5;
            int MinVerenAynıOgrenciSayisi = 1;
            double sondeger = 0.0;

            for (int j = 0; j < ogrenciSayi - 1; j++) {
                if ((benzerlikPuani[j]) < (MinDeger)) {
                    MinDeger = benzerlikPuani[j];
                    sondeger = Double.valueOf(studentArray2[j][4]);
                    studentArray2[ogrenciSayi - 1][4] = String.valueOf(sondeger);

                } else if ((benzerlikPuani[j]) == (MinDeger)) {
                    MinVerenAynıOgrenciSayisi += 1;
                    MinDeger = benzerlikPuani[j];
                    sondeger += Double.valueOf(studentArray2[j][4]);
                    sondeger /= MinVerenAynıOgrenciSayisi;
                    sondeger = Math.round(sondeger);
                    studentArray2[ogrenciSayi - 1][4] = String.valueOf(sondeger);

                }

            }
            System.out.println("-----------Klavyeden Alınan Öğrencilerin Bilgileri:----------");
            for (int i = dosyadanalinanogrenciler; i < ogrenciSayi; i++) { //YERİNİ AYARLA
                System.out.println(studentArray[i].toString());
            }

            int z = 0;
            for (int y = 0; y < 5; y++) {
                double toplam = 0;
                double toplamOrtalama = 0;
                for (int a = dosyadanalinanogrenciler; ogrenciSayi > a; a++) {
                    toplam += (Double.valueOf(studentArray2[a][y]));
                    z = ogrenciSayi - dosyadanalinanogrenciler;

                    toplamOrtalama = toplam / Math.abs(z);
                    ogretimuyesi[y] = toplamOrtalama;
                }
                System.out.print(toplamOrtalama + " ");
            }

            System.out.println(" ");

            System.out.println("Girilecek Başka Öğrenci Yoksa 1 e basınız devam etmek istiyorsanız herhangi bir tuşa basınız : ");
            int cevap = input.nextInt();
            if (1 == cevap) {
                break;

            }

        }

    }

}
