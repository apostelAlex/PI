

public class Calculator{

    public static int add(int a, int b){
        return a+b;
    }
    public static int sub(int a, int b){
        return a-b;
    }
    public static int mul(int a, int b){
        return a*b;
    }
    public static int div(int a, int b){
        return a/b;
    }
    public static int myOwnModulo(int dividend, int divisor){
        // Die Modulo-Operation liefert das gleiche Ergebnis für einen positiven bzw. negativen Divisor.
        // Für eine einfache Implementierung habe ich mich entschieden, den absoluten Wert zu nehmen.
        divisor = Math.abs(divisor);
        // Die Modulo-Operation kann durch die Differenz von Dividend und dem Prodult aus dem abgerundeten Ergebnis der Division und dem Divisor.
        /*  DA:
         * -> dividend/divisor = c + r, c => abgerundetes Ergebnis, r => Rest der Division
         * -> dividend = divisor*c +r => r = dividend - divisor*c ==>  ist gesucht! 
         */
        int quotient_floor = div(dividend, divisor);
        
        return dividend - quotient_floor*divisor;

    }

    public static void main(String[] args){
        int matNr = 1932275;
        System.out.println(myOwnModulo(matNr, 42));
        System.out.println(matNr%42);
        // Gleiches Ergebnis: 23
        


    }








}