#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

void solve() {

	int n, m;

	std::cin >> n >> m;

	std::vector<std::vector<int>> graph(n, std::vector<int>(m));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			std::cin >> graph[i][j];
		}
	}

	int max = 0;
	int max_row = -1;
	int max_col = -1;

	int row_nine_count = 0;
	int col_nine_count = 0;
	for (int i = 0; i < n; i++) {
		int now = 0;
		for (int j = 0; j < m; j++) {
			int temp = graph[i][j];
			while (temp >= 10) {
				if ((temp % 10) == 9) {
					now++;
					row_nine_count++;
				}
				temp /= 10;
			}
			if ((temp % 10) == 9) {
				now++;
				row_nine_count++;
			}
		}
		if (now > max) {
			max = now;
			max_row = i;
		}
	}

	for (int i = 0; i < m; i++) {
		int now = 0;
		for (int j = 0; j < n; j++) {
			int temp = graph[j][i];
			while (temp >= 10) {
				if ((temp % 10) == 9) {
					now++;
					col_nine_count++;
				}
				temp /= 10;
			}
			if ((temp % 10) == 9) {
				now++;
				col_nine_count++;
			}
		}
		if (now > max) {
			max = now;
			max_col = i;
		}
	}

	if (max_col != -1) {
		col_nine_count -= max;
		std::cout << col_nine_count << "\n";
	} else {
		row_nine_count -= max;
		std::cout << row_nine_count << "\n";
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}