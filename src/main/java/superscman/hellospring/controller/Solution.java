package superscman.hellospring.controller;


import java.util.Arrays;

class Solution { //아무래도 다음 강의는 새로운 프로젝트를 만들어서 할 것 같다. 이제 다시 정신차려서 공부하자. 성공 이직 화이팅!!
    public static void main(String[]args) {
        String[] park = {"XXX", "XSX", "XXX"};
        String[] routes = {"S 1"};
        int [] answer = solution(park, routes);

        System.out.println(Arrays.toString(answer));
    }
    public static int[] solution(String[] park, String[] routes) {

        int[] startXY = findStartXY(park);

        int startY = startXY[0];
        int startX = startXY[1];

        System.out.println("startY = " + startY + ", startX = " + startX );

        for(int i =0; i<routes.length; i++) {
            String[] route = routes[i].split(" ");
            String direction = route[0];
            int distance = Integer.parseInt(route[1]);
            System.out.println(isCheckGo(park, direction, distance, startX, startY));
            if(isCheckGo(park, direction, distance, startX, startY)) {
                switch(direction) {
                    case "S":
                        startY += distance;
                        break;
                    case "N":
                        startY -= distance;
                        break;
                    case "W":
                        startX -= distance;
                        break;
                    case "E":
                        startX += distance;
                        break;
                }

            }
            System.out.println("direction = " + direction + ", distance = " + distance);
            System.out.println("y = " + startY + ", x = " + startX);
        }
        int[] answer = {startY,startX};

        return answer;
    }

    private static boolean isCheckGo(String[] park, String direction, int distance, int startX, int startY) {

        int maxX = park[0].length()-1;
        int maxY = park.length-1;

        switch(direction) {
            case "S":
                if(distance+startY > maxY) {
                    System.out.print(distance+startY + " < " + maxY);
                    System.out.println();
                    return false;
                }else if(distance+startY == maxY) {
                    System.out.println("maxY = " + maxY);
                    System.out.println("startX = " + startX);
                    System.out.println(park[maxY].charAt(startX));

                    if(park[maxY].charAt(startX) == 'X') {
                        return false;
                    }
                }else {

                    for(int j=startY+1; j<maxY; j++) {
                        System.out.print(park[j].charAt(startX));

                        if(park[j].charAt(startX) == 'X') {
                            System.out.println();
                            return false;
                        }
                    }


                }
                break;
            case "N":
                if(startY-distance < 0) {
                    System.out.print(startY-distance + " < " + 0);
                    System.out.println();
                    return false;
                }else if(startY-distance == 0) {
                    if(park[startY-distance].charAt(startX) == 'X') {
                        System.out.println();
                        return false;
                    }
                }else {

                    for(int j=startY-1; j>0; j--) {
                        System.out.print(park[j].charAt(startX));

                        if(park[j].charAt(startX) == 'X') {
                            System.out.println();
                            return false;
                        }
                    }


                }
                break;
            case "W":
                if(startX-distance < 0) {
                    System.out.print(startX-distance + " < " + 0);
                    System.out.println();
                    return false;
                }else if(startX-distance == 0) {
                    if(park[startX-distance].charAt(startY) == 'X') {
                        System.out.println();
                        return false;
                    }
                }else {

                    for(int j=startX-1; j>0; j--) {
                        System.out.print(park[startY].charAt(j));

                        if(park[startY].charAt(j) == 'X') {
                            System.out.println();
                            return false;
                        }
                    }


                }

                break;
            case "E":
                if(distance+startX > maxX) {
                    System.out.print(distance+startX + " > " + maxX);
                    System.out.println();
                    return false;
                }else if(distance+startX == maxX) {
                    if(park[startY].charAt(maxX) == 'X') {
                        System.out.println();
                        return false;
                    }
                }else {

                    for(int j=startX+1; j<maxX; j++) {
                        System.out.print(park[startY].charAt(j));
                        if(park[startY].charAt(j) == 'X') {
                            System.out.println();
                            return false;
                        }
                    }


                }
                break;
        }
        return true;
    }

    private static int[] findStartXY(String[] park) {
        for(int i =0; i<park.length; i++) {
            for(int j =0; j<park[0].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    int[] xy = {i,j};
                    return xy;
                }
            }
        }
        return null;
    }

        }

