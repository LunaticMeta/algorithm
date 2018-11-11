package com.example.heejae.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<15; i++) list.add(i);
        Collections.shuffle(list);

        /*
        String strList = bubbleSort(list).stream().map(Object::toString)
                .collect(Collectors.joining(", "));
                */

        String originText = Arrays.toString(list.toArray());
        String str = Arrays.toString(quickSort(list).toArray());

        TextView textView = (TextView) findViewById(R.id.text);
        TextView origin = (TextView) findViewById(R.id.origin);
        origin.setText(originText);
        textView.setText(str);

    }
    private ArrayList<Integer> bubbleSort(ArrayList<Integer> list){
        int size = list.size();
        int temp;

        for(int i=0; i<size; i++){
            for(int j=0; j<size-i-1; j++){
                if(list.get(j) > list.get(j+1)){
                    temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
        return list;
    }

    private ArrayList<Integer> insertionSort(ArrayList<Integer> list){
        for (int i = 1; i < list.size(); i++) {

            int standard = list.get(i);  // 기준
            int aux = i - 1;   // 비교할 대상

            while (aux >= 0 && standard < list.get(aux)) {
                list.set(aux+1, list.get(aux));   // 비교대상이 큰 경우 오른쪽으로 밀어냄
                aux--;
            }

            list.set(aux+1, standard);  // 기준값 저장
        }

        return list;
    }

    private ArrayList<Integer> selectionSort(ArrayList<Integer> list){
        int size = list.size();
        int min; //최소값을 가진 데이터의 인덱스 저장 변수
        int temp;

        for(int i=0; i<size-1; i++){ // size-1 : 마지막 요소는 자연스럽게 정렬됨
            min = i;
            for(int j=i+1; j<size; j++){
                if(list.get(min) > list.get(j)){
                    min = j;
                }
            }
            temp = list.get(min);
            list.set(min, list.get(i));
            list.set(i, temp);
        }

        return list;
    }

    private ArrayList<Integer> quickSort(ArrayList<Integer> list){
        list = recursiveQuickSort(list, 0, list.size()-1);
        return list;
    }
    private ArrayList<Integer> recursiveQuickSort(ArrayList<Integer> list, int l, int r){
        int left = l;
        int right = r;
        int pivot = list.get((l+r)/2);
        int temp;

        do{
            while(list.get(left) < pivot) left++;
            while(list.get(right) > pivot) right--;
            if(left <= right){
                temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
                left++;
                right--;
            }
        }while (left <= right);

        if(l < right) recursiveQuickSort(list, l, right);
        if(r > left) recursiveQuickSort(list, left, r);
        return list;
    }
}
