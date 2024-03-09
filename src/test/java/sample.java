public class sample {




    public static void main(String[] args) {

        int n=21;
        int m=n/2;
        for(int i=2;i<=m;i++){
            if(n%i==0){
                System.out.println("It is not prime");

            }
            else{
                System.out.println("It is prime");
            }
            break;
        }
    }
}
