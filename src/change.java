public class change {
    change(int[][] stones, int x, int y){
//        System.out.println("change");
//        System.out.println("x = " + x + ", y = " + y);
        right(stones, x, y);
        left(stones, x, y);
        up(stones, x, y);
        down(stones, x, y);
        rightup(stones, x, y);
        leftup(stones, x, y);
        rightdown(stones, x, y);
        leftdown(stones, x, y);
    }
    public void right(int[][] stones, int x, int y){
        check a = new check();
        int value = stones[x][y];
//        System.out.println("change right");
        a.right(stones, x, y);
        if(check.ok){
            for(int i = x+1; i < 8; i++){
                if(stones[i][y] == value * (-1)){
                    stones[i][y] = value;
                }
                else{
                    break;
                }
            }
        }
    }
    public void left(int[][] stones, int x, int y){
        check a = new check();
        int value = stones[x][y];
//        System.out.println("change left");
        a.left(stones, x, y);
        if(check.ok){
            for(int i = x-1; i > 0; i--){
                if(stones[i][y] == value * (-1)){
                    stones[i][y] = value;
                }
                else{
                    break;
                }
            }
        }
    }
    public void up(int[][] stones, int x, int y){
        check a = new check();
        int value = stones[x][y];
//        System.out.println("change up");
        a.up(stones, x, y);
        if(check.ok){
            for(int i = y-1; i > 0; i--){
                if(stones[x][i] == value * (-1)){
                    stones[x][i] = value;
                }
                else{
                    break;
                }
            }
        }
    }
    public void down(int[][] stones, int x, int y){
        check a = new check();
        int value = stones[x][y];
//        System.out.println("change down");
        a.down(stones, x, y);
        if(check.ok){
            for(int i = y+1; i < 8; i++){
                if(stones[x][i] == value * (-1)){
                    stones[x][i] = value;
                }
                else{
                    break;
                }
            }
        }
    }
    public void rightup(int[][] stones, int x, int y){
        check a = new check();
        int value = stones[x][y];
//        System.out.println("change rightup");
        a.rightup(stones, x, y);
        int i, j;
        if(check.ok){
            for(i = x+1, j = y-1; i < 8 && j > 0; i++, j--){
                if(stones[i][j] == value * (-1)){
                    stones[i][j] = value;
                }
                else{
                    break;
                }
            }
        }
    }
    public void leftup(int[][] stones, int x, int y){
        check a = new check();
        int value = stones[x][y];
//        System.out.println("change leftup");
        a.leftup(stones, x, y);
        int i, j;
        if(check.ok){
            for(i = x-1, j = y-1; i > 0 && j > 0; i--, j--){
                if(stones[i][j] == value * (-1)){
                    stones[i][j] = value;
                }
                else{
                    break;
                }
            }
        }
    }
    public void rightdown(int[][] stones, int x, int y){
        check a = new check();
        int value = stones[x][y];
//        System.out.println("change rightdown");
        a.rightdown(stones, x, y);
        int i, j;
        if(check.ok){
            for(i = x+1, j = y+1; i < 8 && j < 8; i++, j++){
                if(stones[i][j] == value * (-1)){
                    stones[i][j] = value;
                }
                else{
                    break;
                }
            }
        }
    }
    public void leftdown(int[][] stones, int x, int y){
        check a = new check();
        int value = stones[x][y];
//        System.out.println("change leftdown");
        a.leftdown(stones, x, y);
        int i, j;
        if(check.ok){
            for(i = x-1, j = y+1; i > 0 && j < 8; i--, j++){
                if(stones[i][j] == value * (-1)){
                    stones[i][j] = value;
                }
                else{
                    break;
                }
            }
        }
    }
}
