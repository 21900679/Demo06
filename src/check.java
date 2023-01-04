public class check {
    int come;
    static boolean ok = false;
    check(int[][] stones, boolean color){       //true(black), false(white)
//        System.out.println(color);
        if(color)   come = 1;
        else        come = -1;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(stones[i][j] == 3)
                    stones[i][j] = 0;
            }
        }
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(stones[i][j] == come){
//                    System.out.println("first x = " + i + ", y = " + j);
                    right(stones, i, j);
                    left(stones, i, j);
                    up(stones, i, j);
                    down(stones, i, j);
                    rightup(stones, i, j);
                    leftup(stones, i, j);
                    rightdown(stones, i, j);
                    leftdown(stones, i, j);
                }
            }
        }
    }
    check(){
    }
    public void right(int[][] stones, int x, int y){
        ok = false;
        int value = stones[x][y];
//        System.out.println("right " + "x = " + x + ", y = " + y);
        for(int i = x+1; i < 8; i++){
            if(stones[i][y] == value || stones[x+1][y] == 0 || stones[i][y] == 3){
                if(stones[i][y] == value)
                    ok = true;
                break;
            }
            else if(stones[i][y] == value * (-1)){
                continue;
            }
            else if(stones[i][y] == 0 && stones[i-1][y] == value * (-1)){
//                System.out.println("right");
//                System.out.println("x = " + i + ", y = " + y);
                stones[i][y] = 3;
                break;
            }
        }
    }
    public void left(int[][] stones, int x, int y){
        ok = false;
        int value = stones[x][y];
//        System.out.println("left " + "x = " + x + ", y = " + y);
        for(int i = x-1; i >= 0; i--){
            if(stones[i][y] == value || stones[x-1][y] == 0 || stones[i][y] == 3){
                if(stones[i][y] == value)
                    ok = true;
                break;
            }
            else if(stones[i][y] == value * (-1)){
                continue;
            }
            else if(stones[i][y] == 0 && stones[i+1][y] == value * (-1)){
//                System.out.println("left");
//                System.out.println("x = " + i + ", y = " + y);
                stones[i][y] = 3;
                break;
            }
        }
    }
    public void up(int[][] stones, int x, int y){
        ok = false;
        int value = stones[x][y];
//        System.out.println("up " + "x = " + x + ", y = " + y);
        for(int i = y-1; i >= 0; i--){
            if(stones[x][i] == value || stones[x][y-1] == 0 || stones[x][i] == 3){
                if(stones[x][i] == value)
                    ok = true;
                break;
            }
            else if(stones[x][i] == value * (-1)){
                continue;
            }
            else if(stones[x][i] == 0 && stones[x][i+1] == value * (-1)){
//                System.out.println("up");
//                System.out.println("x = " + x + ", y = " + i);
                stones[x][i] = 3;
                break;
            }
        }
    }
    public void down(int[][] stones, int x, int y){
        ok = false;
        int value = stones[x][y];
//        System.out.println("down " + "x = " + x + ", y = " + y);
        for(int i = y+1; i < 8; i++){
            if(stones[x][i] == value || stones[x][y+1] == 0 || stones[x][i] == 3){
                if(stones[x][i] == value)
                    ok = true;
                break;
            }
            else if(stones[x][i] == value * (-1)){
                continue;
            }
            else if(stones[x][i] == 0 && stones[x][i-1] == value * (-1)){
//                System.out.println("down");
//                System.out.println("x = " + x + ", y = " + i);
                stones[x][i] = 3;
                break;
            }
        }
    }
    public void rightup(int[][] stones, int x, int y){
        ok = false;
        int value = stones[x][y];
//        System.out.println("rightup " + "x = " + x + ", y = " + y);
        int i, j;
        for(i = x+1, j = y-1; i < 8 && j >= 0; i++, j--){
            if(stones[i][j] == value || stones[x+1][y-1] == 0 || stones[i][j] == 3){
                if(stones[i][j] == value)
                    ok = true;
                break;
            }
            else if(stones[i][j] == value * (-1)){
                continue;
            }
            else if(stones[i][j] == 0 && stones[i-1][j+1] == value * (-1)){
//                System.out.println("rightup");
//                System.out.println("x = " + i + ", y = " + j);
                stones[i][j] = 3;
                break;
            }
        }
    }
    public void leftup(int[][] stones, int x, int y){
        ok = false;
        int value = stones[x][y];
        int i, j;
//        System.out.println("leftup " + "x = " + x + ", y = " + y);
        for(i = x-1, j = y-1; i >= 0 && j >= 0; i--, j--){
            if(stones[i][j] == value || stones[x-1][y-1] == 0 || stones[i][j] == 3){
                if(stones[i][j] == value)
                    ok = true;
                break;
            }
            else if(stones[i][j] == value * (-1)){
                continue;
            }
            else if(stones[i][j] == 0 && stones[i+1][j+1] == value * (-1)){
//                System.out.println("leftup");
//                System.out.println("x = " + i + ", y = " + j);
                stones[i][j] = 3;
                break;
            }
        }
    }
    public void rightdown(int[][] stones, int x, int y){
        ok = false;
        int value = stones[x][y];
        int i, j;
//        System.out.println("rightdown " + "x = " + x + ", y = " + y);
        for(i = x+1, j = y+1; i < 8 && j < 8; i++, j++){
            if(stones[i][j] == value || stones[x+1][y+1] == 0 || stones[i][j] == 3){
                if(stones[i][j] == value)
                    ok = true;
                break;
            }
            else if(stones[i][j] == value * (-1)){
                continue;
            }
            else if(stones[i][j] == 0 && stones[i-1][j-1] == value * (-1)){
//                System.out.println("rightdown");
//                System.out.println("x = " + i + ", y = " + j);
                stones[i][j] = 3;
                break;
            }
        }
    }
    public void leftdown(int[][] stones, int x, int y){
        ok = false;
        int value = stones[x][y];
        int i, j;
//        System.out.println("leftdown " + "x = " + x + ", y = " + y);
        for(i = x-1, j = y+1; i >= 0 && j < 8; i--, j++){
            if(stones[i][j] == value || stones[x-1][y+1] == 0 || stones[i][j] == 3){
                if(stones[i][j] == value)
                    ok = true;
                break;
            }
            else if(stones[i][j] == value * (-1)){
                continue;
            }
            else if(stones[i][j] == 0 && stones[i+1][j-1] == value * (-1)){
//                System.out.println("leftdown");
//                System.out.println("x = " + i + ", y = " + j);
                stones[i][j] = 3;
                break;
            }
        }
    }
}
