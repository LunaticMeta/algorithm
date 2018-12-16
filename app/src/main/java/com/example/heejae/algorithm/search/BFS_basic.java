package com.example.heejae.algorithm.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by heejae on 2018-12-16.
 * BFS: 넓이 우선 탐색 (queue)
 */

public class BFS_basic extends AppCompatActivity{

    static int[][] BFS = {
            {0,0,0,0,0,0,0,0},
            {0,0,1,1,0,0,0,0},
            {0,1,0,0,1,0,0,0},
            {0,1,0,0,0,1,1,1},
            {0,0,1,0,0,0,0,0},
            {0,0,0,1,0,0,0,0},
            {0,0,0,1,0,0,0,0},
            {0,0,0,1,0,0,0,0},
    };

    // 전단과 후단을 나타내는 변수
    static int rear = 0;
    static int front = 0;

    //큐와 방문한 노드를 체크하고 위함
    static int  queue[] = new int[10];
    static int search[] = new int[10];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bfs(1);
    }

    public static void bfs(int s){
        search[s] = 1;
        queue[rear++] = s;
        //큐에서 다 빼낼때까지
        while (front < rear){
            s = queue[front++];
            for(int i = 1; i <=7; i++){
                if(BFS[s][i] == 1 && search[i] != 1){
                    search[i] = 1;
                    Log.i("Graph Search", s + "에서 " + i + "로 이동!");
                    queue[rear++] = i;
                }
            }
        }
    }
}
