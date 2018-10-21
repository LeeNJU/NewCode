package DepthFirstSearch;

//题目描述:给定一个二维数组，一个值，和一个位置，sr,sc,以这个位置开始，把连续的值全部改为给定的值
//解法描述:深搜

public class FloodFill {

    private void dfs(int[][] image, int i, int j, int newColor, int sourceColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] == newColor || image[i][j] != sourceColor) {
            return;
        }

        image[i][j] = newColor;

        dfs(image, i + 1, j, newColor, sourceColor);
        dfs(image, i - 1, j, newColor, sourceColor);
        dfs(image, i, j + 1, newColor, sourceColor);
        dfs(image, i, j - 1, newColor, sourceColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }

        dfs(image, sr, sc, newColor, image[sr][sc]);

        return image;
    }
}
