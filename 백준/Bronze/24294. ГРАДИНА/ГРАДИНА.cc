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

	int a, b, c, d;
	std::cin >> a >> b >> c >> d;

	int sum = (b + d) * 2 + a + c + std::abs(a - c) + 4;

	std::cout << sum;

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}