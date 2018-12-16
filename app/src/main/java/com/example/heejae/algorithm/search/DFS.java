package com.example.heejae.algorithm.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by heejae on 2018-12-16.
 * DFS: 깊이 우선 탐색 (Stack, Recursion)
 */

public class DFS extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sc.init();
        solve();
    }

    // 재귀 DFS - 인접행렬
    public static void dfs(int[][] a, int[] c, int v) {
        int n = a.length - 1;
        for (int i = 1; i <= n; i++) {
            if (a[v][i] == 1 && c[i] == 0) {
                c[i] = 1;
                dfs(a, c, i);
            }
        }
    }

    private void solve() {
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        // 방향 그래프, 가중치 x
        int[][] a = new int[n + 1][n + 1];
        int[] c = new int[n + 1];
        int[][] path = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            dfs(a, c, i);
            for (int j = 1; j <= n; j++) {
                path[i][j] = c[j];
            }
            Arrays.fill(c, 0);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(path[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }



    static class sc {

        private static BufferedReader br;
        private static StringTokenizer st;

        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        static String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
            }
            return null;
        }

        static String readLineReplace() {
            try {
                return br.readLine().replaceAll("\\s+", "");
            } catch (IOException e) {
            }
            return null;
        }

        static String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        static long nextLong() {
            return Long.parseLong(next());
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }

        static double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
