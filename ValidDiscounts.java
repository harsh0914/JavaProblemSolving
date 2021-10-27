package com.gfs.finance.billing.billingapi.model.entity;

import java.io.IOException;
import java.util.List;

//Write a program to verify that the elements from the code list are in the shoppingList

class Resultt {

  /*
   * Complete the 'foo' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. STRING_ARRAY codeList
   *  2. STRING_ARRAY shoppingCart
   */
  static int i = 0;

  public static boolean hopper(List<String> cur, List<String> shoppingCart) {
    for (; i < shoppingCart.size(); i++) {
      for (int j = 0; j < cur.size() && i < shoppingCart.size(); j++) {
        //System.out.println(cur + "cur: " + j + cur.get(j) + "scart: " + i + shoppingCart.get(i));
        if (!(cur.get(j).equals(shoppingCart.get(i)) || cur.get(j).equals("anything"))) {
          j = -1;
          i++;
        } else {
          i++;
        }
        if (j == cur.size() - 1) {
          return true;
        }
      }
    }
    return false;
  }

  public static int foo(List<String> codeList, List<String> shoppingCart) {
    // Write your code here
    for (String cur : codeList) {
      if (!hopper(List.of(cur.split(" ")), shoppingCart)) {
        return 0;
      }
    }
    return 1;
  }
}

public class Solutionn {

  public static void main(String[] args) throws IOException {

    List<String> codeList = List.of("apple apple", "apple apple banana");
    List<String> shoppingCart = List.of("apple", "apple", "apple", "", "apple", "banana");
    System.out.println(Resultt.foo(codeList, shoppingCart));
  }
}
