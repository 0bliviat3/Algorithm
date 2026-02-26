#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {

	int n, m;
	std::cin >> n >> m;
	std::vector<std::string> arr(n);
	for (int i = 0; i < n; i++) {
		std::string str;
		std::cin >> str;
		for (int j = 0; j < m; j++) {
			arr[i] += str[j];
			arr[i] += str[j];
		}
	}

	for (int i = 0; i < n; i++) {
		std::string str;
		std::cin >> str;
		if (arr[i] != str) {
			std::cout << "Not Eyfa\n";
			return;
		}
	}

	std::cout << "Eyfa\n";


}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}