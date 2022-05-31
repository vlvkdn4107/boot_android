package com.example.myretrofit3;


/*
* 싱글톤 패턴@@
* 쓰는 이유
*
* */
public class Myprinter_Single {
    private static Myprinter_Single myprinterSingle;
    private Myprinter_Single(){}

    public static Myprinter_Single getInstance(){
        if(myprinterSingle == null){
            myprinterSingle = new Myprinter_Single();
        }
        return myprinterSingle;
    }

    // 테스트 코드 작성
    public static void main(String[] args) {
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();
        // 래퍼런스 주소 비교 (같은 녀석이면 같은 객체임)
        Myprinter_Single myprinter_singleA = aClazz.myprinterSingle;
        Myprinter_Single myprinter_singleB = bClazz.myprinterSingle;
        System.out.println(myprinter_singleA.equals(myprinter_singleB));
    }
}
class AClazz{
    public  Myprinter_Single myprinterSingle;
    public AClazz(){
        myprinterSingle = Myprinter_Single.getInstance();
    }
}
class BClazz{
    public  Myprinter_Single myprinterSingle;
    public BClazz(){
        myprinterSingle = Myprinter_Single.getInstance();
    }
}
