import java.util.Random;
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
        // tar inn inputt
        Scanner sc = new Scanner(System.in);
        System.out.println("Oppgi ett ord også sjekker programmet om det er ett palindrom");
        String input = sc.nextLine();

        // får slutten og starten av Stringen
        int start = 0;
        int slutt = input.length() - 1;


        boolean palindrom = true;
        while (start < slutt) {
            // sjekker om hver char er det samme som char'en på motsatt side at stringen
            if (input.charAt(start) != input.charAt(slutt)) {
                palindrom = false;
                break;
            }
            // increaser eller decreaser indexen for å møte på midten av stringen
            start++;
            slutt--;
        }
        if (palindrom) {
            System.out.println(input + " er et palindrom");
        } else {
            System.out.println(input + " er ikke et palindrom");
        }

    }

    private static void tallgjetting() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Skriv inn ett tall mellom 1-100, skriv 0 for å avslutte programmet");
        // henter random tall fra og med 1 til 101
        int tall = rand.nextInt(1,101);
        int gjett;
        boolean gjetta = true;
        do {
            gjett = sc.nextInt();
            if (gjett == 0) {
                gjetta = false;
                break;
            } else if (gjett < tall) {
                System.out.println("for lavt");
            } else if (gjett > tall) {
                System.out.println("for høyt");
            }
        } while (gjett != tall);
        if (gjetta) {
            System.out.println("Du gjetta tallet " + tall + "! Gratulerer");
        } else {
            System.out.println("Så synd du ga opp, tallet var " + tall + ". Lykke til neste gang!");
        }


    }

    private static void summenAvTall() {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        System.out.println("Skriv inn tall og programmet vil summere de for deg, skriv inn 0 når du er ferdig");
        int tall = sc.nextInt();
        while (tall != 0) {
            sum += tall;
            tall = sc.nextInt();
        }
        System.out.println("Summen av dine tall er " + sum);
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
            double tallkvadratrot = Math.sqrt(tall);

            // definerer at programmet forventer at tallet er et primtall
            boolean tallprimtall = true;

            // sjekker om tallet faktisk er ett primtall med å restdividere tallet på alle tall som er mindre en kvadratroten av tallet
            for (int i = 3; i <= tallkvadratrot; i++) {
                if (tall % i == 0) {
                    // forteller at tallet ikke er primtall og slutter løkka da vi har fårr svaret vi vil ha
                    tallprimtall = false;
                    break;
                }
            }
            // printer om det er ett primtall eller ikke
            if (tallprimtall) {
                System.out.println("Tallet ditt er et primtall");
            } else {
                System.out.println("Tallet ditt er ikke et primtall");
            }

            // boolean for å få riktig output
            boolean harPrintet = false;

            // løkke for å sjekke på alle tall under inputtallet, for å sjekke om de er et primtall
            // alle tall fra og med 3 til alle tall under inputtall
            for (int i = 3; i <= tall-1; i++) {
                // sjekker om i kan restdivideres på 2
                if (i % 2 != 0) {
                    // får kvadratroten til i
                    double ikvadratrot = Math.sqrt(i);

                    // løkke for å sjekke om i kan restivideres på noen tall lavere enn kvadratroten dens
                    // definerer at tallet er allerede et primtall, og løkka sjekker om dette faktisk er sant
                    boolean iprimtall = true;
                    for (int j = 3; j <= ikvadratrot; j++) {
                        // hvis i kan restdivideres på noen tall lavere enn kvadratroten dens og høyere eller lik 3 så er det ikke ett primtall
                        if (i % j == 0) {
                            // definerer at tallet ikke er ett primtall og slutter løkka
                            iprimtall = false;
                            break;
                        }
                    }
                    // printer alle primtall under input tallet
                    if (iprimtall) {
                        harPrintet = true;
                        System.out.println(i);
                    }
                }
            }
            // hvis det ikke er noen tall under inputtallet så kommer denne feilmeldinga
            if (!harPrintet) {
                System.out.println("Ingen primtall under dette tallet");
            }
        } else {
            // litt feilhåndtering
            if (tall == 1 || tall == 0) {
                System.out.println("1 eller 0 kan ikke være primtall");
            } else if (tall % 2 == 0) {
                System.out.println("Tall som kan deles på 2 kan ikke være primtall");
            } else if (tall < 0) {
                System.out.println("Programmet støtter ikke negative verdier");
            } else {
                System.out.println("Udyldig verdi");
            }
        }
    }
}