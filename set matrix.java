class Solution:
    def setZeroes(self, matrix):
        if not matrix:
            return

        m, n = len(matrix), len(matrix[0])

        # Check if the first row and first column need to be zeroed
        first_row_zero = any(matrix[0][j] == 0 for j in range(n))
        first_col_zero = any(matrix[i][0] == 0 for i in range(m))

        # Use the first row and first column to mark the rows and columns that need to be zeroed
        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0  # Mark the row
                    matrix[0][j] = 0  # Mark the column

        # Zero out cells based on markers in the first row and first column
        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0

        # Zero out the first column if needed
        if first_col_zero:
            for i in range(m):
                matrix[i][0] = 0

        # Zero out the first row if needed
        if first_row_zero:
            for j in range(n):
                matrix[0][j] = 0