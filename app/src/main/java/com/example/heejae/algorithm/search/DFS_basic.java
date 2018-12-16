package com.example.heejae.algorithm.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by heejae on 2018-12-16.
 * DFS: 깊이 우선 탐색 (Stack, Recursion)
 */

public class DFS_basic extends AppCompatActivity{

    //중복 탐색을 막기 위한 변수
    static int[] search = new int[10];

    //노드 연결 정보가 담긴 배열
    //(1,2)(2,1) (1,3)(3,1) … 이런 식으로 정보를 알 수 있음
    static int[][] DFS = {
            {0,0,0,0,0,0,0,0},
            {0,0,1,1,0,0,0,0},
            {0,1,0,0,1,0,0,0},
            {0,1,0,0,0,1,1,1},
            {0,0,1,0,0,0,0,0},
            {0,0,0,1,0,0,0,0},
            {0,0,0,1,0,0,0,0},
            {0,0,0,1,0,0,0,0},
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dfs(1);
    }

    public static void dfs(int v) {

        //정점을 방문했다고 표시
        search[v] = 1;

        //7 부분은 노드 개수만큼
        for (int i = 1; i <= 7; i++) {

            //정점을 방문하지 않고 인접행렬이라면
            if (search[i] != 1 && DFS[v][i] == 1 ) {
                Log.i("Graph Search",v + "에서 " + i + "로 이동!");
                dfs(i);
            }
        }
    }
}
