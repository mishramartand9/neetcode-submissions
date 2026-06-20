class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = returnRightRow(matrix, target);
        int left = 0, right = matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target)
                return true;
            else if (matrix[row][mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }

    public int returnRightRow(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int row = 0, left = 0, right = m;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (matrix[mid][0] == target)
                return mid;
            else if (matrix[mid][0] > target)
                right = mid;
            else
                left = mid;
        }
        if(matrix[left][0] <= target && matrix[right][0] > target)
            row = left;
        else if (matrix[right][0] <= target)
            row = right;
        return row;
    }
}
