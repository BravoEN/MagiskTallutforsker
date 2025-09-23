import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menyvalg\n" +
                "1: Primtall\n" +
                "2: Palindrom\n" +
                "3: Tallgjetting\n" +
                "4: Summen av tall\n" +
                "9: Avslutt");
        int svar = sc.nextInt();
        if (svar == 1) {
            primtall();
        } else if (svar == 2) {
            palindrom();
        } else if (svar == 3) {
            tallgjetting();
        } else if (svar == 4) {
            summenAvTall();
        } else if (svar == 9) {
        } else {
            System.out.println("Ugyldig menyvalg");
        }
        
    }

    private static void palindrom() {
    }

    private static void tallgjetting() {
    }

    private static void summenAvTall() {
    }

    private static void primtall() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Oppgi et tall, og så jeg bedømme om det er ett primtall, og gi deg alle primtall som eksisterer under det tallet");
        int tall = sc.nextInt();
        if (tall > 1 && tall % 2 != 0) {
            double kvadratrot = Math.sqrt(tall);
            boolean primtall = true;
            for (int i = 3; i <= kvadratrot; i++) {
                if (tall % i == 0) {
                    primtall = false;
                    break;
                }
            }
            if (primtall) {
                System.out.println("Tallet ditt er et primtall");
            } else {
                System.out.println("Tallet ditt er ikke et primtall");
            }
        }
        boolean harPrintet = false;
        for (int i = 3; i <= tall-1; i++) {
            if (i % 2 != 0) {
                double kvadratrot = Math.sqrt(i);
                boolean primtall = true;
                for (int j = 3; j <= kvadratrot; j++) {
                    if (i % j == 0) {
                        primtall = false;
                        break;
                    }
                }
                if (primtall) {
                    harPrintet = true;
                    System.out.println(i);
                }
            }
        }
        if (!harPrintet) {
            System.out.println("Ingen primtall under dette tallet");
        }

    }
}