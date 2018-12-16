package com.example.heejae.algorithm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by heejae on 2018-11-17.
 * 탐색 알고리즘
 * 순차 탐색 - 이진 탐색 - 이진 탐색 트리 - 레드 블랙 트리
 */

public class SearchAlgorithm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int[] dataArray = {1,2,3,4,5,6,7,8,9,10,11,12,13};

        /*
        String strList = bubbleSort(list).stream().map(Object::toString)
                .collect(Collectors.joining(", "));
                */

        String originText = Arrays.toString(dataArray);

        TextView textView = (TextView) findViewById(R.id.text);
        TextView origin = (TextView) findViewById(R.id.origin);
        origin.setText(originText);
        textView.setText(BinarySearcher(dataArray, 2));
    }

    /**
     * 순차 탐색
     *
     * @param arr
     * @param search
     * @return
     */
    private String sequentialSearch(int[] arr, int search) {

        System.out.println("검색할 데이터를 입력하세요");
        int searchIndex = 0; //데이터를 입력받습니다.
        boolean searchFlag = false;

        for (int i = 0; i < arr.length; i++) {
            //순서대로 비교하기 위해 배열의 크기만큼 반복합니다.

            if (arr[i] == search) {
                searchIndex = i;
                searchFlag = true;
                break;
            }
        }

        if (!searchFlag)
            return "데이터를 찾지 못하였습니다";
        else
            return "데이터의 위치는 " + searchIndex + "번 째입니다.";
    }

    /**
     * 이진 탐색
     * @Warning 배열이 무조건 정렬된 상태로 들어와야 함
     * @param arr
     * @param target
     * @return
     */
    private String BinarySearcher(int[] arr, int target) {

        int first = 0;
        int last = arr.length;
        int mid;
        int searchIndex = 0;
        boolean searchFlag = false;

        while (first <= last) {

            mid = (first + last) / 2;

            if (target == arr[mid]) {
                searchFlag = true;
                searchIndex = mid;
                break;
            } else {

                if (target < arr[mid])
                    last = mid - 1;

                else
                    first = mid + 1;
            }
        }

        if (!searchFlag)
            return "데이터를 찾지 못하였습니다";
        else
            return "데이터의 위치는 " + searchIndex + "번 째입니다.";
    }

    /**
     * Binary Search Tree 이진 탐색 트리
     * @return
     */
    private String BST (){
        return "";
    }
}
