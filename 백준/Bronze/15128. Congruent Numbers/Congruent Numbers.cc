#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {

	long long p1, q1, p2, q2;
	std::cin >> p1 >> q1 >> p2 >> q2;

	int mod = p1 * p2 % (q1 * q2 * 2);
	if (mod) {
		std::cout << 0;
		return;
	}
	std::cout << 1;

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}