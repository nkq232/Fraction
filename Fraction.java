package OOP;

import java.util.Scanner;

public class Fraction {
    private int numerator, demonitor;
    Fraction(){
        this.setDemonitor(1);
    }
    void setNumerator(int num){
        numerator = num;
    }
    void setDemonitor(int dem){
        if (dem!=0) demonitor = dem;
    }
    public int getDemonitor(){
        return demonitor;
    }
    public int getNumerator() {
        return numerator;
    }
    Fraction(int numerator, int demonitor){
        this.setNumerator(numerator);
        this.setDemonitor(demonitor);
    }
    int gcd(int a, int b){
        /** a = b*q+r**/
        if (b==0) return a;
        return gcd(b,a%b);
    }
    Fraction(Fraction a){
        this.numerator = a.getNumerator();
        this.demonitor = a.getDemonitor();
    }
    void reduce(){
        int b = gcd(this.numerator, this.demonitor);
        this.numerator /=b;
        this.demonitor/=b;
    }
    Fraction add(Fraction a){
        this.numerator = a.numerator * this.demonitor + a.demonitor * this.numerator;
        this.demonitor = a.demonitor * this.demonitor;
        this.reduce();
        return this;
    }
    Fraction subtract(Fraction a){
        this.numerator = -a.numerator * this.demonitor + a.demonitor * this.numerator;
        this.demonitor = a.demonitor * this.demonitor;
        this.reduce();
        return this;
    }
    Fraction multiply(Fraction a){
        if(a.getNumerator()==0) return this;
        this.numerator = a.numerator * this.numerator;
        this.demonitor = a.demonitor * this.demonitor;
        this.reduce();
        return this;
    }
    Fraction divide(Fraction a){
        this.demonitor = a.numerator * this.demonitor;
        this.numerator = a.demonitor * this.numerator;
        this.reduce();
        return this;
    }
    public boolean equals(Object obj) {
        if (obj instanceof Fraction){
             Fraction other = (Fraction) obj;
             this.reduce();
             other.reduce();
            boolean b = this.getNumerator() == other.getNumerator() && this.getDemonitor() == other.getDemonitor();
            return b;
        }
        return false;
    }
    public static void main(String[] args){
            int num, dem;
            Scanner in =  new Scanner(System.in);
            num=in.nextInt();
            dem=in.nextInt();
            Fraction a = new Fraction(num,dem);
            a.reduce();
            System.out.println(a.getNumerator() + " / " + a.getDemonitor());
            Fraction b = new Fraction(4,5);
            Fraction c= new Fraction(a);
            c.divide(b);
            Fraction d = new Fraction(a);
            d.subtract(b);
            Fraction e = new Fraction(a);
            e.multiply(b);
            a.add(b);

            System.out.println(a.getNumerator() + " / " + a.getDemonitor());
            System.out.println(c.getNumerator() + " / " + c.getDemonitor());
            System.out.println(d.getNumerator() + " / " + d.getDemonitor());
            System.out.println(e.getNumerator() + " / " + e.getDemonitor());
    }
}

