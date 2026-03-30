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

	long long vk, jk, vc, jc, v, d, j;
	std::cin >> vk >> jk >> vc >> jc >> v >> d >> j;
	long long ans = (vk * jk + vc * jc) * v * d * j;
	std::cout << ans;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}