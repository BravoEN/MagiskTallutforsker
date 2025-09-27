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
        // Tar inn tallet til brukeren
        Scanner sc = new Scanner(System.in);
        System.out.println("Oppgi et tall, og så jeg bedømme om det er ett primtall, og gi deg alle primtall som eksisterer under det tallet");
        int tall = sc.nextInt();

        // Første del av programmet sjekker om tallet de har inputtet er et primtall (ville gjøre det)
        // Sjekker om tallet er høyere enn en og at tallet ikke kan restdivideres på 2
        if (tall > 1 && tall % 2 != 0) {
            // får kradratroten
            double kvadratrot = Math.sqrt(tall);

            // definerer at programmet forventer at tallet er et primtall
            boolean primtall = true;

            // sjekker om tallet faktisk er ett primtall med å restdividere tallet på alle tall som er mindre en kvadratroten av tallet
            for (int i = 3; i <= kvadratrot; i++) {
                if (tall % i == 0) {
                    // forteller at tallet ikke er primtall og slutter løkka da vi har fårr svaret vi vil ha
                    primtall = false;
                    break;
                }
            }
            // printer om det er ett primtall eller ikke
            if (primtall) {
                System.out.println("Tallet ditt er et primtall");
            } else {
                System.out.println("Tallet ditt er ikke et primtall");
            }
        }
        // boolean for å få riktig output
        boolean harPrintet = false;

        // løkke for å sjekke på alle tall under inputtallet, for å sjekke om de er et primtall
        // alle tall fra og med 3 til alle tall under inputtall
        for (int i = 3; i <= tall-1; i++) {
            // sjekker om i kan restdivideres på 2
            if (i % 2 != 0) {
                // får kvadratroten til i
                double kvadratrot = Math.sqrt(i);

                // løkke for å sjekke om i kan restivideres på noen tall lavere enn kvadratroten dens
                // definerer at tallet er allerede et primtall, og løkka sjekker om dette faktisk er sant
                boolean primtall = true;
                for (int j = 3; j <= kvadratrot; j++) {
                    // hvis i kan restdivideres på noen tall lavere enn kvadratroten dens og høyere eller lik 3 så er det ikke ett primtall
                    if (i % j == 0) {
                        // definerer at tallet ikke er ett primtall og slutter løkka
                        primtall = false;
                        break;
                    }
                }
                // printer alle primtall under input tallet
                if (primtall) {
                    harPrintet = true;
                    System.out.println(i);
                }
            }
        }
        // hvis det ikke er noen tall under inputtallet så kommer denne feilmeldinga
        if (!harPrintet) {
            System.out.println("Ingen primtall under dette tallet");
        }

    }
}