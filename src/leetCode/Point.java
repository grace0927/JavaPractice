/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetCode;

/**
 *
 * @author jianyu
 */
public class Point {
      int x;
      int y;
      public Point() {
    	  this.x = 0;
    	  this.y = 0;
      }
      
      public Point(int a, int b) {
    	  this.x = a;
    	  this.y = b;
      }
      
      public int getX() {
    	  return this.x;
      }
      
      public int getY() {
    	  return this.y;
      }
      
      public String printPoint() {
    	  String result = "(" + this.x + ", " + this.y + ")";
    	  return result;
      }
}
