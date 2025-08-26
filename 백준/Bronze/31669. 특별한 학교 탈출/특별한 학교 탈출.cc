#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {
	int n, m;
	std::cin >> n >> m;
	std::vector<bool> arr(m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			char x;
			std::cin >> x;
			if (x == 'O') {
				arr[j] = true;
			}
		}
	}
	for (int i = 0; i < m; i++) {
		if (!arr[i]) {
			std::cout << i + 1;
			return;
		}
	}
	std::cout << "ESCAPE FAILED";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}