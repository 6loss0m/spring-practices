package com.poscodx.aoptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int N = Integer.parseInt(br.readLine());
      String S = br.readLine();
      
      ArrayList<Character> choice = new ArrayList<>();
      int[] alpha = new int[26];
      
      int max = 0;
      for (int i = 0; i < S.length(); i++) {
         char c = S.charAt(i);
         
         // 인식할 수 있는 알파벳이면 +1
         if(choice.contains(c)) {
            alpha[c-'a']++;
         }
         // 인식할 수 없는 알파벳일 경우
         else {
            // 최대 인식 개수면 처음 알파벳 삭제하고 새로운 알파벳 추가
            if(choice.size() == N) {
//               alpha[choice.get(0)-'a'] = 0;
               choice.remove(0);
               choice.add(c);
               alpha[c-'a'] = 1;
            }
            // 최대 인식 개수보다 작으면 add
            else {
               choice.add(c);
               alpha[c-'a'] = 1;
            }
         }
         
         // 최대 길이 갱신
         int sum = 0;
         for(Character a: choice) {
            sum += alpha[a-'a'];
         }
         max = Math.max(max, sum);         
      }
      
      System.out.println(max);
   }

}