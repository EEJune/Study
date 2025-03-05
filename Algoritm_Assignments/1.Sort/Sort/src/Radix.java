public class Radix extends AbstractSort{
    public static void sort(int A[]){
        int i,m=A[0],exp=1,n=A.length;
        int []B=new int[n];
        for (i = 1; i < n; i++)
            if (A[i] > m) m = A[i];
        while(m/exp>0){
            int[]C=new int[10];
            for(i=0;i<n;i++) C[A[i]/exp %10 ]++;
            for(i=1;i<n;i++) C[i]+=C[i-1];
            for(i=n-1;i>=0;i--) B[--C[(A[i]/exp)%10]]=A[i];
            for(i=0;i<n;i++)A[i]=B[i];
            exp*=10;
        }
        for(int j=0;j<n;j++){
            System.out.print(B[j]+" ");
        }
    }
    public static void main(String args[]){
        int [] number={179,208,306,93,859,984,55,9,271,33};
        sort(number);
    }
}
