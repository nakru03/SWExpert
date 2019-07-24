import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
                 
        for(int t=1; t<=10; ++t) {
            int num = sc.nextInt();
            int[][] board = new int[100][100];
            int[][] visit = new int[100][100];
            int startX=0;
            int startY=0;
            for(int y=0; y<100; ++y ) {
                for(int x=0; x<100; ++x) {
                    board[y][x]=sc.nextInt();
                    if(board[y][x]==2) {
                        startY=y;
                        startX=x;   
                        visit[startY][startX]=1;
                    }
                }
            }
            int currY= startY;
            int currX= startX;          
            int[] dy = {0,0,-1};            
            int[] dx = {-1,1,0};
             
            while(true) {
                 
                if(currY==0) {
                    System.out.println("#"+num+" "+currX);
                    break;
                }
                for(int dir=0; dir<3; ++dir) {
                    int ny = currY + dy[dir];
                    int nx = currX + dx[dir];
     
                    if(ny < 0 || nx<0 || nx>=100 || ny>=100) continue; //outofRange
                    if(board[ny][nx] == 0 || visit[ny][nx]==1) continue; //0일때
                    currY = ny;
                    currX = nx;
                    visit[currY][currX] =1;
                    break;      
             
                }
         
        }
 
    }
         
    }
}