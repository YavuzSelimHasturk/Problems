package problems.Kitaplik;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kitapci {

    /*

	1.	Kullanıcının Kitap ekleme, silme ve listeleme gibi
		işlemleri yapmasına imkan tanıyan bir uygulama yazınız.
	2.	Program, kitaplara 1000’den başlayarak sıralı ve otomatik numara vermeli.
		Bunun yanında, her bir kitap için Kitap Adı, Yazar Adı, Yayin Evi, Yayın Yılı ve Fiyat gibi bilgiler girilebilmelidir.
	3.	Programın başlangıcında Kullanıcıya aşağıdaki gibi bir menü sunulmalıdır.
		Kullanıcı programı bitirene kadar işlemlere devam edebilmelidir.
		========= KİTAP PROGRAMI =============
			1: Kitap ekle
			2: Numara ile kitap sil
			3: Tüm kitapları listele
			4: Bitir
 */
    static List<Kitap> kitaplar=new ArrayList<>();
    static int kitapNo;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Kutuphanede mevcut Kitaplar : " + Kitap.kitaplar(kitaplar));
        System.out.println("");
        try {
            anaMenu(kitaplar);
        } catch (Exception e) {

        }
    }

    private static void anaMenu(List<Kitap> kitaplar) {

        System.out.println( "*****************KITAP PROGRAMI******************\n" +
                "1- KITAP EKLE\n" +
                "2- NUMARA ILE KITAP SIL\n" +
                "3- TUM KITAPLARI LISTELE\n" +
                "4- CIKIS");


        System.out.println("Lutfen yapmak istediginiz islemi seciniz : ");
        int secim = scan.nextInt();

        switch (secim){
            case 1 :{
                kitapEkle(kitaplar);
                break;
            }
            case 2 :{
                numaraIleKitapSil(kitaplar);}
            break;
            case 3 :{
                tumKitaplariListele(kitaplar);
                break;
            }
            case 4 :{
                cikis();
                break;
            }
            default:
                System.out.println("Hatali giris yaptiniz. Lutfen tekrar deneyiniz");
                break;
        }
    }
    private static void tumKitaplariListele(List<Kitap> kitaplar)  {
        for (Kitap each:kitaplar) {
            System.out.println(each.toString());
        }
        System.out.println("Devam etmek istiyor musunuz? : E/H ");
        char cevap1 = scan.next().charAt(0);
        String cevap=""+cevap1;

        if (cevap.equalsIgnoreCase("e")){
            anaMenu(kitaplar);
        } else if (cevap.equalsIgnoreCase("h")) {
            cikis();
        }else {
            try {
                System.out.println("Hatali giris yaptiniz.");
            } catch (Exception ignored) {
            }
            anaMenu(kitaplar);
        }
    }
    private static void cikis() {
        System.out.println("Tesekkur ederiz. Yine bekleriz... ");
    }
    private static void numaraIleKitapSil(List<Kitap> kitaplar) {
        System.out.println("Silinecek kitap no giriniz : ");
        int silinicekNo= scan.nextInt();

        for (Kitap each: kitaplar) {
            if (silinicekNo==each.getKitapNo()){
                kitaplar.remove(each);
                System.out.println(silinicekNo + " Nolu kitap kaydi silindi");
                anaMenu(kitaplar);
            }
        }
        System.out.println(silinicekNo+ " ait kitap bulunamadi");
        anaMenu(kitaplar);
    }
    private static void kitapEkle(List<Kitap> kitaplar) {
        System.out.println("Kitap ismi giriniz : ");
        String kitapAdi= scan.next();
        scan.nextLine();
        System.out.println("Kitap yazarini giriniz : ");
        String kitapYazar= scan.nextLine();
        System.out.println("Yayinevi ismini giriniz : ");
        String yayinEvi= scan.nextLine();
        System.out.println("Yayin yilini giriniz : ");
        int yayinYili= scan.nextInt();
        scan.nextLine();
        System.out.println("Kitap fiyatini giriniz : ");
        double fiyat = scan.nextDouble();

        int x =kitaplar.size();
        kitapNo=kitaplar.get(x-1).getKitapNo();
        Kitap kitap= new Kitap(++kitapNo,kitapAdi,kitapYazar,yayinEvi,yayinYili,fiyat);
        kitaplar.add(kitap);
        System.out.println(kitap + " bilgilerine sahip kitap listeye eklendi.");
        anaMenu(kitaplar);
    }

}
