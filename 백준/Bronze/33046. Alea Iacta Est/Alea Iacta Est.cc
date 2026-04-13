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

	int mod = (a + b) % 4;
	mod = mod ? mod : 4;

	mod = (mod + ((c + d) % 4 - 1)) % 4;
	mod = mod ? mod : 4;

	std::cout << mod;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}