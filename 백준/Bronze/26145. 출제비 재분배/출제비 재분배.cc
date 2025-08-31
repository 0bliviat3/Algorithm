#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {
	int n, m;
	std::cin >> n >> m;
	std::vector<int> arr(n + m);
	for (int i = 0; i < n; ++i) {
		std::cin >> arr[i];
	}
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n + m; ++j) {
			int now;
			std::cin >> now;
			arr[i] -= now;
			arr[j] += now;
		}
	}

	for (int i = 0; i < n + m; ++i) {
		std::cout << arr[i] << ' ';
	}


}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}