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

	int n;
	std::cin >> n;
	
	std::vector<std::string> images;

	while (n--) {
		std::string image;
		std::cin >> image;
		images.push_back(image);
	}

	int m;
	std::cin >> m;

	while (m--) {
		int a, b;
		std::cin >> a >> b;

		for (int i = a - 1; i < b; i++) {
			std::cout << images[i] << "\n";
		}
	}


}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}