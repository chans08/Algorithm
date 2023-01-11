import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14499_roll_the_dice {
    static int n, m; //맵의 세로 * 가로
    static int x, y; //주사위 바닥면의 위치
    static int[][] map;
    static int[][] dice = new int[4][3];

    public static void main(String[] args) throws IOException {
        n = read();
        m = read();
        x = read();
        y = read();
        int commandNum = read();
        map = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                map[i][j] = read();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<commandNum; i++) {
            //1. 주사위 굴리기
            int command = read();
            // 범위를 벗어나는 command 제거
            if (isOutside(command)) {
                continue;
            }
            roll(command);
            //2. 숫자 읽어서 처리하기
            if (map[x][y] == 0) {
                map[x][y] = bottom();
            } else {
                dice[3][1] = map[x][y];
                map[x][y] = 0;
            }
            //3. 답 준비
            sb.append(top());
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isOutside(int command) {
        switch (command) {
            case 1: //동
                if (y + 1 >= m) {
                    return true;
                } else {
                    return false;
                }
            case 2: //서
                if (y - 1 < 0) {
                    return true;
                } else {
                    return false;
                }
            case 3: //북
                if (x - 1 < 0) {
                    return true;
                } else {
                    return false;
                }
            case 4: //남
                if (x + 1 >= n) {
                    return true;
                } else {
                    return false;
                }
            default:
                throw new IllegalArgumentException("invalid command.");
        }
    }

    private static int top() {
        return dice[1][1];
    }

    private static int bottom() {
        return dice[3][1];
    }

    /**
     * command = 1(동), 2(서), 3(북), 4(남) 으로 주사위 굴리기
     * @param command
     */
    private static void roll(int command) {
        switch (command) {
            case 1: //동
                int tmp = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = dice[1][2];
                dice[1][2] = dice[1][1];
                dice[1][1] = tmp;
                y += 1;
                break;
            case 2: //서
                tmp = dice[1][0];
                dice[1][0] = dice[1][1];
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[3][1];
                dice[3][1] = tmp;
                y -= 1;
                break;
            case 3: //북
                tmp = dice[0][1];
                dice[0][1] = dice[1][1];
                dice[1][1] = dice[2][1];
                dice[2][1] = dice[3][1];
                dice[3][1] = tmp;
                x -= 1;
                break;
            case 4: //남
                tmp = dice[3][1];
                dice[3][1] = dice[2][1];
                dice[2][1] = dice[1][1];
                dice[1][1] = dice[0][1];
                dice[0][1] = tmp;
                x += 1;
                break;
            default:
                throw new IllegalArgumentException("invalid command.");
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}
