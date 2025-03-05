//학번: 22112120 이름: 서이준
class Solution {
    public int Compare(int [][] arr,int [][] triangle,int i,int j){
        if(arr[i-1][j-1]<arr[i-1][j]) return arr[i-1][j]+triangle[i][j];
        else return arr[i-1][j-1]+triangle[i][j];
    }
    public int solution(int[][] triangle) {
        int answer = 0;
        int height=triangle.length;
        int [][] arr=new int[height][];
        for(int i=0;i<height;i++){
            arr[i]=new int[i+1];
        }
        arr[0][0]=triangle[0][0];
        for(int i=1;i<height;i++){
            int levelHeight=triangle[i].length;
            arr[i][0]=arr[i-1][0]+triangle[i][0];
            arr[i][levelHeight-1]=arr[i-1][levelHeight-2]+triangle[i][levelHeight-1];
        }

        for(int i=2;i<height;i++){
            for(int j=1; j< triangle[i].length-1;j++){
                arr[i][j]=Compare(arr,triangle,i,j);
            }
        }
        for(int i=0; i<height;i++){
            if(answer<arr[height-1][i]) answer=arr[height-1][i];
        }


        return answer;
    }
}