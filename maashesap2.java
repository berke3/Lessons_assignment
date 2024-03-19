import java.util.Scanner;

public class maashesap2 {
    public static void main(String[] args) {
        Scanner giris = new Scanner(System.in);

        System.out.println("Kişi sayısını giriniz");
        byte ks = giris.nextByte();

        String[] ad = new String[ks];
        String[] medeniDurum = new String[ks];
        String[] cinsiyet = new String[ks];
        int[] maas = new int[ks];
        byte[] yas = new byte[ks];
        byte menu;

        for (int i = 0; i < ks; i++) {
            System.out.println((i + 1) + ". İsminizi giriniz:");
            ad[i] = giris.next();
            System.out.println((i + 1) + ". Maaşınızı giriniz:");
            maas[i] = giris.nextInt();
            System.out.println((i + 1) + ". Medeni durumunuzu yazınız:");
            medeniDurum[i] = giris.next();
            System.out.println((i + 1) + ". Cinsiyetinizi giriniz:");
            cinsiyet[i] = giris.next();
            System.out.println((i + 1) + ". Yaşınızı giriniz:");
            yas[i] = giris.nextByte();
        }

        for (;;) {
            System.out.println("1-Listeleme\n2-İsim arama\n3-Erkeklerin yaş ortalaması\n4-Evlilerin maaş ortalaması\n5-En yüksek maaşlı kadın bilgisi\n6-En düşük yaş kime ait\n7-Çıkış");
            menu = giris.nextByte();

            switch (menu) {
                case 1:
                    for (int i = 0; i < ks; i++) {
                        System.out.println("Adı: " + ad[i]);
                        System.out.println("Maaşı: " + maas[i]);
                        System.out.println("Medeni durumu: " + medeniDurum[i]);
                        System.out.println("Cinsiyeti: " + cinsiyet[i]);
                        System.out.println("Yaşı: " + yas[i]);
                    }
                    break;
                case 2:
                    System.out.println("Aranacak adı giriniz:");
                    String arananIsim = giris.next();
                    boolean bulundu = false;
                    for (int i = 0; i < ks; i++) {
                        if (ad[i].equalsIgnoreCase(arananIsim)) {
                            System.out.println("Adı: " + ad[i]);
                            System.out.println("Maaşı: " + maas[i]);
                            System.out.println("Medeni durumu: " + medeniDurum[i]);
                            System.out.println("Cinsiyeti: " + cinsiyet[i]);
                            System.out.println("Yaşı: " + yas[i]);
                            bulundu = true;
                            break;
                        }
                    }
                    if (!bulundu) {
                        System.out.println("Aranan isim bulunamadı.");
                    }
                    break;
                case 3:
                    int toplamYas = 0, erkekSayisi = 0;
                    for (int i = 0; i < ks; i++) {
                        if (cinsiyet[i].equalsIgnoreCase("erkek")) {
                            toplamYas += yas[i];
                            erkekSayisi++;
                        }
                    }
                    if (erkekSayisi > 0) {
                        double erkekYasOrtalamasi = (double) toplamYas / erkekSayisi;
                        System.out.println("Erkeklerin yaş ortalaması: " + erkekYasOrtalamasi);
                    } else {
                        System.out.println("Erkek bulunamadı.");
                    }
                    break;
                case 4:
                    int toplamMaasEvliler = 0, evliKisiSayisi = 0;
                    for (int i = 0; i < ks; i++) {
                        if (medeniDurum[i].equalsIgnoreCase("evli") || medeniDurum[i].equalsIgnoreCase("e")) {
                            toplamMaasEvliler += maas[i];
                            evliKisiSayisi++;
                        }
                    }
                    if (evliKisiSayisi > 0) {
                        double evlilerinMaasOrtalamasi = (double) toplamMaasEvliler / evliKisiSayisi;
                        System.out.println("Evlilerin maaş ortalaması: " + evlilerinMaasOrtalamasi);
                    } else {
                        System.out.println("Evliler bulunamadı.");
                    }
                    break;
                case 5:
                    int enYuksekMaas = 0;
                    String enYuksekMaasAlanKadin = "";
                    for (int i = 0; i < ks; i++) {
                        if (cinsiyet[i].equalsIgnoreCase("kadın")) {
                            if (maas[i] > enYuksekMaas) {
                                enYuksekMaas = maas[i];
                                enYuksekMaasAlanKadin = ad[i];
                            }
                        }
                    }
                    if (!enYuksekMaasAlanKadin.isEmpty()) {
                        System.out.println("En yüksek maaşı alan kadın: " + enYuksekMaasAlanKadin + ", Maaşı: " + enYuksekMaas);
                    } else {
                        System.out.println("Kadın bulunamadı.");
                    }
                    break;
                case 6:
                    byte enKucukYas = Byte.MAX_VALUE;
                    String enKucukYasiOlanKisi = "";
                    for (int i = 0; i < ks; i++) {
                        if (yas[i] < enKucukYas) {
                            enKucukYas = yas[i];
                            enKucukYasiOlanKisi = ad[i];
                        }
                    }
                    if (!enKucukYasiOlanKisi.isEmpty()) {
                        System.out.println("En küçük yaşa sahip kişi: " + enKucukYasiOlanKisi + ", Yaşı: " + enKucukYas);
                    } else {
                        System.out.println("Kişi bulunamadı.");
                    }
                    break;
                case 7:
                    System.out.println("Program sonlandırıldı.");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçenek.");
            }
        }
    }
}