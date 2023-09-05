class Solution:
    def totalNQueens(self, n: int) -> int:
        def is_valid(queens, row, col):
            for prev_row in range(row):
                prev_col = queens[prev_row]

                if prev_col == col or prev_col - prev_row == col - row or prev_col + prev_row == col + row:
                    return False
            return True

        def solve_nqueens(queens, row):
            if row == n:
                self.count += 1
                return

            for col in range(n):
                if is_valid(queens, row, col):
                    queens[row] = col
                    solve_nqueens(queens, row + 1)

        queens = [-1] * n
        self.count = 0
        solve_nqueens(queens, 0)
        return self.count
