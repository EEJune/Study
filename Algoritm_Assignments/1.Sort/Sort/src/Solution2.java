public class Solution2 extends AbstractSort{
    private static int count=0;
    public static void sort(Comparable[]a){
        int N=a.length;
        for(int i=1;i<N;i++){
            for(int j=i;j>0 && less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
        assert isSorted(a);
    }

    public static void add(Integer[] save,Integer[] numbers,int []saveValue,int []saveIndex,int start){
        for (int j = saveIndex[start]; j < numbers.length; j++) {
            int value = numbers[start] + numbers[j];
            if (start > 0 && value <= saveValue[start-1]) continue;
            if (start > 0 && (value > saveValue[start - 1]) && saveIndex[start-1]<numbers.length-1) {
                saveIndex[start] = j;
                saveValue[start]=value;
                return;
            }
            if (value > saveValue[start + 1]) {
                saveIndex[start] = j;
                saveValue[start] = value;
                add(save, numbers, saveValue, saveIndex, (start + 1));
            }
            save[count++] = value;
            saveValue[start]=value;
            saveIndex[start]=j;
        }
        if(start<numbers.length-1) {
            start+=1;
            add(save,numbers,saveValue,saveIndex,start);
        }
        return ;
    }
    public static Integer[] solution(Integer[] numbers) {
        sort(numbers);
        Integer[] Arr=new Integer[numbers[numbers.length-1]+numbers[numbers.length-2]];
        int [] saveValue=new int[numbers.length];
        int [] saveIndex=new int[numbers.length];
        saveIndex[0]=1;
        saveIndex[numbers.length-1]= numbers.length;
        for(int i=1;i<numbers.length-1;i++){
            saveValue[i]=numbers[i]+numbers[i+1];
            saveIndex[i]=i+1;
        }
        add(Arr,numbers,saveValue,saveIndex,0);
        Integer[] answer=new Integer[count];
        int i=0;
        while(Arr[i]!=null){
            answer[i]=Arr[i++];
        }
        Solution2.show(answer);
        count=0;
        return answer;
    }
    public static void main(String[] args){
        Integer []numbers1= {2,1,3,4,1};
        Integer []numbers2= {5,0,2,7};
        solution(numbers1);
        solution(numbers2);
    }
}

