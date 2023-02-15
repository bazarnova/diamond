import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        char[][] chars = fillMatrix(width, height);

        for (int row = 0; row < height; row++) {
            System.out.println(new String(chars[row]));
        }
    }

    private static char[][] fillMatrix(int width, int height) {
        float k = (float) width / height;

        char[][] chars = new char[height][width];
        for (int x = 0; x < height; x++) for (int y = 0; y < width; y++) chars[x][y] = ' ';

        if (width % 2 != 0) {
            chars[0][width / 2] = '#';
            chars[height - 1][width / 2] = '#';
        } else {
            chars[0][width / 2 - 1] = '#';
            chars[height - 1][width / 2] = '#';
        }

        chars[height / 2][0] = '#';
        chars[height / 2][width - 1] = '#';
        if (height % 2 == 0) {
            chars[height / 2 - 1][0] = '#';
            chars[height / 2 - 1][width - 1] = '#';
        }

        for (int row = 1; row < height / 2; row++) {
            float y = (float) row * k;
            int shift = (int) Math.floor(y);
            if (height % 2 != 0 || (height % 2 == 0 && row != height / 2 - 1)) {
                chars[row][width / 2 + shift] = '#';
                chars[height - row - 1][width / 2 + shift] = '#';

                if (width % 2 == 0) {
                    chars[row][width / 2 - shift - 1] = '#';
                    chars[height - row - 1][width / 2 - shift - 1] = '#';
                } else {
                    chars[row][width / 2 - shift] = '#';
                    chars[height - row - 1][width / 2 - shift] = '#';
                }
            }
        }
        return chars;
    }
}