#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {

	int a, b, c;
	int n;
	std::cin >> a >> b >> c;
	std::cin >> n;
	int max = 0;
	while (n--) {
		int sum = 0;
		for (int i = 0; i < 3; ++i) {
			int x, y, z;
			std::cin >> x >> y >> z;
			sum += x * a + y * b + z * c;
		}
		max = std::max(max, sum);
	}
	std::cout << max;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}