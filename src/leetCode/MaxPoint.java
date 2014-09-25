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
public class MaxPoint {
        public static int maxPoints(Point[] points) {
        int count = 0;
        int oldCount = 0;
        for(int i = 0; i < points.length; i++) {
            if(i == 0) {
                oldCount = 1;
            } else if(oldCount <= 2) {
                oldCount = 2;
            }
            for(int j = i + 1; j < points.length; j++) {
                count = 2;
                int deltaY = points[j].y - points[i].y;
                int deltaX = points[j].x - points[i].x;
                double kLine;
                if(deltaX != 0) {
                    kLine = deltaY*1.00/deltaX;
                } else {
                    kLine = 99999;
                }
                for(int k = 0; k < j; k++) {
                    if(k == i) {
                        continue;
                    } else if(points[k].y == points[i].y && points[k].x == points[i].x){
                        count++;
                    }
                }
                for(int k = j+1; k < points.length; k++) {
                    int deltaYy = points[k].y - points[i].y;
                    int deltaXx = points[k].x - points[i].x;
                    double kLineNew;
                    if(deltaXx != 0) {
                        kLineNew = deltaYy*1.00/deltaXx;
                    } else {
                        kLineNew = 99999;
                    }
                    if(kLineNew == kLine) {
                        count++;
                    } else if(deltaYy == 0 && deltaXx == 0) {
                        count++;
                    }
                }
                if(count > oldCount) {
                    oldCount = count;
                }
            }
            if(count > oldCount) {
                    oldCount = count;
            }
        }
        return oldCount;
    }
}
